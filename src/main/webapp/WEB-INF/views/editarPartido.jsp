<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Partido</h2>
		<form:form method="POST" action="./create.htm" modelAttribute="partidoForm">		
			<table> 
				<tr>
					<td>Provincia:</td>
					<td>
					<form:select path="provincia.idProvincia">  
						<form:options items="${provincias}" itemLabel="nombre" itemValue="idProvincia" />						 	 
					</form:select></td>
				</tr>
				<tr>
					<td>Nombre: </td>
					<td><form:input path="nombre" value="${partidoForm.nombre}"/></td>
				</tr>
			<form:hidden path="idPartido"/>		 			 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Partidos</a> 