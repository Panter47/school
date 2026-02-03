;kpante Tchen Aaron 3C INF 07/01/2024

;partendo dall’esempio2, estendere la logica del programma in modo che
;supporti numeri a 8bit e stampi numeri fino a 255 (per i più ardimentosi numeri fino a
;(65535).

data segment

    num DB 255 ; Numero a tre cifre da stampare
ends
stack segment
    dw 128 dup(0)
ends
code segment
start: ; Imposta il data segment:
    MOV AX, data
    MOV DS, AX
    ; Carica il numero da stampare
    XOR AH,AH ; Resetta la parte alta di AX
    MOV AL, num ; Carica il valore della variabile num in AL
    MOV BL, 100 ; Divisore a 8 bit per separare decine e unita'
    DIV BL ; AL -> quoziente (decine), AH -> resto (unità)
    MOV BL, AH ; Salva in BL il resto
    ; Stampa la decina
    ADD AL, '0' ; Converte la decina in carattere ASCII
    MOV DL, AL ; Carica il carattere nel registro DL per la stampa
    MOV AH, 02H ; Funzione DOS per stampare un carattere
    INT 21H ; Interruzione per eseguire la stampa
    ; Stampa l'unita'
    MOV AL, BL ; Carica il resto (unita') in AL
    XOR AH,AH
    MOV BL,10
    DIV BL
    MOV BL,AH
    ADD AL, '0' ; Converte l'unità in carattere ASCII
    MOV DL, AL ; Carica il carattere nel registro DL per la stampa
    MOV AH, 02H ; Funzione DOS per stampare un carattere
    INT 21H ; Interruzione per eseguire la stampa 
    
    ;stampo a schermo 
    MOV AL,BL
    ADD AL,"0"
    MOV DL,AL
    MOV AH,2
    INT 21H
    
    MOV AX, 4c00h ; exit to operating system.
    INT 21H
ends
end start ; set entry point and stop the assembler.