package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	
	//전체 조회
	public List<DeptInfoVO> getAllDept();
	//단건 조회
	public DeptInfoVO getDeptInfo(DeptInfoVO deptVO);
	//등록
	public int InsertDeptInfo(DeptInfoVO deptVO);
	//수정
	public Map<String, Object> updateDeptList(List<DeptInfoVO> deptVO);
	//삭제
	public int deleteDeptList(List<DeptInfoVO> deptVO);
	
}
