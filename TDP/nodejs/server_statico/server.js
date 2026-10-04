const http=require("http")
const fs = require("fs")

const hostname='127.0.0.1';

const port=3000;

function requestHandler(req,res) {
const path = req.url;
switch(path) {
    case "/":
        fs.readFile("index.html", function (error, data) {
            if(error){
                res.writeHead(500,{"Content-Type":"text/plain"});
                res.end("Errore interno del server");
            }else {
                res.writeHead(200, {"Content-Type":"text/html"});
                res.end(data);
            }
        });
        break;
    case "/pagina1.html":
        fs.readFile("pagina1.html", function (error, data) {
            if(error){
                res.writeHead(500,{"Content-Type":"text/plain"});
                res.end("Errore interno del server");
            }else {
                res.writeHead(200, {"Content-Type":"text/html"});
                res.end(data);
            }
        });
        break;
    case "/pagina2.html":
        fs.readFile("pagina2.html", function (error, data) {
            if(error){
                res.writeHead(500,{"Content-Type":"text/plain"});
                res.end("Errore interno del server");
            }else {
                res.writeHead(200, {"Content-Type":"text/html"});
                res.end(data);
            }
        });
        break;
    case "/index.html":
        fs.readFile("index.html", function (error, data) {
            if(error){
                res.writeHead(500,{"Content-Type":"text/plain"});
                res.end("Errore interno del server");
            }else {
                res.writeHead(200, {"Content-Type":"text/html"});
                res.end(data);
            }
        });
        break;
        case "/img/copertina%20Cars%203.jpg":
        fs.readFile("img/copertina Cars 3.jpg", function (error, data) {
            if(error){
                res.writeHead(404,{"Content-Type":"text/plain"});
                res.end("Immagine non trovata");
            }else {
                res.writeHead(200, {"Content-Type":"image/jpeg"});
                res.end(data);
            }
        });
        break;
        case "/img/copertina%20Cars-motori%20ruggenti.jpg":
        fs.readFile("img/copertina Cars-motori ruggenti.jpg", function (error, data) {
            if(error){
                res.writeHead(404,{"Content-Type":"text/plain"});
                res.end("Immagine non trovata");
            }else {
                res.writeHead(200, {"Content-Type":"image/jpeg"});
                res.end(data);
            }
        });
        break;
}
}

const server=http.createServer(requestHandler);

server.listen(port, hostname, function () {

console.log(`Server running at
http://${hostname}:${port}/`);

});