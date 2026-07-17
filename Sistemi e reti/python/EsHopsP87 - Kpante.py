import sys


class Link:
    def __init__(self,ra,rb,p):
        self.ra = ra
        self.rb = rb
        self.p = p

linkRouter = [Link("R1","R2",2),Link("R2","R1",4),Link("R2","R3",2),Link("R3","R2",5),Link("R3","R4",3),Link("R4","R3",1)]
        
if __name__ == "__main__":
    
    rm = int(input("Digitare router Sorgente (1..4): "))
    rd = int(input("digitare router destinazione (1..4): "))
    r = -1
    szHops = f"R{rm} "
    n = len(szHops)

    while rm!= rd and n<70:
        ok =-1
        for i in range(len(linkRouter)):
            if linkRouter[i].ra == f"R{rm}":
                ok = i
                if linkRouter[i].rb != f"R{r}":
                    ok = -2
                    r = rm
                    rm = int(linkRouter[i].rb[1])
                    break
        
        if ok >= 0:
            r = rm
            rm = int(linkRouter[ok].rb[1])
        
        if ok == -1:
            print("Impossibile instradare")
            sys.exit(0)

        szHops += f"R{rm} "
        n = len(szHops)
        print(f"Tratta: {szHops}")

    print("ok" if rm==rd else "Errore TTL!")