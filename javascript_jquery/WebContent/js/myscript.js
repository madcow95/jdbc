/**
 * javascript에서의 주석처리
 */

// 이렇게도 가능
/* document.write("자바스크립트 가능"); */
function cal() {
	var firstNum = document.frm.firstNum.value;
	var secondNum = document.frm.secondNum.value;
	var sum = parseInt(firstNum) + parseInt(secondNum);

	document.frm.sum.value = sum;
}
