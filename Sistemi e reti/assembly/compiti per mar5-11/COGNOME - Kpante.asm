;kpante tchen aaron   3c inf   28/10/2024


;Scrivere e collaudare un programma che permette di salvare in memoria, a partire dalla locazione 200h, il vostro cognome, inserito da tastiera. Il programma ristampa poi il cognome incrementando ogni lettera di 2.

org 100h 

;assegno a [di] la la locazione 0200h
mov di, 0200h
;faccio immettere da tastiera una lettera e l'ha aumento di 2 e poi la vado a salvare nella nella locazione 0200h attraverso l'indirizzamento indiretto  
mov ah, 1
int 21h 
mov [di],al
add [di],2
;incremento [di] di uno cosi da passare alla locazione successiva 
inc di 
;faccio immettere da tastiera una lettera e l'ha aumento di 2 e poi la vado a salvare nella nella locazione 0201h attraverso l'indirizzamento indiretto                                                                       
int 21h 
mov [di],al
add [di],2
;incremento [di] di uno cosi da passare alla locazione successiva
inc di 
;faccio immettere da tastiera una lettera e l'ha aumento di 2 e poi la vado a salvare nella nella locazione 0202h attraverso l'indirizzamento indiretto
int 21h 
mov [di],al
add [di],2                
;incremento [di] di uno cosi da passare alla locazione successiva
inc di 
;faccio immettere da tastiera una lettera e l'ha aumento di 2 e poi la vado a salvare nella nella locazione 0203h attraverso l'indirizzamento indiretto
int 21h  
mov [di],al
add [di],2                                                       
;incremento [di] di uno cosi da passare alla locazione successiva
inc di 
;faccio immettere da tastiera una lettera e l'ha aumento di 2 e poi la vado a salvare nella nella locazione 0204h attraverso l'indirizzamento indiretto
int 21h
mov [di],al
add [di],2                                                       
;incremento [di] di uno cosi da passare alla locazione successiva
inc di 
;faccio immettere da tastiera una lettera e l'ha aumento di 2 e poi la vado a salvare nella nella locazione 0205h attraverso l'indirizzamento indiretto
int 21h  
mov [di],al
add [di],2
; aggiungo uno spazio
mov ah,2
mov dl," "
int 21h 
 
mov di, 0200h ;riporto [di] alla locazione 0200h 
;faccio stampare a schermo a la locazione 0200h e l'ha incrememento di uno 
mov dl,[di]
int 21h
inc di
;faccio stampare a schermo a la locazione 0201h e l'ha incrememento di uno           
mov dl,[di]
int 21h 
inc di
;faccio stampare a schermo a la locazione 0202h e l'ha incrememento di uno
mov dl,[di]
int 21h        
inc di 
;faccio stampare a schermo a la locazione 0203h e l'ha incrememento di uno 
mov dl,[di]
int 21h
inc di 
;faccio stampare a schermo a la locazione 0204h e l'ha incrememento di uno
mov dl,[di]
int 21h
inc di 
;faccio stampare a schermo a la locazione 0205h
mov dl,[di]
int 21h

ret 