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
					<td><c:out value="${categoria.nombre}"/></td>
				</tr>
				<tr>
					<td>Descripcion : </td>
					<td><c:out value="${categoria.descripcion}"/></td>
				</tr>			 
				<tr>
					<td>Categoria Padre : </td>
						<c:choose>
		                    <c:when test="${categoria.padre != null}">
		                       <td><c:out value="${categoria.padre.nombre}" /></td> 
		                    </c:when>
		                    <c:otherwise>
		                       <td>No tiene categoria padre</td> 
		                    </c:otherwise>
		                </c:choose>			
				</tr>
				<tr>
					<td>Sus Subcategorias son:</td> 
						<td><c:forEach items="${categoria.hijos}" var="cat">
							* <c:out value="${cat.nombre}" />
						</c:forEach></td>
				</tr>
				<tr>
					<td>Activo: </td>
					<td><c:out value="${categoria.activo}"/></td>
				</tr>	
				<tr>
					<td>Imagen: </td>
					<c:choose>
			            <c:when test="${categoria.imagen != null}">
			               <td><img src="categoria/mostrarimagen.htm?id=${categoria.idCategoria}" /></td>
			            </c:when>
			            <c:otherwise>
			                <td>No tiene imagen asignada</td>
			            </c:otherwise>
			        </c:choose> 
				</tr>
				<tr>
					<td>Compuesta por los productos:</td> 
						<td><c:forEach items="${categoria.productos}" var="prod">
							* <c:out value="${prod.nombre}" />
						</c:forEach></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./editar.htm?idCat=${categoria.idCategoria}">Editarlo</a><br>
<a href="./ver.htm">Ver Categorias</a> 