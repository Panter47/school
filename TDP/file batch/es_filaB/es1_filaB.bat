@echo off
set /p numero="Inserisci un numero: "
set fattoriale=1

for /l %%i in (1,1,%numero%) do (
    set /a fattoriale*=%%i
)

echo Il fattoriale di %numero% è %fattoriale%
pause
