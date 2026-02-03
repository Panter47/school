;Kpante Tchen Aaron 3c inf 04/11/2024

;Eseguire e studiare il sorgente in allegato, Scrivere modificarlo in modo che:
;a. scriva il vostro nome nell'angolo in alto a sinistra in bianco su nero
;b. scriva il vostro cognome nell'angolo in basso a destra distanziando ogni carattere con uno spazio e in modo che ogni lettera sia di un colore diverso
;c. scriva la vostra data di nascita al centro dello schermo in multicolor e lampeggiante (dovrete scoprire come si fa).

org 100h

    MOV AX, 0B800h    ;indiciamo che andiamo a utilizzare il controllo VGA  
    MOV DS, AX        ;facciamo collegare il data segment alla VGA 
    MOV CL, 'A'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo 
    MOV CH, 00000111b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 000h      ;decidiiamo in che punto in cui vissualizzare             
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx 

    MOV CL, 'A'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000111b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 002h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'R'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000111b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 004h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'O'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000111b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 006h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'N'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000111b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 008h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'K'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000110b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 948h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'P'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000101b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 94Ch      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'A'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000011b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 950h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'N'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000100b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 954h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'T'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001111b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 958h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, 'E'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001010b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 95Ch      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, '1'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001111b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 368h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, '1'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001011b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 36Ah      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, '/'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001101b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 36Ch      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
     
    MOV CL, '0'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001110b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 36Eh      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, '4'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001100b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 370h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, '/'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00000111b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 372h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, '2'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001001b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 374h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, '0'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001010b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 376h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    
    MOV CL, '0'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001000b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 378h      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx
    MOV CL, '8'       ;scriviamo la lettera che vogliamo vissualizzare sullo schermo
    MOV CH, 00001101b ;decidiamo il colore, se evidenziato e di che colore
    MOV BX, 37Ah      ;decidiiamo in che punto in cui vissualizzare  
    MOV [BX], CX      ;diciamo come vissualizzare la cella indicata da bx    


ret  