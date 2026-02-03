import random

stages = [r'''
  +---+
  |   |
  O   |
 /|\  |
 / \  |
      |
=========
''', r'''
  +---+
  |   |
  O   |
 /|\  |
 /    |
      |
=========
''', r'''
  +---+
  |   |
  O   |
 /|\  |
      |
      |
=========
''', '''
  +---+
  |   |
  O   |
 /|   |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
  |   |
      |
      |
=========
''', '''
  +---+
  |   |
  O   |
      |
      |
      |
=========
''', '''
  +---+
  |   |
      |
      |
      |
      |
=========
''']


word_list=["arancia","babbuino","cammello","mela","cane","ciliegia","coltello","casa","gelato","astuccio","penna","matita","oratorio","crema","portafoglio","capelli","autobus","macchina","camion","gomma","telefono","portatile","stampante","altalena","scivolo","palazzo","letto","citofono","violino","contrabbasso","violoncello","chitarra","pianoforte","bottiglia","profumo","alimentarore","quaderno","libro","finestra","cornice","quadro","tastiera","panchina"]

parola_scelta=random.choice(word_list)


lives=6

segnaposto=[]

for i in range(len(parola_scelta)):
    segnaposto.append("_")
    display="".join(segnaposto)
print(display)

j=1

while j==1:
    display=list(display)
    tentativo=input("inserire una lettera: ").lower()
    
    correct= False
    
    for k in range(len(parola_scelta)):
        if parola_scelta[k]==tentativo:
            display[k]=tentativo
            correct=True
    
    if correct==False:
        print(stages[lives])
        lives-=1
    if lives==-1:
        j=0
        print("HAI PERSO, la parola era",parola_scelta)
    
    display="".join(display)
    
    if parola_scelta==display:
        j=0
        print("HAI VINTO")
     
    print(display)


