file=open("studenti.txt","r")
tutto=file.readlines()
file.close()

insieme="".join(tutto)
tutto=insieme.split()


media=0
voti=[]
studenti=[]
for i in range(len(tutto)):
    if i%2!=0:
        media+=int(tutto[i])
        voti.append(tutto[i])
        
    else:
        studenti.append(tutto[i])
            
media=media/len(voti)

print(f"la media dei voti è {media}")

maggiore=[]
mass=max(voti)
for i in range(len(voti)):
    if mass==voti[i]:
        maggiore.append(studenti[i])

maggiore=", ".join(maggiore)

print(f"il nome degli studenti con il voto più alto sono {maggiore}")

dizionario={}
for i in range(len(studenti)):
    if voti[i] not in dizionario.keys():
        dizionario[voti[i]]=[studenti[i]]
    else:
        dizionario[voti[i]].append(studenti[i])
        
print(dizionario)
        
        
    



