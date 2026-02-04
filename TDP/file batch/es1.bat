@echo off 

cls 

cd c:\%usersprofile%\desktop

set /p cartella=inserire il nome della cartella 

if not exist %cartella% (
	echo creazione della cartella %cartella%
	md %cartella%
)

set /p nomefile=inserire il nome dei file da creare.

for /l %%i in (1,1,10) do (
echo > %cartella%\%nomefile%%%i.txt
)

echo file creati

pause
	
	