<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

		<c:url var="actionUrl" value="create.htm" /> 
		
		<form:form id="queryForm" action="${actionUrl }" commandName="provinc" method="post">		
			<fieldset>
				<legend></legend>
					<label for="nombre">Nombre de Provincia:</label>
					<form:input path="nombre"/>
					
					<form:input path="idProvincia" type="hidden" /> 
			</fieldset> 
		</form:form>  