def calculate_love_score(name):
    true="true"
    love="love"
    cont1=0
    cont2=0

    
    for i in name:
        for j in true:
            if i==j:
                cont1+=1
                
    for i in name:
        for j in love:
            if i==j:
                cont2+=1
    
    num=str(cont1)+str(cont2)
    return num
       
name1=input("inserire il primo nome: ")
name2=input("inserire il secondo nome: ")

num1=calculate_love_score(name1)
num2=calculate_love_score(name2)
print(int(num1)+int(num2))

