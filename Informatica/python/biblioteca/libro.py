from mediaItem import MediaItem

class Libro(MediaItem):

    def __init__(self, titolo, anno, autore, pagine):
        super().__init__(titolo, anno)
        self.autore = autore
        self.pagine = pagine
        
        
    def prestito(self):
        if self.disponibile == True:
            self.disponibile = False
            print(f"Il libro {self.titolo} è stato preso in prestito")
        else:
            print(f"Il libro {self.titolo} è già in prestito")
    
    def restituzione(self):
        if self.disponibile == False:
            self.disponibile = True
            print(f"Il libro {self.titolo} è stato restituito correttamente")
        else:
            print(f"Il libro {self.titolo} è già stato restituito")
    
    def __str__(self):
        return f"{super().__str__()}, autore: {self.autore}, pagine: {self.pagine}"