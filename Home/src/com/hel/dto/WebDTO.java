package com.hel.dto;

public class WebDTO {
	
	String id;
	String pass;
	String name;
	String addr;
	String birth;
	String phone;
	
	
	public WebDTO() {
		super();
	}
	public WebDTO(String id, String pass, String name, String addr, String birth, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.birth = birth;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "WebDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", birth=" + birth + ", phone="
				+ phone + "]";
	}

	
}
