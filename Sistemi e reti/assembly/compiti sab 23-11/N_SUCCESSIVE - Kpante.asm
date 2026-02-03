;Kpante Tchen Aaron 3C inf 22/11/2024
 
;Data una lettera C ed una cifra N inserite da tastiera stampa gli N caratteri successivi alla lettera data

org 100h
    ;input da tastiera 
    mov ah,1 
    int 21h

    mov bl,al ;salvo la lettera nel registro BL 
    
    ;input da tastiera 
    int 21h 

    ;salvo il numero nel registro CL e gli sottrago 30h
    mov cl,al 
    sub cl,30h
    
    ;vado a capo
    mov ah,2
    mov dl,13
    int 21h
    mov dl,10
    int 21h

lettere: 
    
    inc bl ;passo alla lettera successiva 
    
    ;stampo la lettera 
    mov dl,bl
    int 21h 
    loop lettere    

ret




