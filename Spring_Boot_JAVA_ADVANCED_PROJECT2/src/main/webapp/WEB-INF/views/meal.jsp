<%@ include file="header.jsp"%>
<div class = "container  mt-3">
	<div class="row" >
		<div class = "col-12">
		<div class="form-group row">
							<div class="col-10 mr-auto">
								<a href="/cafe/${oneMeal.cafe.id}/tables"><button class="btn btn-sm btn-outline-success">Table</button></a>
							</div>
						</div>
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Title</th>
					<th class = "text-center">Description</th>
					<th class = "text-center">Price</th>
					<th class = "text-center">Cafe</th>
					<th class = "text-center">Weight</th>
					<th class = "text-center">Cuisine</th>
					<th class = "text-center">Ingredients</th>
				</tr>
					
					<tr>
						<td>${oneMeal.title}</td>
						<td>${oneMeal.description}</td>
						<td>${oneMeal.price}</td>
						<td>${oneMeal.cafe.name}</td>
						<td>${oneMeal.weight}</td>
						<td>${oneMeal.cuisine.name}</td>
						<td>
						<c:forEach var="ingredient" items="${oneMeal.ingredients}">
							${ingredient.name} 
					</c:forEach>
						</td>
					</tr>
			</table>
		</div>
	
	</div>
</div>
<div class="row">
			<div class="col-12">
		<form:form action="/meal/${oneMeal.id }" method="POST" modelAttribute="comment">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="user">User:</label>
						<div class="col-10">
							<form:input class="form-control" path="user"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="message">Message:</label>
						<div class="col-10">
							<form:textarea class="form-control" path="message"/>
						</div>
					</div>
						<div class="form-group row">
							<div class="col-10 ml-auto">
								<button class="btn btn-sm btn-outline-success">Add comment</button>
							</div>
						</div>
				</form:form>
				</div>
		</div>
		<c:forEach var="comment" items="${comments}">
		<h5>User name: ${comment.user}</h5>
		<h5>Message: ${comment.message}</h5>
		<h5>${comment.time}</h5>
		</c:forEach>
</body>
</html>