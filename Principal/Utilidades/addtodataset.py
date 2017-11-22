import sys
from xml.dom.minidom import parseString
import MySQLdb

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")

informacion=''

with open(sys.argv[1],'r') as f:
    informacion = f.read()

hash_apk=sys.argv[2]
dom = parseString(informacion)
c = conn.cursor()

c.execute('SELECT * FROM benignas WHERE HASH=%s', (hash_apk,))
data=c.fetchall()
if len(data)==0:
    nodes = dom.getElementsByTagName('uses-permission')

    for node in nodes:
        item= node.getAttribute('android:name')
        item=item.replace('android.permission.','')
        item=item.replace('com.android.launcher.permission.','')
        item=item.replace('com.android.browser.permission.','')
        item=item.replace('com.android.vending.','')
        item=item.replace('com.google.android.c2dm.permission.','')
        item=item.replace('com.google.android.providers.gsf.permission.','')

        c.execute('SELECT * FROM benignas WHERE HASH=%s and Permiso=%s', (hash_apk, item))
        data=c.fetchall()
        if len(data)==0:
            print item
            c.execute("INSERT INTO benignas (HASH, Permiso) VALUES (%s, %s)",(hash_apk, item))
            conn.commit()

conn.close()
