<html>
<head>
<% String msg = "Seja bem vindo ao JSP!"; %>
<title><% out.println(msg); %></title>
</head>
<body>
Olá <%=request.getParameter("nome")%>, <%=msg %>
</body>
</html>