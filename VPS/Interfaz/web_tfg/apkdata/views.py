# -*- coding: utf-8 -*-
from __future__ import unicode_literals
import MySQLdb
from django.shortcuts import render, HttpResponse
from django.views.decorators.csrf import csrf_exempt
import datetime
import time, pymongo
from django.http import HttpResponseRedirect
from pymongo import MongoClient
from django.core.mail import send_mail
from apkdata.forms import ProfileForm
from apkdata.models import Profile
import os
from django.conf import settings
import hashlib

# Create your view
def index(request):
	db = MySQLdb.connect("localhost","root","M1_m2m3m4","apk" )
	cursor=db.cursor()
	cursor.execute("select * from aplicaciones order by fecha desc limit 3")
	ultimosadd = []
	ultimosvisit = []
	resultado=cursor.fetchall()
        x = cursor.description
        for r in resultado:
            i = 0
            d = {}
            while i < len(x):
                d[x[i][0]] = r[i]
                i = i+1
            ultimosadd.append(d)
	cursor.execute("select a.HASH, a.nombre_paquete, a.estado, b.fecha from aplicaciones a inner join aplicaciones_consultadas b on a.HASH=b.HASH order by b.fecha desc limit 3")
	resultado=cursor.fetchall()
        x = cursor.description
        for r in resultado:
            i = 0
            d = {}
            while i < len(x):
                d[x[i][0]] = r[i]
                i = i+1
            ultimosvisit.append(d)
	cursor.close()
        db.close()
	return render(request,'index.html', {'ultimosadd':ultimosadd, 'ultimosvisit':ultimosvisit})

@csrf_exempt
def buscar(request):
	eshash=1
	tofind=request.GET['busqueda']
	dba = MySQLdb.connect("localhost","root","M1_m2m3m4","apk" )
	cursor = dba.cursor()
	cursor.execute("select * from aplicaciones where nombre_paquete=%s",[tofind])
	resultado=cursor.fetchall()
	if cursor.rowcount!=0:
		eshash=0
		x = cursor.description
	        hashlist = []
	        for r in resultado:
	            i = 0
	            d = {}
	            while i < len(x):
	                d[x[i][0]] = r[i]
	                i = i+1
	            hashlist.append(d)
		return render(request,'informacion.html', {'eshash':eshash, 'hashlist':hashlist})
	else:
		cursor.execute("select * from aplicaciones where HASH=%s",[tofind])
		resultado=cursor.fetchall()
		if cursor.rowcount!=0:
			x = cursor.description
		        resultsList = []
		        for r in resultado:
		            i = 0
		            d = {}
		            while i < len(x):
		                d[x[i][0]] = r[i]
		                i = i+1
		            resultsList.append(d)
			cursor.execute("select * from aplicaciones_consultadas where HASH=%s",[tofind])
			if cursor.rowcount!=0:
				ts = time.time()
				timestamp = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')
				cursor.execute("update aplicaciones_consultadas set fecha=%s where HASH=%s",(timestamp,[tofind]))
			else:
				cursor.execute("insert into aplicaciones_consultadas (HASH) VALUES (%s)",[tofind])
			dba.commit()
			client = MongoClient('localhost', 27017)
			conn=pymongo.MongoClient()
			db = conn.aplicaciones
			res =db.permisos.find({"HASH": tofind})

			salida=db.static_apk_install.aggregate([{'$match':{'HASH': tofind}},{'$project': {'HASH': 1,'cantidad': { '$size': "$log" }}}])
			num_apk_install=None
			for doc in salida:
			    num_apk_install=doc['cantidad']
			apk_install=db.static_apk_install.find({"HASH": tofind})

			salida=db.static_inject.aggregate([{'$match':{'HASH': tofind}},{'$project': {'HASH': 1,'cantidad': { '$size': "$log" }}}])
			num_inject=None
			for doc in salida:
			    num_inject=doc['cantidad']
			injects=db.static_inject.find({"HASH": tofind})

			salida=db.static_root.aggregate([{'$match':{'HASH': tofind}},{'$project': {'HASH': 1,'cantidad': { '$size': "$log" }}}])
			num_root=None
			for doc in salida:
			    num_root=doc['cantidad']
			roots=db.static_root.find({"HASH": tofind})

			salida=db.static_ips.aggregate([{'$match':{'HASH': tofind}},{'$project': {'HASH': 1,'cantidad': { '$size': "$log" }}}])
			num_ips=None
			for doc in salida:
			    num_ips=doc['cantidad']
			s_ips=db.static_ips.find({"HASH": tofind})

			salida=db.static_sms.aggregate([{'$match':{'HASH': tofind}},{'$project': {'HASH': 1,'cantidad': { '$size': "$log" }}}])
			num_sms=None
			for doc in salida:
			    num_sms=doc['cantidad']
			smss=db.static_sms.find({"HASH": tofind})

			salida=db.IPsPaises.aggregate([ {'$match':{'HASH':tofind}},{ '$unwind' : "$IPs" }, { '$group' : {'_id' : "$_id", 'IPs' : {'$sum':1}  } }  ]);
			num_dips=None
			for doc in salida:
			    num_dips=doc['IPs']
			paises=db.IPsPaises.aggregate([{'$match':{'HASH':tofind}},{'$unwind': '$IPs'},{'$group': {'_id': '$IPs.Pais', 'sum': {'$sum': 1}}}]);
			maliciosas=db.IPsMaliciosas.find({"HASH": tofind})

			salida=db.payload.aggregate([{'$match':{'HASH': tofind}},{'$project': {'HASH': 1,'cantidad': { '$size': "$log" }}}])
			num_pay=None
			for doc in salida:
			    num_pay=doc['cantidad']
			payload=db.payload.find({"HASH": tofind})

			tiene_valoracion_permisos=False
			puntuacion_permisos=None
			cursor.execute("select Puntuacion from puntuaciones where HASH=%s",[tofind])
                        if cursor.rowcount!=0:
				tiene_valoracion_permisos=True
				puntuacion_permisos = cursor.fetchone()
			tiene_valoracion_sys=False
                        valoracion_sys=None
                        cursor.execute("select Puntuacion from puntuaciones_sys where HASH=%s",[tofind])
                        if cursor.rowcount!=0:
                                tiene_valoracion_sys=True
                                valoracion_sys = cursor.fetchone()
			cursor.close()
                        dba.close()
			return render(request,'informacion.html', {'resultado':resultsList, 'permisos':res, 'num_apk_install':num_apk_install,'apk_install':apk_install,'num_inject':num_inject,'injects':injects,
			'num_root':num_root,'roots':roots, 'num_ips':num_ips, 's_ips': s_ips, 'num_sms':num_sms, 'smss':smss, 'num_dips':num_dips, 'paises':paises, 'maliciosas':maliciosas, 'eshash': eshash,
			 'num_pay': num_pay, 'payload': payload, 'tiene_valoracion_permisos':tiene_valoracion_permisos, 'puntuacion_permisos':puntuacion_permisos, 'tiene_valoracion_sys':tiene_valoracion_sys,
			'valoracion_sys':valoracion_sys})
		else:
			return HttpResponseRedirect('/')


