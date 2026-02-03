
;Tramite procedura implementa un programma che stampa N numeri casuali
    
                           
 .model small
 
 .stack 256   
 
 
 .data 
    strReq db 0Ah,0Dh,"Inserire il numero di casuali da generare: $"
    randNum dw ?
    N dw 0
    
    
    
 .code
   mov ax, data
   mov ds,ax
   mov ss,ax

start:   
   ;Prompt Input
   lea dx, strReq 
   mov ah,09h
   int 21h   
   ;getInt
   call getInt
   mov N,ax
   
   ;ciclo N volte
    
    
    ;genero num casuale 
    call rand
    pop randNum
    
    
    ; stampo
    
    push randNum
    call printNum
    jmp start                        
                           
                           
; ==========================================================
; Funzione che legge un intero da tastiera e lo ritorna in AX


getInt     PROC 
    mov ah,1 
    int 21h
    xor ah,ah
    sub al,"0"
    pop cx
    push ax
    push cx
    
        
 
    
 

RET                   ; return to caller.
getInt     ENDP
; ==========================================================                           
                           
  
                           
; ==========================================================
; Funzione che genera un numero casuale a 16 bit e 
; lo ritorna mediante stack

rand     PROC 
    
    mov ah,2
    mov dl,10
    int 21h
    mov dl,13 
    int 21h

    
    mov ah,2ch
    int 21h
    pop cx
    mov si,cx 
    mov ax,dx
    mov bx,10
    xor cx,cx
    mov cx,N
    
pila:
    xor dx,dx   
    div bx
    push dx
    loop pila
    
    mov cx,si
    push cx        
 
    
 

RET                   ; return to caller.
rand     ENDP
; ==========================================================                           
                           
                           
; ==========================================================
; Funzione che stampa il numero a 16 bit passato sullo stack


printNum     PROC
    
    xor cx,cx
    mov cx,N
    pop bx
stamp:    
    mov ah,2
    pop dx 
    add dx,"0"
    int 21h
    loop stamp
            
    push bx
    
 

RET                   ; return to caller.
printNum     ENDP
; ==========================================================
   
   
   
   