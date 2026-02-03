.MODEL SMALL
.STACK 100H
.DATA
    buffer dw 5,0,5 dup("$")
    msg1 db "inserire il valore della x da 2 a 27: $"
    msg2 db 10,13,"il risultato e': $"
    buffer2 dw 5,0,5 dup("$")
    buffer3 dw 5,0,5 dup("$")
    buffer4 dw 5,0,5 dup("$") 
    risultato_msg dw 10,0,10 dup("$")


.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX    
    MOV ES, AX
    
    ;preparo la stampa della stringa e la lettura del numero
    lea dx,msg1
    push dx 
    call PrintString
    call ReadNumber
    
    mov buffer,ax 
    
    ;preparo il calcolo della potenza attraverso lo stack, e la moltiplicazione
    push ax
    mov cx,3
    push cx
    call pow
    pop ax
    mov bx,2
    call product
    
    mov buffer2,ax  ;salvo il risultato
    
    ;preparo il calcolo della potenza attraverso lo stack, e la moltiplicazione
    mov ax,buffer
    push ax
    mov cx,2  
    push cx
    call pow
    pop ax 
    mov bx,3
    call product
    
    mov buffer3,ax  ;salvo il risultato 
    
    ;preparo la moltiplicazione
    mov ax,buffer
    mov bx,5
    call product
    
    mov buffer4,ax  ;salvo il risultato
    
    ;sposto i risultati salvati dalla memoria ai registri
    mov ax,buffer2
    mov bx,buffer3
    mov cx,buffer4
    mov dx,7
    
    ;svolgo le addizioni e sottrazioni da svolgere
    sub ax,bx
    add ax,cx
    sub ax,dx
    mov risultato_msg,ax
    
    ;stampo a schermo la stringa              
    lea dx,msg2
    push dx
    call PrintString 
    
    ;converto in stringa il risultato totale
    xor ax,ax
    mov ax,risultato_msg
    call ConvertToString
    ;stampo a shermo il risutalto 
    push dx
    call PrintString
    
    
    MOV AX, 4C00H
    INT 21H
MAIN ENDP 


; Moltiplica due numeri 
product PROC
    MUL BX           
    RET
product ENDP

; Calcola la potenza: x^y 
pow PROC   
    POP BP
    
    POP CX                
    POP AX
    CMP CX,0
    JE  zero
    
    
    DEC CX
    MOV BX, AX          
powLoop:
    MUL BX              
    LOOP powLoop
    jmp fine
    
zero:
    MOV AX,1
        
fine:
    PUSH AX           
    push BP
    RET
pow ENDP


; Procedure per la conversione in stringa
ConvertToString PROC
    
    MOV BX, 10  
    MOV DI, OFFSET risultato_msg + 10  
ConvLoop:
    XOR DX, DX
    DIV BX  
    ADD DL, '0'  
    DEC DI
    MOV [DI], DL
    TEST AX, AX
    JNZ ConvLoop  
    MOV DX, DI  
    RET
ConvertToString ENDP

; Procedure PrintString    
PrintString PROC
    pop BP
    pop DX
    mov AH, 09
    int 21h 
    push BP
    ret
PrintString ENDP

; Procedure per leggere un numero intero a 8 bit
ReadNumber PROC
    XOR CX, CX
    LEA DX, buffer
    MOV AH, 0Ah       
    INT 21h          

    LEA SI, buffer + 2  

convertLoop:
    LODSB               
    CMP AL, 0Dh          
    JE finishConversion

    SUB AL, '0'         
    MOV BH,AL
    MOV AX,CX
    
    MOV BL, 10          
    MUL BL             
    MOV BL,BH
    XOR BH,BH
    ADD AX,BX          
    MOV CX,AX
    JMP convertLoop     
finishConversion: 
    MOV AX,CX
    RET
ReadNumber ENDP

