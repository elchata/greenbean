
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<div style="width: 95%; margin: 0 auto;">

	<div id="queryDialog" style="display: none;">
		<%@ include file="editarProvincia.jsp"%>
	</div>
	<h1>Lista de Provincias</h1>
	<button class="pure-button pure-button-primary" onclick="addProv()">
		<i class="fa fa-plus"></i> Crear Provincia
	</button>
	<br>
<table border="1">
  <tr>
    <th>Nombre</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${provincias}" var="prov">	
	  	<tr>
		  	<td><c:out value="${prov.nombre}" /></td>
		  	<td>
			<button class="pure-button pure-button-primary" onclick="editarProv(${prov.idProvincia})">
				<i class="fa fa-pencil"></i> Editar
			</button>
			<a class="pure-button pure-button-primary" onclick="return confirm('Seguro queres eliminar la Provincia?');"
			href="./eliminar.htm?idProv=${prov.idProvincia}"> 
				<i class="fa fa-times"></i>Borrar</a>
			</td> 
		</tr>
  </c:forEach>
</table> 
</div>