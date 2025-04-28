from django import forms

class InterestForm(forms.Form):
    principal = forms.FloatField(label='Principal', min_value=0)
    rate = forms.FloatField(label='Rate (Annual %)', min_value=0)
    time = forms.FloatField(label='Time (Years)', min_value=0)
