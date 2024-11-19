<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:include page="layouttopo.jsp"></jsp:include>
	<div class="row">
		<h1>Cadastro de Usu&aacute;rio</h1>
	</div>
	<div class="row">
		<form method="POST" action="/cadastrarusuario">
		  <div class="mb-3">
		    <label for="nome" class="form-label">Nome</label>
		    <input type="text" id="nome" name="nome" class="form-control" />
		  </div>
		  <div class="mb-3">
		    <label for="login" class="form-label">Login</label>
		    <input type="text" id="login" name="login" class="form-control" />
		  </div>
		  <div class="mb-3">
		    <label for="senha" class="form-label">Senha</label>
		    <input type="password" id="senha" name="senha" class="form-control" />
		  </div>		  
		  <button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
<jsp:include page="layoutrodape.jsp"></jsp:include>