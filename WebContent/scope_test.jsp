<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h1>스코프 테스트</h1>
   
   applicationScope : ${ applicationScope.application_name }<br />  <!--  //값 출력  el에서는 applicationScope이렇게 써야함 -->
    sessionScope : ${ sessionScope.session_name }<br />   <!-- //값 출력 -->
    pageScope : ${ pageScope.page_name }<br />    <!-- //값 출력 -->
    requestScope : ${ requestScope.request_name } 



</body>
</html>