<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
	<script>
		$(document).ready(function(){
			var date_input=$('input[id="date"]'); //our date input has the name "date"
			var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			var options={
				format: 'mm/dd/yyyy',
				container: container,
				todayHighlight: true,
				autoclose: true,
				};
		date_input.datepicker(options);
		})
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
	<form:form class="form-horizontal" action="addRegistration" method="POST" modelAttribute="user">
		<div class="form-group">
			<label class="col-md-4 control-label" for="mail">Mail:</label>  
			<div class="col-md-4">
				${errorMailDoubled}
				<form:errors path="mail" cssClass="error"/>
				<form:input class="form-control input-md" path="mail" placeholder="Mail"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="password">Password:</label>  
			<div class="col-md-4">
				<form:errors path="password" cssClass="error"/>
				<form:input class="form-control input-md" path="password" type="password" placeholder="Password"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="passwordConfirm">Password(Confirm):</label>  
			<div class="col-md-4">
				${errorConfirmPassword} 
				<form:errors path="passwordConfirm" cssClass="error"/>
				<form:input class="form-control input-md" path="passwordConfirm" type="password" placeholder="Password(Confirm)"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="name">Name:</label>  
			<div class="col-md-4">
				<form:errors path="name" cssClass="error"/>
				<form:input class="form-control input-md" path="name" placeholder="Name"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="dateOfBirth">Date of Birth:</label>  
			<div class="col-md-4">
				<form:input class="form-control" path="dateOfBirth" id="date" placeholder="MM/DD/YYY" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="street">Street:</label>  
			<div class="col-md-4">
				<form:input class="form-control input-md" path="street" placeholder="Street"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="zipCode">Zip Code:</label>  
			<div class="col-md-4">
				<form:input class="form-control input-md" path="zipCode" placeholder="Zip Code"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="city">City:</label>  
			<div class="col-md-4">
				<form:input class="form-control input-md" path="city" placeholder="City"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-4 control-label" for="country">Country:</label>
			<div class="col-md-4">
				<form:select path="country" id="selectbasic" name="country" class="form-control">
				<form:option value="NONE" label="--- Select ---"/>
				<form:options items="${countries}" />
				</form:select>
			</div>
        </div>
		
		<div class="form-group">
		   <label class="col-md-4 control-label" for="registration"></label>
		   <div class="col-md-4">
				<button type="submit" id="registration" class="btn btn-primary form-control input-md">Registration</button>
		   </div>
		</div> 
	  </form:form>
	</div>
</body>
</html>