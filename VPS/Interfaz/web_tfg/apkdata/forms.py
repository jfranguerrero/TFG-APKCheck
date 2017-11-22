#-*- coding: utf-8 -*-
from django import forms
from .validators import validate_file_extension

class ProfileForm(forms.Form):
   picture = forms.FileField(validators=[validate_file_extension])
