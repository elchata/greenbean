
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="queryDialog" style="display: none;">
	<%@ include file="editStock.jsp"%>
</div>
	 
<h2>Productos:</h2>
<table border="1">
  <tr>
    <th>Nombre</th> 
    <th>Esta activo?</th> 
    <th>Stock</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${productos}" var="prod">	
	  <tr>
	    <td><c:out value="${prod.nombre}"/></td>
	    <td><c:out value="${prod.activo}"/></td>
	    <td><c:out value="${prod.stock}"/></td>
	    <c:url value="./cambiarStock.htm" var="catURL6">
			<c:param name="idProd" value="${prod.idProducto}"/>
		</c:url>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idProd" value="${prod.idProducto}"/>
		</c:url>
		<c:url value="./cambiarActivo.htm" var="catURL3">
			<c:param name="idProd" value="${prod.idProducto}"/>
		</c:url>
		<c:url value="./mostrar.htm" var="catURL4">
			<c:param name="idProd" value="${prod.idProducto}"/>
		</c:url>
		<td>
		<button onclick="editarStock(${prod.idProducto})">Editar Stock</button> / 
		<a href="${catURL2}">editar</a> / 
		<a href="${catURL4}">mostrar</a> / 
		<c:if test="${prod.activo == true }"></c:if>
		<c:choose>
			<c:when test="${prod.activo == true }">
		    	<a href="${catURL3}">Desactivar</a>
		    </c:when>
		    <c:otherwise>
		  		<a href="${catURL3}">Activar</a>
		    </c:otherwise>
		</c:choose>	
		</td>
	  </tr>
  </c:forEach>
</table>
<a href="./new.htm" >Nuevo Producto </a>   