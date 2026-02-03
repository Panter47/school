;Kpante Tchen Aaron 3C INF 17/12/2024

;ROT13 - Richiedere l'immisione di una stringa da tastiera. Codificare il testo immesso con ROT13, 
;badando a rimuovere gli spazi e punteggiature, trasformando tutto in minuscolo e senza alterare le cifre.
org 100h
jmp lettera

str1 db "immettere il testo in chiaro: $"
str2 db 100,?,100 dup(?)

lettera:

;stampa la stringa
    mov dx, offset str1
    mov ah,9
    int 21h  
;salvo nella stringa il carattere messo     
    mov dx, offset str2
    mov ah,0Ah
    int 21h

;applico come ultimo carattere della stringa $    
    xor bx,bx 
    mov bl,str2[1]
    mov str2[bx+2],"$"
    
;applico il ROT13 a ogni carattere presente nella stringa            
    lea bx,str2+2
controllo:

    cmp [bx],"$"
    je fuori

;controllo che non sia un cifra        
    cmp [bx],"0"
    jna prossimo
    
    cmp [bx],"9"
    jb prossimo
    
    ;cmp [bx]," "
    ;je

;controllo se per il ROT13 c'e' bisogno di tornare alla lettera A    
    cmp [bx],4Dh
    ja alfa1    
    ;sommo 13 al carattere immesso da tastiera 
    add [bx], 13
    jmp prossimo

alfa1:
;fa riprende dalla lettera A il ROT13
    mov dl,"["
    mov ah,13
    mov dh,"A"
    sub dl,al
    
    sub ah,dl
    
    add dh,ah
    
    mov [bx],dh    
   
prossimo:
    inc bx 
    jmp controllo   

fuori:

;stampa la stringa
    mov bx,offset str2+2
    mov ah,9
    int 21h    

ret




