const inputNumero = document.getElementById("numero");
const inputIncremento = document.getElementById("incremento");
const btnInc = document.getElementById("incrementa");
const btnDec = document.getElementById("decrementa");

function aggiornaNumero(delta) {
    const numero = parseFloat(inputNumero.value) || 0;
    const incremento = parseFloat(inputIncremento.value) || 0;
    inputNumero.value = numero + delta * incremento;
}

btnInc.addEventListener("click", () => aggiornaNumero(1));
btnDec.addEventListener("click", () => aggiornaNumero(-1));
