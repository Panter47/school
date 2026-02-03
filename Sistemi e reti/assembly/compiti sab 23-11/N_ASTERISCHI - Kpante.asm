;Kpante Tchen Aaron 3C inf 22/11/2024

; Data un numero N compreso tra 0 e 9, stampa una riga di N asterischi di colori diversi


org 100h
    
    ;input da tastiera 
    mov ah,1
    int 21h
    
    ;sposto il numero inserito nel registro dl e gli sottrago 30h
    mov dl,al
    sub dl,30h
    
    ;dico che deve usare la memoria VGA 
    mov ax,0b800h
    mov ds,ax 
    mov ch,0001000b 
    mov bx,002h
    mov [0200h],ch ;salvo il colore nella locazione 0200h
asterischi:
    ;faccio stampare asterisco a schermo
    mov ch,[0200h]
    mov cl,"*"
    mov [bx],cx
    
    ;incremento il colore e lo risalvo nella locazione 0200h
    inc ch  
    mov [0200h],ch
    
    xor ch,ch ;svuoto il registro CH 
    add bx,2 ;aggiungo a BX 2 
    
    ;sposto il contenuto del registro DL in CL e decremento DL 
    mov cl,dl
    dec dl    
    loop asterischi    

ret




