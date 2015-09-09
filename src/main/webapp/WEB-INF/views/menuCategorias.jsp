 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <div id="listCategoria">
	<h4>Categorias:</h4>
	 <div id="menuCategorias" style="">
		 <ul>
		  <c:forEach items="${applicationScope.categorias}" var="cat"> 
		   <c:if test="${ cat.hijos.size() > 0 }">
		 	<li><a href="<c:url value="/producto/filtro.htm?cat=${cat.idCategoria}"/>"><c:out value="${cat.nombre}" /></a>
		 		<ul>
		 		<c:forEach items="${cat.hijos}" var="hijo">
		 			<li><a href="<c:url value="/producto/filtro.htm?cat=${hijo.idCategoria}"/>"><c:out value="${hijo.nombre}" /></a></li>
		 		</c:forEach>	 		
		 		</ul>	 	
		 	</li>
		   </c:if>
		   <c:if test="${ cat.hijos.size() == 0 && cat.padre == null }">
		   <li><a href="<c:url value="/producto/filtro.htm?cat=${cat.idCategoria}"/>"><c:out value="${cat.nombre}" /></a></li>
		   </c:if>
		  </c:forEach>
		 </ul>
	 </div> 
 </div>