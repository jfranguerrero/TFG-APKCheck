#!/bin/bash
# -*- ENCODING: UTF-8 -*-
#Script para añadir permisos a base de datos y realizar estudio sobre permisos


FILES=/APKs/buenas/*
for f in $FILES
do
  echo "Obteniendo hash MD5"
  hashapk=$(python obtenerhashdata.py $f)


  dir=$(echo ${f%.*})
  echo "Intentando descomprimir el fichero apk" $f
  apktool d $f -f -o $dir

  echo $dir
  #$(echo ${1%.*})
  #Análisis estático
  echo "Analizando fichero AndroidManifest.xml"
  python addtodataset.py $dir/AndroidManifest.xml $hashapk

  rm -R $dir
done