def contact(request):

    errors = []
    if request.method == 'POST':
        if not request.POST.get('subject', ''):
            errors.append('Enter a subject.')
        if not request.POST.get('message', ''):
            errors.append('Enter a message.')
        if request.POST.get('email') and '@' not in request.POST['email']:
            errors.append('Enter a valid e-mail address.')
        if not errors:
          try:
            send_mail(
                request.POST['subject'],
                request.POST['message'],
                request.POST.get('email', 'support@ruunalbe.com'),
                ['jfranguerrero@gmail.com'],
            )
            return HttpResponseRedirect('/')
          except Exception, err:
            return HttpResponse(str(err))
    return render(request, 'contact_form.html',
        {'errors': errors})


def listado(request):
	db = MySQLdb.connect("localhost","root","M1_m2m3m4","apk" )
	cursor=db.cursor()
	cursor.execute("select * from aplicaciones order by fecha desc")
	ultimosadd = []
	ultimosvisit = []
	resultado=cursor.fetchall()
        x = cursor.description
        for r in resultado:
            i = 0
            d = {}
            while i < len(x):
                d[x[i][0]] = r[i]
                i = i+1
            ultimosadd.append(d)
	cursor.close()
        db.close()
	return render(request,'listado.html', {'ultimosadd':ultimosadd})



def SaveProfile(request):
   saved = False
   existe = False
   nano=''
   if request.method == "POST":
      #Get the posted form
      MyProfileForm = ProfileForm(request.POST, request.FILES)
      
      if MyProfileForm.is_valid():
         profile = Profile()
         profile.picture = MyProfileForm.cleaned_data["picture"]
         profile.save()
	 nano=profile.filename
	 hash_apk=hashlib.md5(open(os.path.join(settings.MEDIA_ROOT, nano), 'rb').read()).hexdigest()
	 db = MySQLdb.connect("localhost","root","M1_m2m3m4","apk" )
         cursor=db.cursor()
         saved = True
 	 cursor.execute("select * from aplicaciones where HASH=%s",[hash_apk])
	 data=cursor.fetchall()

	 if len(data)!=0:
         	os.remove(os.path.join(settings.MEDIA_ROOT,nano))
		existe= True
	 else:
	 	nano=os.path.basename(nano)
	 	os.rename(settings.MEDIA_ROOT+'/pictures/'+nano,settings.MEDIA_ROOT+'/files/'+nano)
   else:
      MyProfileForm = Profileform()
		
   return render(request, 'saved.html', locals())
