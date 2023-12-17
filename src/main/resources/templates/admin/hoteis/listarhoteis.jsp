<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
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
<link rel="stylesheet" type="text/css" href="reset/style/style.css" />

<!-- styles reset admin-->
<link rel="stylesheet" type="text/css" href="admin/reset/resetadmin.css" />
<!-- styles clientes-->
<link rel="stylesheet" type="text/css" href="admin/hoteis/styles/hoteis.css" />

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
						<jsp:param value="active" name="hoteis-a" />
					</jsp:include>
					<div class="card-body">
						<a href="admin/hoteis/adicionar.jsp" class="btn btn-criar-cliente mb-4">Novo Hotel</a>
						<table class="table table-responsive table-hover">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Nome</th>
									<th scope="col">Preço da diária</th>
									<th scope="col">Cidade</th>
									<th scope="col">Bairro</th>
									<th scope="col">Rua</th>
								</tr>
							</thead>
							<tbody>
							<jstl:forEach items="${listahoteis}" var="h">
								<tr>
									<td>${h.id}</td>
									<td>${h.nome }</td>
									<td>${h.preco_diaria}</td>
									<td>${h.cidade}</td>
									<td>${h.bairro}</td>
									<td>${h.rua}</td>
									<td>
										<div class="d-flex justify-content-center">
											<a href="EditarHotel?id=${h.id}" ><i class="bi bi-pencil-square text-primary-emphasis fs-5 me-2"></i></a>
											<a href="DeletarHotel?id=${h.id}"
											title="cancelar"
											onclick="return confirm('Deseja excluir o hotel ${h.nome}?')"
											>
											<i class="bi bi-trash3 text-danger-emphasis fs-5"></i>
											</a>
										</div>
									</td>
								</tr>
								</jstl:forEach>
							</tbody>
						</table>
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