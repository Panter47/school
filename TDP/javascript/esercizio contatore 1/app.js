const input = document.getElementById("numero");
const btnInc = document.getElementById("incrementa");
const btnDec = document.getElementById("decrementa");

function aggiornaNumero(delta) {
    let numero = parseFloat(input.value) || 0;
    numero += delta;      
    input.value = numero; 
}

btnInc.addEventListener("click", () => aggiornaNumero(1));

btnDec.addEventListener("click", () => aggiornaNumero(-1));
