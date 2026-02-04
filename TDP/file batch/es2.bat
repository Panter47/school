@echo off 

cls 

set dispari=0
set pari=0

echo se si vuole terminare il programma inserire 0

:numeri

set /p numero=inserire un numero

if %numero%==0 (
	goto fine
)

set /a resto=%numero% %% 2

if %resto%==0 (
	set /a pari+=1
) else (
	set /a dispari+=1
)

goto numeri

:fine 

echo sono stati inseriti %pari% numeri pari
echo sono stati inseriti %dispari% numeri dispari

pause