;Kpante Tchen Aaron 3C inf 26/11/2024
 
;Leggere due caratteri da tastiera e stampare 'S' se sono successivi sulla tavola scii, 'N' altrimenti.

org 100h
    
    ;input da tastiera 
    mov ah,1
    int 21h
    
    ;copio la lettera inserita nel registro BL 
    mov bl,al
    
    ;input da tastiera 
    int 21h 
    
    mov ah,2
    ;sposto la lettera inserita nel registro BH 
    mov bh,al
    
    ;sottrago tra di loro le lettere, nel l'ordine prima lettera inserita - seconda lettera inserita, e se il risultato e' 1h, si attiva il jump 
    sub al,bl
    cmp al,1h
    je successivi
    
    ;sottrago tra di loro le lettere, nel l'ordine seconda lettera inserita - prima lettera inserita, e se il risultato e' 1h, si attiva il jump
    sub bl,bh
    cmp bl,1h
    je successivi 
    
    ;stampa N se le lettere inserite non sono in alcun modo successive tra di loro      
    mov dl,"N"
    int 21h 
    jmp fine 
    
successivi:
    
    ;stampa S se le lettere inserite sono successive tra di loro 
    mov dl,"S"
    int 21h
        
fine:
ret




