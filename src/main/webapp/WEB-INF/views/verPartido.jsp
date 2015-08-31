<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

		<h2>Datos Partido</h2>	
			<table>
				<tr>
					<td>Provincia : </td>
					<td><c:out value="${partido.provincia.nombre}"/></td>
				</tr>
				<tr>
					<td>Nombre : </td>
					<td><c:out value="${partido.nombre}"/></td>
				</tr>					
			</table>
		<br>
		
<a href="./ver.htm">Ver Partidos</a> 