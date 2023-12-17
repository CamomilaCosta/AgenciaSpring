<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous" />
<!-- Bootstrap icons -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" />

<!-- styles reset -->
<link rel="stylesheet" type="text/css"
	href="reset/style/style.css" />

<!-- styles reset admin-->
<link rel="stylesheet" type="text/css"
	href="admin/reset/resetadmin.css" />
<!-- styles clientes-->
<link rel="stylesheet" type="text/css"
	href="admin/voos/styles/voo.css" />

<title>Painel de administrador</title>
</head>
<body>
	<header>
		<jsp:include page="../components/menu.jsp">
			<jsp:param value="index.html" name="home"/>
			<jsp:param value="about.html" name="about"/>
			<jsp:param value="tours-1.html" name="tours"/>
			<jsp:param value="contact.html" name="contact"/>
			<jsp:param value="Clientes" name="admin"/>
			<jsp:param value="reset/img/logo1.png" name="logo"/>
		</jsp:include>
	</header>
	<main>
		<section id="itens-admin" class="container">
			<div class="cards">
				<div class="card text-center">
					<jsp:include page="../components/menuAdmin.jsp">
						<jsp:param value="Clientes" name="clientes" />
						<jsp:param value="Hoteis" name="hoteis" />
						<jsp:param value="Voos" name="voos" />
						<jsp:param value="Pacotes" name="pacotes" />
						<jsp:param value="Compras" name="compras" />
						<jsp:param value="active" name="voos-a" />
					</jsp:include>
					<div class="card-body card-body-add">
						<form action="AtualizarVoo" id="form">
							<h3>Editar Voo</h3>
							<input type="hidden" id="id" name="id" value="${voo.id}" />
							<div id="floating-empresa" class="form-floating">
								<select id="empresa" name="empresa" class="form-select"
									aria-label="Floating label select example">
									<option selected>${voo.empresa}</option>
									<option value="LATAM">LATAM</option>
									<option value="Azul">Azul</option>
									<option value="Gol">Gol</option>
								</select> <label for="empresa">Escolha a empresa</label>
							</div>
							<div id="floating-cidadeOrigem" class="form-floating">
								<input type="text" id="cidade-origem" name="cidade_origem"
									class="form-control focus-ring" value="${voo.cidade_origem }"/>
								<label for="cidade-origem">Cidade de origem</label>
							</div>
							<div id="floating-cidadeDestino" class="form-floating">
								<input type="text" id="cidade-destino" name="cidade_destino"
									class="form-control focus-ring" value="${voo.cidade_destino}" />
								<label for="cidade-destino">Cidade de destino</label>
							</div>
							<div id="floating-aeroportoOrigem" class="form-floating">
								<input type="text" id="aeroporto_decolagem"
									name="aeroporto_decolagem" class="form-control focus-ring"
									value="${voo.aeroporto_decolagem}" /> <label
									for="aeroporto_decolagem">Aeroporto de origem</label>
							</div>
							<div id="floating-aeroportoDestino" class="form-floating">
								<input type="text" id="aeroporto_pouso" name="aeroporto_pouso"
									class="form-control focus-ring"
									value="${voo.aeroporto_pouso}" /> <label
									for="aeroporto_pouso">Aeroporto de destino</label>
							</div>
							<div id="floating-HoraSaida" class="form-floating">
								<input type="text" id="hora_decolagem" name="hora_decolagem"
									class="form-control focus-ring" value="${voo.hora_decolagem}" />
								<label for="hora_decolagem">Horário de saída</label>
							</div>
							<div id="floating-HoraChegada" class="form-floating">
								<input type="text" id="hora_pouso" name="hora_pouso"
									class="form-control focus-ring"
									value="${voo.hora_pouso}" /> <label for="hora_pouso">Horário
									de chegada</label>
							</div>
							<div id="floating-dataSaida" class="form-floating">
								<input type="date" id="dia_decolagem" name="dia_decolagem"
									class="form-control" value="${voo.dia_decolagem}" /> <label
									for="dia_decolagem">Data de sáida</label>
							</div>
							<div id="floating-dataChegada" class="form-floating">
								<input type="date" id="dia_pouso" name="dia_pouso"
									class="form-control" value="${voo.dia_pouso}" /> <label
									for="dia_pouso">Data de chegada</label>
							</div>
							<div id="floating-preco" class="form-floating">
								<input type="number" step="0.1" id="preco" name="preco"
									class="form-control" value="${voo.preco}" /> <label
									for="preco">Preço</label>
							</div>
							<div id="buttons" class="d-flex">
								<input type="submit" value="Atualizar" id="btn-submit" />
								<a id="btn-submit" href="Voos">Cancelar</a>
							</div>
						</form>

					</div>
				</div>


			</div>
		</section>
	</main>

	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
		integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
		crossorigin="anonymous"></script>
</body>
</html>