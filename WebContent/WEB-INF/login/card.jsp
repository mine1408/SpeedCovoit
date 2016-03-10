<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="styles.css" />
<link type="text/css" rel="stylesheet" href="assets/bootstrap-3.3.6-dist/css/bootstrap.min.css" />
</head>
<fieldset>
	<form action="logout">
		<h3 class="title">Speed COVOIT'</h3>
		<div class="col-md-10">N'attendez plus, nous avons déjà tout prévu.</div>
		</br>
		<div class="col-md-12">Bienvenue dans votre espace personnel</div>
		
		<c:import url="/WEB-INF/menu/menuAccueil.jsp" />
		<a class="btn btn-primary btn-lg" href="<c:url value="/login"/>"><input type="submit" value="Deconnexion" class="sansLabel" /></a>
		
	</form>
</fieldset>