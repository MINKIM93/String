package com.spring.springgu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//ioc컨테이너 빈을 만들어주고 의존성 관리한다.
@Controller
public class HomeController {
	
	@Autowired // 빈을 꺼내온다 @->
	private ServiceImpl guservice;
	
	@RequestMapping(value = "/home.do")
	public String mainpage(){
		
		return "home";
	}
	
	@ResponseBody//자바 객체를 http응답 본문의 객체로 변환하여 클라이언트로 전송시키는 역할
	@RequestMapping(value="/aemp.do")
	public List<EmpVO> getEmp(){
		
		List<EmpVO> list = guservice.getEmp();
		return list;
	}
	
	
}
