; multi-segment executable file template.

data segment
    
    seed dw 10 dup(?)
    
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
    
    call srand
    call rand  
    lea si,seed 
    inc si
    inc si
    pop [si]
     
    
    mov ax, 4c00h ; exit to operating system.
    int 21h    
ends

srand proc 
    
    mov ah,00h
    int 1Ah
    
    mov seed,dx
     
    ret    
endp  

rand proc 
    
    mov ah,00h
    int 1Ah
    
    pop bx
    
    push dx
    
    
    
    push bx
    ret    
endp

casuale_tra proc 
       
    
    
    
    
    
    
    
    ret    
endp


end start ; set entry point and stop the assembler.
