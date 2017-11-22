import re
import sys
import time
import MySQLdb

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
c = conn.cursor()
c1 = conn.cursor()
hash_apk=sys.argv[1]
numerador=0.0
denominador=0.0
c.execute("SELECT * FROM aplicaciones WHERE HASH=%s and estado='Bad_IPs'", (hash_apk,))
data=c.fetchall()

if len(data)!=0:
    c.execute('SELECT * FROM syscalls WHERE HASH=%s', (hash_apk,))
    data=c.fetchall()
    if len(data)!=0:
        for p in data:
            c1.execute('SELECT * from valoraciones_sys where llamada=%s', (p[1],))
            data2=c1.fetchone()
            if data2 is not None:
                numerador=numerador+(p[2]*data2[1])

        c1.execute('SELECT sum(numero) FROM syscalls WHERE HASH=%s', (hash_apk,))
        data2=c1.fetchone()
        denominador= float(data2[0])
        result=float(numerador/denominador)
        c.execute("INSERT INTO puntuaciones_sys (HASH, Puntuacion) VALUES (%s, %s)",(hash_apk, result))
        c.execute("UPDATE aplicaciones SET estado='Finalizado' WHERE HASH=%s",(hash_apk,))
        conn.commit()
        conn.close()
