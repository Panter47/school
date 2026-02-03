;kpante Tchen Aaron 3c INF 14/01/2024

;data una stringa inserita da tastiera, la stampa invertita. E' un esercizio sull'uso dello stack, ma suggerisco di implementare anche una versione B che faccia ricorso ad un buffer (già svolta in classe). 
;ma suggerisco di implementare anche una versione B che faccia ricorso ad un buffer (già svolta in classe). 

data segment
    stamp1 db "inserire una stringa: $"
    stamp2 db "la stringa al contrario: $"
    str dw 20 dup("/")
    
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
    
    lea dx,stamp1
    mov ah,9
    int 21h

    mov ah,0Ah
    lea dx,str
    int 21h
       
    lea si,str
    add si,3 
    xor cx,cx
    
print_str:
    inc cx    
    xor dx,dx
    mov dl,[si]
    push dx
    inc si
    
    mov dl,[si]
    cmp dx,"/"
    jne print_str
    
    mov ah,2 
    mov dl,13
    int 21h
    mov dl,10
    int 21h
    
    mov ah,9
    lea dx,stamp2 
    int 21h
    
    mov ah,2
           
    xor dx,dx       
            
stamp_str:
        
    pop dx
    int 21h
    loop stamp_str
         
           
    
    
    mov ax, 4c00h ; exit to operating system.
    int 21h    
ends

end start ; set entry point and stop the assembler.
