;Kpante Tchen Aaron 3c inf 02/11/2024

;Implementare un prog. con emu 8086 che consente di inserire una cifra da tastiera, quindi va a capo e stampa il conto alla rovescia a partire dal numero inserito fino a zero.

org 100h   
;faccio immetere una cifra da tastiera e la salvo nella locazione 0001h, cosi da poterla assegnare a cx e gli sottrago 30 cosi assegnargli il numero giusto delle volte che si deve riperete il loop
mov ah,1 
int 21h
mov [0001h],al
mov cx,[0001h] 
sub cx, 30h
 
rovesca:
    ;faccio stampare a schermo a capo il numero antecedente a quello scritto fino a 0
    mov ah,2
    mov dl,10
    int 21h 
    mov dl,13
    int 21h
    dec [0001h] 
    mov dl,[0001]
    int 21h
    loop rovesca 

;faccio stampare a capo
mov dl,10
int 21h
mov dl,13
int 21h

ret




