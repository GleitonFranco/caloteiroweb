<%@ include file="includes.jsp"%>
<html>
<head>
<title>Formulário</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<form id="calote" action="sistema">
		<input type="hidden" name="acao" value="CaloteiroAlterado" />
		<input type="hidden" name="labelID" value="${caloteiroSelect.id}" />
		<TriadTag:campoText
			campoName="nome" 
			label="Nome:" 
			id="labelNome"
 			valor="${caloteiroSelect.nome}"
		/>
		<TriadTag:campoText
			campoName="email" 
			label="E-mail:" 
			id="labelEmail"
			valor="${caloteiroSelect.email}"
		/>
		<TriadTag:campoText
			campoName="devendo" 
			label="Devendo R$:" 
			id="labelDevendo"
			valor="${caloteiroSelect.devendo}"
		/>
		<TriadTag:campoText
			campoName="dataDivida" 
			label="Data Dívida::" 
			id="labelData"
			valor="${dataSelect}"
		/>
		<input type="submit" value="Salvar"/>
	</form>
	<c:import url="rodape.jsp"/>
</body>
</html>