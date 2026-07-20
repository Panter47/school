class TDI:
    def __init__(self,Ia,Ib,Ic,Id,Ma,Mb,Mc,Md,Ga,Gb,Gc,Gd,Ua,Ub,Uc,Ud):
        self.Ia = Ia
        self.Ib = Ib
        self.Ic = Ic
        self.Id = Id
        self.Ma = Ma
        self.Mb = Mb
        self.Mc = Mc
        self.Md = Md
        self.Ga = Ga
        self.Gb = Gb
        self.Gc = Gc
        self.Gd = Gd
        self.Ua = Ua
        self.Ub = Ub
        self.Uc = Uc
        self.Ud = Ud


tdiHost = [TDI(0,0,0,0,0,0,0,0,196,13,1,254,196,13,1,1), TDI(196,13,1,0,255,255,255,0,196,13,1,1,196,13,1,1)]


def DottedToDecimal(a,b,c,d):
    return a*0x1000000 + b*0x10000 + c*0x100 + d

if __name__ == "__main__":
    #utilizzo :<16 per rendere la stampa più precisa ed allineata
    print(f"{'Indirizzo':<16}{'Mask':<16}{'Gateway':<16}{'Use'}") 
    for i in range(len(tdiHost)):
        indirizzo = f"{tdiHost[i].Ia}.{tdiHost[i].Ib}.{tdiHost[i].Ic}.{tdiHost[i].Id}"
        mask = f"{tdiHost[i].Ma}.{tdiHost[i].Mb}.{tdiHost[i].Mc}.{tdiHost[i].Md}"
        gateway = f"{tdiHost[i].Ga}.{tdiHost[i].Gb}.{tdiHost[i].Gc}.{tdiHost[i].Gd}"
        use = f"{tdiHost[i].Ua}.{tdiHost[i].Ub}.{tdiHost[i].Uc}.{tdiHost[i].Ud}"
        print(f"{indirizzo:<16}{mask:<16}{gateway:<16}{use}")

    a = 196
    b = 13
    c = 2
    d=5
    
    for i in range(len(tdiHost)):
        print(f"Regola n.{i+1} per {a}.{b}.{c}.{d}: ")
        u = DottedToDecimal(tdiHost[i].Ma,tdiHost[i].Mb, tdiHost[i].Mc, tdiHost[i].Md)
        u = u & DottedToDecimal(a,b,c,d)
        
        if u == DottedToDecimal(tdiHost[i].Ia,tdiHost[i].Ib,tdiHost[i].Ic,tdiHost[i].Id):
            print("Vera.")
        else:
            print("Falsa.")
        