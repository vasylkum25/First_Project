<%@ include file="header.jsp"%>

<div class = "container mt-3">
		<div class="row" >
			<div class = "col-12">
			 <sec:authorize access="hasRole('ROLE_CAFE')">
			<a href="/profile/ownCafe"><button class="btn btn-sm btn-outline-success ml-3">Own Cafe</button></a>
			<a href="/profile/ownMeal"><button class="btn btn-sm btn-outline-success ml-3">Own Meal</button></a>
			<a href="/profile/orders"><button class="btn btn-sm btn-outline-success ml-3">Orders</button></a>
			</sec:authorize>
				
			</div>
		</div>
	
</div>
</body>
</html>