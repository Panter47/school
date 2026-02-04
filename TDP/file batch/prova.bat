:: Codice di prova

@echo off
cls

echo Creo la cartella appunti
md %userprofile%\Desktop\Appunti

echo Creo la cartella Sistemi
md %userprofile%\Desktop\Appunti\Sistemi

echo Creo la cartella Informatica
md %userprofile%\Desktop\Appunti\Informatica

dir %userprofile% > %userprofile%\Desktop\Appunti\Sistemi\files.txt

copy %userprofile%\Desktop\Appunti\Sistemi\files.txt %userprofile%\Desktop\Appunti\Informatica

pause
 
rd %userprofile%\Desktop\Appunti\Informatica