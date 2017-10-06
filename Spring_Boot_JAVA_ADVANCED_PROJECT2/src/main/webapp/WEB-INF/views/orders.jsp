<%@ include file="header.jsp"%>

<div class = "container mt-3">
<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Title</th>
					<th class = "text-center">Option</th>
				</tr>
					<c:forEach var="order" items="${orders}">
					<tr>
						<td>
						${order.id}
						<%-- <c:forEach var="meal" items="${order.meals}">
							${meal.title}
						</c:forEach> --%>
						</td>
						<td class = "text-center">
						<a href = "/admin/order/update/${meal.id }"  class="btn btn-outline-danger btn-sm">Zamovutu</a>
						<a href = "/admin/order/delete/${meal.id }" class="btn btn-outline-warning btn-sm">Delete</a>
						</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	
	</div>
	<%-- <div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${orders}"/>
 			</div>
 		</div> --%>
</div>
</body>
</html>