import sys
from xml.dom.minidom import parseString
import MySQLdb
from pymongo import MongoClient
client = MongoClient()

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
db = client.aplicaciones

lista_permisos = ['READ_CALENDAR', 'WRITE_CALENDAR', 'CAMERA', 'READ_CONTACTS' ,
'WRITE_CONTACTS', 'GET_ACCOUNTS' , 'ACCESS_FINE_LOCATION' ,'ACCESS_COARSE_LOCATION' ,
'RECORD_AUDIO', 'READ_PHONE_STATE', 'CALL_PHONE', 'READ_CALL_LOG', 'WRITE_CALL_LOG',
'ADD_VOICEMAIL','USE_SIP', 'PROCESS_OUTGOING_CALLS', 'BODY_SENSORS','SEND_SMS' ,
'RECEIVE_SMS' , 'READ_SMS', 'RECEIVE_WAP_PUSH' , 'RECEIVE_MMS' , 'READ_EXTERNAL_STORAGE',
'WRITE_EXTERNAL_STORAGE'];
informacion =''

with open(sys.argv[1],'r') as f:
    informacion = f.read()
dom = parseString(informacion)


package_name = dom.getElementsByTagName('manifest')[0].getAttribute('package')
target_sdk = dom.getElementsByTagName('manifest')[0].getAttribute('platformBuildVersionCode')
hash_apk=sys.argv[2]
c = conn.cursor()
c.execute("SELECT * FROM aplicaciones WHERE HASH=%s and estado='Creado'", (hash_apk,))
data=c.fetchall()

if len(data)!=0:



    if db.permisos.find({'HASH' : hash_apk}).count() == 0:
        result = db.permisos.insert_one(
            {
            "HASH": hash_apk,
            "permisos": []
            }
        )

    if db.permisos_totales.find({'HASH' : hash_apk}).count() == 0:
        result = db.permisos_totales.insert_one(
            {
            "HASH": hash_apk,
            "permisos": []
            }
        )

    nodes = dom.getElementsByTagName('uses-permission')

    for node in nodes:
        item= node.getAttribute('android:name')
        item=item.replace('android.permission.','')
        item=item.replace('com.android.launcher.permission.','')
        item=item.replace('com.android.browser.permission.','')
        item=item.replace('com.android.vending.','')
        item=item.replace('com.google.android.c2dm.permission.','')
        item=item.replace('com.google.android.providers.gsf.permission.','')

        db.permisos_totales.update({"HASH": hash_apk}, {'$push':{ "permisos" : item}}, True)

        if item in lista_permisos:
            db.permisos.update({"HASH": hash_apk}, {'$push':{ "permisos" : item}}, True)


    if db.actividades.find({'HASH' : hash_apk}).count() == 0:
        result = db.actividades.insert_one (
            {
            "HASH": hash_apk,
            "actividades": []
            }
        )

    nodes = dom.getElementsByTagName('activity')
    for node in nodes:
            item= node.getAttribute('android:name')
            db.actividades.update({"HASH": hash_apk}, {'$push':{ "actividades" : item}}, True)

    if db.acciones.find({'HASH' : hash_apk}).count() == 0:
        result = db.acciones.insert_one(
            {
            "HASH": hash_apk,
            "acciones": []
            }
        )

    nodes = dom.getElementsByTagName('action')
    for node in nodes:
            item= node.getAttribute('android:name')
            if(item.startswith("android")) and db.acciones.find({'HASH' : hash_apk, "acciones" : item}).count() == 0:
                db.acciones.update({"HASH": hash_apk}, {'$push':{ "acciones" : item}}, True)

    c.execute("UPDATE aplicaciones SET nombre_paquete=%s, version_android=%s, estado='A_Manifest' WHERE HASH = %s and estado = 'Creado'",(package_name, target_sdk, hash_apk))
    conn.commit()
    conn.close()
