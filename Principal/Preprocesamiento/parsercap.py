
#!/usr/bin/env python
# -*- coding: utf-8 -*-
import dpkt
from dpkt.ip import IP
from dpkt.ethernet import Ethernet
from dpkt.arp import ARP
import socket
import re
import sys
from sets import Set
import MySQLdb
from pymongo import MongoClient

client = MongoClient()
conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
c = conn.cursor()
db = client.aplicaciones

hash_apk=sys.argv[2]

c.execute("SELECT * FROM aplicaciones WHERE HASH=%s and estado='Estatico'", (hash_apk,))
data=c.fetchall()

if len(data)!=0:

    filename=sys.argv[1]

    f = open(filename)
    pcap = dpkt.pcap.Reader(f)
    IPs = Set([])


    rex=re.compile("/(^127\.)|(^192\.168\.)|(^10\.)|(^0\.)|(^172\.1[6-9]\.)|(^172\.2[0-9]\.)|(^172\.3[0-1]\.)/")
    cont=1;
    for ts, buf in pcap:
        if cont > 1:
            eth=dpkt.ethernet.Ethernet(buf)
            if eth.type!=dpkt.ethernet.ETH_TYPE_IP:
                continue

            ip=eth.data

            destino = socket.inet_ntoa(ip.dst)
            src=dst_ip_addr_str = socket.inet_ntoa(ip.src)

            if rex.match(destino) == None:
                IPs.add(destino)

            if rex.match(src) == None:
                IPs.add(src)

        cont=cont+1


    f.close()

    if db.IPs.find({'HASH' : hash_apk}).count() == 0:
            result = db.IPs.insert_one(
                {
                "HASH": hash_apk,
                "IPs": []
                }
            )


    for value in IPs:
        db.IPs.update({"HASH": hash_apk}, {'$push':{ "IPs" : value}}, True)

    c.execute("UPDATE aplicaciones SET estado='Get_IPs' WHERE HASH = %s and estado = 'Estatico'",(hash_apk,))
    conn.commit()
    conn.close()
