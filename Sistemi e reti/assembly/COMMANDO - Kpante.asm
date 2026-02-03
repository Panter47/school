;kpante Tchen Aaron 3C INF 03/12/2024

;e' un vecchio videogame arcade del tipo sparatutto a scorrimento militare. Vogliamo implementare un suo clone  
;su un processore con pochissima memoria RAM (4k). Per riuscire nell'impresa, si è pensato di codificare lo 
;stato del personaggio in una sola WORD (una variabile/registro a 16bit)
;Nella word di stato sono codificati sia valori numerici (ad esempio attributi come la salute, scudo, ecc) 
;sia flag booleani (ad esempio "modalità ghost" o "possiede chiave"). 
;La codifica dei 16 bit è la seguente:


;creo la macro per andare a capo 
aCapo    MACRO 
    mov ah,2
    mov dl,10
    int 21h 
    mov dl,13 
    int 21h
endm


org 100h

jmp inizio:

;inizializzo le variabili: scudo, vita, ghost, invisibile, armi, chiave e direzione.
    scudo DB "livello scudo: ",0
    vita DB "hp: ",0
    ghost DB "ghost mode: ",0
    invisibile DB "invisibile: ",0
    Arma DB "tipo di arma: ",0
    chiave DB "possiede la chiave speciale: ",0
    direzione DB "direzione corrente: ",0

inizio:

;output variabile scudo     
    mov bx, offset scudo
    mov ah,2
scudo1:     
    mov dl,[bx]
    int 21h
    inc bx 
    cmp dl,0h
    je fuori1
    loop scudo1 
    
fuori1:
        
    mov bx, 0B12Bh ;codice dello stato del personaggio
    shr bx,13 ;dico quanti bit mi servono in questo momento 
    and bx,07h ;rendo 0 i bit che non mi servono 
    add bx,"0" ;rendo il numero scrivibile in codice ascii
    mov dl,bl ;output valore
    int 21h
    
    aCapo

;output variabile scudo      
    mov bx,offset vita

vita1:     
    mov dl,[bx]
    int 21h
    inc bx
    cmp dl,0h
    je fuori2 
    loop vita1

fuori2:        
    
    mov bx, 0B12Bh ;codice dello stato del personaggio
    shr bx,09 ;dico quanti bit mi servono in questo momento 
    and bx,0Fh ;rendo 0 i bit che non mi servono 
    add bx,"0" ;rendo il numero scrivibile in codice ascii 
    mov dl,bl ;output valore
    int 21h
    
    aCapo

;output variabile scudo      
    mov bx,offset ghost
    
ghost1:
     
    mov dl,[bx]
    int 21h
    inc bx 
    cmp dl,0h
    je fuori3
    loop ghost1 
    
fuori3:
    
    mov bx, 0B12Bh ;codice dello stato del personaggio
    shr bx,08 ;dico quanti bit mi servono in questo momento 
    and bx,01h ;rendo 0 i bit che non mi servono 
    add bx,"0" ;rendo il numero scrivibile in codice ascii
    mov dl,bl ;output valore
    int 21h
      
    aCapo 

;output variabile scudo      
    mov bx, offset invisibile
    
invisibile1:
    mov dl,[bx]
    int 21h
    inc bx
    cmp dl,0h
    je fuori4
    loop invisibile1
    
fuori4:

    mov bx, 0B12Bh ;codice dello stato del personaggio
    shr bx,07 ;dico quanti bit mi servono in questo momento 
    and bx,01h ;rendo 0 i bit che non mi servono 
    add bx,"0" ;rendo il numero scrivibile in codice ascii
    mov dl,bl ;output valore
    int 21h 
    
    aCapo

;output variabile scudo    
    mov bx, offset arma

arma1:

    mov dl,[bx]
    int 21h
    inc bx
    cmp dl,0h
    je fuori5
    loop arma1

fuori5:           

    mov bx, 0B12Bh ;codice dello stato del personaggio
    shr bx,04 ;dico quanti bit mi servono in questo momento 
    and bx,07h ;rendo 0 i bit che non mi servono 
    add bx,"0" ;rendo il numero scrivibile in codice ascii
    mov dl,bl ;output valore
    int 21h 

    aCapo

;output variabile scudo    
    mov bx,offset chiave 

chiave1:

    mov dl,[bx]
    int 21h
    inc bx
    cmp dl,0h
    je fuori6
    loop chiave1
    
fuori6:
    
    mov bx, 0B12Bh ;codice dello stato del personaggio
    shr bx,03 ;dico quanti bit mi servono in questo momento 
    and bx,01h ;rendo 0 i bit che non mi servono 
    add bx,"0" ;rendo il numero scrivibile in codice ascii
    mov dl,bl ;output valore
    int 21h 
        
    aCapo

;output variabile scudo    
    mov bx, offset direzione

direzione1:

    mov dl,[bx]
    int 21h
    inc bx
    cmp dl,0h
    je fuori7
    loop direzione1

fuori7:
    
    mov bx, 0B12Bh ;codice dello stato del personaggio
    and bx,07h ;rendo 0 i bit che non mi servono 
    add bx,"0" ;rendo il numero scrivibile in codice ascii
    mov dl,bl ;output valore
    int 21h
        
ret




