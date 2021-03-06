<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Clientes:</h2>
<table border="1">
  <tr>
    <th>Id Usuario</th>
    <th>Empresa de login</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${clientes}" var="cli">	
	  <tr>
	    <td><c:out value="${cli.idUser}"/></td>
	    <td><c:out value="${cli.empresa.nombre}"/></td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idCli" value="${cli.idUser}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idCli" value="${cli.idUser}"/>
		</c:url>
		<c:url value="./mostrar.htm" var="catURL4">
			<c:param name="idCli" value="${cli.idUser}"/>
		</c:url>
		<td>
		<a href="${catURL2}">editar</a> /
		<a href="${catURL4}">mostrar</a> /
		<a href="${catURL3}">eliminar</a></td>
	  </tr>
  </c:forEach>
</table> 
<a href="./new.htm" >Nuevo Cliente </a>