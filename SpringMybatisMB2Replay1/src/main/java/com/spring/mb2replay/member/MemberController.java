package com.spring.mb2replay.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService;
	
	@RequestMapping("/login.me")
	public String userCheck(MemberVO memberVO, HttpSession session, HttpServletResponse response) throws Exception{
		
		int res = memberService.userCheck(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if (res == 1)
		{
			session.setAttribute("id",memberVO.getId());
			writer.write("<script>alert('로그인 성공!!');" + "location.href='./boardlist.bo';</script>");
			
			
		//	return "resirect : /main.me";
		}
		else
		{
			writer.write("<script>alert('로그인실패!!');" + "location.href='./loginform.me';</script>");
			//return "redirect:./loginform.me"; // 요청을 다시 보내는 것 (찾아보기)
		}
		return null;
	}
		@RequestMapping("/main.me")
		public String mainPage() throws Exception {
			return "member/main";
		}
		
		@RequestMapping("/loginform.me")
		public String loginForm() throws Exception {
			return "member/loginForm";
		}
		
		@RequestMapping("/joinform.me")
		public String joinForm() throws Exception {
			return "member/joinForm";
		}
		
		@RequestMapping("/joinprocess.me")
		public String insertMember(MemberVO memberVO, HttpServletResponse response) throws Exception {
			int res = memberService.insertMember(memberVO);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			
			if (res != 0)
			{
				writer.write("<script>alert('회원가입성공!!');" + "location.href='./loginform.me';</script>");
				
				
			//	return "resirect : /main.me";
			}
			else
			{
				writer.write("<script>alert('회원가입실패!!');" + "location.href='./joinform.me';</script>");
				//return "redirect:./loginform.me"; // 요청을 다시 보내는 것 (찾아보기)
			}
			return null;
		}
	

		@RequestMapping("/memberlist.me")
		public String getMemberlist(Model model) throws Exception{
			ModelAndView result = new ModelAndView();
			
			ArrayList<MemberVO> member_list = memberService.getMemberlist();
			model.addAttribute("member_list", member_list);
		
			return "member/member_list";
		}
		
		@RequestMapping("/memberinfo.me")
		public String selectMember(MemberVO memberVO, Model model) throws Exception{
			MemberVO vo = memberService.selectMember(memberVO);
			model.addAttribute("memberVO", vo);
			
			return "member/member_info";
		}
		
		@RequestMapping("/memberdelete.me")
		public String deleteMember(MemberVO memberVO, Model model) throws Exception{
			
			memberService.deleteMember(memberVO);
			
			return "redirect:/memberlist.me";
			
		}
	
	
	
}
