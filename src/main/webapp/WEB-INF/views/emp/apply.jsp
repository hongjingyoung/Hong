<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	function readURL (input) {
		if (input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#img').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}


	$(document).ready(function(){
		$("#file").change(function(){
			readURL(this);
			
		});
		
		$("#btnApply").click(function(){
			var usrImg = $("#file").val();
			var usrName = $("#usrName").val();
			var usrSal = $("#usrSal").val();
			
			//alert(usrImg +"," + usrName +"," +usrSal);
			if(usrImg == ""){
				alert("사진을 입력해주세요");
				return false;
			}
			if(usrName ==""){
				alert("이름을 입력해주세요");
				return false;
				
			}
			if(usrSal == ""){
				alert("연봉을 입력해주세요");
				return false;
			}
			$("#frm").submit();
		});
	
	});
</script>
</head>
<body>
<form id="frm" action="/emp/procApply" method="post" enctype="multipart/form-data">
<table style="width:700px">
	<tr>
		<td rowspan="2" style="width:20%" >
		<table>	
			<tr>
				<td><img src="#" id="img" style="width:80px; height:80px" /></td>
			</tr>
			<tr>
				<td>
					<input type="file" id="file" name="file"/>
				</td>
			</tr>
		</table>
		</td>
		<td>
			<input type="text" id="usrName" name="usrName" placeholder="이름" />
		</td>
		<td>
			<input type="text" id="usrSal" name="usrSal" placeholder="희망연봉" />
		</td>
		
	</tr>

	<tr>
		<td colspan="2">
			<input type="text" id="usrAddress" name="usrAddress" placeholder="주소" style="width:90%" />
		</td>
	</tr>
	<tr>
		<td colspan="2">	
			<input type="text" id="usrFavorite" name="usrFavorite" placeholder="특기" />
		</td>
		<td colspan="2">	
			<input type="text" id="usrHobby" name="usrHobby" placeholder="취미" />
		</td>
	</tr>
	
	
	<tr>
		<td colspan="3">			
			<textarea rows="20" cols="80" id="usrIntro" name="usrIntro">자기 소개서</textarea>
		</td>
	</tr>	
	<tr>
		<td colspan="2" align="center">
			<button id="btnApply" type="button">등록</button>
		</td>
	</tr>
	
</table>
</form>
</body>
</html>