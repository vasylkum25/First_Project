<%@ include file="header.jsp"%>

<div class = "container">
<div class="row" >
			<div class = "col-12">
				<form:form action="/admin/ingredient" method="POST" modelAttribute="ingredient">
					<div class="row" >
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="name"/>
						</div>
					</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="name">Name:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="name" path="name"/>
					</div>
				</div>
					<div class="form-group row">
							<div class="col-10 ml-auto">
								<button class="btn btn-sm btn-outline-success">Save</button>
								<a href="/admin/ingredient/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
							</div>
					</div>
				</form:form>
			</div>
		</div>
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Name</th>
					<th class = "text-center">Option</th>
				</tr>
					<c:forEach var="ingredient" items="${ingredients.content}">
					<tr>
						<td>${ingredient.name}</td>
						<td class = "text-center">
						<a href = "/admin/ingredient/update/${ingredient.id }"  class="btn btn-outline-danger btn-sm">Update</a>
						<a href = "/admin/ingredient/delete/${ingredient.id }" class="btn btn-outline-warning btn-sm">Delete</a>
						</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	
	</div>
</div>
<div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${ingredients}"/>
 			</div>
 		</div>
</body>
</html>