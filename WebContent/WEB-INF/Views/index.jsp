<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- pageEncoding="ISO-8859-1" -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="taxApp.browserTab.title" /></title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class="col-12">
				<div class="jumbotron">
					<text class="alert-danger">${message} </text>
					<h1 class="display-4"><spring:message code="taxApp.welcome"></spring:message></h1>
					<p class="lead "><spring:message code="taxApp.tagLine"></spring:message></p>
					<div class="col-6">
						<a href="<c:url value='/assessment' />"
							class="btn btn-lg btn-outline-success"><spring:message code="taxApp.navlink.selfAssessment"></spring:message></a>
					</div>
					<br>
					<div class="col-12">
						<a href="report/zonal" class="btn btn-lg btn-outline-success"><spring:message code="taxApp.navlink.report.zonal"></spring:message></a>
					</div>
				</div>
			</div>
		</div>

		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>