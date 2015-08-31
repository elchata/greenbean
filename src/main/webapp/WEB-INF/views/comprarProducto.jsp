<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <div id="venta" align="center">
	 <h2><c:out value="${producto.nombre}"/></h2> 
	<div style=" margin:5px; float: left; width: 200px"><img width="180px" src="producto/mostrarimagen.htm?id=${producto.idProducto }"/></div>
	<div style=" float: right;text-align: left; width: 45%; font-size: 15px" id="cont2 ">
		<div>$<c:out value="${producto.precios.get(0).monto}"/> por <c:out value="${producto.medida.nombre}" /></div>
		<div>
		<c:url var="actionUrl" value="/producto/agregarCarro.htm" /> 
		<form:form method="POST" action="${actionUrl }" commandName="compra">	 
			<form:select id="mult" path="cantidad" onchange="multiplicar(${producto.precios.get(0).monto})"> 
				 <% for(int i = 1; i < 30; i+=1) { %>
				        <form:option value="<%=i %>"/> 
				  <% } %>		                    		 
			</form:select>
			<c:out value="${producto.medida.abreviacion}"/>
			<form:hidden path="idProducto" value="${producto.idProducto}"/>		
			<div style="text-align: left;width: 40%;">Total:<div id="resultado"></div></div> 
			<input type="submit" value="Agregar al carro" />
		</form:form>
		</div>
	</div>
	<div style="text-align: center; border: 1px; border-style: solid; width: 90% ;float: left;  margin:5px; padding:4px; "><c:out value="${producto.descripcion}" /></div>
 </div> 