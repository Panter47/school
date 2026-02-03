
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h
   
mov ah,1
int 21h 

mov bh,al 
int 21h  

mov bl,al 
mov ah,bh
mov bh,bl
mov bl,ah
 
mov ah,2
mov dl," "
int 21h

mov dl,bh
int 21h
 
mov dl," "
int 21h     

mov dl, bl
int 21h 


ret




