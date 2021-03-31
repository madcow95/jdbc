package com.bizpoll.dto;

public class ClassDTO02 {
	
	int no;
	String name;
	int age;
	String addr;
	String phone;
	
	
	public ClassDTO02() {
		super();
	}
	public ClassDTO02(int no, String name, int age, String addr, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ClassDTO02 [no=" + no + ", name=" + name + ", age=" + age + ", addr=" + addr + ", phone=" + phone + "]";
	}

	
}
