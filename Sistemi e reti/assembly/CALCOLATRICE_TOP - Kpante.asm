data segment
        
    array dw 4 dup(?)   
    
    help db "per poter mettere il segno della potenza premere (shift+6)$"
    help2 db "per poter mettere il segno dell'and premere (shift+7)$"
    scelta db "le operazioni disponibili sono: +,-,*,/,!,&,|,^$"
    input db "Inserire operando, operazione e secondo operando: $"
    str db 20,?,20 dup(?) 
    
    op1 dw 4 dup(?)
    op2 dw 4 dup(?)
    segno db 0
    indice db 1 
    indice2 db 0
    result dw 4 dup(?)
    memory db 200 dup(0)
    cont_rest dw 4 dup(?) 
    
     
    error_op db "ERRORE! Operanzione non riconosciuta. $"
    error_zero db "ERRORE! impossibile dividere per zero. $"
    error_sott db " ERRORE! impossibile sottrare per un numero a un numero piu' piccolo. $"  
        
    send db "bye.$"
    
    resto db " Con un resto di $"
    
    
ends

stack segment
    dw   128  dup(0)
ends

code segment
start:
; set segment registers:
    mov ax, data
    mov ds, ax
    mov es, ax

;stampo a schermo le stringhe HELP, HELP2, INPUT
    mov ah,9
    lea dx,help
    int 21h
    call acapo
    
    mov ah,9
    lea dx,help2
    int 21h
    call acapo

    mov ah,9
    lea dx,scelta
    int 21h
    call acapo
          
    lea dx, input
    mov ah, 09h
    int 21h
        
number:
        
    call acapo
        
    call indic
    
;salvo nella stringa STR quello che viene immesso da tastiera    
    lea dx, str
    mov ah ,0Ah
    int 21h
    
    ;punto con SI la stringa STR e con DI la stringa ARRAY
    lea si,str
    inc si
    lea di,array
    inc di
    
     

ciclo1:
    
;controllo che il primo carattere non sia x,X e che sia compreso tra 0 e 9, della stringa STR
    mov [di],dx    
    inc si 
    cmp [si],"x"
    je fine     ;salto alla fine per finire il carattere
    cmp [si],"X"
    je fine     ;salto alla fine per finire il carattere
    cmp [si],"0"
    jb fuori1   
    cmp [si],"9"
    ja fuori1 
    mov dl,[si]
    inc di
    
    jmp ciclo1
    
fuori1: 
    
    cmp [si]," ";controllo che il carattere messo non sia spazio
    je ciclo2
    mov bp,si   ;salvo in bp in che punto sono arrivato a leggere STR
    call getInt  
    mov op1,ax
    mov si,bp
    call getoperand ;salvo il segno nella sua variabile
    lea di,array
    inc di
    
ciclo2:
;controllo che i caratteri imessi siano tra 0 e 9    
    mov [di],dx    
    inc si
    cmp [si],"0"
    jb fuori2
    cmp [si],"9"
    ja fuori2 
    mov dl,[si]
    inc di    
    
    jmp ciclo2
fuori2:

;controllo che il carattere messo non sia spazio
    cmp [si]," "
    je ciclo2
    call getInt
    mov op2,ax 
    
;controllo che operazione vuole svolgere l'utente    
    mov al,segno
    
    cmp al,"+"
    jne pross1
    call addizione
    jmp pross8 
    
pross1:
        
    cmp al,"-"
    jne pross2
    call sottrazione
    jmp pross8
pross2:
    
    cmp al,"*"
    jne pross3
    call moltiplicazione 
    jmp pross8

pross3:    

    cmp al,"/"    
    jne pross4
    call divisione 
    jmp pross8

pross4:      

    cmp al,"!"
    jne pross5
    call fattoriale1 
    jmp pross8

pross5:    

    cmp al,"&"
    jne pross6
    call and_and1
    jmp pross8

pross6:    

    cmp al,"|"
    jne pross7
    call or_or1 
    jmp pross8

pross7:    

    cmp al,"^"   
    jne no_uguale
    call potenza1
    jmp pross8

no_uguale: 
;stampa l'errrore in caso il segno messo non venga riconosciuto
    call acapo
    lea dx,error_op
    mov ah, 09h
    int 21h
    call acapo
    jmp number
pross8:
    
    call acapo
;stampa a schermo, (= )    
    mov ah,2
    mov dl,"="
    int 21h 
    
    mov dl," "
    int 21h

;controllo se il segno e' / nel caso salto a STAMPDIV    
    mov bl,segno
    cmp bl,"/"
    je stampdiv
    
;preparo i registri a stampare a schermo attraverso lo stack    
    mov ax,result    
    mov bx,10
    call stampa 
    call acapo
    
    ;indico la posizione in cui andare a salvare il risultato in memoria
    lea di,memory 
    xor ax,ax
    mov al,indice
    
    add di,ax
    
    dec di
    dec di
    
    mov bx,result
    
    mov [di],bx
    
    jmp number

stampdiv:

;stampo a schermo prima il quoziente poi il resto
    mov ax,result
    mov bx,10
    call stampa 
    mov ah,9
    lea dx, resto
    int 21h
    mov ax,cont_rest
    call stampa 
    jmp number
      
    
fine: 
;finisce il programma
    call acapo 
    mov ah,9
    lea dx,send 
    int 21h    
    mov ax, 4C00h ; exit to operating system.
    int 21h            
 
indic proc  

