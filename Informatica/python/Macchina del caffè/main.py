from menu import Menu
from coffee_maker import CoffeeMaker
from money_machine import MoneyMachine


inFunzione=True
menu = Menu()
saldo = MoneyMachine()
macchinaCaffè = CoffeeMaker() 

bevanda = None

while(inFunzione):
    print()
    print(menu.get_items())
    scelta = input("scegliere tra le bevande sopra elencate quale si desidera: ")
    bevanda = menu.find_drink(scelta.lower())
    if bevanda == None:
        if scelta.lower() == "off":
            print("macchina del caffè spenta")
            break
        if scelta.lower() == "report":
            print()
            macchinaCaffè.report()
            saldo.report()
    else:
        if macchinaCaffè.is_resource_sufficient(bevanda):
            print()
            if saldo.make_payment(bevanda.cost):
                macchinaCaffè.make_coffee(bevanda)


        
    