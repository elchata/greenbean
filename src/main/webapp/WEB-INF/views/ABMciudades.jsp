
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<h2>Ciudades:</h2>
<table border="1">
  <tr>
    <th>Nombre</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${ciudades}" var="ciu">	
	  <tr>
	    <td><c:out value="${ciu.nombre}"/></td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idCiu" value="${ciu.idCiudad}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idCiu" value="${ciu.idCiudad}"/>
		</c:url>
		<c:url value="./mostrar.htm" var="catURL4">
			<c:param name="idCiu" value="${ciu.idCiudad}"/>
		</c:url>
		<td>
			<a href="${catURL4}">mostrar</a> /
			<a href="${catURL2}">editar</a> /
			<a href="${catURL3}">eliminar</a>
		</td>
	  </tr>
  </c:forEach>
</table>
<a href="./new.htm" >Nueva Ciudad </a>   