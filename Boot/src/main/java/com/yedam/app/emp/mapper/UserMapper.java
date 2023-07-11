package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.security.UserVO;

public interface UserMapper {

	public UserVO selectUser(String id);
	
	public List<String> selectRole(String id);
}
