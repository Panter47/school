;kpante tchen aaron 3c inf 29/10/2024

;Implementare un prog. con emu 8086 che popola le locazioni di memoria a partire da 0xggmmh con i caratteri stampabili del codice ASCII, dove mm è il vostro mese di nascita e gg il vostro giorno di nascita. Alla pressione di un tasto qualsiasi il programma stampa poi tutti i codici salvati in memoria, uno per riga.

org 100h
 
mov di,1104h ;assegno a di la locazione 1104h

    xor bx,bx ;controlla che in bx non ci sia niente la svota 
    mov bx, 32 ;assegna a bx il valore di 32 cosi da cominciare a scrivere il codice ascii

    mov cx, 224 ;assegna a cx il valore 224 cosi da dire al loop che si dovra' ripere 224 volte 

ascii:
    mov [di],bx  
    inc bx ;incrementa bx al valore successivo cosi da salvare in memoria uno a uno il codice ascii
    inc di ;incrementa di cosi da andare a salvare il prossimo codice ascii nella locazione successiva 
    loop ascii
              
    mov cx,224 ;ri assegnamo a cx il valore 224 cosi da far ripere il loop 224
    mov di,1104h ; ri assegnamo a di la locazione 1104h
    ; assegnamo ad ah 1 cosi da poter scrivere un carattere a schermo  
    mov ah,1
    int 21h
stampa:
    ;assegnamo ad ah 2 cosi da poter stampare a schermo, e dl a di cosi da poter stampare la locazione assegnanta a di
    mov ah,2 
    mov dl, [di]
    int 21h   
    ;assegnamo a dl 10 cosi da poter andare alla riga successiva 
    mov dl,10 
    int 21h                                                      
    ;assegnamo a dl13 cosi da poter tornare all'inizio della riga 
    MOV dl,13
    int 21h
    inc di ;incrementiamo di di uno cosi da poter leggere la locazione successiva 
    loop stampa 

ret




