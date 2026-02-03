;kpante tchen aaron 3c inf 29/10/2024

;Implementare un prog. con emu 8086 che popola le locazioni di memoria a partire da 0xggmmh con i caratteri stampabili del codice ASCIII, dove mm è il vostro mese di nascita e gg il vostro giorno di nascita

org 100h
; assegno a [di] la locazione 1104h di indirizzamento 
mov di,1104h
; faccio immetere da tastiera un carattere e lo indirizzo in [di] e lo incremento di 1  
mov ah,1
int 21h
mov [di], al
inc di 
; faccio immetere da tastiera un carattere e lo indirizzo in [di] e lo incremento di 1 
int 21h
mov [di], al 
inc di 
; faccio immetere da tastiera un carattere e lo indirizzo in [di] e lo incremento di 1 
int 21h
mov [di], al
inc di        
; faccio immetere da tastiera un carattere e lo indirizzo in [di] e lo incremento di 1        
int 21h
mov [di], al
inc di 
; faccio immetere da tastiera un carattere e lo indirizzo in [di] e lo incremento di 1 
int 21h
mov [di], al
inc di 

ret




