const http=require("http")

const hostname='192.168.105.58';

const port=3000;

let counter = 0;

function requestHandler(request,response) {

console.log("In comes a request to: "+request.url);

response.writeHead(200,{'Content-Type':'text/plain'});

if ( request.url == "/")
	counter++;

response.end("Hello,World! ciao sono Aaron " + counter);

}

const server=http.createServer(requestHandler);

server.listen(port, hostname, function () {

console.log(`Server running at http://${hostname}:${port}/`);

});