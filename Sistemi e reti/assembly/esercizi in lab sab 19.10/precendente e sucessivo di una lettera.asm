;kpante tchen aaron 

;Scrivere e collaudare un programma che legge una lettera da tastiera e stampa la precedente e la successiva. A commento Spiegare perché il programma va in errore per la 'a' e per la 'z'.


org 100h
;si inserisce la lettera       
mov ah,1 
int 21h 
;assegnato a bl il valore di 1 
mov bl,1h  
;spostiamo la lettera inserita' in bh
mov bh,al
mov ch,bh
;assegnamo a ah 2 cosi da poter fare l'output
mov ah,2  
;sottraiamo alla lettera 1 cosi da ottenere la lettere antecedente in ascii 
sub ch,bl
;inseriamo uno spazio 
mov dl," "
int 21h
;spositamo il risulato in dl e stampiamo la lettera antecedente a quella scritta  
mov dl,ch 
int 21h 
;sommiamo alla lettera inserita 1 cosi da ottenere la lettere succesiva in ascii
add bh,bl
;spostiamo il risultato in al
mov al,bh
;inseriamo uno spazio 
mov dl," "
int 21h
;stampiamo la lettera successiva a quella inserita 
mov dl,bh
int 21h 

      
ret


;non funziona perche' prima della A e dopo la Z in codice ascii non sono presenti altre lettere ma dei simboli e da come riscontro quelle.