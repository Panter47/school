@echo off
set /p colore1="Inserisci il primo colore: "
set /p colore2="Inserisci il secondo colore: "
set /p colore3="Inserisci il terzo colore: "

echo %colore1% > colori.txt
echo %colore2% >> colori.txt
echo %colore3% >> colori.txt

rem Mostra il contenuto del file colori.txt
echo Il contenuto del file colori.txt è:
type colori.txt

pause
