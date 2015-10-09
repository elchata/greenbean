<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.User , beans.Categoria , java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<link rel="stylesheet" href='<c:url value="/resources/css/pure-0.4.2.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/media/css/jquery.dataTables.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/jquery-ui.css"/>'>
<script src='<c:url value="/resources/media/js/jquery.js"/>'></script>
<script src='<c:url value="/resources/js/jquery-ui.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/js-for-listBooks.js"/>'></script> 
<script src='<c:url value="/resources/media/js/jquery.dataTables.js"/>'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>GreenBean</title> 
</head>
<body>
<nav>
	<jsp:include page="menuAdmin.jsp" />
</nav>
<c:choose >
	<c:when test="${sessionScope.sesion == null}">
		<div id="logg">
			<a href="<c:url value="/login.htm"/>">Iniciar Sesion</a>
		</div>
	</c:when>
	<c:otherwise>
		<div id="sesion"><a href=" <c:url value="/cliente/mostrar.htm?idCli=${sessionScope.sesion.idUser }"/>">Ver mi perfil</a> <a href=" <c:url value="/cerrarSesion.htm"/>">Cerrar Sesion</a></div>
	</c:otherwise>
</c:choose>   

<div id="menuCategorias"> 
	<jsp:include page="menuCategorias.jsp" />
 </div>
 
<div id="cuerpo" style="width: 70%; float: left;">
	<jsp:include page="${vista}" />
</div> 
<div id="carrito" style="width: 20%;padding:5px; float: left; border: 3px; border-style: solid; text-align: center">
	<h3>Mi Pedido:</h3>
	<c:set var="tot" value="0" />
	<c:choose>
		<c:when test="${sessionScope.sesion != null}">
			<c:forEach items="${sessionScope.sesion.carrito.productos}" var="prod">
			<br>
				<c:out value="${prod.key.nombre}" />
				<c:out value="${prod.value}" />	
				<c:out value="${prod.key.medida.abreviacion}" />	 
				<c:set var="tot" value="${prod.key.precios.get(0).monto * prod.value + tot}" />
				<a href="<c:url value="/producto/quitar.htm?idKey=${prod.key.idProducto}"/>">Quitar</a>
			</c:forEach>
		</c:when>
		<c:otherwise>
		   	<c:forEach items="${sessionScope.carro.productos}" var="prod">
		   	<br>
				<c:out value="${prod.key.nombre}" />
				<c:out value="${prod.value}" />	
				<c:out value="${prod.key.medida.abreviacion}" />	 
				<c:set var="tot" value="${prod.key.precios.get(0).monto * prod.value + tot}" />
				<a href="<c:url value="/producto/quitar.htm?idKey=${prod.key.idProducto}"/>">Quitar</a>
			</c:forEach>
		</c:otherwise>
	</c:choose>	 
	<h4>Total: $<c:out value="${tot}" /></h4>
	<a href="<c:url value="/pedido/confirmarCompra.htm"/>">Confirmar Pedido</a>
</div>
</body>
</html>