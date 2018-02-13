<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script>
		$(document).ready(function(){
			("#btnSearch").click(function(){
				$("#frm").submit();
				
			});
		});
	</script>
</head>
<body>
	<form id="frm" action="emp/selectSalbar" method="post" >
		<input type="text" id="sal" name="sal" />
		<button type="button" id="btnSearch" >조회</button>

	</form>
	<c:forEach var="emp" items="${list } ">
		${emp.ename } - ${emp.sal } - ${emp.dname }
	</c:forEach>

</body>

</html>
