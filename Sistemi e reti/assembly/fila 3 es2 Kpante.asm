;kpante Tchen Aaron 3C INF 07/12/2024




org 100h

jmp start      
    
vec dw 45,97,213, 251, 39, 56, 178, 210, 0,127   
       
res dw 0    
     
start: 
    xor dx,dx
    mov bx, offset vec
    mov cx, 10
    
sloop:
    mov ax,[bx]
    and ax, 00000010b
    jnz somma
    jmp continua
    
somma:
    mov dx,[bx]
    add res, dx 
                    
continua:         
    inc bx  
    loop sloop      
    
ret

