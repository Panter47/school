; Kpante Tchen Aaron 30/11/2024
; Date due lettera inserite da tastiera verifica se sono in ordine 
; lessicografico e stampa N in caso negativo, l'elenco delle lettere
; comprese in caso positivo. Il programma termina quando le due lettere
; coincidono stampando il messaggio "...bye" .
;   Es:
;   ah->bcdefg
;   uq->N
;   nn ...bye


;	+----+----+
;	| AH | AL |
;	+----+----+
;	| BH | BL |
;	+----+----+
;	| CH | CL |
;	+----+----+
;	| DH | DL |
;	+----+----+
;	| SI      |
;	+---------+
;	| DI      |
;	+---------+
;	| BP      |
;	+---------+
;	| SP      |
;	+---------+
 
aCapo  MACRO

    mov ah , 2
    mov dl , 10
    int 21h
    mov dl , 13
    int 21h
ENDM        
     



org 0100h 

JMP inizio:
str1 DB 'Lettera 1:',0
str2 DB 'Lettera 2:',0
acapo DB 0dh,0ah,00h
saluto DB '...Bye!',0


inizio:
    
start:
aCapo
 
;Scrittura "Lettera 1:"
    mov bx, offset str1
    mov ah , 2 
lettera1:
    mov dl,[bx] 
    int 21h    
    inc bx
    cmp dl,0h
    je fuori1
    loop lettera1
    
fuori1:        
;Input lettera 1
    mov ah , 1
    int 21h
    mov dh , al  
    
;New Line
    aCapo

;scrittura "lettera 2:"    
    MOV bx, offset str2
lettera2:
    
    mov ah,2
    mov dl,[bx]
    int 21h
    inc bx 
    cmp dl,0h
    je fuori2
    loop lettera2
    
fuori2:     
;input lettera 2    
    mov ah,1 
    int 21h
    mov ch,al 
    
    
;New line
    aCapo
    
    ;Controllo se le lettere sono uguali
    cmp dh , ch
    je exit         ;Finisco il programma
    
    ;Controllo se sono in ordine lessicografico    
    cmp dh , ch
    ja false        ;Scrivo "N"
    
    ;Se sono in ordine scrivo le lettere comprese
    dec ch ;tolgo 1 cosi non va a riscrivere la h    
    included:
        cmp dh , ch
        je start
        inc dh
        mov dl , dh
        int 21h
        jmp included
    
    
    ;Scrivo "N" , new line , Re inizio il programma
    false:
        mov dl , 'N'
        int 21h
        aCapo
        jmp start
         
    
;Chiudo il programma scrivendo "...bye"

      
exit:
    mov bx, offset saluto 
bye:    
    mov dl ,[bx]
    int 21h
    inc bx 
    cmp dl,0h
    je fine3 
    loop bye
   
fine3:   
    ret






