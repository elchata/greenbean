<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Direccion</h2>
		<form:form method="POST" action="./create.htm" modelattribute="command">		
			<table> 
				<tr>
					<td>Ciudad:</td>
					<td>
					<form:select path="ciudad.idCiudad"> 
					 		<c:forEach items="${ciudades}" var="ciu">
					  			<c:choose>
		                    		<c:when test="${ciu.idCiudad== command.ciudad.idCiudad}">
		                        		<form:option value="${ciu.idCiudad}" selected="selected" label="${ciu.nombre}"/>
		                    		</c:when>
		                    		<c:otherwise>
		                        		<form:option value="${ciu.idCiudad}" label="${ciu.nombre}"/>
		                    		</c:otherwise>
		                		</c:choose>			
					 		</c:forEach>
					</form:select></td>
				</tr>
				<tr>
					<td>Calle: </td>
					<td><form:input path="calle" value="${command.calle}"/></td>
				</tr>
				<tr>
					<td>Numero: </td>
					<td><form:input path="numero" value="${command.numero}"/></td>
				</tr>
				<tr>
					<td>Piso: </td>
					<td><form:input path="piso" value="${command.piso}"/></td>
				</tr>
				<tr>
					<td>Departamento: </td>
					<td><form:input path="dpto" value="${command.dpto}"/></td>
				</tr>
				<tr>
					<td>Nombre del Titular: </td>
					<td><form:input path="nombre" value="${command.nombre}"/></td>
				</tr>
				<tr>
					<td>Apellido: </td>
					<td><form:input path="apellido" value="${command.apellido}"/></td>
				</tr>
				<tr>
					<td>Telefono: </td>
					<td><form:input path="telefono" value="${command.telefono}"/></td>
				</tr>
				<tr>
					<td>Celular: </td>
					<td><form:input path="celular" value="${command.celular}"/></td>
				</tr>
				
				<tr>
					<td>Banda horaria:</td>
					<td>
					<form:select path="horario.idBanda"> 
					 		<c:forEach items="${bandas}" var="banda">
					  			<c:choose>
		                    		<c:when test="${banda.idBanda== command.horario.idBanda}">
		                        		<form:option value="${banda.idBanda}" selected="selected" label="${banda.horaInicio} - ${banda.horaFin}"/>
		                    		</c:when>
		                    		<c:otherwise>
		                        		<form:option value="${banda.idBanda}" label="${banda.horaInicio} - ${banda.horaFin}"/>
		                    		</c:otherwise>
		                		</c:choose>			
					 		</c:forEach>
					</form:select></td>
				</tr>
				<tr>
					<td>Otros datos: </td>
					<td><form:input path="otros" value="${command.otros}"/></td>
				</tr>
				<form:hidden path="idDireccion"/>		 			 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Productos</a> 