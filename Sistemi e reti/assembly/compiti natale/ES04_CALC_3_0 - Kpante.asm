; multi-segment executable file template.

acapo  macro
    mov ah,2
    mov dl,10
    int 21h
    mov dl,13
    int 21h 
endm 

cifre macro
    lea si,operand
    add si,3
    mov al,[si]
    sub al,30h
    inc si
    mov dl,[si]
    xor ah,ah
    sub dl,30h 
endm

data segment
    ; add your data here!
    calcolatrice db "inserire operazione, operando1 e operando 2: $"
    operand db 6,?,6 dup(?)
    errore db "operazione non riconosciuta rinserire operazione, operando1 e operando2 $"
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
    
    mov ah,9
    lea dx,calcolatrice
    int 21h
numeri:    
    lea dx, operand
    mov ah ,0Ah
    int 21h
    
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
    
    lea dx,errore
    mov ah,9
    int 21h
    jmp numeri
    
addizione:
    acapo
        
    lea dx,somma
    mov ah,9
    int 21h
    
    cifre
    
    add al,dl
    mov bx,10
    xor cx,cx
    xor dx,dx
    
salva:   
    div bx
    push dx
    xor dx,dx
    inc cx
    or ax,ax
    je stamp
    jmp salva

stamp:
    pop dx
    add dl,"0"   
    mov ah,2
    int 21h    
    loop stamp
    jmp fine:
    
sottrazione:
    acapo
    
    lea dx,differenza
    mov ah,9
    int 21h
    
    cifre
     
    sub al,dl
    mov bx,10
    xor cx,cx
    xor dx,dx
    jmp salva   
    
moltiplicazione:
    acapo
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
    lea dx,quoziente
    mov ah,9
    int 21h
    
    cifre
    div dl
    mov bx,10
    xor cx,cx
    xor dx,dx
    mov offset appoggio,ah
    xor ah,ah
salva2:    
    div bx
    push dx
    xor dx,dx
    inc cx
    or ax,ax
    je stamp2
    jmp salva2

stamp2:
    pop dx
    add dl,"0"   
    mov ah,2
    int 21h    
    loop stamp2
    
    lea dx,resto
    mov ah,9
    int 21h
    
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
