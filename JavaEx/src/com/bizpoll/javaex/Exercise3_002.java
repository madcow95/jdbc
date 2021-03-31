package com.bizpoll.javaex;

public class Exercise3_002 {

	public static void main(String args[]) {
		// 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을수있다면
		// 몇개의 바구니가 필요한지 작성.

		int apple = 123;
//		int basket = apple / 10;
		int basket = 10;
		int basketNum = apple / basket;
//		boolean bYes = apple % 10 == 0;
		boolean bYes = apple % basket == 0;
		int count = 0;
		for (int i = 0; i < basketNum; i++) {
			count++;
		}
		if(!bYes) {
			count = count + 1;
		}
		System.out.println("바구니 갯수 : " + count + "개");
		
		System.out.println("--------------------");
		
		int numOfApple = 123;
		int sizeOfBucket = 10;
		
		int numOfBucket = numOfApple / sizeOfBucket + (numOfApple % sizeOfBucket > 0 ? 1 : 0); // numOfApple을 sizeOfBucket을 나눴을때 나머지가 0보다 크면 1을 더하고 아니면 0을 더해라
		System.out.println("필요한 바구니의 수 : " + numOfBucket + "개"); // 필요한 값이 나왔다고 바로 끝내지말고, 다른걸로도 테스트 해봐라
	}

}