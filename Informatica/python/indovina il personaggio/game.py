import random
class Game:
    
    def __init__(self, lista_personaggi, lista_domande):
        self.lista_personaggi = lista_personaggi
        self.lista_domande = lista_domande
        self.personaggio_segreto =""
        self.numero_domanda = 0
        self.punteggio_domanda = 5 
        self.tentativi = 0
        self.suggerimento = 0
        
    def scegli_personaggio(self):
        self.personaggio_segreto = random.choice(self.lista_personaggi)
    
    def next_question(self):
        #separo le domande per categoria
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
        
        #controllo la scelta dell'input
        print("Scegli una domanda (0 per indovinare): ")
        print(f"1. {prima_domanda.testo}")
        print(f"2. {seconda_domanda.testo}")
        print(f"3. {terza_domanda.testo}")
        print(f"4. {quarta_domanda.testo}")
        
        scelta = int(input())
        self.suggerimento += 1
        
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
        #Fornisce un suggerimento dopo alla settima domanda
        if self.suggerimento == 7:
            self.indizio()
            self.suggerimento = 0
    
    def guess_personaggio(self):
        risposta = input("Chi pensi che sia?\n")
        
        #controllo la risposta inserita dall'utente, aggiorno il conteggio dei punti/tentativi
        if risposta.lower() == self.personaggio_segreto.nome.lower():
            print("risposta corretta!!!")
            self.numero_domanda += self.punteggio_domanda
            self.tentativi = 0 
            return False
        else:
            if self.punteggio_domanda == 0:
                self.punteggio_domanda = 0
                
            else:
                self.punteggio_domanda -= 1
                self.tentativi += 1
            print("Risposta sbagliata -1 punto")
            print(f"se si azzecca la domanda si fanno {self.punteggio_domanda}\n")
            return True
    
    def play(self):
        
        print("Benvenuto al gioco Chi è il Personaggio?")
        print("Si hanno massimo 5 tentativi per indovinare la domanda")
        print("Il sistema di punteggio funziona che si fanno 5 punti se si indovina la risposta al primo tentativo\nogni tentativo sbagliato -1 al punteggio di quella domanda.")
        print("Non si può andare in negativo con il punteggio\n")        
        
        while True:
            self.scegli_personaggio()
            self.punteggio_domanda = 5
            self.tentativi = 0
            print("Ho scelto un personaggio segreto. Cerca di indovinare chi è!\n\n")
            continua = True
            
            #somministra le domande e controlla che non si superino il numero massimo di tentativi
            while(continua):
                continua = self.next_question()
                if self.tentativi == 5:
                    print("si è esaurito il numero massimo di tentativi a disposizione")
                    break
                
            if self.tentativi != 5:    
                print(f"Il tuo punteggio attuale è di {self.numero_domanda}")
            if input("vuoi continuare a giocare? ").lower() == "no":
                break
            
    
    def indizio(self):
        #fornisce un indizio su un personaggio che sicuramente non è
        while True:
            indizio = random.choice(self.lista_personaggi)
            
            if indizio != self.personaggio_segreto:
                print(f"Il personaggio da indovinare non è {indizio.nome}\n")
                break

    