package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptInfoVO;

public interface DeptInfoMapper {// 예외적으로 mapper에 한해서 bean에 등록하는 경우가 있음. Spring보단 Spring boot에서 주로 사용.
	//전체조회
	public List<DeptInfoVO> selectAllDept();
	//단건조회
	public DeptInfoVO selectOneDept(DeptInfoVO deptVO);
	//등록
	public int insertDeptInfo(DeptInfoVO deptVO);
	//수정
	public int updateDeptInfo(DeptInfoVO deptVO);
	//삭제
	public int deleteDeptInfo(int deptNo); //mapper에서는 void 보단 특정돌아오는 값을 mapping해주는 것이 좋음. JAVA는 조금의 수정으로도 코드 전체가 흔들릴수 있기 때문에 
										   //가급적이면 mapper는 담아 쓰도록 하자. 갑자기 값을 받아와서 사용해야할 경우 일이 복잡해질수있음.
	
}



