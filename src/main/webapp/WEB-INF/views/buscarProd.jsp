<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<h2>Buscar Producto por Nombre</h2>
		<form:form method="POST" action="./result.htm" modelAttribute="find">		
			<table>
				<tr>
					<td>Nombre:  </td> 
					<td><form:input path="nombre"/></td>	
				</tr>					 
				<tr>
					<td colspan="3"><input type="submit" value="Buscar"/></td>
				</tr>
			</table>
		</form:form>