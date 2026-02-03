;Kpante Tchen Aaron 3c inf 15/11/2024

;Stampare il codice ASCII Esteso, in modo che per ogni carattere cambino colore in primo piano e background


org 100h

    xor cx,cx; cancello tutto quello che e' salvato in CX 
    
    ; imposto le volte che si deve riperete il ciclo, imposto il colore e la posizione.
    mov cx,255
    MOV CH, 01011111b 
    MOV BX, 000h   
    
ascii:
    ;
    mov ch,al
    mov dl,cl
    
    ;dico che deve usare la memoria VGA, gli dico il carattere e in che punto deve farlo.
    MOV AX, 0B800h    
    MOV DS, AX        
    MOV CL, dh           
    MOV [BX], CX
    
    ;incremento la posizione, cambio colore, incremento il codice ascii da stampare 
    add bx,002h  
    inc ch    
    inc dh 
    
    mov cl,dl ; sposto in CL il prossimo carattere ascii da stampare 
    xor ax,ax ; cancello tutto quello che e' salvato in AX
    mov al,ch ; salvo il colore nel registro AL
    mov ch,00 ; salvo 00 nel registro CH 
    
    loop ascii
    
    
ret




