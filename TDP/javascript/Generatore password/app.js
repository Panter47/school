function generatore_password() {
    let caratteri ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_*+%&$=";
    let password="";
    for(let k=0;k<5;k++) {
        
        for(let i=0;i<12;i++) {
            let indice =Math.floor(Math.random() * caratteri.length);
            password += caratteri[indice]
        }
        password +="\n";
        
    }
    document.getElementById("risultato").innerText = password;
    
}