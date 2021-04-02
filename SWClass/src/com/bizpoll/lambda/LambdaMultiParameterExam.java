package com.bizpoll.lambda;

public class LambdaMultiParameterExam {
	
	public static void main(String[] args) {
		
		Person3 person = new Person3();
		
		person.greeting(new Say3() {
			
			@Override
			public int something(int a, int b) {
				System.out.println("My name is java.");
				System.out.println("Nice to meet you");
				System.out.println("parameter values is : " + a + "," + b);
				return 7;
			}
		});
		
		System.out.println("===========================================");
		// java 1.8 이상부터
		// parameter는 또 ()가 생략하다고? 하나일때만
		person.greeting((a, b) -> {
			System.out.println("This is java.");
			System.out.println("Thank you Lambda");
			System.out.println("parameter values is : " + a + "," + b);
			
			return 8;
		});
	}
}
