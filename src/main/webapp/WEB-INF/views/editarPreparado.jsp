<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

		<c:url var="actionUrl" value="guardarPreparado.htm" /> 
		
		<form:form id="queryForm" action="${actionUrl }" commandName="command" method="post">		
			<fieldset>
					<form:input path="idPedido" type="hidden" /> 
			</fieldset> 
		</form:form>  