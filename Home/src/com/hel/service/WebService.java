package com.hel.service;

import java.util.List;

import com.hel.dto.WebDTO;

public interface WebService {
	
	public int signin();
	public String login();
	public int update(String userId, String userPw);
	public List<WebDTO> select(String selectId, String selectPw);
	public int delete(String strId, String strPw);

}
