<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getAttribute("erreur") != null) {
		%>
		<div>erreur!!!!</div>
		<%
		}
		%>
	<form action="./hello" method="post">
		<div>
		prenom:<input name="prenom">
		</div>
	
		<div>
			<button type="submit">envoyer</button>
		</div>
	</form>
</body>
</html>