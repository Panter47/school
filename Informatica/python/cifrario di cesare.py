parola = input("inserire una parola: ")
rot =  int(input("inserire il numero di salti da ruotare: "))

ruotato=[]
parola=parola.lower()

for i in range(len(parola)):
    if(ord(parola[i])+rot>ord("z") or ord(parola[i])+rot<ord("a")):
        temp=((ord(parola[i])-ord("a"))+rot)%26
        ruotato.append(chr(ord("a")+temp))
    else:
        ruotato.append(chr(ord(parola[i])+rot))

stamp="".join(ruotato)

print(stamp)
        
