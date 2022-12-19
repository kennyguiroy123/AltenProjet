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
		<h1>Edition departement</h1>
		<div class="card w-100">
			<div class="card-body">
				<form action="./departement" method="post">
					<input type="hidden" name="q" value="save">
					<c:if test="${departement.id!=null}">
							<div class="form-group">
								<label for="id">Id :</label> 
								<input id="id" name="id"class="form-control" value="${departement.id}" readonly placeholder="generation automatique">
							</div>
					</c:if>
					
					<div class="form-group">
						<label for="nomDept"> nom Departement :</label> <input id="nomDept" name="nomDept"
							class="form-control" value="${departement.nom}">
					</div>
					<div>
                        <label for="employe.matricule"> Employe:</label> 
                        <select id="employe.id" name="employe.id" class="form-control">
                            <c:forEach items="${employees}" var="e">
                                <c:choose>
                                    <c:when test="${department_responsible_id == e.matricule }">
                                        <option value="${e.matricule}" selected="selected">${e.nom}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${e.matricule}">${e.nom}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
						
					<div class="form-group">
						<button type="submit" class="btn btn-outline-primary">enregistrer</button>
						<a href="./departement" class="btn btn-outline-warning">annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>