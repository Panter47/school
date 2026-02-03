;Kpante Tchen Aaron 3C inf 21/11/2024

;Data una cifra N stampa, a capo, la precedente se minore di 5, la successiva se maggiore o uguale.

org 100h
    ;input da tastiera e lo sposto in BL
    mov ah,1
    int 21h
    mov bl,al
    
    ;vado a capo
    mov ah,2
    mov dl,10
    int 21h
    mov dl,13
    int 21h
       
    cmp bl,"5" ;confronto il numero inserito con 5

    jae maggiore ;se e' maggiore uguale salta
    
    dec bl ;toglie 1 al numero inserito 
        
    jmp stop ;salta allo stop 
    
maggiore:     
    inc bl ;incrementa di 1 il numero inserito 
                
stop:
    ;output numero 
    mov dl,bl
    int 21h        
ret




