package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.dept.service.DeptService;

@Controller
public class DeptInfoController {
	
	@Autowired
	DeptService deptService;
	
	//컨트롤러는 경로와 기능(View)을 연결 
	//경로뿐 아니라 method까지 고려했을때 -> Unique해야한다.
	//@RequestMapping(value = "/deptList", method = RequestMethod.POST) //get post delete put모두 대응.
	
	//조회(데이터, 페이지) -> GET 
	//등록, 수정, 삭제 -> POST
	//전체조회 - 페이지
	@GetMapping("deptList")
	public String getDeptAllList(@RequestParam(required = false)String msg, Model model, HttpServletRequest request) {
		model.addAttribute("deptList",deptService.getAllDept());
		
		System.out.println("redirect : "+ msg);
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			System.out.println("department_id : " + flashMap.get("departmentId"));
		}
		
		
		return "dept/list";
	}
	//단건조회 - 페이지
	@GetMapping("deptInfo")
	public String getDeptInfo(DeptInfoVO deptVO, Model model) {
		//객체형태로 받아서 처리하는것이 기본형태
		DeptInfoVO findDept = deptService.getDeptInfo(deptVO);
		model.addAttribute("deptInfo",findDept); //담아주는이름 체크
		return "dept/info";
	}
	//등록 - 페이지 : GET방식
	@GetMapping("deptInsert")
	public String deptInsertForm(Model model) {
		return "dept/insert";
	}
	//등록 - 기능 : POST방식(보안상이유도 포함해서)
	@PostMapping("deptInsert")
	public String deptInsert(DeptInfoVO deptVO, RedirectAttributes rtt) { //항상쓸 필요는 없음.
		deptService.InsertDeptInfo(deptVO);
		//return "redirect:deptList"; //redirect는 기본적으로GET방식
		
		rtt.addFlashAttribute("departmentId", deptVO.getDepartmentId()); //- response가 깨지기 직전에 session에 복사하고 다시 담음.
		rtt.addAttribute("msg","test"); // 존재는 하지만 경로에 붙음(?msg=test). 
		//return "redirect:deptList?departmentId="+deptVO.getDepartmentId(); //rtt속성으로 사용하지 않는다면 왼쪽같이 작성.
		return "redirect:deptList"; //-> rtt.attribute사용시 
	}
	
	//수정 - 기능 : POST방식
	//@RequestBody : JSON포맷을 사용하는 경우 -> content-type : 'application/json'
	@PostMapping("deptUpdate")
//	@ResponseBody
//	public Map<String, Object> deptUpdate(@RequestBody List<DeptInfoVO> deptVO) {
//		return deptService.updateDeptList(deptVO);
//	}
	public String deptUpdate(@RequestBody List<DeptInfoVO> deptVO, RedirectAttributes rtt) {
		Map<String, Object> map = deptService.updateDeptList(deptVO);
		rtt.addFlashAttribute("updateRes", map);
		return "redirect:deptInfo?departmentId="+deptVO.get(0).getDepartmentId();
	}
	//삭제 - 기능 : POST방식
	@PostMapping("deptDelete")
	public String deptDelete(DeptListVO list) {
		int result = deptService.deleteDeptList(list.getDeptList());
		return "redirect:deptList?msg="+result; 
	}
}
