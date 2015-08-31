<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

		<h2>Datos Banda Horaria</h2>	
			<table>
				<tr>
					<td>Hora Inicio : </td>
					<td><c:out value="${banda.horaInicio}"/></td>
				</tr>
				<tr>
					<td>Hora Fin : </td>
					<td><c:out value="${banda.horaFin}"/></td>
				</tr>			
			</table>
		<br>
		
<a href="./ver.htm">Ver Bandas</a> 