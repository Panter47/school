;Kpante Tchen Aaron 3C INF 30/11/2024

 
; Data una lettera da tastiera, stampare a schermo le successive 4 in modo che si alternino Maiuscole e minuscole.

org 100h

    ;input da tastiera 
    mov ah,1
    int 21h

    xor cx,cx;svuoto cx  
    mov cx,2;ripeto il ciclo 2 volte 
    
    ;output
    mov ah,2
    
lettera: 
    
    ;stampo la lettera successiva maiuscola 
    inc al
    sub al,20h
    mov dl,al
    int 21h 
    
    ;stampo la lettera successiva minuscola 
    inc al
    add al,20h
    mov dl,al
    int 21h
    
    loop lettera

ret




