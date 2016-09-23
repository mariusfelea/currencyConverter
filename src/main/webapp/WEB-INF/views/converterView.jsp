<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
	    	<div class="navbar-header">
	      		<a class="navbar-brand" >Forex Currency Rates</a>
	    	</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="http://localhost:8080/currencyConverter/">Home</a></li>
			</ul>
	  	</div>
	</nav>
	
	<div class="container">
		<div class="box">
			<div id="login-box">  
				<c:if test="${not empty error}"><div class="error">${error}</div></c:if>
				<c:if test="${not empty msg}"><div class="msg">${msg}</div></c:if>
				<c:url value="/j_spring_security_logout" var="logoutUrl" />
				<form action="${logoutUrl}" method="post" id="logoutForm">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h5>Welcome : ${pageContext.request.userPrincipal.name} | 
						<a href="javascript:formSubmit()"> Logout</a></h5>
				</c:if>
			</div> 
		</div>
		<form:form class="form-horizontal" action="convertAmount" method="POST" modelAttribute="rateConverter">
			<div class="form-group">
				<label class="col-md-4 control-label" for="fromCurrency">From Currency:</label>
				<div class="col-md-4">
					<form:select path="fromCurrency" id="selectbasic" name="fromCurrency" class="form-control">
						<option selected>EUR</option>
						<form:options items="${currencies}" />
					</form:select>
				</div>
	        </div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="city">Amount:</label>  
				<div class="col-md-4">
					<form:errors path="amount" cssClass="error"/>
					<form:input class="form-control input-md" path="amount" type="number" placeholder="Amount"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="toCurrency">To Currency:</label>
				<div class="col-md-4">
					<form:select path="toCurrency"  name="toCurrency" class="form-control">
					<option selected>USD</option>
					<form:options items="${currencies}" />
					</form:select>
				</div>
	        </div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="city">Converted Amount:</label>  
				<div class="col-md-4">
					<form:input class="form-control input-md" path="convertedAmount" placeholder="Converted Amount" readonly="true"/>
				</div>
			</div>
			
			<div class="form-group">
			   <label class="col-md-4 control-label" for="registration"></label>
			   <div class="col-md-4">
					<button type="submit" id="registration" class="btn btn-primary form-control input-md">Convert</button>
			   </div>
			</div>
		</form:form>
		
		<div>
			<h2>Converter Rates History</h2>
			<table class="table table-hover">
				<thead>
		    	<tr>
					<th>User Mail</th>
					<th>From Currency</th>
					<th>Amount</th>
					<th>To Currency</th>
					<th>Converted Amount</th>
					<th>Date</th>
		  		</tr>
				</thead>
			<tbody>
			<c:forEach var="rateConverter" items="${getRatesConverter}" varStatus="counter">	
				<tr>
					<td>${rateConverter.userMail}</td>
					<td>${rateConverter.fromCurrency}</td>
					<td>${rateConverter.amount}</td>
					<td>${rateConverter.toCurrency}</td>
					<td>${rateConverter.convertedAmount}</td>
					<td>${rateConverter.date}</td>
			  	</tr>
		  	</c:forEach>
			</tbody>
		  </table>
		</div>
	</div>
</body>
</html>