const http=require("http")
const fs = require("fs")

const hostname='127.0.0.1';

const port=3000;

function requestHandler(req,res) {
const path = req.url;
switch(path) {
    case "/":
        var stream = fs.createReadStream("index.html");
        stream.on("open", function () {
            res.writeHead(200, {"Content-Type":"text/html"});
            stream.pipe(res);
        });
        stream.on("error", function () {
            res.writeHead(500,{"Content-Type":"text/plain"});
            res.end("Errore interno del server");
        });
        break;
    case "/pagina1.html":
        var stream = fs.createReadStream("pagina1.html");
        stream.on("open", function () {
            res.writeHead(200, {"Content-Type":"text/html"});
            stream.pipe(res);
        });
        stream.on("error", function () {
            res.writeHead(500,{"Content-Type":"text/plain"});
            res.end("Errore interno del server");
        });
        break;
    case "/pagina2.html":
        var stream = fs.createReadStream("pagina2.html");
        stream.on("open", function () {
            res.writeHead(200, {"Content-Type":"text/html"});
            stream.pipe(res);
        });
        stream.on("error", function () {
            res.writeHead(500,{"Content-Type":"text/plain"});
            res.end("Errore interno del server");
        });
        break;
    case "/index.html":
        var stream = fs.createReadStream("index.html");
        stream.on("open", function () {
            res.writeHead(200, {"Content-Type":"text/html"});
            stream.pipe(res);
        });
        stream.on("error", function () {
            res.writeHead(500,{"Content-Type":"text/plain"});
            res.end("Errore interno del server");
        });
        break;
    case "/img/copertina%20Cars%203.jpg":
        var stream = fs.createReadStream("img/copertina Cars 3.jpg");
        stream.on("open", function () {
            res.writeHead(200, {"Content-Type":"image/jpeg"});
            stream.pipe(res);
        });
        stream.on("error", function () {
            res.writeHead(404,{"Content-Type":"text/plain"});
            res.end("Immagine non trovata");
        });
        break;
    case "/img/copertina%20Cars-motori%20ruggenti.jpg":
        var stream = fs.createReadStream("img/copertina Cars-motori ruggenti.jpg");
        stream.on("open", function () {
            res.writeHead(200, {"Content-Type":"image/jpeg"});
            stream.pipe(res);
        });
        stream.on("error", function () {
            res.writeHead(404,{"Content-Type":"text/plain"});
            res.end("Immagine non trovata");
        });
        break;
}
}

const server=http.createServer(requestHandler);

server.listen(port, hostname, function () {

console.log(`Server running at http://${hostname}:${port}/`);

});