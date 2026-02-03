import random
from art import logo, vs
from game_data import data

print(logo)

rand1=random.choice(data)
guess=True
score=0

while guess:
    rand2=random.choice(data)
    
    a=rand1["follower_count"]
    b=rand2["follower_count"]
    
    print("confronta A: ", rand1["name"], rand1["description"], rand1["country"], "\n", vs, "\n", "contro B: ", rand2["name"], rand2["description"], rand2["country"] )
    #print(vs)
    #print("contro B: ", rand2["name"], rand2["description"], rand2["country"])
    scelta=input("chi ha più follower su instagram? scrivere A o B: ").lower()
    
    if (a>=b and scelta=="a" or b>=a and scelta=="b"):
        score+=1 
        print("hai fatto la scelta giusta adesso il tuo score è ",score)
        rand1=rand2
    
    else:
        print("hai fatto la scelta sbagliata il tuo score è di ",score)
        guess=False
    






