<%@ include file="includes.jsp"%>
<html>
<head>
<title>Formulário</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
</head>
<body>
	<form action="TestBean.jsp">
		<input type="text" name="nomeCaloteiro" />
		<input type="text" name="emailCaloteiro" />
		<input type="text" name="devendo" />
		<input type="text" name="data" />
		
		<input type="submit" value="Salvar"/>
	</form>
</body>
</html>