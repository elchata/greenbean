<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

		<h2>Datos Banda</h2>
		
		<form:form action="./create.htm" method="post" modelAttribute="command">		
			<fieldset>
				<legend></legend>
					<label for="horaInicio">Horario de Inicio:</label>
					<form:input path="horaInicio" value = "${command.horaInicio}"/>
					<label for="horaFin">Horario de Fin:</label>
					<form:input path="horaFin" value = "${command.horaFin}"/>
					<label for="activo">Activo: </label>
					<form:checkbox path="activo" value="${command.activo}"/>
					<form:input path="idBanda" type="hidden" /> 
			</fieldset> 
					<input type="submit" value="Enviar Datos"/>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Bandas</a> 