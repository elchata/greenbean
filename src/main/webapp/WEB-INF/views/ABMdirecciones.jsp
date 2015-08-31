
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<h2>Direcciones:</h2>
<table border="1">
  <tr>
  	<th>Calle</th>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${direcciones}" var="dir">	
	  <tr>
	    <td><c:out value="${dir.calle}"/></td>
	    <td><c:out value="${dir.nombre}"/></td>
	    <td><c:out value="${dir.apellido}"/></td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idDir" value="${dir.idDireccion}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idDir" value="${dir.idDireccion}"/>
		</c:url>
		<c:url value="./mostrar.htm" var="catURL4">
			<c:param name="idDir" value="${dir.idDireccion}"/>
		</c:url>
		<td>
			<a href="${catURL4}">mostrar</a> /
			<a href="${catURL2}">editar</a> /
			<a href="${catURL3}">eliminar</a>
		</td>
	  </tr>
  </c:forEach>
</table>
<a href="./new.htm" >Nueva Direccion </a>   