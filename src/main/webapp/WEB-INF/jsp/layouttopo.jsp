<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8" />
    <title>SpringMVC</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap5/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/estilos.css" />
    <script src="js/jquery-3.2.1.slim.min.js"></script>
    <script src="css/bootstrap5/js/bootstrap.min.js"></script>
  </head>
  <body>
		<header>
		  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		    <div class="container-fluid">
		      <a class="navbar-brand" href="#">Desenvolvimento Para Servidores II</a>
		      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		        <span class="navbar-toggler-icon"></span>
		      </button>
		      <div class="collapse navbar-collapse" id="navbarCollapse">
		        <ul class="navbar-nav me-auto mb-2 mb-md-0">
		          <li class="nav-item">
		            <a class="nav-link" href="/index">Página Inicial</a>
		          </li>
			      <li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" 
			          role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            Menu
			          </a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li>
			            <a class="dropdown-item" href="#">Submenu 1</a>
			            </li>
			            <li><hr class="dropdown-divider"></li>			            
			            <li>
			            <a class="dropdown-item" href="#">Submenu 2</a>
			            </li>
			          </ul>
			       </li>
			      		          
		        </ul>
		        <form class="d-flex" method="GET" action="/">
		          <input class="form-control me-2" type="search" placeholder="Procurar" 
		          	aria-label="Search" name="descricao">
		          <button class="btn btn-outline-success" type="submit">Procurar</button>
		        </form>
		      </div>
		    </div>
		  </nav>
			<div class="logo">
				<img src="imagens/spring.png" />
			</div>		  
		</header>
		<main>
			<div class="container">