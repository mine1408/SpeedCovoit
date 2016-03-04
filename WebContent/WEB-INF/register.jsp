<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="styles.css" />
    </head>
    <body>
    	<c:import url="/WEB-INF/menu/menu.jsp" />
		<br>
		<c:import url="/WEB-INF/user/form.jsp" />
        <br />
        <c:if test="${ !errorStatus }">
        	<c:import url="/WEB-INF/user/card.jsp" />
	    </c:if>
    </body>
</html>