<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

<title>Todo's List</title>
</head>
<body>

	<div class="container">
	<table class="table table-striped">
	<caption>Your todos are</caption>
		<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is it Done?</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Del</a></td>
					</tr>
				</c:forEach>
			</tbody>
		
	</table>
	<div> <a class="button" href="/add-todo">Add a Todo</a></div>

		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	</div>

</body>
</html>