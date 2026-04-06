from mediaItem import MediaItem

class DVD(MediaItem):
    
    def __init__(self, titolo, anno, regista, durata):
        super().__init__(titolo, anno)
        self.regista = regista
        self.durata = durata
        
        
    def prestito(self):
        if self.disponibile == True:
            self.disponibile = False
            print(f"Il DVD {self.titolo} del regista {self.regista} dalla durata di {self.durata} è stato preso in prestito")
        else:
            print(f"Il DVD {self.titolo} del regista {self.regista} dalla durata di {self.durata} è già in prestito")
            
            
    def restituzione(self):
        if self.disponibile == False:
            self.disponibile = True
            print(f"Il DVD {self.titolo} del regista {self.regista} dalla durata di {self.durata} è stato restituito correttamente")
        else:
            print(f"Il DVD {self.titolo} del regista {self.regista} dalla durata di {self.durata} è già stato restituito")
            
            
    def __str__(self):
        return f"{super().__str__()}, regista: {self.regista}, durata: {self.durata}"
    