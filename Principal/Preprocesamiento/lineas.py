
#Parseo de ficheros con las salidas de los grep que examinan las clases java de la aplicacion. Se introducen datos en MongoDB

import sys
from pymongo import MongoClient
client = MongoClient()
import MySQLdb

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
db = client.aplicaciones
HASH=sys.argv[1]
tipo=int(sys.argv[3])

c = conn.cursor()
c.execute("SELECT * FROM aplicaciones WHERE HASH=%s and estado='A_Manifest'", (HASH,))
data=c.fetchall()

if len(data)!=0:
    if tipo == 1:
        if db.static_apk_install.find({'HASH' : HASH}).count() == 0:
            result = db.apk_install.insert_one (
                {
                "HASH": HASH,
                "log": []
                }
            )
        with open(sys.argv[2]) as f:

            for line in f:
                      class_name= line.split(':', 1)[0]
                      mensaje = line.split(" ",1)[1].lstrip()
                      db.static_apk_install.update({"HASH": HASH}, {'$push':{ "log" : {'Clase' : class_name, 'Mensaje' : mensaje }}}, True)

        f.close()

    elif tipo == 2:
        if db.static_inject.find({'HASH' : HASH}).count() == 0:
            result = db.static_inject.insert_one (
                {
                "HASH": HASH,
                "log": []
                }
            )
            with open(sys.argv[2]) as f:

                for line in f:
                       class_name= line.split(':', 1)[0]
                       mensaje = line.split(" ",1)[1].lstrip()
                       db.static_inject.update({"HASH": HASH}, {'$push':{ "log" : {'Clase' : class_name, 'Mensaje' : mensaje }}}, True)

            f.close()
    elif tipo == 3:
        if db.static_root.find({'HASH' : HASH}).count() == 0:
            result = db.static_root.insert_one (
                {
                "HASH": HASH,
                "log": []
                }
            )
            with open(sys.argv[2]) as f:

                for line in f:
                       class_name= line.split(':', 1)[0]
                       mensaje = line.split(" ",1)[1].lstrip()
                       db.static_root.update({"HASH": HASH}, {'$push':{ "log" : {'Clase' : class_name, 'Mensaje' : mensaje }}}, True)

            f.close()
    elif tipo == 4:
        if db.static_ips.find({'HASH' : HASH}).count() == 0:
            result = db.static_ips.insert_one (
                {
                "HASH": HASH,
                "log": []
                }
            )
            with open(sys.argv[2]) as f:

                for line in f:
                       class_name= line.split(':', 1)[0]
                       mensaje = line.split(" ",1)[1].lstrip()
                       db.static_ips.update({"HASH": HASH}, {'$push':{ "log" : {'Clase' : class_name, 'Mensaje' : mensaje }}}, True)

            f.close()
    elif tipo == 5:
        if db.static_sms.find({'HASH' : HASH}).count() == 0:
            result = db.static_sms.insert_one (
                {
                "HASH": HASH,
                "log": []
                }
            )
            with open(sys.argv[2]) as f:

                for line in f:
                       class_name= line.split(':', 1)[0]
                       mensaje = line.split(" ",1)[1].lstrip()
                       db.static_sms.update({"HASH": HASH}, {'$push':{ "log" : {'Clase' : class_name, 'Mensaje' : mensaje }}}, True)

            f.close()

        c.execute("UPDATE aplicaciones SET estado='Estatico' WHERE HASH=%s and estado = 'A_Manifest'",(HASH,))
        conn.commit()
        conn.close()
