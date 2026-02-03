str1=input("inserire la prima stringa: ")
str2=input("inserire la seconda stringa: ")

str3=""

if(len(str1)==len(str2)):
    for x,y in zip(str1,str2):
        str3+=x+y


elif(len(str1)>len(str2)):
    cont=len(str2)
    for x in (range(cont)):
        str3+= str1[x] + str2[x]
    str3+=str1[cont:]
else:
    cont=len(str1)
    for x in (range(cont)):
        str3+= str1[x] + str2[x]
    str3+=str2[cont:]   
        

print(str3)
