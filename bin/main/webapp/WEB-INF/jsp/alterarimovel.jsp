<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <jsp:include page="layouttopo.jsp"></jsp:include>

            <!DOCTYPE html>
            <html lang="pt-BR">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Formulário de Imóvel</title>
                <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

                <link rel="stylesheet" href="css/imovel.css">

            </head>

            <body>

                <div class="container">
                    <h2>Alterar Imóvel</h2>
                    <form:form action="/alterarimovel" modelAttribute="imovel">
                        <div class="form-group">
                            <label for="codigo">Código do imovel</label>
                            <input type="text" class="form-control" id="rua" value="${imovel.getCodigo()}" disabled>
                            <input type="hidden" name="codigo" value="${imovel.getCodigo()}">
                        </div>
                        <div class="form-group">
                            <label for="rua">Rua</label>
                            <input type="text" class="form-control" id="rua" name="rua" value="${imovel.getRua()}">
                        </div>
                        <div class="form-group">
                            <label for="numero">Número</label>
                            <input type="number" class="form-control" id="numero" name="numero"
                                value="${imovel.getNumero()}">
                        </div>
                        <div class="form-group">
                            <label for="tamanho">Tamanho (m²)</label>
                            <input type="number" class="form-control" id="tamanho" name="tamanho"
                                value="${imovel.getTamanho()}">
                        </div>
                        <div class="form-group">
                            <label for="valor">Valor (R$)</label>
                            <input type="number" class="form-control" id="valor" name="valor"
                                value="${imovel.getValor()}">
                        </div>
                        <button type="submit" class="btn btn-primary">Alterar</button>
                    </form:form>
                </div>

                <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            </body>

            </html>

            <jsp:include page="layoutrodape.jsp"></jsp:include>