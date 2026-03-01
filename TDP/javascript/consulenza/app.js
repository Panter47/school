const checkname =/^[a-zA-Z]{3,}$/;
const checkPassword =/^[a-zA-Z\d]{8,}$/;
const checktelefono = /^\d{10}$/;
const checksitoWeb = /^www\.[a-zA-Z\d-]+\.[a-zA-Z]{2,}$/;

let dati = {
    nome: "",
    password: "",
    telefono: "",
    sitoWeb: "",
    preferenza: "",
    data: ""
};

function inviaForm() {
    dati.nome = document.getElementById("nome").value;
    dati.password = document.getElementById("password").value;
    dati.telefono = document.getElementById("telefono").value;
    dati.sitoWeb = document.getElementById("sitoWeb").value;
    dati.preferenza = document.getElementById("preferenza").value;
    dati.data = document.getElementById("data").value;

    if (!checkname.test(dati.nome)) {
        alert("Il nome deve contenere almeno 3 lettere e non può contenere numeri o caratteri speciali.");
        return;
    }
    if (!checkPassword.test(dati.password)) {
        alert("La password deve contenere almeno 8 caratteri, lettere e numeri.");
        return;
    }
    if (!checktelefono.test(dati.telefono)) {
        alert("Il numero di telefono deve contenere esattamente 10 cifre.");
        return;
    }
    if (!checksitoWeb.test(dati.sitoWeb)) {
        alert("Il sito web non è valido.");
        return;
    }
    if (dati.preferenza === "vuoto") {
        alert("Per favore, seleziona una preferenza.");
        return;
    }
    if (!dati.data) {
        alert("Per favore, seleziona una data e ora.");
        return;
    }
    
    const dataInserita = new Date(dati.data);
    const oggi = new Date();
    if (dataInserita < oggi) {
        alert("La data inserita non valida");
        return;
    }
    localStorage.setItem("dati", JSON.stringify(dati));
    window.open("index2.html", "_blank");
}

function riepilogo() {
    const dati = JSON.parse(localStorage.getItem("dati"));
    document.getElementById("nome").textContent = "Nome: " + dati.nome;
    document.getElementById("password").textContent = "Password: " + "*".repeat(dati.password.length);
    document.getElementById("telefono").textContent = "Telefono: " + dati.telefono;
    document.getElementById("sitoWeb").textContent = "Sito Web: " + dati.sitoWeb;
    document.getElementById("preferenza").textContent = "Preferenza: " + dati.preferenza;
    document.getElementById("data").textContent = "Data: " + dati.data;

    let prestazione = new Date(dati.data);
    prestazione.setDate(prestazione.getDate() + 7);

    if(prestazione.getDay() === 6){
        prestazione.setDate(prestazione.getDate() + 2);
    }
    else if(prestazione.getDay() === 0){
        prestazione.setDate(prestazione.getDate() + 1);
    }

    document.getElementById("dataPrestazione").textContent = "Data Prestazione: " + prestazione.toLocaleDateString("it-IT", {year:"numeric",month:"numeric",day:"numeric"}) 
}