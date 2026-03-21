class Domanda:
    
    def __init__(self, testo, attributo, valore_atteso):
        self.testo = testo
        self.attributo = attributo
        self.valore_atteso = valore_atteso
    
    
    def controlla(self, personaggio):
        if self.valore_atteso == getattr(personaggio, self.attributo):
            return True
        return False
    
    