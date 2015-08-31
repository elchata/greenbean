<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<div id="queryDialog" style="display: none;">
		<%@ include file="editarDatosPersonales.jsp"%>
	</div>
 
		<h3>Mis Datos</h3>	
			<table> 
				<tr>
					<td>Logeado a travez de : </td>
					<td><c:out value="${cliente.empresa.nombre}"/></td>
				</tr>	
				<tr>
					<td>Id de Facebook : </td>
					<td><c:out value="${cliente.idFacebook}"/></td>
				</tr> 
				<tr>
					<td><h4>Datos: </h4></td>
					 <c:forEach items="${cliente.datos}" var="dato">
						<tr><td>${dato.key} : ${dato.value}</td></tr>
					</c:forEach>
				</tr> 
				<tr>
				<td><button onclick="editarDatos(${cliente.idUser})">Editar datos personales</button></td>
				</tr> 
			</table>
		<br> 