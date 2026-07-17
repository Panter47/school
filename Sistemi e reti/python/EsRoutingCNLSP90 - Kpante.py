import sys


class TDI:
    def __init__(self,add,p,h,c):
        self.add = add
        self.p = p
        self.h = h
        self.c = c

tdiR1 = [TDI("a",1,0,0), TDI("b",2,1,5), TDI("c",2,2,2)]
tdiR2 = [TDI("a",3,1,0), TDI("b",7,0,5), TDI("c",2,1,2)]
tdiR3 = [TDI("a",9,2,0), TDI("b",8,1,5), TDI("c",9,0,0)]


class Link:
    def __init__(self,ra,rb,p):
        self.ra = ra
        self.rb = rb
        self.p = p

linkRouter = [Link("R1","R2",2), Link("R2","R1",4), Link("R2","R3",2), Link("R3","R2",5)]

if __name__ == "__main__":

    chS = input("Digitare indirizzo sorgente (a,b,c): ")
    chD = input("Digitare indirizzo destinazione (a,b,c): ")

    h = -1
    r = 1
    szHops = f"{chS} "
    n = len(szHops)

    while h:
        p = -1 
        h = -1
        szHops += f"R{r} "
        n = len(szHops)
        if r == 1:
            tdi = tdiR1
        elif r == 2:
            tdi = tdiR2
        elif r == 3:
            tdi = tdiR3
        
        for i in range(len(tdi)):
            if chD == tdi[i].add:
                h = tdi[i].h
                p = tdi[i].p
                break
        
        if h > 0:
            for j in range(len(linkRouter)):
                if int(linkRouter[j].ra[1]) == r and linkRouter[j].p == p:
                    r = int(linkRouter[j].rb[1])
                    break
        else:
            if h == 0:
                szHops += chD
                n = len(szHops)
            else:
                print("Impossibile instradare")
                sys.exit(0)
    
    print(f"Percorso: {szHops}")
    
