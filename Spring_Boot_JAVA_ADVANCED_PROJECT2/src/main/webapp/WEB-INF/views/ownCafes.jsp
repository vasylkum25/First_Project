<%@ include file="header.jsp"%>

<div class = "container mt-3">
		<div class="row" >
			<div class = "col-6">
			 <sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/profile/ownCafe/add"><button class="btn btn-sm btn-outline-success ml-3">New Cafe</button></a>
			</sec:authorize>
			</div>
		</div>
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Name</th>
					<th class = "text-center">Address</th>
					<th class = "text-center">Description</th>
					<th class = "text-center">Photo</th>
					<th class = "text-center">Type</th>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<th class = "text-center">Option</th>
					</sec:authorize>
				</tr>
					<c:forEach var="cafe" items="${ownCafes.content}">
					<tr>
					<td><a href="/cafe/${cafe.id}">${cafe.name}</a></td>
						<td>${cafe.address}</td>
						<td>${cafe.shortDescription}</td>
						<td>${cafe.photoUrl}</td>
						<td>${cafe.type}</td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td class = "text-center">
						<a href = "/profile/ownCafe/update/${cafe.id }"  class="btn btn-outline-danger btn-sm">Update</a>
						<a href = "/profile/ownCafe/delete/${cafe.id }" class="btn btn-outline-warning btn-sm">Delete</a>
								<a href="/profile/ownCafe/${cafe.id}/tables"><button class="btn btn-sm btn-outline-success">Table</button></a>
						</td>
						</sec:authorize>
					</tr>
					</c:forEach>
			</table>
		</div>
	</div>
	<div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${ownCafes}"/>
 			</div>
 		</div>
</div>
</body>
</html>