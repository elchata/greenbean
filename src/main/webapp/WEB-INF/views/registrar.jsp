<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<link rel="stylesheet" href='<c:url value="/resources/css/pure-0.4.2.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>'>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script type="text/javascript" src='<c:url value="/resources/js/js-for-listBooks.js"/>'></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GreenBean</title> 
</head>
<body>
<script>
	//data de facebook 
	
	var facebookUser = {};
		
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '1000938079945709',
    cookie     : true,  // enable cookies to allow the server to access 
    status     : true,  // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.2' // use version 2.2
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/es_LA/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() { 
    FB.api('/me', function(data) {
    	// Guardar los datos en una variable global
		facebookUser = data; 
    	
      document.getElementById('nom').value = facebookUser.name; 
     // Obtiene la foto de perfil del facebook
     // document.getElementById('datos').innerHTML  = '<img src="https://graph.facebook.com/'+ facebookUser.id+'/picture?type=large"/>'; 
      
      
    }); 
  }
</script>

<div id="status">
</div> 
<div id="cuerpo" style="width: 70%; float: left;">
	<h2>Registrarse:</h2>
<c:url var="actionUrl" value="registro.htm" /> 
		
		<form:form id="regForm" action="${actionUrl }" commandName="datosFace" method="post">		
			<fieldset>
				<table>
				<tr>
					<td>Alias de Facebook:</td>
					<td><form:input path="faceNombre" id="nom" readonly="true"/></td>
				</tr>
				<tr>
					<td>Nombre:</td>
					<td><form:input path="nombre" id="app"/></td>
				</tr>
				<tr>
					<td>Apellido:</td>
					<td><form:input path="apellido" id="app"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" id="app"/></td>
				</tr>
				<tr>
					<td>Facebook ID :</td>
					<td><form:input path="id" value="${datosFace.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:button type="submit">Enviar</form:button></td>
				</tr>
				</table>
			</fieldset> 
		</form:form>   
</div> 
</body>
</html>