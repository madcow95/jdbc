package com.bizpoll.javaex;

public class Exercise3_006 {
	
	/*
	 * 아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오.
	 * c = 30
	 * ch = C
	 * f = 1.5
	 * l = 27000000000
	 * result = true
	 */
	
	public static void main(String args[]) {
		
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);
		
		char ch = 'A';
		ch = (char) (ch + 2);
		
		float f = 3 / 2f;
		long l = 3000 * 3000 * 3000L;
		// long 은 뒤에 1과 헷갈려서 소문자로 안쓰고 대문자로
		
		float f2 = 0.1f;
		double d = 0.1;
		
		boolean result = (float)d == f2;
		
		System.out.println("c = " + c);
		System.out.println("ch = " + ch);
		System.out.println("f = " + f);
		System.out.println("l = " + l);
		System.out.println("result = " + result); 
	}

}
