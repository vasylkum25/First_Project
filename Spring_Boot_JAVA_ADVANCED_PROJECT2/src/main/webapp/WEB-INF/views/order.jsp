<%@ include file="header.jsp"%>

<div class = "container mt-3">
<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Title</th>
					<th class = "text-center">Price</th>
					<th class = "text-center">Weight</th>
					<th class = "text-center">Ingredients</th>
					<th class = "text-center">Option</th>
				</tr>
					<c:forEach var="meal" items="${meals.content}">
					<tr>
						<td>${meal.title}</td>
						<td>${meal.price}</td>
						<td>${meal.weight}</td>
						<td>
						<c:forEach var="ingredient" items="${meal.ingredients}">
							${ingredient} 
						</c:forEach>
						</td>
						<td class = "text-center">
						<a href = "/profile/ownCafe/${table.cafe.id}/table/${table.id}/order/${meal.id}"  class="btn btn-outline-danger btn-sm">Zamovutu</a>
						<a href = "/admin/order/delete/${meal.id }" class="btn btn-outline-warning btn-sm">Delete</a>
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