from django.shortcuts import render, redirect
from .forms import InterestForm

def interest_input(request):
    if request.method == 'POST':
        form = InterestForm(request.POST)
        if form.is_valid():
            # Get cleaned data
            p = form.cleaned_data['principal']
            r = form.cleaned_data['rate']
            t = form.cleaned_data['time']

            # Calculate simple interest
            si = (p * r * t) / 100

            # Pass data via session (or URL, or context) — session is clean
            request.session['si'] = si
            request.session['p'] = p
            request.session['r'] = r
            request.session['t'] = t

            return redirect('interest_result')
    else:
        form = InterestForm()

    return render(request, 'core/interest_input.html', {'form': form})

def interest_result(request):
    si = request.session.get('si')
    p = request.session.get('p')
    r = request.session.get('r')
    t = request.session.get('t')

    return render(request, 'core/interest_result.html', {
        'si': si,
        'p': p,
        'r': r,
        't': t,
    })
