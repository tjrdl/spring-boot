<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    <script type="text/javascript" src="${contextPath}/js/scriptTest.js"></script>
</head>

<body>
hello.jsp~<br>
<c:if test="${not empty message}">
    ${message}
</c:if>
<br>
<img src="${contextPath}/image/duke.png" width="200" height="200" alt="duke">
<input type="button" name="test" value="test" onclick="test()">

</body>
</html>