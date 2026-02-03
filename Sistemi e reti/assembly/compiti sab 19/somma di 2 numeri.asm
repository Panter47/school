
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

mov ah,1
int 21h 

mov dh, al

mov ah,1
int 21h 
mov dl, al
       
add dh, dl 
 
mov ah,2 
mov dl, " "
int 21h 

mov dl,dh  
int 21h 


ret




