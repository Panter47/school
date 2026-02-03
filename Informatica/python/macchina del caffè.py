from main import MENU, resources




def espresso(ingredienti):

    global resources
    

    if(ingredienti["water"]<=resources["water"] and ingredienti["coffee"]<=resources["coffee"]):
        resources["water"]-=ingredienti["water"]
        resources["coffee"]-=ingredienti["coffee"]
        return "epresso preparato correttamente, buona degustazione"
    else:
        return "non ci sono abbstanza ingredienti"

def latte(ingredienti):

    global resources
    

    if(ingredienti["water"]<=resources["water"] and ingredienti["coffee"]<=resources["coffee"] and ingredienti["milk"]<=resources["milk"]):
        resources["water"]-=ingredienti["water"]
        resources["coffee"]-=ingredienti["coffee"]
        resources["milk"]-=ingredienti["milk"]
        return "latte preparato correttamente, buona degustazione"
    else:
        return "non ci sono abbstanza ingredienti"

def cappuccino(ingredienti):

    global resources
    

    if(ingredienti["water"]<=resources["water"] and ingredienti["coffee"]<=resources["coffee"] and ingredienti["milk"]<=resources["milk"]):
        resources["water"]-=ingredienti["water"]
        resources["coffee"]-=ingredienti["coffee"]
        resources["milk"]-=ingredienti["milk"]
        return "cappuccino preparato correttamente, buona degustazione"
    else:
        return "non ci sono abbstanza ingredienti"


def somma(costo):

    quarter=input("quanti quarter(0,25$) vuoi inserire? ")
    dime=input("quanti dime(0,10$) si voglio inserire? ")
    nickel=input("quanti nickel(0,05$) si vogliono inserire? ")
    penny=input("quanti penny(0,01$) si vogliono inserire? ")

    tot=(int(quarter)*0.25)+(int(dime)*0.10)+(int(nickel)*0.05)+(int(penny)*0.01)

    if tot>=costo:
        return True,tot
    else:
        return False
    

accesso=True
resources["denaro"]=0

while accesso:
    ordine=input("cosa desideri? espresso/latte/cappuccino\n").lower()
    if(ordine=="espresso"):
        costo=MENU["espresso"]
        costo=costo["cost"]
        print(f"il costo dell'espresso è {costo}")

        accetto=[False]
        accetto=somma(costo)

        while not accetto:
            print("l'importo inserito non è sufficente per prendere l'espresso\nrininserire la giusta somma")
            accetto=somma(costo)   

        resources["denaro"]+=costo
        print(f"il resto a lei dovuto è {accetto[1]-costo}")

        ingredienti=MENU[str(ordine)]
        ingredienti=ingredienti["ingredients"]
        risultato=espresso(ingredienti)
        print(risultato)

    elif(ordine=="latte"):
        costo=MENU["latte"]
        costo=costo["cost"]
        print(f"il costo del tuo latte è {costo}")

        accetto=[False]
        accetto=somma(costo)

        while not accetto:
            print("l'importo inserito non è sufficente per prendere il latte\nrininserire la giusta somma")
            accetto=somma(costo)   

        resources["denaro"]+=costo
        print(f"il resto a lei dovuto è {accetto[1]-costo}")


        ingredienti=MENU[str(ordine)]
        ingredienti=ingredienti["ingredients"]
        risultato=latte(ingredienti)
        print(risultato)
        


    elif(ordine=="cappuccino"):
        costo=MENU["cappuccino"]
        costo=costo["cost"]
        print(f"il costo del tuo cappuccino è {costo}")

        accetto=[False]
        accetto=somma(costo)

        while not accetto:
            print("l'importo inserito non è sufficente per prendere il cappuccino\nrininserire la giusta somma")
            accetto=somma(costo)   

        resources["denaro"]+=costo
        print(f"il resto a lei dovuto è {accetto[1]-costo}")


        ingredienti=MENU[str(ordine)]
        ingredienti=ingredienti["ingredients"]
        risultato=cappuccino(ingredienti)
        print(risultato)
        

    elif(ordine=="off"):
        print("la maccchina da caffè verra spenta")
        accesso=False
        
    elif(ordine=="report"):

        print(resources)

    else:
        print("l'ordine inserito non è stato compreso")




