
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav class="menubar" role="navigation">
  <div class="container">
	<div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">        
        <li class="active">
			<a href="${pageContext.request.contextPath}">
				<img src="${pageContext.request.contextPath}/static/images/home.png" alt="home"/>&nbsp;Home
			</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/google/0">
				<img src="${pageContext.request.contextPath}/static/images/home.png" alt="Index0"/>&nbsp;Index0
			</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/google/1">
				<img src="${pageContext.request.contextPath}/static/images/home.png" alt="Index1"/>&nbsp;Index1
			</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/google/2">
				<img src="${pageContext.request.contextPath}/static/images/home.png" alt="Index2"/>&nbsp;Index2
			</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/google/3">
				<img src="${pageContext.request.contextPath}/static/images/home.png" alt="Index3"/>&nbsp;Index3
			</a>
		</li>
		<li>
			<a href="${pageContext.request.contextPath}/google/4">
				<img src="${pageContext.request.contextPath}/static/images/home.png" alt="Index4"/>&nbsp;Index4
			</a>
		</li>
        <li>
			<a href="#">Link</a>
		</li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Opciones <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li>
				<a href="#" id="googleMap">Google Map</a>
			</li>           
            <sec:authorize access="hasRole('ROLE_HACK2PROGRESS.ADMIN')">
				<li class="divider"></li>
				<li><a href="#">Accion Administracion</a></li>
            </sec:authorize>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="app.menu.informacion.titulo"/> <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li>
				<a href="${pageContext.request.contextPath}/auth/utils/changelog">
					<spring:message code="app.menu.informacion.changelog"/>
				</a>
			</li>
			
          </ul>
        </li>        
      </ul>
	</div>
 </div><!-- /.container-fluid -->
</nav>
