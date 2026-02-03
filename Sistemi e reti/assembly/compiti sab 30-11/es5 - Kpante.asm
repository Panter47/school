;Kpante Tchen Aaron 3C INF 30/11/2024

 
;Dato l'input di un tasto qualsiasi stamparne il codice ASCII corrispondente in esadecimale. 
;Per la risoluzione del problema si suggerisce di ricorrere agli operatori SHR e AND. 
;Il programma termina alla pressione del tasto '\'

freccia      MACRO
    
    mov ah,2
    mov dl,"-"
    int 21h 
    mov dl,">"
    int 21h

ENDM     
        
org 100h

    mov ah,1
    int 21h 

    mov bl,al

    freccia 
    
     bl,cl
    mov dl,bl
    int 21h



ret




