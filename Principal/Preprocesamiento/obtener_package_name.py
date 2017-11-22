import sys
import MySQLdb

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
c = conn.cursor()

hash_apk=sys.argv[1]


c.execute("SELECT nombre_paquete FROM aplicaciones WHERE HASH=%s", (hash_apk,))
print c.fetchone()[0]
