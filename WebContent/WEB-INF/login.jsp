<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Mon espace</title>
    <link type="text/css" rel="stylesheet" href="styles.css" />
</head>
<body>
   	<c:import url="/WEB-INF/menu/menu.jsp" />
	<br>
	<c:import url="/WEB-INF/login/form.jsp" />
       <br />
       <c:if test="${ statusOK }">
       <c:import url="/WEB-INF/login/card.jsp" />
    </c:if>
</body>
</html>