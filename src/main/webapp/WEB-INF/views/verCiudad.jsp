<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

		<h2>Datos Ciudad</h2>	
			<table>
				<tr>
					<td>Partido : </td>
					<td><c:out value="${ciudad.partido.nombre}"/></td>
				</tr>
				
				<tr>
					<td>Nombre : </td>
					<td><c:out value="${ciudad.nombre}"/></td>
				</tr>			
					
				<tr>
					<td>Código posta : </td>
					<td><c:out value="${ciudad.codPost}"/></td>
				</tr>
				
				<tr>
					<td>Costo de envío : </td>
					<td><c:out value="${ciudad.costoEnvio}"/></td>
				</tr>			
			</table>
		<br>
		
<a href="./ver.htm">Ver Partidos</a> 