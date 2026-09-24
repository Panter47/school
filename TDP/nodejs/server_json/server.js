const http=require("http")

const hostname='192.168.105.58';

const port=3000;

function requestHandler(req,res) {

console.log("In comes a request to: "+req.url);

res.statusCode=200;

res.setHeader("Content-Type", "application/json");

res.end(JSON.stringify({"messaggio": "ciao mondo sono aaron","sono": "Kpante"}));

}

const server=http.createServer(requestHandler);

server.listen(port, hostname, function () {

console.log(`Server running at http://${hostname}:${port}/`);

});