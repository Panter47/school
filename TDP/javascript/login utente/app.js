function auth(){
    let utente = [{"username": "admin", "password": md5("real4dm1n"), "role": "Admin"},
                 {"username": "notAdmin", "password": md5("fak3Adm1n"), "role": "User"}]

    let name= document.getElementById("username").value.trim();
    let password= md5(document.getElementById("password").value.trim());
    let trov=false;

    for(let i=0; i<utente.length; i++){
        if(utente[i].username=== name && utente[i].password=== password){
            trov=true;
            document.getElementById("userRole").innerText = utente[i].role;
        }
    }

    if(!trov){
        alert("Wrong Username or Password");
        location.reload();
    }
}