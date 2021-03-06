<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
	$(document).ready(function(){
	    $('#categoriasID').DataTable();
	});
</script>

<h2>Categorias:</h2>
<table id="categoriasID" cellpadding="0" cellspacing="0" border="0"  >
<thead>
  <tr>
    <th>Nombre</th>
    <th>Categoria Padre</th>
    <th>Acciones</th>
  </tr>
</thead>
<tbody>
  <c:forEach items="${categorias}" var="cat">	
	  <tr>
	    <td><c:out value="${cat.nombre}"/></td>
	    <td><c:out value="${cat.padre.nombre}"/></td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idCat" value="${cat.idCategoria}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idCat" value="${cat.idCategoria}"/>
		</c:url>
		<c:url value="./mostrar.htm" var="catURL4">
			<c:param name="idCat" value="${cat.idCategoria}"/>
		</c:url> 
		<td>
		<a href="${catURL2}">editar</a> /
		<a href="${catURL3}">eliminar</a> /
		<a href="${catURL4}">mostrar</a></td>
	  </tr>
  </c:forEach>
</tbody>
</table>
<a href="./new.htm" >Nueva Categoria </a>