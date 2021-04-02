package com.bizpoll.anonymous;
// 람다식
public class Anonymous {
	
	Person field = new Person() {
		String studentNo;
		
		void walk() {
			System.out.println("등교합니다.");
		}
		
		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			walk();
		};
		
	};
	
	void method1() {
		Person localVar = new Person() {
			String studentNo;
			
			void walk() {
				System.out.println("산책합니다.");
			}
			
			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			};
		};
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}

}
