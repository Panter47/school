@echo off
set /p folder="Inserisci il percorso della cartella: "

@echo off
set /p cartella="Inserisci il percorso della cartella: "

if not exist "%cartella%" (
    echo La cartella specificata non esiste.
    pause
    exit /b
)

set /a counter=0

for %%f in ("%cartella%\*") do (
    set /a counter+=1
)

echo Ci sono %counter% file nella cartella "%cartella%".
pause
