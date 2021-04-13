/**
 * 
 */
function sum() {
	var x = document.getElementById("x").value;
	var y = document.getElementById("y").value;
	var sum = parseInt(x) + parseInt(y);
	document.getElementById("result").value = sum;
}

function gop() {
	var x = document.getElementById("x").value;
	var y = document.getElementById("y").value;
	var gop = parseInt(x) * parseInt(y);
	document.getElementById("result").value = gop;
}