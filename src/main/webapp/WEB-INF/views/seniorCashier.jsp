<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : \"en\"}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="properties"/>

<html>
<head>
    <title>cashier page</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1><fmt:message key="cash.register"/></h1>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <jsp:include page="parts/header.jsp"></jsp:include>
        <jsp:include page="parts/menu.jsp"></jsp:include>
        <div class="w3-container w3-center w3-green">
            <h2>
                <i><fmt:message key="invoices.list"/></i>
            </h2>
            <table border="1" cellpadding="5" cellspacing="1" >
                <tr>
                    <th><fmt:message key="product.id"/></th>
                    <th><fmt:message key="price"/></th>
                    <th><fmt:message key="quantity"/></th>
                    <th><fmt:message key="cashier.id"/></th>
                </tr>
                <c:forEach items="${invoices}" var="invoice" >
                    <tr>
                        <td>${invoice.product_id}</td>
                        <td>${invoice.cost}</td>
                        <td>1</td>
                        <td>${invoice.userId.id}</td>
                        <td><a href="/delete?id=${invoice.id}"><fmt:message key="delete"/></a></td>
                    </tr>
                </c:forEach>
            </table>
            <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/delete_all'"><fmt:message key="deleteAll"/></button>
            <br>
        </div>
    </div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/api/login'"><fmt:message key="back.to.user.menu"/></button>
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>
</body>
</html>
