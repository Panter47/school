;Kpante Tchen Aaron 3C INF 07/01/2024

;in molti sistemi di calcolo un operazione molto utilizzata è la
;sommatoria dei prodotti su due array. Implementa un programma che effettua il prodotto di
;due array, elemento per elemento (tipo arr1[i]* arr2[i]) e ne effettua la somma. I due array
;sono dichiarati in memoria ed il programma stampa la somma finale.

data segment
    ; add your data here!
    array1 db 1, 3,  5, 7,  9, 11, 13, 15, 2, 4
    array2 db 4, 8, 12, 0, 15,  3,  9,  5, 7, 1
    salva dw 10 dup(?)
    somma db "sommaprodotto: $"
ends

stack segment
    dw   128  dup(0)
ends

code segment
start:
l      
    mov ax, data
    mov ds, ax
    mov es, ax
    
    ;assegno alle 2 varabili un registro 
    xor ax,ax
    xor bx,bx
    lea si,array1
    lea di,array2
    mov al,[si]
    mov bl,[di]
    xor cx,cx
    xor dx,dx
    mov cx,10
    
molt:
    ;effettuo la moltiplicazione tra i 2 array
    mul bl
    add dx,ax
    inc si
    inc di
    mov al,[si]
    mov bl,[di]
    loop molt
    
    mov salva,dx
    ;stampo a schermo somma prodotto
    mov ah,9
    lea dx,somma
    int 21h
    
    mov ax,salva 
    mov bx,10
    xor cx,cx
    
salv:
    ;salvo il risultato del sommaprodotto nello stack    
    xor dx,dx
    div bx
    push dx
    inc cx
    or ax,ax
    jnz salv
    
stamp:  
    ;stampo a schermo lo stack
    pop dx
    add dl,"0"
    mov ah,2
    int 21h
    loop stamp     
    

    mov ax, 4c00h ; exit to operating system.
    int 21h    
ends

end start ; set entry point and stop the assembler.
