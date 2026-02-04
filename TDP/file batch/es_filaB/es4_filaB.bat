@echo off

set /p extensions="Inserisci le estensioni dei file separate da spazi (esempio: txt docx pdf)"

for %%E in (%extensions%) do (
    set found=0
    for %%F in (*.%%E) do (
        echo File trovato: %%F
        set /a found+=1
    )
    
    if %found%==0 (
        echo Nessun file con estensione %%E trovato
    ) else (
        echo Totale file %%E: %found%
    )
)

pause