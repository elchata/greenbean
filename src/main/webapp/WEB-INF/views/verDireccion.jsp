<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

		<h2>Datos Direccion</h2>	
			<table>
				<tr>
					<td>Provincia : </td>
					<td><c:out value="${direccion.ciudad.partido.provincia.nombre}"/></td>
				</tr>
				<tr>
					<td>Partido : </td>
					<td><c:out value="${direccion.ciudad.partido.nombre}"/></td>
				</tr>
				<tr>
					<td>Ciudad : </td>
					<td><c:out value="${direccion.ciudad.nombre}"/></td>
				</tr> 
				<tr>
					<td>Calle : </td>
					<td><c:out value="${direccion.calle}"/></td>
				</tr>	
				<tr>
					<td>Numero : </td>
					<td><c:out value="${direccion.numero}"/></td>
				</tr>
				<tr>
					<td>Piso: </td>
					<td><c:out value="${direccion.piso}"/></td>
				</tr> 
				<tr>
					<td>Departamento : </td>
					<td><c:out value="${direccion.dpto}"/></td>
				</tr>				
				<tr>
					<td>Registrado a nombre de : </td>
					<td><c:out value="${direccion.nombre}"/></td>
				</tr>	
				<tr>
					<td>Apellido : </td>
					<td><c:out value="${direccion.apellido}"/></td>
				</tr>	 
					
				<tr>
					<td>Telefono : </td>
					<td><c:out value="${direccion.telefono}"/></td>
				</tr>	
				<tr>
					<td>Celular : </td>
					<td><c:out value="${direccion.celular}"/></td>
				</tr>	
				<tr>
					<td>Otros datos : </td>
					<td><c:out value="${direccion.otros}"/></td>
				</tr>					
			</table>
		<br>
		
<a href="./ver.htm">Ver Direcciones</a> 