<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Quadri</title>
</head>
<body>
	<ul>
		<c:forEach var="quadro" items="${quadri}">
			<li><a href="quadro?id=${quadro.id}"> ${quadro.titolo} </a>
			<form action="quadro" method="post">
			 	<input type="hidden" value="${quadro.id}" name="id"/>
			    <input type="submit" value="cancella" name="commandC"/>
			</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>