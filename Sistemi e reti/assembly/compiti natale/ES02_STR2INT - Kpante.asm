;Kpante Tchen Aaron 3C INF 07/01/2024

;partendo dall’esempio1, estendere la logica del programma in modo che
;supporti numeri fino a 255 (ancora meglio sarebbe fino a 65535).

data segment
    ; add your data here!
    cifra db "inserire un numero a 3 cifre: $"
    num db 4,?,4  dup(?)
ends

stack segment
    dw   128  dup(0)
ends

code segment
start:
; set segment registers:
    mov ax, data
    mov ds, ax
    mov es, ax

    ;stampa a schermo la stringa CIFRA        
    lea dx, cifra
    mov ah, 9
    int 21h        
    
    ;salva le cifre inserite nella stringa NUM
    lea dx, num    
    mov ah, 0Ah
    int 21h 
    
    MOV SI, OFFSET num ; Carica l'indirizzo della stringa in SI
    INC SI
    INC SI
    MOV AL, [SI] ; Carica il primo carattere (decine) in AL
    SUB AL, '0' ; Converti il carattere da ASCII a intero
    MOV AH, 0 ; Azzera AH per lavorare con un numero 16-bit
    MOV BL, 100 ; Moltiplicatore per il posto delle decine
    MUL BL ; AX = decina * 10
    MOV DX,AX
    INC SI ; Passa al carattere successivo (unita')
    MOV AL, [SI] ; Carica il secondo carattere in DL 
    XOR AH,AH
    SUB AL, '0' ; Converti da ASCII a intero
    MOV BL,10
    MUL BL
    ADD AX, DX ; Somma le unita' al totale
    INC SI
    MOV DL,[SI]
    SUB DL,"0" 
    XOR DH,DH
    ADD AL,DL
; AX ora contiene il numero converti
    
    mov ax, 4c00h ; exit to operating system.
    int 21h


    
ends

end start ; set entry point and stop the assembler.
