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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap/bootstrap.min.css" >
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/calendar.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/camera.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/countdown.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/custom_1.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/fallback.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/font-awesome.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/form.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/grid.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/ie.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/skeleton.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/style_common.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/style4.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/superfish.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/template/touchTouch.css" />
    
    <script	src="${pageContext.request.contextPath}/static/js/jquery/jquery-1.9.1.min.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/camera.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/cd_config.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/data.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/html5shiv.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery.calendario.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery.countdown.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery.easing.1.3.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery.equalheights.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery.hoverfold.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery.mobile.customized.min"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery.mobilemenu.js"></script>    
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery.ui.totop.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/jquery-migrate-1.2.1.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/modernizr.custom.69142.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/owl.carousel.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/script.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/superfish.js"></script>    
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/TMForm.js"></script>
    <script	src="${pageContext.request.contextPath}/static/js/jquery/template/PIE.php"></script>
        
  </head>
  
  <body>  
		<tiles:insertAttribute name="header" />
	    <tiles:insertAttribute name="appbar" />
	    <tiles:insertAttribute name="menu" />
        <tiles:insertAttribute name="body" />			
  </body> 
</html>

         
