		
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<div class="applicationbar">
	<div class="container">
		<div class="col-md-8  pull-left">
			<spring:message code="app.name"/>
		</div>
		<div class="col-md-4 pull-right">
			<sec:authorize	access="hasAnyRole('ROLE_HACK2PROGRESS.ADMIN','ROLE_HACK2PROGRESS.USUARIO')">
				<sec:authentication property="principal.username" var="username" />
				<sec:authentication property="authorities" var="roles" scope="page" />
				<spring:message code="app.bar.user"/>: ${username} <spring:message code="app.bar.roles"/>: 
				<c:forEach	var="role" items="${roles}">
					${fn:replace(role,"ROLE_HACK2PROGRESS.","")}&nbsp;
				</c:forEach>
			</sec:authorize>
		</div>
	</div>
</div>
