<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<%@ page import = "javax.naming.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.spring.membermybatis.MemberVO" %>
<style>
	body{
		display : flex;
		justify-content: center;
		align-items: center; 
	}
</style>
    
 <%
	request.setCharacterEncoding("UTF-8");
 
	String id = null;  
 
	if( (session.getAttribute("id") == null) || !(((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginform.me'");
		out.println("</script>");
	}
	
	MemberVO vo = (MemberVO)request.getAttribute("memberVO"); 

 %>
 
<form name="updateform" action="updateProcess.me" method = "post">
		<table border=1>
			<tr>
				<td colspan=2 align=center>
					<b><font size=5> 회원가입 페이지</font></b>
				</td>
			</tr>
			<tr>
				<td>아이디 : </td>
				<td>
					<%=vo.getId() %>
					<input type="hidden" name="id" value="<%=vo.getId()%>">
				</td>
				
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><%=vo.getPassword() %></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="name" placeholder=<%=vo.getName()%>></td>
			</tr>
			<tr>
				<td>나이 : </td>
				<td><input type="text" name="age" maxlength=2 size=5 placeholder=<%=vo.getAge()%>></td>
			</tr>
			<tr>
				<td>성별 : </td>
				<td>
					<input type="radio" name="gender" value="남" checked/>남
					<input type="radio" name="gender" value="여"/>여 
					<!-- if, else로 해줌 된다. -->
				</td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td><input type="text" name="email" size=30 placeholder=<%=vo.getEmail()%>></td>
			</tr>
			<tr>
				<td colspan=2 align=center>
					<!-- 인라인 형식의 자바스크립트 코드. -->
					<a href="javascript:updateform.submit()">수정</a>
					<a href="javascript:updateform.reset()">다시작성</a>
				</td>
			</tr>
		</table>
	</form>