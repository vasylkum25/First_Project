<%@ include file="header.jsp"%>
<div class = "container  mt-3">
	
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
				</tr>
					<c:forEach var="meal" items="${meals.content}">
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
					</tr>
					</c:forEach>
			</table>
		</div>
	</div>
	<div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${meals}"/>
 			</div>
 		</div>
</div>
</body>
</html>