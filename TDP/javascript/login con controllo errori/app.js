function validaNome() {
    nome = document.getElementById("username").value;
    for(i = 0; i < nome.length; i++) {
        if(!((nome[i] >= 'A' && nome[i] <= 'Z') || (nome[i] >= 'a' && nome[i] <= 'z') || nome[i] == ' ')) {
            document.getElementById("errNominativo").innerHTML = "Nominativo non valido";
            return false;
        }
        document.getElementById("errNominativo").innerHTML = "";
    }
}

document.getElementById("username").addEventListener("blur", validaNome);



function validaEta() {
    eta = document.getElementById("eta").value;
    if(eta < 18 || eta > 100) {
        document.getElementById("errEta").innerHTML = "Età non valida";
        return false;
    }
    document.getElementById("errEta").innerHTML = "";

}

document.getElementById("eta").addEventListener("blur", validaEta);

function validaPassword() {
    password = document.getElementById("password").value;
    var errorMessage = "La password deve contenere: maiuscole, minuscole, numeri, caratteri speciali e deve essere lunga tra 8 e 20 caratteri.";
    if (password.length < 8 || password.length > 20) {
        document.getElementById("errPassword").innerHTML = errorMessage;
        return false;
    }
    if (!/[A-Z]/.test(password)) {
        document.getElementById("errPassword").innerHTML = errorMessage;
        return false;
    }
    if (!/[a-z]/.test(password)) {
        document.getElementById("errPassword").innerHTML = errorMessage;
        return false;
    }
    if (!/[0-9]/.test(password)) {
        document.getElementById("errPassword").innerHTML = errorMessage;
        return false;
    }
    if (!/[!@#$%^&*]/.test(password)) {
        document.getElementById("errPassword").innerHTML = errorMessage;
        return false;
    }
    document.getElementById("errPassword").innerHTML = "";
}

document.getElementById("password").addEventListener("blur", validaPassword);