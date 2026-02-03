import random

cards = [11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10]

game_over=False
while not game_over:
    
    somma=0
    computer_somma=0
    
    player=[]
    computer=[]

    for i in range(2):
        player.append(random.choice(cards))
        computer.append(random.choice(cards))
        
    print("le tue carte hanno volore: ", player)
    print(f"la prima carta del banco ha valore {computer[0]}")


    if(int(player[0])+int(player[1])==21):
        print("hai fatto blackjack")    
    else:
        not_game=input("vuoi pescare ancora? si/no: ").lower() == "si"
        for i in player:
            somma+=int(i)
        
        while not_game:
            player.append(random.choice(cards))
            print(player[-1])
            somma=0
            for i in player:
                somma+=int(i)
            if int(somma)>21:
                if 11 in player:  
                    for i in range(len(player)):
                        if player[i]==11:
                            player[i]=1
                            somma-=10
                            print("hai PERSO hai superato 21")
                            not_game=False
                else:
                    not_game=False
                    print("hai perso hai superato 21")
                    over=False
            elif int(somma)==21:
                not_game=False
                print("hai fatto black jack")
            else:
                 print(f"il totale delle carte ammonta a {somma}")
                 not_game=input("vuoi pescare ancora? si/no: ").lower() =="si"
    if (int(somma)<21 or over=="False"):
        print("le due carte del banco sono: ",computer)
        if(int(computer[0])+int(computer[1])==21):
            print("il banco ha fatto black jack")
            for i in computer:
                computer_somma+=int(i)

        else:
            computer_somma=0
            for i in computer:
                computer_somma+=int(i)
            while int(computer_somma)<16:
                computer.append(random.choice(cards))
                print(computer[-1])
                computer_somma+=int(computer[-1])
                print(f"il totale delle carte del banco ammonta a {computer_somma}")
                if int(computer_somma)>21:
                    if 11 in computer:
                        for i in range(len(computer)):
                            if computer[i]==11:
                                computer[i]=1
                                computer_somma-=10
                    else:
                        computer_somma=-1
                        break
                    
    if (int(somma)>int(computer_somma) and int(somma)<=21):
        print("hai VINTO")
    elif (int(somma)<int(computer_somma) or int(somma)>21):
          print("il BANCO ha VINTO")
    else:
        print("pareggio")
    game_over=input("vuoi giocare ancora? si/no: ").lower() =="no"
        
                    
                
    
        
   
        
    
        
        