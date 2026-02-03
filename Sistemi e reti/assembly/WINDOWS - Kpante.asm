;Kpante Tchen Aaron 3c inf 19/11/2024

;Data una larghezza W e altezza H salvate in opportune variabili, disegnare una cornice di dimensione WxH caratteri (sarebbe bello poter 
;scegliere la posizione in cui disegnarla con altre due variabili X e Y che individuano l'angolo superiore sinistro...). Per il disegno della cornice potete usare qualsiasi carattere.
org 100h

;faccio immetere da tastiera un numero
    mov ah,1
    int 21h

;;sotraggo al numero messo 30 e lo salvo nella locazione 0200h
    mov dl,al 
    sub dl,30h 
    mov [0200h],dl 

;faccio immetere da tastiera un numero  gli sottraggo 31
    int 21h
    mov dh,al
    sub dh,31h

;accedo alla memoria VGA e gl dico di stampare il carattere "-" con il colore bianco su sfondo nero, a partire dalla posizione 000h
    mov ax, 0B800h
    mov ds, ax 
    mov cl,"-"
    mov ch,00000111b 
    mov bx,000h
    mov [bx],cx 


riga1:    
    
    
    dec dl ;decremento di uno il valore di DL
    
    ;faccio stampare il carattere "-" con colore bianco su sfondo nero e incremento la posizione di 2
    mov cl,"-"
    mov ch,00000111b
    add bx,2
    mov [bx],cx
    
    xor cx,cx ;cancello tutto quello che c'e' in CX
    mov cl,dl ;sposto il contenuto di DL in CL 
    
    loop riga1
    
    mov dl,dh ;sposto il contenuto di DH in DL 
    sub dl,2 ; sottrago a DL 2
    mov [0201h],dl ;salvo il contenuto di DL nella locazione 0201h
    add bx,096h  ;aggiungo a BX 096h
capo:    
        
    
    dec dh ;decremento di 1 il valore di DH 
    
    ;faccio stampare il carattere "-" con colore bianco su sfondo nero e incremento la posizione di 2
    mov cl,"-"
    add bx,2
    mov ch, 00000111b
    mov [bx],cx 
    
    xor cx,cx ;cancello tutto quello che c'e' in CX
    mov dl,[0201h] ;sposto quello che e' salvato nella locazione 0201h nel registro DL 
        
        vuoto:
            
            add bx,2 ;aggiungo 2 al valore salvato in BX
            
            ;faccio stampare il carattere "-" con colore bianco su sfondo nero e incremento la posizione di 2
            mov ch,00000111b
            mov cl,"x"
            mov [bx],cx
            
            xor cx,cx ;cancello tutto quello che c'e' in CX
            mov cl,dl ;sposto il contenuto del registro DL nel registro CL 
            dec dl ;decremento di uno DL 
            
            loop vuoto
    
    ;faccio stampare il carattere "-" con colore bianco su sfondo nero e incremento la posizione di 2
    mov cl,"-"
    add bx,2
    mov ch, 00000111b
    mov [bx],cx
    
    xor cx,cx ;cancello tutto quello che c'e' in CX
    mov cl,dh ;sposto il contenuto del registro DH nel registro CL       
 
    add bx,096h ;aggiungo a bx 096h
    
    loop capo

    mov dl,[0200h] ; sposto il contenuto della locazione 0200h nel registro DL

fine:
    dec dl ;decremento di uno DL
    
    ;faccio stampare il carattere "-" con colore bianco su sfondo nero e incremento la posizione di 2
    mov cl,"-"
    mov ch,00000111b
    add bx,2
    mov [bx],cx
    
    xor cx,cx ;cancello tutto quello che c'e' in CX
    mov cl,dl ;sposto il contenuto del registro DL nel registro CL
    
    loop fine
ret
