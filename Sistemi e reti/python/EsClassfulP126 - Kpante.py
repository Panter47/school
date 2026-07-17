class Classful:
    def __init__(self,mask,leading,netmask):
        self.mask = mask
        self.leading = leading
        self.netmask = netmask

classiIp = [Classful(0x80,0x00,0xff000000), Classful(0xc0,0x80,0xffff0000), Classful(0xe0,0xc0,0xffffff00)]

class IPINFO:
    def __init__(self,a,b,c,d,ip,netid):
        self.a = a
        self.b = b
        self.c = c
        self.d = d
        self.ip = ip
        self.netid = netid

Ip = []
if __name__ == "__main__":

    Ip.append(IPINFO(10,1,0,3,0,0))
    Ip.append(IPINFO(192,168,0,1,0,0))
    Ip.append(IPINFO(137,168,0,1,0,0))
    Ip.append(IPINFO(137,168,249,17,0,0))

    i = 0
    for i in range(4):
        for j in range(3):
            Ip[i].ip = Ip[i].a*0x1000000 + Ip[i].b*0x10000 + Ip[i].c*0x100 + Ip[i].d
            if Ip[i].a & classiIp[j].mask == classiIp[j].leading:
                Ip[i].netid = Ip[i].ip & classiIp[j].netmask
                print(f"{Ip[i].a}.{Ip[i].b}.{Ip[i].c}.{Ip[i].d} classe {chr(65+j)} (mask: {classiIp[j].netmask:x}) e netId {Ip[i].netid:X}")

    for i in range(4-1):
        for j in range(i+1,4):
            if Ip[i].netid == Ip[j].netid:
                print(f"{Ip[i].a}.{Ip[i].b}.{Ip[i].c}.{Ip[i].d} e {Ip[j].a}.{Ip[j].b}.{Ip[j].c}.{Ip[j].d} stessa rete")
