<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
<title>Départements</title>
</head>
<body class="container">
	<nav>
		<a href="./departement" class="btn btn-link">departement</a> <a
				href="./employe" class="btn btn-link">employe</a>
	</nav>
	<h1>Liste de departement</h1>
	<table class="table">
		<tr>
			<th>Id :</th>
			<th>Nom :</th>
			<th>Responsable Département ID :</th>	
			<th></th>
			<th><div class="alert alert-danger">attention on ne gere
					pas si il y a toujours des produits associer au
					employe=>violation de contrainte</div></th>
		</tr>
		<c:forEach items="${departements}" var="d">
			<tr>
				<td>${d.id}</td>
				<td>${d.nom}</td>

				
				<td><a href="./departement?q=edit&id=${d.id}"
					class="btn btn-outline-primary">editer</a></td>
				<td><a href="./departement?q=delete&id=${d.id}"
					class="btn btn-outline-danger">supprimer</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="./departement?q=add" class="btn btn-link">nouveau
		departement</a>
</body>
</html>