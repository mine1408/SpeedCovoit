<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mon espace</title>
<link type="text/css" rel="stylesheet" href="styles.css" />
<link type="text/css" rel="stylesheet"
	href="assets/bootstrap-3.3.6-dist/css/bootstrap.min.css" />
</head>
<body>
	<c:if test="${ !statusOK }">
		<c:import url="/WEB-INF/menu/menuIndex.jsp" />
		<br>
		<c:import url="/WEB-INF/login/form.jsp" />
	</c:if>
	<br />
	<c:if test="${ statusOK }">
		<c:import url="/WEB-INF/login/card.jsp" />
	</c:if>
</body>
</html>