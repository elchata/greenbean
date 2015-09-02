<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

		<c:url var="actionUrl" value="guardarEnviado.htm" /> 
		
		<form:form id="queryForm" action="${actionUrl }" commandName="command" method="post">		
			<fieldset>
				<legend></legend>	
					<form:input path="idPedido" type="hidden" /> 
			</fieldset> 
		</form:form>  