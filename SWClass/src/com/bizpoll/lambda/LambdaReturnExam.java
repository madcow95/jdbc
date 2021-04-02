package com.bizpoll.lambda;

public class LambdaReturnExam {
	
	public static void main(String[] args) {
		
		Person1 person = new Person1();
		
		person.greeting(new Say1() {
			
			@Override
			public int something() {
				System.out.println("My name is java.");
				System.out.println("Nice to meet you");
				
				return 7;
			}
		});
		
		System.out.println("===========================================");
		// java 1.8 이상부터
		person.greeting(() -> {
			System.out.println("This is java.");
			System.out.println("Thank you Lambda");
			
			return 8;
		});
	}
}
