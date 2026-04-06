from mediaItem import MediaItem
from prestabile import Prestabile

class Ebook(MediaItem, Prestabile):
    
    def __init__(self, titolo, anno, formato, dimensione_mb):
        super().__init__(titolo, anno)
        self.formato = formato
        self.dimensione_mb = dimensione_mb
        self.num_prestiti = 0
        
         
    def prestito(self):
        if self.disponibile == True:
            self.disponibile = False
            self.num_prestiti += 1
            print(f"L'Ebook {self.titolo} è stato preso in prestito")
        else:
            print(f"L'Ebook {self.titolo} è già in prestito")
    
    def restituzione(self):
        if self.disponibile == False:
            self.disponibile = True
            print(f"L'Ebook {self.titolo} è stato restituito correttamente")
        else:
            print(f"L'Ebook {self.titolo} è già stato restituito")
    
    def __str__(self):
        return f"{super().__str__()}, formato: {self.formato}, dimensione_mb: {self.dimensione_mb}"
    
    def statistiche(self):
        print(f"L'Ebook {self.titolo} è stato prestato {self.num_prestiti} volte")
        