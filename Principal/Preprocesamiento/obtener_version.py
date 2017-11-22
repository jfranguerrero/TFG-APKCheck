import sys
import MySQLdb

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
c = conn.cursor()

hash_apk=sys.argv[1]


c.execute("SELECT version_android FROM aplicaciones WHERE HASH=%s", (hash_apk,))
tmp=c.fetchone()[0]
if tmp is '':
    print 17
else:
    print tmp
