# -*- coding: utf-8 -*-

from __future__ import unicode_literals
from django.core.exceptions import ValidationError
from django.db import models
from .validators import validate_file_extension
from django_fake_model import models as f
# Create your models here.


class Profile(models.Model):
   picture = models.FileField(upload_to = 'pictures',validators=[validate_file_extension])

   class Meta:
      db_table = "profile" 

   @property
   def filename(self):
       return self.picture.name
