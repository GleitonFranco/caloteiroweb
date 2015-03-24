<%@page import="br.com.triadworks.javaweb.modelo.Caloteiro"%>
<%@page import="java.util.List"%>
<%@page import="br.com.triadworks.javaweb.dao.CaloteiroDAO"%>
<html>
<head>
<title>Lista de Caloteiros</title>
</head>
<body>
	<h1>Lista de Caloteiros</h1>
	<% 
		CaloteiroDAO dao = new CaloteiroDAO();
		List<Caloteiro> lista = dao.getLista();
		for(Caloteiro c : lista) { 
	%>
	<li>
		<%=c.getNome() %> - <%=c.getEmail() %>
	</li>
	<% } %>
	</br>
	Obrigado pela preferência!
</body>
</html>