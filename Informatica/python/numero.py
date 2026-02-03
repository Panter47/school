import random

i=0
thislist=[]
while i<20:
    genera =random.randint(1,100)

    thislist.append(genera)
    i=i+1
    
print(thislist)
media=0
for x in thislist:
    media=media+x


media=media/20

print("la media dei 20 numeri generati casualmente è",media)

