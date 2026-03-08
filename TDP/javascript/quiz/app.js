const checknomeCognome = /^[a-zA-Z]{3,}$/; 
const checkclasse = /^\d{1}[a-zA-Z]{1}$/;

let nome, cognome, classe, primaDomanda, secondaDomanda, terzaDomanda;
let punteggio = 0;

function inviaQuiz() {

    nome = document.getElementById("nome").value;
    cognome = document.getElementById("cognome").value;
    classe = document.getElementById("classe").value;
    primaDomanda = document.getElementById("primaDomanda").value;
    secondaDomanda = document.getElementById("secondaDomanda").value;
    terzaDomanda = document.getElementById("terzaDomanda").value;
    

    if(!checknomeCognome.test(nome)){
        document.getElementById("errNome").innerText = "inserire un nome composto da almeno 3 lettere";
        return
    }else{
        document.getElementById("errNome").innerText = "";
    }
    if(!checknomeCognome.test(cognome)){
        document.getElementById("errCognome").innerText = "inserire un cognome composto da almeno 3 lettere";
        return
    }else{
        document.getElementById("errCognome").innerText = "";
    }
    if(!checkclasse.test(classe)){
        document.getElementById("errClasse").innerText = "inserire una classe vadida es: 1a, 2a, 3B..."
        return
    }else{
        document.getElementById("errClasse").innerText = "";
    }
    if(primaDomanda === "vuoto"){
        document.getElementById("errPrimaDomanda").innerText = "seleziona una risposta";
        return 
    }else{
        document.getElementById("errPrimaDomanda").innerText = "";
    }
    
    if(secondaDomanda === "vuoto"){
        document.getElementById("errSecondaDomanda").innerText = "seleziona una risposta";
        return 
    }else{
        document.getElementById("errSecondaDomanda").innerText = "";
    }
    
    if(terzaDomanda === "vuoto"){
        document.getElementById("errTerzaDomanda").innerText = "seleziona una risposta";
        return 
    }else{
        document.getElementById("errTerzaDomanda").innerText = "";
    }


    if(primaDomanda === "giusto")
        punteggio += 1.5;
    if(secondaDomanda === "giusto")
        punteggio +=1.5;
    if(terzaDomanda === "giusto")
        punteggio +=1.5;

    riepilogo();

}

function riepilogo(){

    document.body.innerHTML =`
   <h1>Riepilogo</h1>
        <div class="testo" id="nome"></div>
        <div class="testo" id="classe"></div>
        <div class="testo" id="punteggio"></div>
        <div class="testo" id="valutazione"></div>
    `;

    document.getElementById("nome").innerText = "nome: " + nome + " " + cognome;
    document.getElementById("classe").innerText = "classe: " + classe;
    document.getElementById("punteggio").innerText = "punteggio: " + punteggio;
    
    if(punteggio <= 1.5)
        document.getElementById("valutazione").innerText = "valutazione: Risultato scarso";
    if(punteggio == 3)
        document.getElementById("valutazione").innerText = "valutazione: Buon risultato";
    if(punteggio == 4.5)
        document.getElementById("valutazione").innerText = "valutazione: Ottimo risultato";

}
