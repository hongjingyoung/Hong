<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="navbar navbar-default">
	<div class="container">
		<div class=" navbar-header">
			<button class="navbar-header">
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Elvis Blog</a>
		</div>


		<c:choose>
			<c:when test="${sessionScope.id ne null}">
				<form>
				<div class="navbar-header pull-right">
					<span class="navbar-brand"> ${sessionScope.id}님 반갑습니다</span>
					<a href="#" class="btn btn-default btn-logout"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a>
				</div>
				</form>
			</c:when>
			<c:otherwise>
	
				<center>
					<div class="navbar-collapse collapse" id="navbar-main">
						<form class="navbar-form navbar-right" action="/login/loginCheck" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="id" placeholder="username">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name=" password" placeholder="Password">
					</div>
						<input type="submit" class="btn btn-default" value="로그인"></button>
						</form>
					</div>
				</center>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>