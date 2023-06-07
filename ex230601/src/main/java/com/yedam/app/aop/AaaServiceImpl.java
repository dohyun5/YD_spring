package com.yedam.app.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("aService")
public class AaaServiceImpl implements AaaService {
	
	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional
	@Override
	public void insert() { //왼쪽에 화살표는 Around가 걸려있다는 의미임.
		aaaMapper.insert("5105");
		aaaMapper.insert("4017"); //String으로 넘겨 주더라도 데이터자체는 DB의 타입과 맞춰줘야함.
		//transactional 로 묶으면  여러개의 SQL문 사용 가능하지만 하나만 오류가 나면 SQL전체 롤백.
		
	}
}
