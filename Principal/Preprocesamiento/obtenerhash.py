#Obtiene hash y lo introduce en SQL.
import hashlib
import sys
import MySQLdb

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
hash_md5 = hashlib.md5()

with open(sys.argv[1], "rb") as f:
    for chunk in iter(lambda: f.read(4096), b""):
        hash_md5.update(chunk)

c = conn.cursor()
c_hash=hash_md5.hexdigest()
c.execute('SELECT * FROM aplicaciones WHERE HASH=%s', (c_hash,))
data=c.fetchall()
if len(data)==0:
    c.execute("INSERT INTO aplicaciones (HASH, estado) VALUES (%s,'Creado')",(c_hash,))
    conn.commit()
    conn.close()

print c_hash
