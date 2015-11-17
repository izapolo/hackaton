<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %> 

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="app.name"/></title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script
	src="${pageContext.request.contextPath}/static/js/jquery/jquery-1.9.1.min.js"></script>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	height: 100%;
	float: left;
	width: 63%;
	height: 100%;
}

#floating-panel {
	position: absolute;
	/*   top: 10px; */
	left: 25%;
	z-index: 5;
	background-color: #fff;
	padding: 5px;
	border: 1px solid #999;
	text-align: center;
	font-family: 'Roboto', 'sans-serif';
	line-height: 30px;
	padding-left: 10px;
}

#floating-boton {
	position: absolute;
	right: 35%;
	background-color: #fff;
	padding: 5px;
	text-align: center;
	line-height: 30px;
	padding-left: 10px;
}

#right-panel {
	float: right;
	width: 34%;
	height: 100%;
}

#right-panel {
	font-family: 'Roboto', 'sans-serif';
	line-height: 30px;
	padding-left: 10px;
}

#right-panel select, #right-panel input {
	font-size: 15px;
}

#right-panel select {
	width: 100%;
}

#right-panel i {
	font-size: 12px;
}

.panel {
	height: 100%;
	overflow: auto;
}
</style>
<script>
 	
    
    $( document ).ready(function() {
    	$( "#buttonMagic" ).click(function() {
    		if($("#right-panel").is(":visible")){
    			$( "#map" ).css("width", "100%");
    			$( "#floating-boton" ).css("right", "0%");
        		$( "#buttonMagic" ).val("Mostar");
    			$( "#right-panel" ).hide();
    		}else{
    			$( "#map" ).css("width", "63%");
    			$( "#floating-boton" ).css("right", "35%");
    			$( "#buttonMagic" ).val("Ocultar");    			
    			$( "#right-panel" ).show();
    		}
    	});
    	$( "#map" ).hide();
    	$( "#floating-panel" ).hide();
    	$( "#right-panel" ).hide();
    	$( "#floating-boton" ).hide();

    	$("#googleMap" ).click(function() {
    		$.getJSON( "../google/getJsonWayMap", function( data ) {
    			  initMap(data);
    		});
   		});
    }); 
function initMap(json) {
	$( "#containerHome" ).hide();
	$( "#map" ).show();
	$( "#floating-panel" ).show();
	$( "#right-panel" ).show();
	$( "#floating-boton" ).show();

	var primeroJson = {lat: parseFloat(json[0].latitud), lng: parseFloat(json[0].longitud)};  
    var segundoJson= {lat: parseFloat(json[1].latitud), lng: parseFloat(json[1].longitud)};
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 16,
    center: primeroJson  // Taxi Lonja.
  });

  var directionsService = new google.maps.DirectionsService;
  var directionsDisplay = new google.maps.DirectionsRenderer({
    draggable: true,
    map: map,
    panel: document.getElementById('right-panel')
  });

  directionsDisplay.addListener('directions_changed', function() {
    computeTotalDistance(directionsDisplay.getDirections());
  });

//DRIVING, WALKING, BICYCLING, TRANSIT
  
//   displayRoute(primeroJson, segundoJson, directionsService,
//       directionsDisplay, google.maps.TravelMode.DRIVING);

	document.getElementById('mode').addEventListener('change', function() {
		calcularDistancia(primeroJson, segundoJson, directionsService, directionsDisplay);
  	});
	calcularDistancia(primeroJson, segundoJson, directionsService, directionsDisplay);
	



//   displayRoute(primeroJson, segundoJson, directionsService,
// 	      directionsDisplay, google.maps.TravelMode.BICYCLING);
  
//   displayRoute(primeroJson, segundoJson, directionsService,
// 	      directionsDisplay, google.maps.TravelMode.TRANSIT);	
  
}

function calcularDistancia(primeroJson, segundoJson, directionsService, directionsDisplay){
	var selectedMode = document.getElementById('mode').value;	
	  displayRoute(primeroJson, segundoJson, directionsService,
		      directionsDisplay, google.maps.TravelMode[selectedMode]);
}

function displayRoute(origin, destination, service, display, travelMode) {
  service.route({
    origin: origin,
    destination: destination,
    travelMode: travelMode,
    avoidTolls: true
  }, function(response, status) {
    if (status === google.maps.DirectionsStatus.OK) {
        console.log(response);
      display.setDirections(response);
    } else {
      alert('Could not display directions due to: ' + status);
    }
  });
}

function computeTotalDistance(result) {
  var total = 0;
  var myroute = result.routes[0];
  for (var i = 0; i < myroute.legs.length; i++) {
    total += myroute.legs[i].distance.value;
  }
  total = total / 1000;
  document.getElementById('total').innerHTML = total + ' km';
}
    </script>
    
  </head>
  <body>  
		<tiles:insertAttribute name="header" />
	    <tiles:insertAttribute name="appbar" />
	    <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />
        
		<script src="${pageContext.request.contextPath}/static/js/jquery/jquery-1.9.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/bootstrap/bootstrap.min.js"></script>				
  </body> 
</html>

         
