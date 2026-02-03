;kpante Tchen Aaron 3c INF 14/01/2024

;Riciclare il codice precedente per implementare un procedura "reverse_string" che riceve in AX l'offset  
;della stringa (terminata da '$') e quando ritorna nello stesso buffer la stringa è invertita: si parla 
;di algoritmo in place poichè non alloca altra memoria per funzionare. Ho caricato la versione che usa 
;due parametri: offset in AX e lunghezza in CX.

data segment
    stamp1 db "inserire una stringa: $"
    stamp2 db "la stringa al contrario: $"
    str dw 20 dup("$")
    
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
    add si,2
    mov cl,[si-1]
    mov ax,si 
    xor ch,ch  
    
    call inverti
        
    mov ah,2 
    mov dl,13
    int 21h
    mov dl,10
    int 21h
    
    mov ah,9
    lea dx,stamp2 
    int 21h
    
    lea si,str
    mov cl,[si+1]
    add si,2
print:
    mov ah,2
    mov dx,[si]
    int 21h
    inc si
    loop print 


            
    mov ax, 4c00h ; exit to operating system.
    int 21h    
ends

proc inverti
  
;Carico lo stack
    mov si, ax
push_str:
    mov al,[si]
    xor ah,ah
    push ax
    inc si
    loop push_str    

    lea si,str
    mov cl,[si+1]
    add si,2
; Inverte la stringa di partenza    
pop_str:
    pop ax
    mov [si],ax
    inc si
    loop pop_str
    
    ret
endp inverti

end start ; set entry point and stop the assembler.
