const http=require("http")
const fs = require("fs")

const nomeHost='127.0.0.1';

const porta=3000;

function gestisciRichiesta(richiesta,risposta) {
const percorso = richiesta.url;
switch(percorso) {
    case "/":
        var flussoLettura = fs.createReadStream("input.txt");
        flussoLettura.on("open", function () {
            var flussoScrittura = fs.createWriteStream("output.txt");
            risposta.writeHead(200, {"Content-Type":"text/plain"});
            flussoLettura.pipe(risposta);
            flussoLettura.pipe(flussoScrittura);
        });
        flussoLettura.on("error", function () {
            risposta.writeHead(500,{"Content-Type":"text/plain"});
            risposta.end("Errore del server durante la lettura del file.");
        });
        break;
    default:
        risposta.writeHead(404,{"Content-Type":"text/plain"});
        risposta.end("Error 404");
        break;
}
}

const server=http.createServer(gestisciRichiesta);

server.listen(porta, nomeHost, function () {

console.log(`Server in esecuzione su http://${nomeHost}:${porta}/`);

});