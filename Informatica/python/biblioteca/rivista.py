from mediaItem import MediaItem

class Rivista(MediaItem):
    def __init__(self, titolo, anno, numero, mese):
        super().__init__(titolo, anno)
        self.numero = numero
        self.mese = mese
        
        
    def prestito(self):
        if self.disponibile == True:
            self.disponibile = False
            print(f"La rivista {self.titolo} numero {self.numero} del mese {self.mese} è stata presa in prestito")
        else:
            print(f"La rivista {self.titolo} numero {self.numero} del mese {self.mese} è già in prestito")
            
            
    def restituzione(self):
        if self.disponibile == False:
            self.disponibile = True
            print(f"La rivista {self.titolo} numero {self.numero} del mese {self.mese} è stata restituito correttamente")
        else:
            print(f"La rivista {self.titolo} numero {self.numero} del mese {self.mese} è già stata restituita")
            
    
    def __str__(self):
        return f"{super().__str__()}, mese: {self.mese}, numero: {self.numero}"