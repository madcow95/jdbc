package com.bizpoll.service;

import java.util.List;

import com.bizpoll.dto.ClassDTO;

public interface ClassService {
	
	public int signin();
	public String login();
	public int update(String userId, String userPw);
	public List<ClassDTO> select(String selectId, String selectPw);
	public int delete(String strId, String strPw);

}
