;kpante Tchen Aaron 3C INF 07/01/2024

;Implementa una calcolatrice che richieda l’operazione da eseguire e a
;seguire i due operandi (mono cifra). Calcola il risultato e lo stampa. Il programma deve
;supportare le 4 operazioni: +, -, x, :


acapo  macro
    mov ah,2
    mov dl,10
    int 21h
    mov dl,13
    int 21h 
endm 

cifre macro 
    ;copio le 2 cifre nei registri AL,DL
    lea si,operand
    add si,3
    mov al,[si]
    sub al,"0"
    inc si
    mov dl,[si]
    xor ah,ah
    sub dl,"0" 
endm

data segment
    ; add your data here!
    calcolatrice db "inserire operazione, operando1 e operando 2: $"
    operand db 6,?,6 dup(?)
    errore db "operazione non riconosciuta rinserire operazione, operando1 e operando2 $"
    errore2 db "i due operandi devono essere diversi da 0 per eseguire una divisione, rinserirli $"
    somma db "la somma dei 2 operandi e' $"
    differenza db "la differenza tra i 2 operandi e' $"
    prodotto db "il prodotto dei 2 operandi e' $" 
    quoziente db "il quoziente e' $"
    resto db " con resto $"
    appoggio db 4,?,4 dup(?)
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
    
    ;stampo a schermo la stringa CALCOLATRICE
    mov ah,9
    lea dx,calcolatrice
    int 21h

numeri:
    
    ;input da tastiera salvati nella stringa operand
    lea dx, operand
    mov ah ,0Ah
    int 21h
    
    ;controllo quale operazione deve svolgere
    lea si,operand
    inc si
    inc si
    mov al,[si]
    cmp al,"+"
    je addizione
    cmp al,"-"
    je sottrazione
    cmp al,"x"
    je moltiplicazione
    cmp al,"/"
    je divisione
    
    acapo 
    
    ;stampa a schermo la stringa ERRORE nel caso si ha sbagliato a inserire il segno 
    lea dx,errore
    mov ah,9
    int 21h
    jmp numeri
    
error:  
    acapo
    ;stampa a schermo la stringa ERRORE2 nel caso uno dei 2 operandi della divisione siano pari a 0
    lea dx,errore2
    mov ah,9
    int 21h
    jmp numeri    
    
addizione:
    acapo
    ;stampa a schermo la stringa SOMMA    
    lea dx,somma
    mov ah,9
    int 21h
    
    cifre
    ;esegue l'addizione tra i due operandi
    add al,dl
    mov bx,10
    xor cx,cx
    xor dx,dx
    
salva:
    ;inscrive nello stack il risulato dell'operazione   
    div bx
    push dx
    xor dx,dx
    inc cx
    or ax,ax
    je stamp
    jmp salva

stamp:
    ;stampa a schermo dallo stack il risultato dell'operazione
    pop dx
    add dl,"0"   
    mov ah,2
    int 21h    
    loop stamp
    jmp fine:
    
sottrazione:
    acapo
    ;stampa a schermo la stringa DIFFERENZA    
    lea dx,differenza
    mov ah,9
    int 21h
    
    cifre
    ;esegue la sottrazione tra i 2 operandi 
    sub al,dl
    mov bx,10
    xor cx,cx
    xor dx,dx
    jmp salva   
    
moltiplicazione:
    acapo 
    ;stampa a schermo la stringa PRODOTTO    
    lea dx,prodotto
    mov ah,9
    int 21h
    
    cifre
    
    mul dl
    mov bx,10
    xor cx,cx
    xor dx,dx
    jmp salva    

divisione:
    acapo 
    ;stampa a schermo la stringa QUOZIENTE    
    lea dx,quoziente
    mov ah,9
    int 21h
    
    cifre 
    ;controlla che i 2 operandi siano diversi da 0
    add al,"0"
    add dl,"0"    
    cmp al,"0"
    je error
    cmp dl,"0"
    je error
    sub al,"0"
    sub dl,"0"
    
    ;effettuta le divisione
    div dl
    mov bx,10
    xor cx,cx
    xor dx,dx
    mov offset appoggio,ah ;salva il resto nella stringa APPOGGIO
    xor ah,ah
salva2:
    ;salva il quoziente nello stack    
    div bx
    push dx
    xor dx,dx
    inc cx
    or ax,ax
    je stamp2
    jmp salva2

stamp2:
    ;stampa a schermo il quoziente dallo stack
    pop dx
    add dl,"0"   
    mov ah,2
    int 21h    
    loop stamp2

    ;stampa a schermo la stringa RESTO    
    lea dx,resto
    mov ah,9
    int 21h
    
    ;copia il resto nel registro AL
    xor ah,ah
    lea si,appoggio
    mov al,[si]
    mov bx,10
    xor cx,cx
    xor dx,dx
    jmp salva     
        
fine:    
    
    mov ax, 4c00h ; exit to operating system.
    int 21h    
ends

end start ; set entry point and stop the assembler.