;stampa a schermo l'indice   
   mov dl,indice ;copio l'indice nel registro dl 
   cmp dl,9
   ja doppio
rip: 
   inc dl        ;incremento il contatore dell'indice 
   mov indice,dl ;salvo il nuovo numero nella variabile INDICE
   dec dl        ;decremento il contatore per tornare al numero originale
   add dl,"0"
   mov bl,dl    ;rendo il numero scrivibile in ascii code
   jmp stamp2
          
doppio:
    ;incrementa la decine per l'indice
    mov dl,0
    mov indice,dl
    mov bl,indice2
    inc bl
    mov indice2,bl
    jmp rip

stamp2:   
   ;stampo il numero
   mov ah,2
   mov dl,indice2
   add dl,"0"  
   int 21h
   mov dl,bl
   int 21h 
   mov dl,"]"
   int 21h
   mov dl," "
   int 21h 
       
    ret
indic endp


acapo proc 

;vado a capo    
    mov ah,2
    mov dl,10
    int 21h
    mov dl,13
    int 21h
    
    
    ret
acapo endp    


getint proc
     
;salvo nella propria variabile il numero diviso dal resto 
     
      mov result, 00h
      mov bx , 10
      lea ax, [array+2]
      mov si , ax
      convert_loop:
         xor ah , ah
         mov al , [si]                  ; Carica il carattere in al
         cmp al , 00                    ; Controllo con terminatore a capo
         je done                        ; Uscita dal ciclo
         
         sub al , '0'                   ; Converte da ascii a numero
         mov cx , ax                    ; Salva il numero corrente in cx
         mov ax , result                ; Carico il risultato definitivo in ax
         mul bx                         ; ax = ax * 10 (sposta a sinistra le cifre)
         add ax , cx                    ; Somma il nuovo numero come unità
         mov result , ax                ; Salva il nuovo risultato
         
         inc si                         ; Passo al prossimo carattere
         jmp convert_loop               ; Continuo il ciclo

   done:
      mov ax , result  
      
      ret

getint endp


getoperand proc 

;salvo il segno nella sua variabile
prima:    
    mov ah,[si]
    cmp ah," "
    je  dopo
    mov segno,ah
    jmp fin
    
dopo:
    inc si
    jmp prima    
fin:     
    ret 
getoperand endp 


stampa proc 

;stampo a schermo il numero attravero lo stack    
    pop di
    xor cx,cx
salva:
    ;inscrive nello stack il risulato dell'operazione
        
    xor dx,dx   
    div bx
    push dx    
    inc cx
    cmp ax,0
    je stamp
    jmp salva

stamp:
    ;stampa a schermo dallo stack il risultato dell'operazione
    pop dx
    add dl,"0"   
    mov ah,2
    int 21h    
    loop stamp

    push di
    ret
stampa endp 


addizione proc

;svolgo l'addizione tra i due numeri        
    mov ax,op1
    mov dx,op2
    
    
    ;esegue l'addizione tra i due operandi
    add ax,dx
    mov bx,10
    mov result,ax 
              
    ret          
addizione endp    


sottrazione proc 

;svolgo la sotttrazione tra i due numeri    
    mov ax,op1
    mov dx,op2
    
    cmp ax,dx
    jb errorsot
    jmp sottra
    
errorsot: 

;errore nel caso OP2 sia superiore a OP1  
    mov ah,9
    lea dx,error_sott
    int 21h 
    mov result,0000h
    jmp fin4
            

sottra:    
    ;esegue la sottrazione tra i 2 operandi 
    sub ax,dx
    mov bx,10

    mov result,ax
    
    
fin4:    
    ret
    
sottrazione endp       

    
moltiplicazione proc 
   
;eseguo la moltiplicazione tra i due numeri   
    mov ax,op1
    mov dx,op2
    
    mul dx
    mov bx,10
    
    mov result,ax
    
    ret

moltiplicazione endp


fattoriale1 proc

;eseguo il fattoriale tra i due numeri    
    mov cx,op1
    
    ;copio il numero in bx e lo decremento
    mov bx,cx
    dec bx
fatt:    
    
    mov ax,bx
    
    mul cx
    mov cx,ax
    dec bx
    cmp bx,0
    jne fatt  
    
    mov result,ax
    
    ret
fattoriale1 endp



potenza1 proc
    
;eseguo la potenza del numero    
    mov ax,op1
    
    mov bx,ax
    
    mov cx,op2
    dec cx
pot:    
    mul bx
    dec cx
    
    cmp cx,0
    jne pot
        
    
    mov result,ax
             
    ret
potenza1 endp


and_and1 proc

;eseguo AND tra i due numeri        
    mov ax,op1
    mov bx,op2

    AND ax,bx 
    
    mov result,ax

    ret
and_and1 endp


or_or1 proc    

;eseguo OR tra i due numeri    
    mov ax,op1
    mov bx,op2
    
    or ax,bx
    
    mov result,ax
    
    ret
    
or_or1 endp 
    
divisione proc

;eseguo la divisione tra i due numeri     
    mov ax,op1 
    mov bx,op2
    xor dx,dx
        
    cmp bx,0
    jne giust 
error1:

;errore nel caso sia una divisione per 0
    mov ah,9
    lea dx,error_zero
    int 21h
    jmp finindus

giust:
    
    div bx
    
    mov result,ax
    mov cont_rest,dx ;salva il resto nella stringa CONT_REST

finindus:    
    ret
divisione endp

ends
end start ; set entry point and stop the assembler.