
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<div class="navbar navbar-static-top imageCabecera" role="navigation">
	<div class="container">
		<div class="navbar-header pull-right">
			<ul class="enlacesCabecera">
				
				<sec:authorize access="isAuthenticated()">
					<li class="enlaceCabecera">
						<a href="#"><strong><spring:message code="app.header.link.mapa"/> &raquo;</strong></a>
					</li>
					<li class="enlaceCabecera">
						<a href="${pageContext.request.contextPath}/j_spring_security_logout"><strong><spring:message code="app.header.link.desconectar"/> &raquo;</strong></a>
					</li>
				</sec:authorize>
			</ul>
		</div>					
	</div>					 
</div>
