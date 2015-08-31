
$(function() {
	$("#queryDialog").dialog({
		autoOpen : false,
		position : 'center',
		modal : true,  
		resizable : false,
		width : 440,
		buttons : {
			"Guardar" : function() {
				$('#queryForm').submit();
			},
			"Cancelar" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {	
			resetDialog($('#queryForm'));	
			$(this).dialog('close');
		}
	});
	
	$("#prodDialog").dialog({
		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Cerrar" : function() {
				$(this).dialog('close');
			}
		}
	});
	
	function resetDialog(form) {
	
		form.find("input").val("");
	} 
	
	$("#abrido").button().click(function () {
		$("#queryDialog").dialog("option", "title", 'Crear Provincia');
		$("#queryDialog").dialog("open");
	});
});


function multiplicar(val){
	m1 = document.getElementById("mult").value;
	m2 = val;
	r = m1*m2;
	document.getElementById("resultado").innerHTML= "$ " + r;
} 

function addProv() {
	$('#queryDialog').dialog("option", "title", 'Agregar provincia');
	$('#queryDialog').dialog('open');
}

function editarProv(id) {
	$.get("editar.htm?idProv=" + id, function(result) {
		$("#queryDialog").html(result);
		$('#queryDialog').dialog("option", "title", 'Editar Provincia');
		$("#queryDialog").dialog('open'); 
	});
} 

function editarEstado(nombre, id) {
	$.get("cambiarEstado.htm?nombre="+nombre+"&idPed=" + id, function(result) {
		$("#queryDialog").html(result);
		$('#queryDialog').dialog("option", "title", 'Cambiar Estado');
		$("#queryDialog").dialog('open'); 
	});
}

function editarDatos(id) {
	$.get("editarDatos.htm?idCli=" + id, function(result) {
		$("#queryDialog").html(result);
		$('#queryDialog').dialog("option", "title", 'Datos Personales');
		$("#queryDialog").dialog('open'); 
	});
} 

function verProd(id) {
	$.get("mostrar.htm?idProd=" + id, function(result) {
		$("#prodDialog").html(result);
		$('#prodDialog').dialog("option", "title", 'Datos Producto');
		$("#prodDialog").dialog('open'); 
	});
} 

function resetDialog(form) {
	form.find("input").val("");
} 
