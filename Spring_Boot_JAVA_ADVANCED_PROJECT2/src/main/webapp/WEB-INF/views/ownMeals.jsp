<%@ include file="header.jsp"%>
<div class = "container  mt-3">
	
		 <sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/profile/ownMeal/add"><button class="btn btn-sm btn-outline-success ml-3">New Meal</button></a>
			</sec:authorize>
			
			
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Title</th>
					<th class = "text-center">Description</th>
					<th class = "text-center">Price</th>
					<th class = "text-center">Cafe</th>
					<th class = "text-center">Weight</th>
					<th class = "text-center">Cuisine</th>
					<th class = "text-center">Ingredients</th>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<th class = "text-center">Option</th>
					</sec:authorize>
				</tr>
					<c:forEach var="meal" items="${ownMeals.content}">
					<tr>
						<td><a href="/meal/${meal.id}">${meal.title}</a></td>
						<td>${meal.description}</td>
						<td>${meal.price}</td>
						<td><a href="/cafe/${meal.cafe.id}">${meal.cafe.name}</a></td>
						<td>${meal.weight}</td>
						<td>${meal.cuisine}</td>
						<td>
						<c:forEach var="ingredient" items="${meal.ingredients}">
							${ingredient} 
						</c:forEach>
						</td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td class = "text-center">
						<a href = "/profile/ownMeal/update/${meal.id}"  class="btn btn-outline-danger btn-sm">Update</a>
						<a href = "/profile/ownMeal/delete/${meal.id}" class="btn btn-outline-warning btn-sm">Delete</a>
						<a href="/profile/ownCafe/${meal.cafe.id}/tables"><button class="btn btn-sm btn-outline-success">Table</button></a>
						</td>
						</sec:authorize>
					</tr>
					</c:forEach>
			</table>
		</div>
	</div>
	<div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${ownMeals}"/>
 			</div>
 		</div>
</div>
</body>
</html>