package com.spring.membermybatis;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.membermybatis.ServiceImpl;
import com.spring.membermybatis.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private ServiceImpl memberService;
	
	@RequestMapping("/Login.do")
	public ModelAndView main () {
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberlist = memberService.getMembers();
		
		result.addObject("memberList", memberlist);
		result.setViewName("member_list");
		return result;
	}

	@RequestMapping("/insert.do")
	public ModelAndView insert(MemberVO member) { 
		memberService.insertMember(member);
		
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberService.getMembers();
		result.addObject("memberList", memberList); // 데이터 추가
		result.setViewName("member_list");
		
		return result; 
	}
	
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(MemberVO member) {
		String id = member.getId();
		member = memberService.getMember(id); 
		System.out.println("updateForm complete");
		
		ModelAndView result = new ModelAndView();
		result.addObject("member", member);
		result.setViewName("updateForm");
		return result;
	}
	@RequestMapping("/update.do")
	public String update(MemberVO member) {
		memberService.updateMember(member);
		System.out.println("update complete");
	
		return "redirect:/list.do";
}
	@RequestMapping("/delete.do")
	public ModelAndView delete(MemberVO member) {
		String id = member.getId();
		memberService.deleteMember(id);
		System.out.println("delete complete");
	
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
		
	}
	
}
