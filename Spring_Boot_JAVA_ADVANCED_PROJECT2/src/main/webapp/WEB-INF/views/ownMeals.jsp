<%@ include file="header.jsp"%>
<div class = "container  mt-3">
	
		 <sec:authorize access="hasRole('ROLE_CAFE')">
			<a href="/profile/ownMeal/add"><button class="btn btn-sm btn-outline-success ml-3">New Meal</button></a>
			</sec:authorize>
	<div class="row" >
	<div class="col-3">
	<form:form action="/profile/ownMeal" method="GET" modelAttribute="mealFilter">
					<div class="form-group row">
						<div class="col-12">
							<form:input class="form-control" path="search" placeholder="Search"/>
						</div>
					</div>
					
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minPrice" class="form-control" placeholder="Min price"/>
						</div>
						<div class="col-6">
							<form:input path="maxPrice" class="form-control" placeholder="Max price"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:select class="form-control" items="${cafes}" path="cafeId" element="div" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:select class="form-control" items="${cuisines}" path="cuisineId" element="div" itemLabel="name" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
        					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
      					</div>
					</div>
				</form:form>
		</div>
		<div class = "col-9">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Title</th>
					<th class = "text-center">Description</th>
					<th class = "text-center">Price</th>
					<th class = "text-center">Cafe</th>
					<th class = "text-center">Weight</th>
					<th class = "text-center">Cuisine</th>
					<th class = "text-center">Ingredients</th>
					<sec:authorize access="hasRole('ROLE_CAFE')">
					<th class = "text-center">Option</th>
					</sec:authorize>
				</tr>
					<c:forEach var="meal" items="${ownMeals.content}">
					<tr>
						<td><a href="/meal/${meal.id}">${meal.title}</a></td>
						<td>${meal.description}</td>
						<td>${meal.price}</td>
						<td>${meal.cafe}</td>
						<td>${meal.weight}</td>
						<td>${meal.cuisine}</td>
						<td>
						<c:forEach var="ingredient" items="${meal.ingredients}">
							${ingredient} 
						</c:forEach>
						</td>
						<sec:authorize access="hasRole('ROLE_CAFE')">
						<td class = "text-center">
						<a href = "/profile/ownMeal/update/${meal.id}"  class="btn btn-outline-danger btn-sm">Update</a>
						<a href = "/profile/ownMeal/delete/${meal.id}" class="btn btn-outline-warning btn-sm">Delete</a>
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