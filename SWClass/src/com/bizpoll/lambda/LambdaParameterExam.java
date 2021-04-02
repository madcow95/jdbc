package com.bizpoll.lambda;

public class LambdaParameterExam {
	
	public static void main(String[] args) {
		
		Person2 person = new Person2();
		
		person.greeting(new Say2() {
			
			@Override
			public int something(int c) {
				System.out.println("My name is java.");
				System.out.println("Nice to meet you");
				System.out.println("parameter values is : " + c);
				return 7;
			}
		});
		
		System.out.println("===========================================");
		// java 1.8 이상부터
		// parameter는 또 ()가 생략하다고? 하나일때만
		person.greeting(a -> {
			System.out.println("This is java.");
			System.out.println("Thank you Lambda");
			System.out.println("parameter values is : " + a);
			
			return 8;
		});
	}
}
