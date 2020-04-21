<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the Tax App</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<h1 class="text-center display-5">Zonal wise Collection of
			Property Tax</h1>
		<div class="row">
			<div class="offset-2 col-8">
				<table class="table table-bordered table-hover">
					<thead class="bg-info">
						<tr>
							<th>Zone Name</th>
							<th>Property Type</th>
							<th>Amount Collected</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="report" items="${reportUI}">
							<tr>
								<td class="text-center">Zone ${report.zone}</td>
								<td>${report.propertyType}</td>
								<td class="text-right">&#x20b9; ${report.amountCollected}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="offset-2 col-8 text-right">
				<a href="<c:url value='/' />" class="btn btn-outline-info btn-block">Click here to go Back..!</a>
			</div>

		</div>

		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>