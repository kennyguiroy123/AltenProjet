<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
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
</head>
<body>
	<div class="container">
		<nav>
			<a href="./departement" class="btn btn-link">departement</a> <a
				href="./employe" class="btn btn-link">employe</a>
		</nav>
		<h1>Edition d'employes</h1>
		<div class="card w-100">
			<div class="card-body">
				<form action="./employe" method="post">
					<input type="hidden" name="q" value="save">
					<div>
                        <label for="employee.matricule">employee:</label> <select
                            id="employee.id" name="employee.id" class="form-control">
                            <c:forEach items="${employees}" var="e">
                                <c:choose>
                                    <c:when test="${responsable_department_id == e.matricule }">
                                        <option value="${e.matricule}" selected="selected">${e.nom}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${e.matricule}">${e.nom}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
					<c:if test="${employe.matricule!=null}">
							<div class="form-group">
								<label for="matricule">Matricule :</label> 
								<input id="matricule" name="matricule"class="form-control" value="${employe.matricule}" readonly placeholder="generation automatique">
							</div>
					</c:if>
					<div class="form-group">
						<label for="prenom"> prenom:</label> <input id="prenom" name="prenom"
							class="form-control" value="${employe.prenom}">
					</div>
					<div class="form-group">
						<label for="nom">nom:</label> <input id="nom" name="nom"
							class="form-control" value="${employe.nom}">
					</div>
					<div class="form-group">
						<label for="adresse.numero">numero:</label> <input
							id="adresse.numero" name="adresse.numero" class="form-control"
							value="${employe.adresse.numero}">
					</div>
					<div class="form-group">
						<label for="adresse.rue">rue:</label> <input id="adresse.rue"
							name="adresse.rue" class="form-control"
							value="${employe.adresse.rue}">
					</div>
					<div class="form-group">
						<label for="adresse.codePostal">code postal:</label> <input
							id="adresse.codePostal" name="adresse.codePostal"
							class="form-control" value="${employe.adresse.codePostal}">
					</div>
					<div class="form-group">
						<label for="adresse.ville">ville:</label> <input
							id="adresse.ville" name="adresse.ville" class="form-control"
							value="${employe.adresse.ville}">
					</div>
					<div class="form-group">
						<label for="salaire"> salaire :</label> <input type="salaire" id="salaire"
							name="salaire" class="form-control" value="${employe.salaire}">
					</div>
					<div class="form-group">
						<label for="telephone">telephone :</label> <input id="telephone"
							name="telephone" class="form-control"
							value="${employe.telephone}">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-outline-primary">enregistrer</button>
						<a href="./employe" class="btn btn-outline-warning">annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>