#Password Generator Project
import random
letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
numbers = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
symbols = ['!', '#', '$', '%', '&', '(', ')', '*', '+']

print("Benvenuto nel generatore di password!")
nr_letters= int(input("Quante lettere vuoi nella tua password? ")) 
nr_symbols = int(input("Quanti simboli vuoi? "))
nr_numbers = int(input("Quanti numeri vuoi? "))

#Livello facile - Ordine non randomizzato:
#e.g. 4 letter, 2 symbol, 2 number = JduE&!91
i=0
password=[]
while (i<nr_letters):
    temp=random.choice(letters)
    password.append(temp)
    
    i+=1

i=0
while i<nr_symbols:
    temp=random.choice(symbols)
    password.append(temp)
    i+=1

i=0
while i<nr_numbers:
    temp=random.choice(numbers)
    password.append(temp)
    i+=1

print(password)
random.shuffle(password)
print(password)

#Livello medio - Ordine dei caratteri randomizzato:
#e.g. 4 letter, 2 symbol, 2 number = g^2jk8&P