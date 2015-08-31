<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<ul>
	<li><a href="<c:url value="/categoria/ver.htm"/>">ABM categorias</a></li>
	<li><a href="<c:url value="/cliente/ver.htm"/>">ABM clientes ( va a pasar a ser solo eliminar.. el alta y edicion la hace el user)</a></li>
	<li><a href="<c:url value="/direccion/ver.htm"/>">ABM direcciones</a></li>
	<li><a href="<c:url value="/medida/ver.htm"/>">ABM medidas</a></li>
	<li><a href="<c:url value="/producto/ver.htm"/>">ABM productos</a></li>
	<li><a href="<c:url value="/pedido/ver.htm"/>">ABM pedidos</a></li>
	<li><a href="<c:url value="/provincia/ver.htm"/>">ABM provincia</a></li>
	<li><a href="<c:url value="/partido/ver.htm"/>">ABM partido</a></li>
	<li><a href="<c:url value="/banda/ver.htm"/>">ABM banda</a></li>
	<li><a href="<c:url value="/producto/buscar.htm"/>">Buscar producto x nombre</a></li>
	<li><a href="<c:url value="/producto/listar.htm"/>">Listar Productos</a></li>
	<li><a href="<c:url value="/ciudad/ver.htm"/>">ABM ciudad</a></li>
</ul>