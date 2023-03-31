<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <%
 
     String id = request.getParameter("id");
     String pw = request.getParameter("pw");
 
 %>
 
          아이디 : <%= id %> <br/>
          비밀번호 : <%= pw %> <br/>
     <hr>
     
    applicationScope : ${ applicationScope.application_name }<br />  <!--  //값 출력  el에서는 applicationScope이렇게 써야함 -->
    sessionScope : ${ sessionScope.session_name }<br />   <!-- //값 출력 -->
    pageScope : ${ pageScope.page_name }<br />    <!-- //값 출력 -->
    requestScope : ${ requestScope.request_name } 
    

</body>
</html>