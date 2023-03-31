
<%@page import="edu.global.ex.vo.EmpVO"%>
<%@page import="edu.global.ex.dao.EmpDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- 반드시 복사 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> <%out.print("AAA"); %>
           <%= "AAA" %>
           ${"AAA"}
           <c:out value = "hello World"/> <br> 
           
           <%--
           <c:out> 채그
                      출력문을 만드는 태드이다.
           
            --%>
            
            <c:out value = "hello World"/> <br>
            <c:out value = "hello"/> <br>
            <c:out value = '${"안녕하세요"}'></c:out> <br>
            
               <%-- <c:set> 태그 --%>
               <!--  변수를 다룰 때 사용한다. -->
               
               <c:set var = "name1" value = "홍길동"/>  <!-- 메모리에 올렸으니 '홍길동' 출력 -->
               <c:set var = "name2" value = "홍길순"/> 
               <% 
               pageContext.setAttribute("name1", "바뀔까");   /* 이거 넣는 순간 '홍길동'이 안나오고 '바뀔까'가 나옴. pageContext 영역 안에서만 쓸 수 있음 */
               %>
               ${name1} </br>
               ${name2} </br>
               
               
               <%-- <c:remove> 태그 --%>
              <hr>
              <c:remove var = "name1"/>
              ${name1} </br>
              ${name2} </br>
            
              <c:if test="${10 > 20}" var="result1">
              10은 20보다 크다.<br>      <!-- 결과가 false이면 '10은 20보다 크다.' 안뿌려짐 -->
              </c:if>
              result1 : ${result1}<br>
 
             <c:if test="${10 < 20}" var="result2">
              20은 10보다 크다.<br>    
               </c:if>
              result2 : ${result2} <br>
              
               <!-- else if에 해당하는 태그 -->
               <c:set var="user" value = "abcd123"/>
               <c:choose>   
               <c:when test= "${user=='admin'}">
                                        관리자 페이지
                 </c:when>
                 <c:otherwise>
                    ${user}님 반갑습니다.
                 </c:otherwise>
                 </c:choose>
                 
                 
                 <hr>
                 
                 <!-- $(달러 문법을 많이 헷갈려함)
                 ${el}은 메모리에 올라간 것을 가져올 때 쓰는 거라고 외움. -->
                 
                 <%pageContext.setAttribute("numList", new String[]{"1","2","3","4","5"}); %>  <!-- numList라는 이름으로 메모리 올림 -->
                 <ul>
                     <c:forEach var= "num" items= "${numList}" begin="1" end="3">    <!-- begin 과 end를 지정해주면 딱 3번 돈다. 지정안하면 5번 돈다. -->
                 <li>${num}</li>
                 </c:forEach>
                 </ul>
                 
                <%
                 List<String> fruits = new ArrayList<>();
                 fruits.add("apple");
                 fruits.add("banana");
                 fruits.add("pineapple");
                 fruits.add("kiwi");
                 fruits.add("melon");
                 pageContext.setAttribute("fruits", fruits);
                  %>
                  
                  <ul>
                  <c:forEach var = "fruit" items="${fruits}">
                  <li>${fruit}</li>
                  </c:forEach>
                  </ul>
                 
                 <hr>
            <!-- <문제1> -->
            
             <%
            EmpDAO dao = new EmpDAO();
            List<EmpVO> emps = dao.empSelect();
            
            pageContext.setAttribute("emps", emps);
            %>
            
              <ul> 
               <c:forEach var = "emp" items ="${emps}">
                <li>${emp.empno}</li>
                </c:forEach>
                </ul>
            
                <hr>
                  <!-- <문제2> -->
                  
                <table  border="1">
      <c:forEach var="i" begin="1" end="9">
         <tr>
            <c:forEach var="j" begin="1" end="9">
               <td>${j }x ${i} = ${i*j}</td>
            </c:forEach>
         </tr>
      </c:forEach>
   </table>
               
                

</body>
</html>