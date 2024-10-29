<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
	<jsp:include page="layouttopo.jsp"></jsp:include>
	<div class="row">
		<h1>Lista de Imoveis</h1>
	</div>
	<div class="row">

		<table class="table table-striped">

			<thead>
				<tr>
					<th scope="col">Código</th>
					<th scope="col">Rua</th>
					<th scope="col">Número</th>
					<th scope="col">Tamanho</th>
					<th scope="col">Valor</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach items="${listaImoveis}" var="imovel">
					<tr>
						<td>${imovel.getCodigo()}</td>
						<td>${imovel.getRua()}</td>
						<td>${imovel.getNumero()}</td>
						<td>${imovel.getTamanho()}</td>
						<td>${imovel.getValor()}</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>
	<jsp:include page="layoutrodape.jsp"></jsp:include>