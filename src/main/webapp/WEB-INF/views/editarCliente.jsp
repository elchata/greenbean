<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Cliente</h2>
		<form:form method="POST" action="./create.htm" modelattribute="command">		
			<table>
				<tr>
					<td>Logeado a travez de :  </td>
					<td>
					<form:select path="auxEmp">
					 		<c:forEach items="${empresas}" var="emp" >
					  			<c:choose>
		                    		<c:when test="${emp.idEmpresa == command.empresa.idEmpresa}">
		                        		<form:option value="${emp.idEmpresa}" selected="selected" label="${emp.nombre}" />
		                    		</c:when>
		                    		<c:otherwise>
		                        		<form:option value="${emp.idEmpresa}" label="${emp.nombre}"/>
		                    		</c:otherwise>
		                		</c:choose>			
					 		</c:forEach>
					</form:select>
					</td>					
				</tr>			
				<tr>
					<td>Id Facebook : </td>
					<td><form:input path="idFacebook" value="${command.idFacebook}"/></td>
				</tr>	 
				<form:hidden path="idUser"/>					 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Clientes</a> 