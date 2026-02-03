;Kpante Tchen Aaron  3c inf  15/11/2024

;Implementare un prog. con emu 8086 che consente di inserire una cifra da tastiera, stampa il conto alla rovescia a partire dal numero inserito fino a zero, ogni numero di un colore diverso.

ORG 100h
    
    ; vado a far inserire da tastiera una cifra 
    mov ah,1
    int 21h 
    
    ;sposto la cifra inserita in cl e gli sottrago 30 
    mov cl,al
    mov dl,cl
    sub cl, 30h
    
    ;assegno a BX e CH la posizione il colore di cui fare quella cella 
    MOV BX, 002h      
    MOV CH, 00000001b 
        
rovesca:
     
    ;faccio a stampare a schermo la cifra predente a quella stampata con un colore diverso  
    mov ch,[0002h]
    mov ah,2
    dec dl   
    int 21h
    
    ;dico che deve utilizzare il controllo VGA per modificare la crifra scritta in quella posizione  
    MOV AX, 0B800h   
    MOV DS, AX
    mov cl,dl            
    MOV [BX], CX
      
    inc ch ;incremento il colore di 1 
    mov [0002h],ch ; salvo il colore in memoria 
    add bx,002h ;incremento di 2 la posizione in cui andare a colorare la cella 
    
    ;modifico ch facendolo diventare 00 e sottrago 30 a cl cosi che il contatore per il loop torni al numero giusto 
    mov ch, 0
    sub cl,30h           
                       
    loop rovesca          
    
RET             

                              
                                                                     


