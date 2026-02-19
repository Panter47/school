const regioni = {
    "Abruzzo": ["L'Aquila", "Teramo", "Pescara", "Chieti"],
    "Basilicata": ["Potenza", "Matera"],
    "Calabria": ["Catanzaro", "Cosenza", "Crotone", "Reggio Calabria", "Vibo Valentia"],
    "Campania": ["Napoli", "Salerno", "Avellino", "Benevento", "Caserta"],
    "Emilia-Romagna": ["Bologna", "Modena", "Reggio Emilia", "Parma", "Piacenza", "Ferrara", "Ravenna", "Forlì-Cesena", "Rimini"],
    "Friuli-Venezia Giulia": ["Trieste", "Gorizia", "Udine", "Pordenone"],
    "Lazio": ["Roma", "Frosinone", "Latina", "Rieti", "Viterbo"],
    "Liguria": ["Genova", "Imperia", "La Spezia", "Savona"],
    "Lombardia": ["Milano", "Bergamo", "Brescia", "Como", "Cremona", "Lecco", "Lodi", "Mantova", "Monza e Brianza", "Pavia", "Sondrio", "Varese"],
    "Marche": ["Ancona", "Pesaro e Urbino", "Macerata", "Fermo", "Ascoli Piceno"],
    "Molise": ["Campobasso", "Isernia"],
    "Piemonte": ["Torino", "Alessandria", "Asti", "Biella", "Cuneo", "Novara", "Verbano-Cusio-Ossola", "Vercelli"],
    "Puglia": ["Bari", "Brindisi", "Barletta-Andria-Trani", "Foggia", "Lecce", "Taranto"],
    "Sardegna": ["Cagliari", "Nuoro", "Oristano", "Sassari", "Sud Sardegna"],
    "Sicilia": ["Palermo", "Catania", "Messina", "Siracusa", "Ragusa", "Trapani", "Agrigento", "Enna", "Caltanissetta"],
    "Toscana": ["Firenze", "Arezzo", "Grosseto", "Livorno", "Lucca", "Massa-Carrara", "Pisa", "Pistoia", "Prato", "Siena"],
    "Trentino-Alto Adige": ["Trento", "Bolzano"],
    "Umbria": ["Perugia", "Terni"],
    "Valle d'Aosta": ["Aosta"]
};

const regioneSelect = document.getElementById("regione");
const provinciaSelect = document.getElementById("provincia");
function mostraProvince() {
    const regione = regioneSelect.value;
    provinciaSelect.innerHTML = '<option value="">-- Seleziona una provincia --</option>';

    if (regioni[regione]) {
        for (let i = 0; i < regioni[regione].length; i++) {
            let opt = document.createElement("option");
            opt.textContent = regioni[regione][i];
            provinciaSelect.appendChild(opt);
        }
    }
}

regioneSelect.addEventListener("change", mostraProvince);
