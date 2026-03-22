from data import dati_personaggi, dati_domande
from personaggio import Personaggio
from domanda import Domanda
from game import Game

lista_personaggi = []
lista_domande = []

#inserisco all'interno delle liste gli oggetti dei personaggi e delle domande
for i in dati_personaggi:
    lista_personaggi.append(Personaggio(i["nome"], i["professione"], i["nazionalita"], i["epoca"], i["genere"]))

for i in dati_domande:
    lista_domande.append(Domanda(i["testo"], i["attributo"], i["valore_atteso"]))


newGame = Game(lista_personaggi, lista_domande)
newGame.play()