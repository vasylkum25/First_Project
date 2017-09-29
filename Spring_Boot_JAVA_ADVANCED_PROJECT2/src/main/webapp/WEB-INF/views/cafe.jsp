<%@ include file="header.jsp"%>

<div class = "container mt-3">
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Name</th>
					<th class = "text-center">Address</th>
					<th class = "text-center">Description</th>
					<th class = "text-center">Photo</th>
					<th class = "text-center">Type</th>
				</tr>
					<c:forEach var="cafe" items="${cafes.content}">
					<tr>
					<td><a href="/cafe/${cafe.id}">${cafe.name}</a></td>
						<td>${cafe.address}</td>
						<td>${cafe.shortDescription}</td>
						<td><img src="${cafe.photoUrl}"></td>
						<td>${cafe.type}</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	
	</div>
	<div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${cafes}"/>
 			</div>
 		</div>
</div>
</body>
</html>