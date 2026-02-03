; multi-segment executable file template.

data segment
 
    num1 dw 12345 
    num2 dw 65432
    vec db 5 dup(?)  
ends        

stack segment
    dw   128  dup(0)
ends

code segment
    
    
start:

    mov ax, data
    mov ds, ax
    mov es, ax

    
    lea si,vec       ;carico in SI l'offset del primo elemento di VEC
    
    
    mov ax, num1
    call print_num_ln   
    
    mov ax, num2
    call print_num_ln  
    
    mov ax, 4c00h ; exit to operating system.
    int 21h   
    
   
    
     
ends  


print_num_ln     PROC
        lea si,vec       ;carico in SI l'offset del primo elemento di VEC
        
        mov bx, 10
        mov dx, 0 
        
    save_digit:
        div bx   
        
        add dl,'0'
        mov [si],DX
        
        
        mov dx,0
        inc si
        
        cmp ax,0
        jne save_digit
        
        
        lea cx,vec  
        mov ah, 02 
        
    print_str_num:
        dec si       
        mov dl, [si]      
        int 21h 
        cmp cx,si
        jne print_str_num 
        
    mov dl, 0Dh
    int 21h
    mov dl, 0Ah
    int 21h    
    
    RET

print_num_ln     ENDP 

end start ; set entry point and stop the assembler.
