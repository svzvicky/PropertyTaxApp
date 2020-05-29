<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function calculateTax() {
		var zoneVal = document.getElementById("zone").value;
		var catVal = document.getElementById("category").value;
		var statusVal = document.getElementById("status").value;
		var consYearVal = document.getElementById("consYear").value;
		var buildingAreaVal = document.getElementById("buildingArea").value;

		var testData = {
			zone : zoneVal,
			category : catVal,
			status : statusVal,
			Year : consYearVal,
			buildingArea : buildingAreaVal
		};

		$(document).ready(function() {
			$.ajax({
				url : "calculatetax",
				type : 'POST',
				data : testData,
				//dataType: "text",
				success : function(result) {
					console.log(result);
					$("#totalTax").val(result);
				}
			});

		});
	}
</script>

<title>Welcome to the Tax App</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>

		<div class="row">
			<div class="col-12">
				<h2 class="offset-1 page-header"><spring:message code="taxApp.taxAssessment.form.title"></spring:message></h2>
			</div>
		</div>

		<div class="row">
			<div class="offset-1 col-8">
			<text class="alert-danger">${errorMessage} </text>
				<form:form id="taxSave" action="saveTax"
					modelAttribute="taxAssessment" cssClass="form-horizontal"
					role="form">
					<div class="form-group row">
						<label for="yearofAssessment" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.yearOfAssessment"></spring:message></label>
						<div class="col-6">
							<form:input path="yearofAssessment" cssClass="form-control" />
							<form:errors path="yearofAssessment" cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="nameofOwner" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.nameOfOwner"></spring:message></label>
						<div class="col-6">
							<form:input id="ownername" path="nameofOwner"
								cssClass="form-control" />
							<form:errors path="nameofOwner" cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="ownerEmail" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.email"></spring:message></label>
						<div class="col-6">
							<form:input path="ownerEmail" cssClass="form-control" />
							<form:errors path="ownerEmail" cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="addressofProperty" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.address"></spring:message></label>
						<div class="col-6">
							<form:textarea path="addressofProperty" rows="4"
								cssClass="form-control" />
							<form:errors path="addressofProperty" cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="zonalClassification" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.zone"/></label>
						<div class="col-6">
							<select id="zone" onchange="calculateTax();"
								name="zonalClassification">
								<c:forEach var="zones" items="${zones}">
									<option value="${zones.name}">Zone ${zones.name}</option>
								</c:forEach>
							</select>
							<%-- 							<form:input path="zonalClassification" cssClass="form-control" />
							<form:errors path="zonalClassification" cssClass="alert-danger" /> --%>
						</div>
					</div>

					<div class="form-group row">
						<label for="propertyDescription" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.propertyDesc"/></label>
						<div class="col-6">
							<select id="category" onchange="calculateTax()"
								name="propertyDescription">
								<c:forEach var="category" items="${categories}">
									<option value="${category.id}">${category.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label for="status" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.status"></spring:message></label>
						<div class="col-6">
							<form:select id="status" onchange="calculateTax()" path="status">
								<form:option value="">Select Status</form:option>
								<form:option value="Tenanted">Tenanted</form:option>
								<form:option value="Owner">Owner</form:option>
							</form:select>
							<form:errors path="status" cssClass=" alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="buildingConstructedYear" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.formbuildingConstructedYear"></spring:message></label>
						<div class="col-6">
							<form:input id="consYear" onchange="calculateTax()"
								path="buildingConstructedYear" cssClass="form-control" />
							<form:errors path="buildingConstructedYear"
								cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="builtUpArea" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.builtUpArea"></spring:message></label>
						<div class="col-6">
							<form:input id="buildingArea" onchange="calculateTax()"
								path="builtUpArea" cssClass="form-control" />
							<form:errors path="builtUpArea" cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="totalTaxPayable" class="col-4 col-form-label"><spring:message code="taxApp.taxAssessment.form.totalTax"></spring:message></label>
						<div class="col-3">
							<form:input id="totalTax" type="number" path="totalTaxPayable"
								cssClass="form-control" readonly="true" />
							<form:errors path="totalTaxPayable" cssClass="alert-danger" />
						</div>
						<div class="col-5"><spring:message code="taxApp.taxAssessment.form.infoMsg"></spring:message></div>
					</div>

					<!-- <div class="col-3"><p>[Computation from details provided above]</p></div> -->

					<div class="form-group row">
						<div class="col-4">
							<a href="<c:url value='/' />" class="btn btn-primary"><spring:message code="taxApp.taxAssessment.nav.button.cancel"></spring:message></a>
							<!--<input type="button" onclick="location.href='/home';" value="Cancel" name="btnSubmit"
								class=" btn btn-primary"> -->
						</div>
						<div class="col-6">
							<input type="submit" value="<spring:message code="taxApp.taxAssessment.nav.button.payTax"></spring:message>" name="btnSubmit"
								class=" btn btn-primary">
						</div>
					</div>

				</form:form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>