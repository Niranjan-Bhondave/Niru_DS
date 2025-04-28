from django.urls import path
from . import views

urlpatterns = [
    path('', views.interest_input, name='interest_input'),
    path('result/', views.interest_result, name='interest_result'),
]
