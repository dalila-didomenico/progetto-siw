<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Autori</title>
</head>
<body>
	<ul>
		<c:forEach var="autore" items="${autori}">
			<li><a href="autore?id=${autore.id}"> ${autore.nome} ${autore.cognome}</a>
			<form action="autore" method="post">
			 	<input type="hidden" value="${autore.id}" name="id"/>
			    <input type="submit" value="cancella" name="commandC"/>
			</form>    
			</li>
		</c:forEach>
		<li><div><a href="index.jsp">Torna alla home</a></div> </li>
	</ul>
</body>
</html>