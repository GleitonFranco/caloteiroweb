<html>
<head>
<% String msg = "Seja bem vindo ao JSP!"; %>
<title><% out.println(msg); %></title>
</head>
<body>
Ol� <%=request.getParameter("nome")%>, <%=msg %>
</body>
</html>