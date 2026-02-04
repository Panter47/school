import threading
import time

# Funzione che simula il download di un file
def scarica_file(nome_file, durata):
    print(f"Inizio download di {nome_file}...")
    time.sleep(durata)  # simula il tempo di download
    print(f"Download completato di {nome_file} in {durata} secondi.")

# Lista di file da scaricare
file_da_scaricare = [
    ("file1.txt", 3),
    ("file2.txt", 2),
    ("file3.txt", 4),
]

# --- Versione 1: Senza thread ---
inizio_seq = time.time()
for nome, durata in file_da_scaricare:
    scarica_file(nome, durata)
fine_seq = time.time()

print(f"\nTempo totale senza thread: {fine_seq - inizio_seq:.2f} secondi\n")

# --- Versione 2: Con thread ---
threads = []
inizio_thread = time.time()

for nome, durata in file_da_scaricare:
    t = threading.Thread(target=scarica_file, args=(nome, durata))
    threads.append(t)
    t.start()

for t in threads:
    t.join()

fine_thread = time.time()
print(f"\nTempo totale con thread: {fine_thread - inizio_thread:.2f} secondi")
