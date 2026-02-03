; Kpante Tchen Aaron 3c inf 02/11/2024

;Implementare un prog. con emu 8086 che riceve in input parole fino a 10 caratteri. All'inserimento di ogni lettera, stampa accanto la traslata di 13 posti (ad es. A -> N), va a capo e accetta la successiva lettera.  

org 100h  
 
mov cx, 10 ;assegno a cx 10 cosi da indicare che il loop si ripetera' per 10 volte 

lettera:  
    ;faccio immettere da tastiera un carattere 
    mov ah,1 
    int 21h 
    mov ah,2
    
    cmp al,4Dh
    ja alfa1    
    ;sommo 13 al carattere immesso da tastiera 
    add al, 13
    ;vado a stampare il carattere implementato di 13
    mov dl,al
    int 21h
    
    jmp spazio

alfa1:
    mov bl,"["
    mov bh,13
    mov dh,"A"
    sub bl,al
    
    sub bh,bl
    
    add dh,bh
    
    mov dl,dh
    int 21h    


spazio:        
    ;faccio andare alla riga successiva 
    mov dl,10
    int 21h
    ;faccio andare all'inizio della riga 
    mov dl,13
    int 21h
    loop lettera 
     
ret




