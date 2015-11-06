<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:useAttribute id="key_message" name="message"/>
<tiles:useAttribute id="key_title" name="title"/>
<tiles:useAttribute id="key_button" name="button"/>
<tiles:useAttribute id="key_image" name="image"/>

<div class="container content" role="main">
	<div class="row">
		<div class="span12 text-center">
			<img src="${pageContext.request.contextPath}/static/images/<spring:message code="${key_image}"/>" alt="session timeout"/>
		</div>
	</div>  
  
	<div class="alert alert-danger info-entrada">
 		<div class="text-center"><h4><spring:message code="${key_title}"/></h4></div>
 		<div class="text-left"> 			
 			<spring:message code="${key_message}"/>
 	 	</div>
 
 	 	<div class="text-center">
 	 		<a href="${pageContext.request.contextPath}/login">
				<button type="button" class="btn btn-warning"><spring:message code="${key_button}"/></button>
			</a>
 	 	</div>
	</div>
</div>






