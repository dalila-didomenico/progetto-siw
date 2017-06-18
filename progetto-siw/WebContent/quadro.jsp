<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettagli quadro</title>
</head>
<body>

<h2><p align="center">${quadro.titolo}</p></h2>
<div>${quadro.autore}</div> <!-- si ricava così l'autore?? -->
<div style="color: Purple; ">Tecnica: ${quadro.tecnica}</div>
<div>Anno di realizzazione: ${quadro.annoRealizzazione}</div>
<div>Dimensioni: ${quadro.dimensioni}</div>
<div>Si trova nella sala ${quadro.sala}</div> <!-- si ricava così la sala?? -->
</body>
</html>