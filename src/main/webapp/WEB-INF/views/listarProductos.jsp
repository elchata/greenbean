<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="prodDialog" style="display: none;" >
	<%@ include file="comprarProducto.jsp"%>
</div>
 
<div id="productosMostrar">
 <h2>Productos:</h2>
 <c:forEach items="${productos}" var="prod"> 
 
	 <div id="detalle" align="center" onClick="verProd(${prod.idProducto})" style="border-style: solid;  cursor: pointer; width:150px ; height:150px;  border-width: 2px; float: left; margin: 8px; padding: 2px ;" >
	 	<c:out value="${prod.nombre}"/><br>
	 	<img src="producto/mostrarimagen.htm?id=${prod.idProducto}" alt="prod.nombre" width="80%"  height="80%">
	 </div>
	 
 </c:forEach> 
 </div>
 <div id="maxVisita" style="width: 20%;padding:5px; margin:10px 0px;float: left; border: 3px; border-style: solid; text-align: center">
<h4>El Producto más visto por Usd es: <c:out value="${maximo.nombre}"/></h4>
</div>