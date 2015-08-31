<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
 		<h2>Datos Producto</h2>
			<table>
				<tr>
					<td>Nombre : </td>
					<td><c:out value="${producto.nombre}"/></td>
				</tr>
				<tr>
					<td>Descripcion : </td>
					<td><c:out value="${producto.descripcion}"/></td>
				</tr>
				<tr>
					<td>Stock : </td>
					<td><c:out value="${producto.stock}"/> <c:out value="${producto.medida.nombre}" /></td>
				</tr>
				<tr>
					<c:choose>
			            <c:when test="${producto.imagen != null}">
			               <td align="right"><img src="producto/mostrarimagen.htm?id=${producto.idProducto}" width="80%"/></td>
			            </c:when>
			            <c:otherwise>
			                <td>No tiene imagen asignada</td>
			            </c:otherwise>
			        </c:choose>
				</tr> 
			</table>
		<br>
			
<a href="./editar.htm?idProd=${producto.idProducto}">Editarlo</a><br> 