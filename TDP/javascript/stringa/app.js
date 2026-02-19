function ultimo_carattere() {
    
    let str1 = document.getElementById("stringa").value;

    let ultimoCarattere = str1.charAt(str1.length - 1);

    if (ultimoCarattere == '?') 
        document.getElementById("frase1").innerText = "non lo so"
    else if (ultimoCarattere == '!') 
        document.getElementById("frase1").innerText = "hai ragione"
    else
        document.getElementById("frase1").innerText = "riformula la frase"
}
