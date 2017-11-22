#!/usr/bin/env python
# -*- coding: utf-8 -*-ç
from pymongo import MongoClient
import sys
import dns.resolver
import urllib, json
import MySQLdb

conn = MySQLdb.connect(host= "localhost",
                  user="root",
                  passwd="M1_m2m3m4",
                  db="apk")
c = conn.cursor()
client = MongoClient()
db = client.aplicaciones

hash_apk=sys.argv[1]

c.execute("SELECT * FROM aplicaciones WHERE HASH=%s and estado='Get_IPs'", (hash_apk,))
data=c.fetchall()

if len(data)!=0:
    bls = ["b.barracudacentral.org", "bl.spamcannibal.org", "bl.spamcop.net",
           "blacklist.woody.ch", "cbl.abuseat.org", "cdl.anti-spam.org.cn",
           "dnsbl-1.uceprotect.net", "dnsbl-2.uceprotect.net", "dnsbl.cyberlogic.net",
           "dnsbl.sorbs.net","duinv.aupads.org", "dul.dnsbl.sorbs.net",
           "dyna.spamrats.com", "dynip.rothen.com",
           "korea.services.net", "misc.dnsbl.sorbs.net",
           "noptr.spamrats.com", "pbl.spamhaus.org", "phishing.rbl.msrbl.net"
           ,"rbl.interserver.net", "smtp.dnsbl.sorbs.net",
           "socks.dnsbl.sorbs.net", "spam.abuse.ch", "spam.dnsbl.sorbs.net",
           "spam.rbl.msrbl.net", "spam.spamrats.com", "spamrbl.imp.ch",
            "tor.dnsbl.sectoor.de", "ubl.lashback.com","virus.rbl.msrbl.net",
           "web.dnsbl.sorbs.net", "wormrbl.imp.ch", "xbl.spamhaus.org",
    "zen.spamhaus.org", "zombie.dnsbl.sorbs.net"]

    busqueda=db.IPs.find({'HASH' : hash_apk})

    if db.IPsMaliciosas.find({'HASH' : hash_apk}).count() == 0:
            result = db.IPsMaliciosas.insert_one(
                {
                "HASH": hash_apk,
                "IPs": []
                }
            )

    if db.IPsPaises.find({'HASH' : hash_apk}).count() == 0:
        result = db.IPsPaises.insert_one(
            {
            "HASH": hash_apk,
            "IPs": []
            }
        )


    for valor in busqueda:
    	for ip in valor['IPs']:
    		for bl in bls:
    		    try:
        		        my_resolver = dns.resolver.Resolver()
        		        query = '.'.join(reversed(str(ip).split("."))) + "." + bl
        		        answers = my_resolver.query(query, "A")
        		        mensaje_respuesta = my_resolver.query(query, "TXT")
            		#print 'IP: %s IS listed in %s (%s: %s)' %(ip, bl, answers[0], mensaje_respuesta[0])
        			if 'Dynamic' not in str(mensaje_respuesta.response):
                                    db.IPsMaliciosas.update({"HASH": hash_apk}, {'$push':{ "IPs" : {'IP' : ip , 'blacklist' : bl }}}, True)

                                    url="http://ip-api.com/json/%s"%ip
                                    response = urllib.urlopen(url)
                                    data = json.loads(response.read())
                                    pais= data['country']
                                    db.IPsPaises.update(
                                        {'HASH': hash_apk},
                                        {'$addToSet': { 'IPs': {'IP' : ip , 'Pais' : pais } } }
                                    );
    		    except dns.resolver.NXDOMAIN:
    		        pass
    		    except dns.resolver.Timeout:
    			print "timeout, sigo"
    		    except dns.resolver.NoNameservers:
    			print "No Internet"

    c.execute("UPDATE aplicaciones SET estado='Bad_IPs' WHERE HASH = %s and estado = 'Get_IPs'",(hash_apk,))
    conn.commit()
    conn.close()
