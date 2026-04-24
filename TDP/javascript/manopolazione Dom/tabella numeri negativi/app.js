let tabella


function GeneraTabella() {

    let Nrighe = document.getElementById("righe").value
    let Ncolonne = document.getElementById("colonne").value

    tabella = document.createElement("table")

    for(let i = 0; i < Nrighe; i++) {
        let riga = document.createElement("tr")
        for(let j = 0; j < Ncolonne; j++) {
            let colonna = document.createElement("th")
            colonna.textContent = Math.floor((Math.random()* 200) - 100)
            riga.appendChild(colonna)
        }
        tabella.appendChild(riga)
    }

    document.getElementById("tabella-container").appendChild(tabella)
}

function colorenegativo(){
    const caselle = tabella.querySelectorAll('th')
    caselle.forEach(casella => {
        if(parseInt(casella.textContent) < 0) {
            casella.style.backgroundColor = "red"
        } else{
            casella.style.backgroundColor = "white"
        }
    })
}


document.getElementById("genera").addEventListener('click', GeneraTabella)
document.getElementById("colora").addEventListener('click', colorenegativo)