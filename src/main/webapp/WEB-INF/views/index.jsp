<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : \"en\"}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="properties"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>main</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
  <h1><fmt:message key="cash.register"/></h1>
</div>
<c:out value="${username}"/>

<div class="w3-container w3-center">
  <div class="w3-bar w3-padding-large w3-padding-24">
    <a href="/registration">Registration</a>
    <a href="/login">Login</a>
    <div>
      <a href="${pageContext.request.contextPath}/views/language//?language=ua">
        <fmt:message key="ua"/>
      </a>
      <a href="${pageContext.request.contextPath}/views/language//?language=en">
        <fmt:message key="en"/>
      </a>
    </div>
  </div>
</div>


</body>
</html>