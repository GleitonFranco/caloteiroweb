<%@ include file="includes.jsp"%>
<%-- <jsp:useBean id="dao" class="br.com.triadworks.javaweb.dao.CaloteiroDAO" /> --%>
<html>
<head>
<title>Lista de Caloteiros JSTL</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<form action="sistema?acao=AutenticarUsuario" method="post" id="formLogin">
		Login:<input type="text" name="login" value="">
		Senha:<input type="password" name="senha" value="">
		<input type="submit" value="Log In">
	</form>
	<p>${usumsg}</p>
</body>
</html>