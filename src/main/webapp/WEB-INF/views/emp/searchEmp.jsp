<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#btnSearch").click(function(){
			var selectType = $("#selectType").val();
			var searchWord = $("#searchWord").val();
			//alert(selectType + ", " +searchWord);
			
			if(searchWord == ""){
			alert("검색어를 입력해주세요.");
				return false;
		}
			
		$("#frm").submit();
			
		});
	});
</script>
</head>
<body>
<form id="frm" action="/emp/searchEmp" method="post">
	<select id="selectType" name="selectType">
		<option value="job">직업 </option>
		<option value="dname">부서명</option>
	</select>
	<input type="text" id="searchWord" name="searchWord" />
	<button type="button" id="btnSearch">검색</button>
</form>
<hr>
	<c:forEach var="emp" items="${list }">
		${emp.ename} - ${emp.job} - ${emp.dname}<br>
	</c:forEach>
</body>
</html>