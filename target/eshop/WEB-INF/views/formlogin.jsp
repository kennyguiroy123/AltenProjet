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
	<form action="./login" method="post">
		<div>
		login:<input name="login">
		</div>
		<div>
		password:<input name="password">
		</div>
	
		<div>
			<button type="submit">envoyer</button>
		</div>
	</form>
</body>
</html>