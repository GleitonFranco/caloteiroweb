<%@ include file="includes.jsp"%>
<jsp:useBean id="dao" class="br.com.triadworks.javaweb.dao.CaloteiroDAO" />
<html>
<head>
<title>Lista de Caloteiros JSTL</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>
	<h1>Lista de Caloteiros</h1>
	<c:forEach var="caloteiro" items="${dao.lista}">
		<li> ${caloteiro.nome} </li>
	</c:forEach>
	</br>
	<table border="4">
		<c:forEach var="caloteiro" items="${lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? '99FF99' : 'ffffff' }">
				<td>${id.count}</td>
				<td>
					<c:choose>
						<c:when test="${not empty caloteiro.nome}">
							${caloteiro.nome}
						</c:when>
						<c:otherwise>
							Nome não encontrado
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${not empty caloteiro.email}">
								<a href="mailto:${caloteiro.email}">${caloteiro.email}</a>		
						</c:when>
						<c:otherwise>
							E-mail não encontrado
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${not empty caloteiro.devendo}">
							<td>${caloteiro.devendo}</td>
						</c:when>
						<c:otherwise>
							<td>Valor não encontrado</td>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${not empty caloteiro.dataDivida}">
							<f:formatDate value="${caloteiro.dataDivida.time}" pattern="dd/MM/yyyy"/>
						</c:when>
						<c:otherwise>
							Data não encontrada
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<a href="sistema?acao=AlterarCaloteiro&selecionado=${caloteiro.id}">Editar</a>
					<a href="sistema?acao=RemoverCaloteiro&selecionado=${caloteiro.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</br>
	Obrigado pela preferência!
	</br>
	<c:import url="rodape.jsp"/>
</body>
</html>