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
	


</script>

</head>
<body>
<c:forEach var="members" items="${list  }">
	${members.mNo } - ${members.mId } - ${members.mName } <br>
</c:forEach>
<c:forEach var="i" begin="${startPageNum }" end="${lastPageNum }">
<a href="/member/selectPaingMemberList?currPage=${i }" >[${i }]</a>
</c:forEach>
<button type="button" > 다음</button>
<button type="button" > 이전</button>
</body>
</html>