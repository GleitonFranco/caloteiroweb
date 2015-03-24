<%@ include file="includes.jsp"%>
<html>
<head>
<title>Formulário</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"></link>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<form action="adicionaCaloteiro">
		<input type="hidden" name="acao" value="AdicionarCaloteiro" />
		<TriadTag:campoText
			campoName="nome" 
			label="Nome:" 
			id="labelNome"
		/>
		<TriadTag:campoText
			campoName="email" 
			label="E-mail:" 
			id="labelEmail"
		/>
		<TriadTag:campoText
			campoName="devendo" 
			label="Devendo R$:" 
			id="labelDevendo"
		/>
		<TriadTag:campoText
			campoName="dataDivida" 
			label="Data Dívida::" 
			id="labelData"
		/>
		<input type="submit" value="Salvar"/>
	</form>
	<c:import url="rodape.jsp"/>
</body>
</html>