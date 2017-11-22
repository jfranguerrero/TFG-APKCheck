#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""web_tfg URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url, include
from django.contrib import admin
from apkdata import views
from django.views.generic import TemplateView

urlpatterns = [
    url(r'^$', views.index, name='index'),
    url(r'^admin/', admin.site.urls),
    url(r'^buscar/$', views.buscar, name='buscar'),
    url(r'^contacto/', views.contact, name='contacto'),
    url(r'^listado/', views.listado, name='listado'),
    url(r'^upload/', TemplateView.as_view(template_name="profile.html"),name='upload'),
    url(r'^saved/', views.SaveProfile, name = 'saved'),
]
