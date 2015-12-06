<%@ include file="includes.jsp"%>
<html>
<head>
<title>Formulário</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
</head>
<body>
	<jsp:useBean id="caloteiro" class="br.com.triadworks.javaweb.modelo.Caloteiro" >
		<jsp:setProperty name="caloteiro" property="nome" param="nomeCaloteiro"/>
		<jsp:setProperty name="caloteiro" property="email" param="emailCaloteiro"/>
	</jsp:useBean>
	<%= caloteiro.getNome() %>
	<jsp:getProperty property="nome" name="caloteiro"/>
</body>
</html>