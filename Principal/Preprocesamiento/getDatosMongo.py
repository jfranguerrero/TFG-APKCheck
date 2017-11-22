#!/usr/bin/env python
# -*- coding: utf-8 -*-ç
from pymongo import MongoClient
import sys

client = MongoClient()
db = client.aplicaciones

HASH=sys.argv[1]
tipo=int(sys.argv[2])
lista=[]

if tipo==1:
    busqueda=db.actividades.find({'HASH' : HASH})


    for valor in busqueda:
        for ip in valor['actividades']:
            lista.append(ip.encode("utf-8"))
elif tipo==2:
    busqueda=db.acciones.find({'HASH' : HASH})


    for valor in busqueda:
        for ip in valor['acciones']:
            lista.append(ip.encode("utf-8"))

else:
    busqueda=db.permisos.find({'HASH' : HASH})


    for valor in busqueda:
        for ip in valor['permisos']:
            lista.append(ip.encode("utf-8"))


print lista
