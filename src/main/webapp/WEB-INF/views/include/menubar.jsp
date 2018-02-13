<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 메뉴 바 -->

		<style>
			body {
                margin: 0;
                padding: 0;
			    background-image: url("gradient_bg.png");
   			    background-repeat: repeat-x;
            }

            .container {
                position: relative;
                width: 100%;
            }

            .right {
                position: relative;
                left: 20%;
                right: 20%;
                width: 60%;
                background-color: #58D3F7;
				bordercolor : #6E6E6E
            }
            table   {
			    margin-left: auto;
                margin-right: auto;
             }
          
       </style>
</head>
<body>
<h2 >이미지!!!!!!</h2>
          <div class="container" style="border:solid 1px #000000" >
            <div class="right">
              
             <!-- 메뉴바! -->
              <table  border="1" width="350" height="50" style="border:solid 1px #58D3F7 ">
                  <tr id=""  >
                        <td> <button type ="submit" onclick="location.href='경로'"  style="color:#FFFFFF">최근경기</button></td>
                        <td> <button type ="submit"onclick="location.href='경로'" >일반</button></td>
                        <td> <button type ="submit" onclick="location.href='경로'" >솔로랭크</button></td>
                        <td> <button type ="submit" onclick="location.href='경로'" >자유랭크</button></td>
                  </tr>
              </table>
              

            </div>
          </div>
 
            
</body>
</html>