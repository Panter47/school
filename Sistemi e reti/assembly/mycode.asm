;Kpante tchen Aaron 3C inf 26/11/2024
 
;Dato un carattere in input: stampa C se è una cifra, L se è una lettera, A se altro. Il programma continua a richiede l'input fino 
;all'inserimento di '\'.

org 100h


carattere:
    ;input da tastiera 
    mov ah,1
    int 21h
     
    mov ah,2 
    
    ;se il carattere insierito e' "\" il programma finisce 
    cmp al,"\"
    je fine 
    
    ;stampo la freccia 
    mov dl,"-"
    int 21h 
    mov dl,">"
    int 21h
    
    ;controlla se e' stato inserito un carattere superiore a "0"
    cmp al,"0"
    jae cifra

non:
    ;controlla se il cararettere inserito e' superiore a "A"
    cmp al,"A"
    jae maiuscola    
    
    jmp altro;salta se il carattere non e' superiore "A" salta ad altro
    
cifra:
     
    cmp al,"9"
    ja non;se il carattere inserito e' superiore a "9" nel codice ascii salta a (non) 
    
    ;output (C) e salta a (capo)
    mov dl,"C"
    int 21h        
    jmp capo
        
maiuscola:
    
    cmp al,"Z"
    ja minuscola ; se il carattere inserito e' superiore a "Z" nel codice ascii salta a (minuscola)
    
    ;output (L) e salta a (capo)
    mov dl,"L"
    int 21h
    jmp capo
    
minuscola:
    ; se il carattere inserito non e' compreso tra "a" e "z" nel codice ascii salta a (altro)
    cmp al,"a"
    jb altro 
    cmp al,"z"
    ja altro 
    
    ;output "L" e salta a (capo)
    mov dl,"L"
    int 21h 
    jmp capo
    
altro:
    ;output "A" 
    mov dl,"A"
    int 21h

capo: 
    
    ;vado a capo
    mov dl,10
    int 21h
    mov dl,13
    int 21h    
    
    loop carattere
fine:
ret




