<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>롤 전적검색 메인화면</title>
</head>
<body>
	<jsp:include page="/include/menubar.jsp" flush="false" />
	<jsp:include >
         	<div >
          		<!-- include로 검색창 불러오기  -->
          		<table  border="1" width="450px" height="100px" style="border:solid 1px #58D3F7">	
                	<tr>
                    	<td>챔피언목록 검색창 include</td>
                    </tr>
                </table>
      
                <!-- api로 받은 정보로 챔피언 이미지 불러오기 -->
     			<table  border="1" width="450px" height="130px" style="border:solid 1px #58D3F7">	
                	<tr>
                    	<td>금주의 로테이션챔피언</td>
   
                    <tr >
                   		<td rowspan="100"> 이미지창</td>
                    </tr>
                </table>
                     <table  border="1" width="450px" height="130px" style="border:solid 1px #58D3F7">	
                	<tr>
                    	<td>현재 진행중인 챔피언 및 스킨 세일 </td>
                    </tr>
                    <tr>
                    	<td rowspan="100">이미지창</td>
                    </tr>
                    <!-- api로 받은 정보로 전적이미지 출력 -->
                </table>
               <table  border="1" width="450px" height="520px" style="border:solid 1px #58D3F7">	
                	<tr>
                    	<td></td>
                    </tr>
                </table>
            </div>
		
</body>
</html>


