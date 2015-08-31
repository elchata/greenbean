<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Producto</h2>
		<form:form method="POST" action="./create.htm" modelattribute="command">		
			<table>
				<tr>
					<td>Nombre de Producto : </td>
					<td><form:input path="nombre" value="${command.nombre}"/></td>
				</tr>
				<tr>
					<td>Descripcion : </td>
					<td><form:textarea path="descripcion" rows="3" cols="30" value="${command.descripcion}"/></td>
				</tr>			 
				<tr>
					<td>Precio : </td>
					<td><form:input path="auxMon" value="${command.precios[0].monto}"/></td>
				</tr>
				<form:hidden path="idProducto"/>
				<tr>
					<td>Activo: </td>
					<td><form:checkbox path="activo" value="${command.activo}"/></td>
				</tr>	
				<tr>
					<td>Medida: </td>
					<td>
					<form:select path="medida.idMedida">
						<form:option value="0" label="--- Select ---"/>
					 		<c:forEach items="${medidas}" var="med">
					  			<c:choose>
		                    		<c:when test="${med.idMedida == command.medida.idMedida}">
		                        		<form:option value="${med.idMedida}" selected="selected" label="${med.nombre}"/>
		                    		</c:when>
		                    		<c:otherwise>
		                        		<form:option value="${med.idMedida}" label="${med.nombre}"/>
		                    		</c:otherwise>
		                		</c:choose>			
					 		</c:forEach>
					</form:select>
					<a href="../medida/new.htm">Crear nueva medida</a>
					</td>
				</tr>	
				<tr>
					<td>Stock: </td>
					<td><form:input path="stock" value="${command.stock}"/></td>
				</tr>	
				<tr>
					<td>Categorias a las que pertenece: </td>
					<td>
					<c:forEach items="${categorias}" var="cat">
								<c:choose>
		                    		<c:when test="${command.categorias.contains(cat)}"> 
		                        		<form:checkbox path="categos" label="${cat.nombre}" value="${cat.idCategoria}" checked="checked"/> 
		                    		</c:when>
		                    		<c:otherwise> 
		                        		<form:checkbox path="categos" label="${cat.nombre}" value="${cat.idCategoria}"/>
		                    		</c:otherwise>
		                		</c:choose>	
					</c:forEach>
					</td>
				</tr>	
				<tr>
					<td>Imagen: </td>
					<c:if test="${command.imagen != null}">
					<td><img src="producto/mostrarimagen.htm?id=${command.idProducto}" /></td></c:if>
					<td>Selecciona fichero:<form:input type="file" path="auxImagen" enctype="multipart/form-data"/></td> 
				</tr>		 			 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Productos</a> 