from libro import Libro
from dvd import DVD
from rivista import Rivista

class Catalogo:
    
    def __init__(self):
        self.articoli = []
        
    def aggiungi(self, item):
        self.articoli.append(item)
    
    def stampa_catalogo(self):
        
        for i in self.articoli:
            print(i)
    
    def disponibile(self):
        
        for i in self.articoli:
            if i.disponibile == True:
                print(i)

    def cerca_per_tipo(self, tipo):
        filtrati = []
        
        for i in self.articoli:
            if isinstance(i, tipo):
                filtrati.append(i)
        return filtrati
    
    def report(self):
        libri = self.cerca_per_tipo(Libro)
        riviste = self.cerca_per_tipo(Rivista)
        dvd = self.cerca_per_tipo(DVD)
        
        print(f"il numero di libri totali è {len(libri)} di cui disponibili {len(self.disponibili_per_tipo(Libro))} e in prestito {len(self.inPrestito_per_tipo(Libro))}")
        print(f"il numero di riviste totali è {len(riviste)} di cui disponibili {len(self.disponibili_per_tipo(Rivista))} e in prestito {len(self.inPrestito_per_tipo(Rivista))}")
        print(f"il numero di dvd totali è {len(dvd)} di cui disponibili {len(self.disponibili_per_tipo(DVD))} e in prestito {len(self.inPrestito_per_tipo(DVD))}")
        
    
    def disponibili_per_tipo(self,tipo):
        filtrati = []
        
        for i in self.articoli:
            if isinstance(i, tipo) and i.disponibile == True:
                filtrati.append(i)
        return filtrati
    
    def inPrestito_per_tipo(self,tipo):
        filtrati = []
        
        for i in self.articoli:
            if isinstance(i, tipo) and i.disponibile == False:
                filtrati.append(i)
        return filtrati