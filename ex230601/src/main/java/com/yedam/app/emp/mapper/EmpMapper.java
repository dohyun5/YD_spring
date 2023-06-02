package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectOne(int empNo);
	public List<EmpVO> selectList(EmpVO vo);
	public int insertMember(EmpVO vo);
	public int selectCount(EmpVO vo);
}



