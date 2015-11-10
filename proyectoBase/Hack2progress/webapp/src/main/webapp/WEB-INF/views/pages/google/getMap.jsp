<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

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
}
</style>
<script>
	// When you add a marker using a Place instead of a location, the Maps API will
	// automatically add a 'Save to Google Maps' link to any info window associated
	// with that marker.
	
	var json=${json};

	function initMap() {
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 14,
			center : {
				lat : 43.453237,
				lng : -3.821732
			}
		});

		for(i = 0; i < json.length; i++){

	 		var marker = new google.maps.Marker({
				map : map,
				// Define the place with a location, and a query string.
				place : {
					location : new google.maps.LatLng(json[i].latitud, json[i].longitud),
					query : json[i].nombre+', España'
	
				},
				// Attributions help users find your site again.
				attribution : {
					source : 'Google Maps JavaScript API',
					webUrl : 'https://developers.google.com/maps/'
				}
			});

	 		
		}

// 		var taxiLonja = new google.maps.LatLng(43.453237, -3.821732);
// 		var palacioMagdalena = new google.maps.LatLng(43.469383, -3.766449);

// 		var marker = new google.maps.Marker({
// 			map : map,
// 			// Define the place with a location, and a query string.
// 			place : {
// 				//43.453237, -3.821732
// 				location : taxiLonja,
// 				query : 'Taxi, Lonja, España'

// 			},
// 			// Attributions help users find your site again.
// 			attribution : {
// 				source : 'Google Maps JavaScript API',
// 				webUrl : 'https://developers.google.com/maps/'
// 			}
// 		});

// 		var marker1 = new google.maps.Marker({
// 			map : map,
// 			// Define the place with a location, and a query string.
// 			place : {
// 				//43.469383, -3.766449
// 				location : palacioMagdalena,
// 				query : 'Palacio, Magdalena, España'

// 			},
// 			// Attributions help users find your site again.
// 			attribution : {
// 				source : 'Google Maps JavaScript API',
// 				webUrl : 'https://developers.google.com/maps/'
// 			}
// 		});

// 		// Construct a new InfoWindow.
// 		var infoWindow = new google.maps.InfoWindow({
// 			content : 'Taxi Lonja'
// 		});

// 		// Opens the InfoWindow when marker is clicked.
// 		marker.addListener('click', function() {
// 			infoWindow.open(map, marker);
// 		});
	}
</script>
</head>
<body>
<body>
	<div id="map"></div>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBoloNmQ59tsVAvdZ-TdzW7ysRhZoufSu8&signed_in=true&libraries=places&callback=initMap"></script>
</body>
</html>