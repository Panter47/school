;Kpante Tchen Aaron 3C INF 06/12/2024

;Leggi una sequenza di caratteri da tastiera (terminata da INVIO), e 
;forzala tutta in maiuscolo senza usare SOTTRAZIONI
aCapo macro
    mov ah,2 
    mov dl,10
    int 21h 
    mov dl,13
    int 21h
endm

org 200h

;input da tastiera a partire dalla locazione 0200h
mov bx,0200h
mov ah,1


lettere: 
     
;controllo che non venga scritto invio e salvo la lettera scritta nella locazione successiva  
    int 21h 
    cmp al,13
    je stop 
    mov [bx],al
    inc bx
    inc dh
    loop lettere

stop:
    
;nuova linea, leggo a partire dalla locazione 0200h e imposto il counter del loop
    aCapo
    xor cx,cx    
    mov ah,2
    mov cl,dh 
    mov bx,0200h
let:
    
;controllo che la lettera sia minuisca nel caso contrario la converto e la stampo a schermo    
    mov dl,[bx]
    inc bx
    cmp dl,"Z"
    jna minuscolo
    jmp suc

minuscolo: 
    or dl,00100000b
suc:    
    int 21h
    loop let                 

ret




