;Kpante Tchen Aaron 3C inf 26/11/2024

;Date due lettera inserite da tastiera verifica se sono in ordine lessicografico e stampa N in caso negativo, l'elenco delle lettere 
;comprese in caso positivo. Il programma termina quando le due lettere coincidono stampando il messaggio "...bye" .


org 100h

lettere:
    
    ;input tastiera 
    mov ah,1
    int 21h

    mov bl,al;copio la lettera inserita nel registro BL 

    int 21h;input tastiera 
    
    mov bh,al;copio la lettera inserita nel registro BH
    
    ;stampo la freccia     
    mov ah,2 
    mov dl,"-"
    int 21h 
    mov dl,">"
    int 21h
    
    xor cx,cx;svuoto CX 
    
    cmp bl,bh 
    je fine ;se le lettere inserite sono uguali stalta a (fine)
    
    ja inferiore;se le lettere non sono in ordine lessicografico salta a inferiore 
    
    ;imposto il numero di volte che si deve ripetere il ciclo
    sub bh,bl
    mov cl,bh
    dec cl  
    
mezzo:
    
    ;stampo tutte le lettere comprese tra le 2 inserite 
    inc bl
    mov dl,bl
    int 21h
    loop mezzo     
    
    jmp capo 
     
inferiore:
    
    ;stampo "N"
    mov dl,"N"
    int 21h    

capo: 
    
    ;vado a capo 
    mov dl,10
    int 21h 
    mov dl,13
    int 21h
    
    loop lettere
        
fine:
    
    ;imposto l ripetizioni del loop 
    mov cx,3 

punto:

    ;stampo "."
    mov dl,"."
    int 21h
    loop punto
    
    ;stampo la scritta "bye" 
    mov dl,"b"
    int 21h 
    mov dl,"y"
    int 21h 
    mov dl,"e"
    int 21h      
ret




