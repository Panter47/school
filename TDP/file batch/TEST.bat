@echo off 

cls

::set numero=5

:: set /p serve per richiedere in input come scanf
set /p numero1=inserire il primo numero:  

set /p numero2=inserire il secondo numero: 

::set/a serve per stampare il valore della variabile e non es 5+6 MA  11

set /a somma=%numero1%+%numero2%

echo %somma%


