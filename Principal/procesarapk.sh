#!/bin/bash
# -*- ENCODING: UTF-8 -*-

echo "Obteniendo hash MD5"
hashapk=$(python Preprocesamiento/obtenerhash.py $1)
echo $hashapk

sleep 3

echo "Intentando descomprimir el fichero apk" $1
apktool d $1 -f
dir=$(echo ${1%.*})
echo $dir
#$(echo ${1%.*})
#Análisis estático
echo "Analizando fichero AndroidManifest.xml"
python Preprocesamiento/parserAndroidManifest.py $dir/AndroidManifest.xml $hashapk

echo "Obteniendo fichero jar"
./Preprocesamiento/d2j-dex2jar.sh -f $dir.apk -o $dir.jar

echo "Obtener clases java"
java -jar Preprocesamiento/jd-core.jar $dir.jar $dir-java

#buscando instalaciones de apks
grep -i ".*\.apk[^ a-z]" -r $dir-java/ | while read line; do   echo  "$line"; done > $dir-apks.txt
python Preprocesamiento/lineas.py $hashapk $dir-apks.txt 1

grep -i "application/vnd.android" -r $dir-java/ | while read line; do   echo  "$line"; done > $dir-apks_vnd.txt
python Preprocesamiento/lineas.py $hashapk $dir-apks_vnd.txt 1

# Inyección de código en Dalvik, peligroso
grep -i "DexClassLoader InjectCall" -r $dir-java/ | while read line; do   echo  "$line"; done > $dir-inject.txt
python Preprocesamiento/lineas.py $hashapk $dir-inject.txt 2

#Uso de carpeta root
grep -i "/bin/su" -r $dir-java/ | while read line; do   echo  "$line"; done > $dir-root.txt
python Preprocesamiento/lineas.py $hashapk $dir-root.txt 3

#IPs donde intenta conectar
grep -i "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" -r $dir-java/ | while read line; do   echo  "$line"; done > $dir-ips.txt
python Preprocesamiento/lineas.py $hashapk $dir-ips.txt 4

grep -i "sendTextMessage" -r $dir-java/ | while read line; do   echo  "$line"; done > $dir-sms.txt
python Preprocesamiento/lineas.py $hashapk $dir-sms.txt 5


rm $dir-*.txt
rm -r $dir $dir-java
version_android=$(python Preprocesamiento/obtener_version.py $hashapk)
nombre_paquete=$(python Preprocesamiento/obtener_package_name.py $hashapk)


if [ $version_android -le 10 ]; then
  maquina_android=Android2.3.7
elif [ $version_android -le 17 ]; then
  maquina_android=Android4.2
elif [ $version_android -le 20 ]; then
  maquina_android=Android4.4
elif [ $version_android -le 22 ]; then
  maquina_android=Android5.1
elif [ $version_android -ge 23 ]; then
  maquina_android=Android6
fi


echo "Capturamos paquetes"
VBoxManage modifyvm $maquina_android --nictrace2 on --nictracefile2 $dir.cap &

echo "Lanzando máquina" $maquina_android
/home/francisco/Descargas/genymotion/player --vm-name $maquina_android &

sleep 90
ip_android=$(adb devices | grep -oE "\b([0-9]{1,3}\.){3}[0-9]{1,3}\b")

adb connect $ip_android
echo "Instalamos la aplicación"
echo $dir
adb install -r $1
sleep 3

permisos_apk=($(python Preprocesamiento/getDatosMongo.py $hashapk 3 | tr -d "''" | tr -d '[],'))

for i in "${permisos_apk[@]}"
do
	adb shell pm grant $nombre_paquete android.permission.$i
  echo $i
done
adb shell am force-stop $nombre_paquete
sleep 3
adb shell monkey -p $nombre_paquete -c android.intent.category.LAUNCHER 1

adb shell 'set `ps | grep' $nombre_paquete'` && strace -p $2' > $dir-syscall.txt &
echo "Cargamos actividades, acciones y permisos"

actividades_apk=($(python Preprocesamiento/getDatosMongo.py $hashapk 1 | tr -d "''" | tr -d '[],'))


sleep 5
for i in "${actividades_apk[@]}"
do
	adb shell am start -n $nombre_paquete/$i
  echo $i
  sleep 3
done

adb shell killall strace

sleep 5



echo "Desinstalamos la aplicación"
adb uninstall $nombre_paquete
sleep 5
echo "Detenemos la máquina"
vboxmanage controlvm $maquina_android poweroff || true
ps x | grep "/home/francisco/Descargas/genymotion/player --vm-name $maquina_android" | awk '{print $1}' | xargs kill

echo "Detenemos la captura de paquetes"
VBoxManage modifyvm $maquina_android --nictrace2 off --nictracefile2 $dir.cap

echo "Añadiendo IPs en base de datos"
python Preprocesamiento/parsercap.py $dir.cap $hashapk


python Analisis/parserstrace.py $dir-syscall.txt $hashapk
rm $dir.cap
rm $dir.apk
rm $dir-syscall.txt

echo "Comprobamos las IPs"
python Analisis/checkip.py $hashapk
echo "Valoraciones"
python Analisis/calculaValoracionMalwarePermisos.py $hashapk
python Analisis/valoracion_syscalls.py $hashapk
exit
