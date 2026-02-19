let dizionario = [
    {italiano : "ciao", inglese : "hello"}, 
    {italiano : "casa", inglese : "house"},
    {italiano : "telefono", inglese : "phone"},
    {italiano : "porta", inglese : "door"},
    {italiano : "finestra",inglese :"windows"},
    {italiano : "scuola", inglese : "school"},
    {italiano : "zaino", inglese : "backpack"},
    {italiano : "cane", inglese : "dog"}, 
    {italiano : "gatto", inglese : "cat"},
    {italiano : "pagina", inglese :"page"}]


function dizio() {
    
    let word= document.getElementById("word").value.trim()
    let found=false;
    for(let i=0; i<dizionario.length; i++) {
        if(dizionario[i].italiano === word) {
           document.getElementById("tradu").innerText=dizionario[i].inglese
           found=true
        }
    }

    if(found == false) {
        alert("traduzione non disponibile")
    }
}

function show() {
    let testo=""
    for(let i=0;i<dizionario.length;i++) {
        testo+=dizionario[i].italiano+" : "+dizionario[i].inglese+"\n"
    }
    document.getElementById("tabel").innerText=testo
}

function addtradu() {
    document.getElementById("nuoviCampi").style.display = "block";
}
function salvaTraduzione() {
    let it = document.getElementById("parola").value.trim()
    let eg = document.getElementById("parola2").value.trim()

    if(dizionario.some(item => item.italiano === it))
        alert("la parola è gia presente all'interno del dizionario")
    else {
        dizionario.push({italiano : it , inglese : eg})
        document.getElementById("riuscita").innerText="parola aggiunta correttamente al dizionario"
    }
}
