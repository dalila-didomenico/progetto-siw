<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuovo quadro</title>
</head>
<body>
<h2>Inserisci un nuovo quadro</h2>
	<form action="quadro" method="post">
		<div>
			Titolo*: <input type="text" name="titolo" value='${quadro.titolo}' />
			${errTitolo}
		</div>
		<div>
			Tecnica*: <input type="text" name="tecnica" value='${quadro.tecnica}' />
			${errTecnica}
		</div>
		<div>
			Dimensioni*: <input type="text" name="dimensioni"
				value='${quadro.dimensioni}' /> ${errDimensioni}
		</div>
		<div>
			Anno di realizzazione*: <input type="text" name="anno"
				value='${quadro.anno}' /> ${errAnno}
		</div>
		</div>
		<div>*Campo obbligatorio</div>
		<input type="submit" name="sumbit" value="invia" />
	</form>
	<a href="quadri">Lista quadri</a>
</body>
</html>