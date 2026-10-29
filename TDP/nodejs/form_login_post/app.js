function auth(){
    const username=document.getElementById("username").value
    const password=document.getElementById("password").value

    fetch("/loginPost",{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({username:username,password:password})
    })
    .then(risposta=>risposta.text())
    .then(testo=>{
        document.getElementById("userRole").innerText=testo
    })
}