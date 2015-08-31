<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Pedido</h2>	
		Detalle del pedido:
				<ul>
					<c:forEach items="${pedido.productos}" var="prod">
						<li>${prod.key.nombre}: ${prod.value} ${prod.key.medida.abreviacion}</li>
					</c:forEach>
				</ul> 
			<table>
				<tr>
					<td>Precio Final : </td>
					<td><c:out value="${pedido.precioFinal}"/></td>
				</tr>	
				<tr>
					<td>Realizado por el cliente : </td>
					<td><c:out value="${pedido.cliente.idUser}"/> <a href="<c:url value="/cliente/mostrar.htm?idCli=${pedido.cliente.idUser}"/>">Mostrar Cliente</a></td>
				</tr>	 
			</table>
		<br>
		
<a href="./ver.htm">Ver Pedidos</a> 