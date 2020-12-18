<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.spring.membermybatis.MemberVO" %>
<%
	String id = null;  
    
	if( (session.getAttribute("id") == null) || !(((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginform.me'");
		out.println("</script>");
	}
	

	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("memberList");
	
%>

<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
	<table border=1 width=300>
		<tr align=center>
			<td colspan = 3>회원목록</td>
		</tr>
		<%
			for(int i = 0; i < list.size(); i++)
			{
				MemberVO vo = (MemberVO)list.get(i);
		%>
			<tr align=center>
				<td>
					<a href="memberinfo.me?id=<%=vo.getId() %>">
						<%=vo.getId() %>
					</a>
				</td>
				<td><a href="deleteMember.me?id=<%=vo.getId() %>">삭제</a></td>
				<td><a href="updateMember.me?id=<%=vo.getId() %>">수정</a></td>
			</tr>
		<%} %>
	</table>
</body>
</html>




