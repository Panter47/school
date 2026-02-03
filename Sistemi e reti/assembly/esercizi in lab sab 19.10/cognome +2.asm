;kpante tchen aaron   3c inf   28/10/2024


;Scrivere e collaudare un programma che permette di salvare in memoria, a partire dalla locazione 200h, il vostro cognome, inserito da tastiera. Il programma ristampa poi il cognome incrementando ogni lettera di 2.

org 200h

;faccio immettere da tastiera ogni lettere e la metto in una cella di locazione a partire da 200h
mov ah, 1
int 21h 
mov [di],al
                                                                       
int 21h 
mov [di+1],al

int 21h 
mov [di+2],al

int 21h  
mov [di+3],al

int 21h
mov [di+4],al

int 21h  
mov [di+5],al
; aggiungo uno spazio
mov ah,2
mov dl," "
int 21h 
;aggiungo a ogni lettera 2 cosi da poter incrementare ogni lettera di 2 
add [di],ah
add [di+1],ah
add [di+2],ah
add [di+3],ah
add [di+4],ah
add [di+5],ah 
;stampo a schermo ogni lettera inserita incrementata di 2 utilizzando un indirizzamento indiretto 
 
mov dl,[di]
int 21h
           
mov dl,[di+1]
int 21h 

mov dl,[di+2]
int 21h        
 
mov dl,[di+3]
int 21h

mov dl,[di+4]
int 21h

mov dl,[di+5]
int 21h

ret 