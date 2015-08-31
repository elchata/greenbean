<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Categoria</h2>
		<form:form method="POST" action="./create.htm" modelattribute="command">		
			<table>
				<tr>
					<td>Nombre de Categoria : </td>
					<td><form:input path="nombre" value="${command.nombre}"/></td>
				</tr>
				<tr>
					<td>Descripcion : </td>
					<td><form:textarea path="descripcion" rows="3" cols="30" value="${command.descripcion}"/></td>
				</tr>			 
				<tr>
					<td>Categoria Padre : </td>
					<td>
					<form:select path="padre.idCategoria">
						<form:option value="0" label="--- Select ---"/>
					 		<c:forEach items="${categorias}" var="cat">
					  			<c:choose>
		                    		<c:when test="${cat.idCategoria == command.padre.idCategoria}">
		                        		<form:option value="${cat.idCategoria}" selected="selected" label="${cat.nombre}"/>
		                    		</c:when>
		                    		<c:otherwise>
		                        		<form:option value="${cat.idCategoria}" label="${cat.nombre}"/>
		                    		</c:otherwise>
		                		</c:choose>			
					 		</c:forEach>
					</form:select>
					</td>					
				</tr>	
				<form:hidden path="idCategoria"/>
				<tr>
					<td>Activo: </td>
					<td><form:checkbox path="activo" value="${command.activo}"/></td>
				</tr>	
				<tr>
					<td>Imagen: </td>
					<c:if test="${command.imagen != null}">
					<td><img src="categoria/mostrarimagen.htm?id=${command.idCategoria}" /></td></c:if>
					<td>Selecciona fichero:<form:input type="file" path="auxImagen" enctype="multipart/form-data"/></td> 
				</tr>		 			 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Categorias</a> html>