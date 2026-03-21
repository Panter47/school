import random
class Game:
    
    def __init__(self, lista_personaggi, lista_domande):
        self.lista_personaggi = lista_personaggi
        self.lista_domande = lista_domande
        self.personaggio_segreto =""
        self.numero_domanda = 0
        
    def scegli_personaggio(self):
        self.personaggio_segreto = random.choice(self.lista_personaggi)
    
    def next_question(self):
        domande_professione = []
        domande_nazionalita = []
        domande_epoca = []
        domande_genere = []
           
        for i in self.lista_domande:
            if i.attributo == "professione":
                domande_professione.append(i)
            elif i.attributo == "nazionalita":
                domande_nazionalita.append(i)
            elif i.attributo == "epoca":
                domande_epoca.append(i)
            elif i.attributo == "genere":
                domande_genere.append(i)
           
        prima_domanda = random.choice(domande_professione)
        seconda_domanda = random.choice(domande_nazionalita)
        terza_domanda = random.choice(domande_epoca)
        quarta_domanda = random.choice(domande_genere)
       
        print("Scegli una domanda (0 per indovinare): ")
        print(f"1. {prima_domanda.testo}")
        print(f"2. {seconda_domanda.testo}")
        print(f"3. {terza_domanda.testo}")
        print(f"4. {quarta_domanda.testo}")
        scelta = int(input())
        if scelta == 1:
            self.check_answer(prima_domanda)
            return True
        elif scelta == 2:
            self.check_answer(seconda_domanda)
            return True
        elif scelta == 3:
            self.check_answer(terza_domanda)
            return True
        elif scelta == 4:
            self.check_answer(quarta_domanda)
            return True
        elif scelta == 0:
            return self.guess_personaggio()
            
        
        
    
    def check_answer(self, domanda):
        if domanda.controlla(self.personaggio_segreto):
            print("Risposta: Si\n")
        else:
            print("Risposta: No\n")
    
    def guess_personaggio(self):
        risposta = input("Chi pensi che sia?\n")
        
        if risposta.lower() == self.personaggio_segreto.nome.lower():
            print("risposta corretta!!!")
            self.numero_domanda +=1
            return False
        else:
            print("Risposta sbagliata")
            return True
    
    def play(self):
        print("Benvenuto al gioco Chi è il Personaggio?")
        while True:
            self.scegli_personaggio()
            print("Ho scelto un personaggio segreto. Cerca di indovinare chi è!\n\n")
            continua = True
            while(continua):
                continua = self.next_question()
            print(f"Il tuo punteggio attuale è di {self.numero_domanda}")
            if input("vuoi continuare a giocare? ").lower() == "no":
                break
            
        
    