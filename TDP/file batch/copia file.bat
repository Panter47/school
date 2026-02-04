@echo off
cls
:partenza

set /p cartella=scrivere la cartella dai cui copia i file .txt: 

if not exist %cartella% (
	echo ERRORE: la cartella non esiste!
	pause 
	goto partenza 
)
	
set /p desti=scrivere la cartella di destinazione:  

if not exist %desti% (
	echo creazione della cartella %desti%	
	md %desti%
)

copy "%cartella%\*.txt" "%desti%\"

echo sono stati copiati i file .txt

echo uscita in corso...

pause

exit