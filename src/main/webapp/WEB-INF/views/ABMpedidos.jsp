
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 	<div id="queryDialog" style="display: none;">
		<%@ include file="editarConfirmado.jsp"%>
		<%@ include file="editarCancelado.jsp"%>
		<%@ include file="editarEntregado.jsp"%>
		<%@ include file="editarEnviado.jsp"%>
		<%@ include file="editarPreparado.jsp"%>
	</div>
<h2>Pedido:</h2>
<table border="1">
  <tr>
    <th>Precio Final</th>
    <th>Id Cliente</th>
    <th>Estado actual</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${pedidos}" var="ped">	
	  <tr>
	    <td><c:out value="${ped.precioFinal}"/></td>
	    <td><c:out value="${ped.cliente.idUser}"/></td>
	    <td>
	    <select onchange="editarEstado(this.value, ${ped.idPedido})">
	    <option value="${ped.estado.idEstado }" selected="selected">${ped.estado['class'].toString()}</option>
	    <c:forEach items="${ped.estado.siguiente}" var="est">
		     <option value="${est}" >${est}</option>		
		</c:forEach> 
		</select>
		</td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idPed" value="${ped.idPedido}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idPed" value="${ped.idPedido}"/>
		</c:url>
		<c:url value="./mostrar.htm" var="catURL4">
			<c:param name="idPed" value="${ped.idPedido}"/>
		</c:url>
		<td>
			<a href="${catURL2}">editar</a> /
			<a href="${catURL4}">mostrar</a> /
			<a href="${catURL3}">eliminar</a>
		</td>
	  </tr>
  </c:forEach>
</table>
<a href="./new.htm" >Nuevo Pedido </a>  