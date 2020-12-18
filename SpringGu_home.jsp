<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>aemp</title>
</head>
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
   <script type="text/javascript">
	
	$(document).ready(function () {
		      $('#output').empty();// $ -> 제이쿼리함수 () 선택자, .->제이쿼리객체 초기화(테이블 비어주기)
		     
		      $.ajax({//ajax를 위한 기본 jQuery 형식
		          url:'/springgu/aemp.do',
		          //type:'POST',
		          contentType:  'application/x-www-form-urlencoded',
		         // dataType:'json',
		          success:function(data){
		        	$.each(data, function(index, item){
		        		var output = '';
		        			 output += '<tr>';
		                     output += '<td width="80">' + item.empno + '</td>';
		                     output += '<td width="80">' + item.ename + '</td>';
		                     output += '<td width="80">' + item.job + '</td>';
		                     output += '<td width="80">' + item.mgr + '</td>';
		                     output += '<td width="80">' + item.hiredate + '</td>';
		                     output += '<td width="80">' + item.sal + '</td>';
		                     output += '<td width="80">' + item.comm + '</td>';
		                     output += '<td width="80">' + item.deptno + '</td>';
		                     output += '</tr>';		        		
		        		
		        		 $('#output').append(output); //$('#output')선택자 append(output) 더하다
		            });
		         },
	            error:function(){
	               alert("ajax 통신 실패!!!");
	            }
	         });
	      });
</script>
<body>
<table id="output">
</table>
</body>
</html>
