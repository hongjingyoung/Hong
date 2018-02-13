<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="" action="" method="post">
<c:forEach var="members" items="${list  }">
	${members.mId } - ${members.mName }<br>
</c:forEach>
<input type="text" id="t" name="search">
<button type="button" id="b" name="search">검색</button>
</form>
</body>
</html>