;Kpante Tchen Aaron 3C inf 22/11/2024

;Data una lettere minuscola in input stampa la corrispondente maiuscola (qualsiasi altro carattere viene ignorato). Il programma continua a 
;fare a conversione e si interrompe solo alla pressione della barra spaziatrice, stampando poi un saluto


org 100h
 
maiuscola:
    
    ;input da tastiera 
    mov ah,1
    int 21h
    
    ;output 
    mov ah,2
    
    ;controlla che il carattere inserito non sia SPAZIO o al di fuori dell'alfabeto in minuscolo 
    cmp al," "
    je fine
    cmp al,60h
    jb fuori
    cmp al,7Bh
    ja fuori
    
    mov bl,al ;copio la lettera nel registro BL 
    
    ;stampo la freccia
    mov dl,"-"
    int 21h
    mov dl,">"
    int 21h 
    
    ;sottrago 20h alla lettera inserita e la vado a stampare 
    sub bl,20h
    mov dl,bl
    int 21h
    
fuori:
    
    ;vado a capo
    mov dl,10
    int 21h
    mov dl,13
    int 21h 
    
    loop maiuscola   
    
fine:

    ;stampo il saluto 
    mov dl,"b"
    int 21h
    mov dl,"y"
    int 21h 
    mov dl,"e"
    int 21h
    mov dl,"!"
    int 21h    
    
ret




