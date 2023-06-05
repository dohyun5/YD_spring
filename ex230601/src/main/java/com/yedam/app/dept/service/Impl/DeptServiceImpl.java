package com.yedam.app.dept.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptInfoMapper;
import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.emp.mapper.EmpMapper;

//Impl로 끝나는 모든 파일은 Service필수
@Service 
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptInfoMapper deptMapper;
	
	@Autowired
	EmpMapper empMapper;
	
	
	@Override
	public List<DeptInfoVO> getAllDept() {
		return deptMapper.selectAllDept();
	}

	@Override
	public DeptInfoVO getDeptInfo(DeptInfoVO deptVO) {
		return deptMapper.selectOneDept(deptVO);
	}

	@Override
	public int InsertDeptInfo(DeptInfoVO deptVO) {
		int result =  deptMapper.insertDeptInfo(deptVO);
		System.out.println("id :" + deptVO.getDepartmentId());
		return result;
//		deptMapper.insertDeptInfo(deptVO);
//		deptVO.getDepartmentId(); 
//		selectKey로 인해 primarykey를 가지고 있는상태. 즉 여기서는 departmentId를 가지고 있음.
	}

	@Override
	public Map<String, Object> updateDeptList(List<DeptInfoVO> deptVO) {
		Boolean result = false;
		List<Integer> successList = new ArrayList<>();
		int count = 0;
		for(DeptInfoVO deptInfo : deptVO) {
			int result2 = deptMapper.updateDeptInfo(deptInfo);
			if(result2 > 0) {
				//정상적으로 수정이 되었을 경우
				count += 1;
				successList.add(deptInfo.getDepartmentId());
			}
		}
		if(count > 0) {
			result = true;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("success", count);
		map.put("deptList", successList);
		return map;
	}
	//실질적인 비지니스 로직이 들어가야함. 
	
	@Override
	public int deleteDeptList(List<DeptInfoVO> deptVO) {
		int count = 0;
		for(DeptInfoVO deptInfo : deptVO) {
			count += deptMapper.deleteDeptInfo(deptInfo.getDepartmentId());
		}
		return count;
	}

}
