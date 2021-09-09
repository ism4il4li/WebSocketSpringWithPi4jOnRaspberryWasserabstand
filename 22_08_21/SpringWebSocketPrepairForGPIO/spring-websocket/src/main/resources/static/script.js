
var wsUri = "ws://localhost:8080/myWs";//Projektname und / etwas, etwas muss @ServerEndpoint(value = "/etwas" sein und aufruf nur localhost:8080/Projektname nicht zusätzlich etwas
var ws = new WebSocket(wsUri);
ws.onopen = ()=>{
	console.log("connected to : " + wsUri);
	ws.send("client sendet....");// ohne ws.send sieht dann  die Änderung im HTML nicht
	document.getElementById("text").innerHTML =event.data;
	};
ws.onmessage = (event)=>{
	document.getElementById("text").innerHTML =event.data;//event in parameter und event.data, um den Server-Nachricht zu bekommen
}