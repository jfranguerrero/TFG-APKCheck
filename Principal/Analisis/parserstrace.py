import re
import sys
import time
import MySQLdb

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
c = conn.cursor()
hash_apk=sys.argv[2]

regex = re.compile("^[^\(,]*")
with open(sys.argv[1],'r') as f:
    next(f)
    for line in f:
        result = regex.findall(line)
        if len(result[0].split()) <= 1:
            c.execute('SELECT * FROM syscalls WHERE HASH=%s and llamada=%s', (hash_apk,result[0]))
            data=c.fetchall()
            if len(data)==0:
                c.execute("INSERT INTO syscalls (HASH, llamada, numero) VALUES (%s, %s,1)",(hash_apk, result[0]))
            else:
                c.execute('UPDATE syscalls set numero=numero+1 WHERE HASH=%s and llamada=%s', (hash_apk,result[0]))


conn.commit()
conn.close()
