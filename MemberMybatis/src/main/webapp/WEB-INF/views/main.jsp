<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = null;

	if(session.getAttribute("id")!=null){
		id = (String)session.getAttribute("id");
	}else{
		/* 로그인 상태가 아니면 loginForm으로 이동한다. */
		out.println("<script>");
		out.println("location.href='loginform.me'");
		out.println("</script>");
	}
%>
<html>
<head>
<title>회원관리 시스템 메인 페이지</title>
</head>
<body>
	<h3><%=id %>로 로그인 했다.</h3>
	
	<% if(id.equals("admin")){%>
		<a href="memberlist.me">관리자 모드 접속(회원 목록 보기)</a>
	<%} %>
</body>
</html>