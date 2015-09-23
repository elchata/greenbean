<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

		<c:url var="actionUrl" value="cambiarStock.htm" /> 
		
		<form:form id="queryForm" action="${actionUrl }" commandName="prod" method="post">		
			<fieldset>
				<legend></legend>
					<label for="nombre">Nombre de Producto:</label>
					<c:out value="${prod.nombre }"/><br>
					<label for="stock">Stock actual:</label>
					<c:out value="${prod.stock }"></c:out><br>
					<label for="stockNuevo">Nuevo Stock:</label>
					<form:input path="stock"/>					
					<form:input path="idProducto" type="hidden" /> 
			</fieldset> 
		</form:form>  