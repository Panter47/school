;Kpante Tchen Aaron 3C INF 17/12/2024

;Richiedere l'immissione di una stringa con caratteri qualsiasi; a capo, stampare la stringa in caratteri maiuscoli.

aCapo macro
    mov ah,2 
    mov dl,10
    int 21h 
    mov dl,13
    int 21h
endm

org 100h
jmp start
str1 db "inserisci una stringa: $" 
str2 db 100,?,100 dup(?)

start:
;stampo la str1 a schermo    
    mov dx, offset str1
    mov ah,9
    int 21h

;salvo quello che viene immesso da tastiera nella str2    
    mov dx, offset str2
    mov ah, 0Ah
    int 21h

;aggiungo il carattere $ a fine stringa
    xor bx,bx
    mov bl,str2[1]
    mov str2[bx+2],"$"

;forzo se necessario il carattere in maiuscolo    
    lea bx,str2+2
maiuscolo:    
    cmp [bx],"$"    
    je stampa    
    cmp [bx],"A"    
    jb incrementa    
    and [bx],11011111b
incrementa:    
    inc bx 
    jmp maiuscolo  

;stampa stringa
stampa:     
    aCapo 
    mov dx, offset str2+2
    mov ah,9
    int 21h

ret
