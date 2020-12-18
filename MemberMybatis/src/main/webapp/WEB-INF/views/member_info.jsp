<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<%@ page import = "javax.naming.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.spring.membermybatis.MemberVO" %>
<%
	MemberVO vo = (MemberVO)request.getAttribute("memberVO");
%>

<html>
<head>
<title>회원정보</title>
<style>
	body{
		display : flex;
		justify-content: center;
		align-items: center; 
	}
</style>
</head>
<body>
	<table border=1 width=300>
		<tr align=center>
			<td colspan="2"> 회원정보</td>
		</tr>
			<tr align=center>
				<td>아이디</td>
				<td><%=vo.getId() %></td>
			</tr>
			<tr align=center>
				<td>비번</td>
				<td><%=vo.getPassword() %></td>
			</tr>
			<tr align=center>
				<td>이름</td>
				<td><%=vo.getName() %></td>
			</tr>
			<tr align=center>
				<td>나이</td>
				<td><%=vo.getAge() %></td>
			</tr>
			<tr align=center>
				<td>이메일</td>
				<td><%=vo.getEmail() %></td>
			</tr>
			<tr>
				<a href="main.me">돌아가기</a>
			</tr>
			
	</table>
</body>
</html>




	
				
				
				