<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="${pageContext.request.contextPath}/static/js/jquery/jquery-1.9.1.min.js"></script>
<title>Save a Place</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">
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
 	var json=${json};
    var primeroJson = {lat: parseFloat(json[0].latitud), lng: parseFloat(json[0].longitud)};  
    var segundoJson= {lat: parseFloat(json[1].latitud), lng: parseFloat(json[1].longitud)};
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
    	
    }); 
function initMap() {
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
<body>
	<div id="map"></div>
	<div id="floating-panel">
		<b>Mode of Travel: </b> <select id="mode">
			<option value="DRIVING">Driving</option>
			<option value="WALKING">Walking</option>
			<option value="BICYCLING">Bicycling</option>
			<option value="TRANSIT">Transit</option>
		</select>
	</div>
	<div id="right-panel">
		<p>
			Total Distance: <span id="total"></span>
		</p>
	</div>
	<div id="floating-boton">
		<input type="button" id="buttonMagic" value="Ocultar" />
	</div>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBoloNmQ59tsVAvdZ-TdzW7ysRhZoufSu8&signed_in=true&callback=initMap&libraries=places"
		async defer></script>
</body>
</html>