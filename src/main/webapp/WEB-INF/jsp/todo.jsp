<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Todo Page</title>

</head>
<body>
	<div class="container">
		<form:form method="POST" modelAttribute="todo">
		
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label> 
				<form:input path="desc" type="text"
					class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning"/>
			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
			
		</form:form>

	</div>

	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>

</body>
</html>