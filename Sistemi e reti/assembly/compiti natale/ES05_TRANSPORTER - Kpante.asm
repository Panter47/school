;kpante Tchen Aaron 3C INF 07/01/2024

;dopo aver completato il codice dall’esempio3, implementare l’input
;dei dati (sfruttare le procedure definite negli esercizi precedenti)


.MODEL SMALL
.STACK 100H
.DATA
distance DW 8,?,8 dup(?) ; Distanza per viaggio (km)
cost_per_km DW 8,?,8 dup(?) ; Costo per chilometro
budget DW 8,?,8 DUP(?) ; Budget totale disponibile
cost_per_trip DW 0 ; Costo totale per viaggio

max_trips DW 0 ; Numero massimo di viaggi
remaining_budget DW 0 ; Residuo del budget  
str1 db "Budget disponibile: $"
str2 db "Costo per viaggio: $"
str3 db "Viaggi massimi: $"
str4 db "Budget residuo: $" 
str5 db "distanza viaggio: $"
str6 db "costo per chilometro? $"
inf db "scrivere tutti i numeri con 4 cifre$"
.CODE

acapo macro
    mov ah,2
    mov dl,10
    int 21h 
    mov dl,13
    int 21h
endm 

print macro 
    ;converto il numero in decimale 
    inc si
    inc si
    XOR AX,AX
    mov Al,[si]

    sub al,"0"
    mov bx,1000
    mul bx
    mov dx,ax
    inc si
    xor ax,ax
    mov al,[si]
    xor bx,bx
    mov bl,100
    sub al,"0"
    mul bl
    add dx,ax
    inc si
    xor ax,ax
    mov al,[si]
    sub al,"0"
    mov bl,10
    mul bl
    xor ah,ah
    add dx,ax
    inc si
    mov al,[si]
    sub al,"0"
    add ax,dx 
    xor dx,dx
endm

    

MAIN PROC
    MOV AX, @DATA ; Inizializza il segmento dati
    MOV DS, AX
    
    ;stampo a schermo la stringa INF 
    mov ah,9
    lea dx,inf
    int 21h
    
    acapo
    
    ;stampo a schermo la stringa STR1
    mov ah,9
    lea dx,str1
    int 21h
    
    ;salvo nella stringa BUDGET quello che viene messo in input
    lea dx,budget
    mov ah,0Ah
    int 21h
    XOR DX,DX 
    
    acapo
    
    ;stampo a schermo la stringa STR5 
    lea dx,str5
    mov ah,9
    int 21h
    ;salvo nella stringa DISTANCE quello che viene messo in input
    mov ah,0Ah
    lea dx,distance
    int 21h
    
    acapo
    
    ;stampo a schermo la stringa STR6
    lea dx,str6
    mov ah,9
    int 21h 
    ;salvo nella stringa COST_PER_KM quello che viene messo in input
    mov ah,0Ah
    lea dx,cost_per_km
    int 21h 
    
    
    
    LEA SI, distance ; Carico la distanza in SI
    print
    
    mov distance,ax
    lea si,cost_per_km
    print
    ; Costo per viaggio (cost_per_trip = distance * cost_per_km)
    mov bx,ax 
    mov cost_per_km,bx
    mov ax,distance
    MUL BX ; AX = distance * cost_per_km
    MOV cost_per_trip, AX ; Salva il risultato in cost_per_trip
    ; Numero massimo di viaggi (max_trips = budget / cost_per_trip)
    
    LEA SI, budget ; Carica il budget in AX
    print
    
    mov BX, cost_per_trip ; Carica il costo per viaggio in BX
    DIV BX ; AX = budget / cost_per_trip, DX = resto
    MOV max_trips, AX ; Salva il numero massimo di viaggi
    MOV remaining_budget, DX ; Salva il budget residuo
    ; Stampa dei risultati                
    
    
 ;;MOV AX, budget ; Carica il costo per viaggio
    CALL PRINT_NUMBER ; Stampa il numero
    ; Stampa "Costo per viaggio:"
    ; ....
    ; Stampa "Viaggi massimi:"
    ; ....
    ; Stampa "Budget residuo:"
    ; ....
    ; Fine del programma
    MOV AH, 4CH ; Termina il programma
    INT 21H
    ; Procedura per stampare un numero (AX contiene il numero da stampare)
PRINT_NUMBER PROC
    XOR DX, DX ; Resetta DX
    XOR CX, CX ; Resetta CX - contatore cifre
    MOV BX, 10 ; Divisore per ottenere le cifre
DIVIDE_LOOP:
    DIV BX ; Divide AX per 10
    PUSH DX ; Salva il resto sullo stack
    XOR DX,DX ; Resetta DX per la prossima divisione
    INC CX
    OR AX, AX ; Controlla se il quoziente e' 0
    JZ PRINT_DIGITS ; Se si', passa alla stampa
    JMP DIVIDE_LOOP ; Altrimenti continua a dividere
PRINT_DIGITS:

    acapo
    
    ;stampo la stringa a schermo
    mov ah,9
    lea dx,str2
    int 21h
    
    ;inserire la cifra nello stack
    mov ax,cost_per_trip
    xor dx,dx
    xor cx,cx
    mov bx,10
cost_div:
    div bx
    push dx
    xor dx,dx
    inc cx
    or ax,ax
    jz cost_stamp
    jmp cost_div
   
    ;va a stampare la cifra salvata nello stack
cost_stamp:
    pop dx
    add dl,"0"
    mov ah,2
    int 21h
    loop cost_stamp
             
    acapo
    
    ;stampo la stringa a schermo
    mov ah,9
    lea dx,str3
    int 21h
    
    ;inserire la cifra nello stack
    mov ax,max_trips
    xor dx,dx
    xor cx,cx
    mov bx,10
max_div:
    div bx
    push dx
    xor dx,dx
    inc cx
    or ax,ax
    jz max_stamp
    jmp max_div
    
    ;va a stampare la cifra salvata nello stack
max_stamp:
    pop dx
    add dl,"0"
    mov ah,2
    int 21h 
    loop max_stamp
    
    acapo 
    
    ;stampo la stringa a schermo
    mov ah,9
    lea dx,str4
    int 21h           
    
    ;inserire la cifra nello stack
    mov ax, remaining_budget    
    xor dx,dx
    xor cx,cx
    mov bx,10 
remaining_div:
    div bx
    push dx
    xor dx,dx
    inc cx
    or ax,ax
    jz remaining_stamp
    jmp remaining_div
    
    ;va a stampare la cifra salvata nello stack
remaining_stamp:
    pop dx
    add dl,"0"
    mov ah,2
    int 21h
    loop remaining_stamp        
       
    RET
PRINT_NUMBER ENDP
END MAIN