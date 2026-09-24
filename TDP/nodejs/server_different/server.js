const http=require("http")

const hostname='192.168.105.58';

const port=3000;

function requestHandler(req,res) {

if (req.url==="/") {

res.end ('Benvenuto nella pagina sorgente');

} else if (req.url==="/JSON") {

res.end(JSON.stringify({"messaggio": "ciao mondo sono aaron","sono": "Kpante"}));

}else if (req.url == "/HTML"){

res.end("<h1>Benvenuto nella pagina html <h1>");


} else {

res.end ("errore url 404!!!!");

}

}

const server=http.createServer(requestHandler);

server.listen(port, hostname, function () {

console.log(`Server running at
http://${hostname}:${port}/`);

});