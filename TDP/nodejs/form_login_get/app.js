function auth(){
    const username=document.getElementById("username").value
    const password=document.getElementById("password").value

    fetch("/loginGet?username="+encodeURIComponent(username)+"&password="+encodeURIComponent(password))
    .then(risposta=>risposta.text())
    .then(testo=>{
        document.getElementById("userRole").innerText=testo
    })
}   