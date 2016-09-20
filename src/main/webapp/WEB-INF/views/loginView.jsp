<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
	    	<div class="collapse navbar-collapse" id="myNavbar">
	      		<ul class="nav navbar-nav navbar-right">
	        		<li></li>
					<li><a href="registrationView"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      		</ul>
	    	</div>
	  	</div>
	</nav>
	
	<div class="container">
		<div class="form-group">
			<label class="col-md-4 control-label" for="mail"></label> 
			<c:if test="${not empty msg}"><div class="alert alert-success  col-md-4">${msg}</div></c:if>
			<c:if test="${not empty error}"><div class="alert alert-warning input-md col-md-4">${error}</div></c:if>
			<c:url var="loginUrl" value="/j_spring_security_check" />
		</div>
	</div>
	
	<div class="container">
	<form action="${loginUrl}" method="post" class="form-horizontal">
		<div class="form-group">	
			<label class="col-md-4 control-label" for="mail">E-mail:</label>  
			<div class="col-md-4">
				<input class="form-control input-md" type='text' name='mail' value=''placeholder="E-mail"/>		
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="password">Password:</label>
			<div class="col-md-4">
				<input class="form-control input-md" type='password' name='password' value=''placeholder="Password"/> 
			</div>		
		</div>	  
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="registration"></label>
			<div class="col-md-4">
				<button type="submit" id="registration" class="btn btn-primary form-control input-md">Login</button>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
		</div>							
	</form>  
	</div>
</body>
</html>