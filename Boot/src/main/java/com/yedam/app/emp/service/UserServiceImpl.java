package com.yedam.app.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.UserMapper;
import com.yedam.app.security.UserVO;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserVO selectUser(UserVO userVO) {
		return userMapper.selectUser(userVO.getLoginId());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = userMapper.selectUser(username);
		if(vo == null) {
			throw new UsernameNotFoundException("no User");
		}
		vo.setRoleName(userMapper.selectRole(vo.getId()));
		return vo;
	}
	
	
	
	
	
	
}
