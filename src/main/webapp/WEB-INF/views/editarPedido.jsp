<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Pedido</h2>
		<form:form method="POST" action="./create.htm" modelattribute="command">		
			<table>
				<tr>
					<td>Precio Total productos : 
					<form:input path="precioFinal" value="${command.precioFinal}"/></td>
				</tr>
				
				<form:hidden path="cliente.idUser"/> 
				<form:hidden path="idPedido"/>		
				<tr><td>
				
					<c:forEach items="${command.cliente.direcciones}" var="dir" varStatus="cant">
						<fieldset> 
						<legend>Domicilio ${cant.count}</legend>
						<form:radiobutton path="direccion.idDireccion" label="${dir.calle} ${dir.ciudad.nombre} ${dir.ciudad.partido.nombre }" value="${dir.idDireccion}"/> 
						</fieldset>
					</c:forEach>
					<a href="<c:url value="/direccion/new.htm"/>">Agregar Domicilio</a> 
				</td></tr>
				<tr>	
					<td><form:textarea path="auxString" rows="3" cols="40" placeholder="Agregue algun dato extra..." /></td>	
				</tr>	 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>