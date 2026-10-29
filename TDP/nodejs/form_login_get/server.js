const http=require("http")
const fs = require("fs")

const nomeHost='127.0.0.1';

const porta=3000;

const nomi=["aaron","luigi","anna"]
const passwords=["1234","abcd","pass"]

function controllaUtente(nome,password){
    let posizione=nomi.indexOf(nome)
    return posizione!=-1 && passwords[posizione]==password
}

function rispondiLogin(res,nome,password){
    if(controllaUtente(nome,password)){
        res.writeHead(200,{"Content-Type":"text/plain"})
        res.end("Benvenuto "+nome)
    }else{
        res.writeHead(401,{"Content-Type":"text/plain"})
        res.end("Utente non autorizzato")
    }
}

function servi(res,percorso,tipo){
    const stream=fs.createReadStream(percorso)
    stream.on("open",()=>{
        res.writeHead(200,{"Content-Type":tipo})
        stream.pipe(res)
    })
    stream.on("error",()=>{
        res.writeHead(404,{"Content-Type":"text/plain"})
        res.end("File non trovato")
    })
}

const server=http.createServer((req,res)=>{
    const url=new URL(req.url,"http://"+nomeHost+":"+porta)

    switch(url.pathname){
        case "/":
            servi(res,"./index.html","text/html")
            break

        case "/app.js":
            servi(res,"./app.js","text/javascript")
            break

        case "/loginPost":
            let corpo=""
            req.on("data",(pezzo)=>{
                corpo+=pezzo
            })
            req.on("end",()=>{
                const dati=JSON.parse(corpo)
                rispondiLogin(res,dati.username,dati.password)
            })
            break

        case "/loginGet":
            rispondiLogin(res,url.searchParams.get("username"),url.searchParams.get("password"))
            break

        default:
            res.writeHead(404,{"Content-Type":"text/plain"})
            res.end("Pagina non trovata")
    }
})

server.listen(porta,nomeHost,()=>{
    console.log("Server in ascolto su http://"+nomeHost+":"+porta)
})