<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Ciudad</h2>
		<form:form method="POST" action="./create.htm" modelAttribute="ciudadForm">		
			<table> 
				<tr>
					<td>Partido:</td>
					<td>
					<form:select path="partido.idPartido">  
						<form:options items="${partidos}" itemLabel="nombre" itemValue="idPartido" />						 	 
					</form:select></td>
				</tr>
				<tr>
					<td>Nombre: </td>
					<td><form:input path="nombre" value="${ciudadForm.nombre}"/></td>
				</tr>
				<tr>
					<td>Código Postal: </td>
					<td><form:input path="codPost" value="${ciudadForm.codPost}"/></td>
				</tr>
				<tr>
					<td>Costo de envío: </td>
					<td><form:input path="costoEnvio" value="${ciudadForm.costoEnvio}"/></td>
				</tr>
			<form:hidden path="idCiudad"/>		 			 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Ciudades</a> 