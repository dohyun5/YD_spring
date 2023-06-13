package com.yedam.app.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails {
	
	// ex) private MemberVO member; 보통은 아래처럼 바로 작성하지 않고 VO를 따로 만들어서 왼쪽과 같이 사용. 
	
	private String id;
	private String pwd;
	private String role;
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<>(); 
		auth.add(new SimpleGrantedAuthority(this.role));
		return auth;
	}

	@Override
	public String getPassword() {
		return pwd;
	}

	@Override
	public String getUsername() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
