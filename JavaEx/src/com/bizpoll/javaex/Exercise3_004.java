package com.bizpoll.javaex;

public class Exercise3_004 {
	
	public static void main(String args[]) {
		
		int randomNum = 1877;
		System.out.println(randomNum - (randomNum % 100));
		
		int num = 1;
		String result = (num > 0) ? "양수" : "음수";
		if(num == 0) {
			result = "0";
		}
		System.out.println(num + "은(는) " + result);
		
		System.out.println("-----------------------------------");
		
		int number = 5;
		System.out.println(number > 0 ? "양수" : (number < 0 ? "음수" : "0"));
		
		int rNum = 111;
		System.out.println(rNum/100*100);
	}
}
