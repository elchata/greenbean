
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<h2>Bandas:</h2>
<table border="1">
  <tr>
    <th>Horarios</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${bandas}" var="banda">	
	  <tr>
	    <td><c:out value="${banda.horaInicio} - ${banda.horaFin}" /></td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idBanda" value="${banda.idBanda}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idBanda" value="${banda.idBanda}"/>
		</c:url>
		<td>
			<a href="${catURL2}">editar</a> /
			<a href="${catURL3}">eliminar</a>
		</td>
	  </tr>
  </c:forEach>
</table>
<a href="./new.htm" >Nueva Banda Horaria </a>   