<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

		<c:url var="actionUrl" value="/cliente/create2.htm" /> 
		
		<form:form id="queryForm" action="${actionUrl }" commandName="datos" method="post">		
			<fieldset>
				<legend></legend>
					<label for="nombre">Nombre:</label>
					<form:input path="nombre" value="${cliente.datos.get('nombre')}"/><br>
					<label for="apellido">Apellido:</label>
					<form:input path="apellido" value="${cliente.datos.get('apellido')}"/><br>
					<label for="email">Email:</label>
					<form:input path="email" value="${cliente.datos.get('email')}"/><br>
					<label for="faceNombre">Nombre en Facebook:</label>
					<form:input path="faceNombre" value="${cliente.datos.get('faceNombre')}" disabled="true"/><br>
					<form:hidden path="faceNombre" value="${cliente.datos.get('faceNombre')}" /> 
			</fieldset> 
		</form:form>  