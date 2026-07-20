import sys


class PRIVATEIP:
    def __init__(self,id1,id2,netmasklen):
        self.id1 = id1
        self.id2 = id2
        self.netmasklen = netmasklen

Ipp = [PRIVATEIP(10,0,8), PRIVATEIP(172,16,16), PRIVATEIP(192,168,24)]

def DectoszBin(quale, lunghezza):
    mask = 1 << (lunghezza - 1)
    risultato = []
    while mask:
        if quale & mask:
            risultato.append('1')
        else:
            risultato.append('0')
        mask = mask >> 1
    return ''.join(risultato)

if __name__ == "__main__":
    a = 192
    b = 168
    c = 0 
    d = 0
    subnetmask = 26 

    idx= -1

    for i in range(3):
        if a == Ipp[i].id1: idx = i
    if idx == -1: sys.exit(1)
    
    subnetlen = subnetmask - Ipp[idx].netmasklen
    if subnetmask<Ipp[idx].netmasklen: sys.exit(2)

    hostlen = 32 - subnetmask
    subnetid = 1 << subnetlen
    szBin = DectoszBin(subnetid-1,subnetlen)

    print(f"Rete privata del gruppo {Ipp[idx].id1}.{Ipp[idx].id2}.{0}.{0} (netmask /{Ipp[idx].netmasklen})")
    print(f"Subnet Mask /{subnetmask}; subnetid: {szBin}")
    print("Subnet disponibili:")
    for i in range(subnetid):
        u = i << hostlen

        if idx == 0: print(f"{Ipp[idx].id1}.{(u & 0x00ff0000) >> 16}.{(u & 0x0000ff00) >> 8}.{u & 0x000000ff}")
        elif idx == 1: print(f"{Ipp[idx].id1}.{Ipp[idx].id2}.{(u & 0x0000ff00) >> 8}.{u & 0x000000ff}")
        elif idx == 2: print(f"{Ipp[idx].id1}.{Ipp[idx].id2}.{Ipp[idx].id2}.{u & 0x000000ff}")
