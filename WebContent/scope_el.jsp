<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <!-- <form action="objelOk.jsp" method="get">
           아이디 : <input type="text" name="id"><br />
           패스워드 : <input type="password" name="pw">
      <input type="submit" value="login">
   </form> -->
   
   <%  // 밑에 4개는 내장객체
      application.setAttribute("application_name", "application_value");  /*application이 돌아갈 때 까지 */
      session.setAttribute("session_name", "session_value");
      pageContext.setAttribute("page_name", "page_value");
      request.setAttribute("request_name", "request_value"); //key, value 형태로 값을 집어넣음. 
   %>


       pageScope : ${pageScope.page_name } <br/>
       <jsp:forward page = "objelOk.jsp"/>



</body>
</html>