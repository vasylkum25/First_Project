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
		<div class="col-3">
				<form:form action="/profile/ownCafe" method="GET" modelAttribute="cafeFilter">
					<div class="form-group row">
						<div class="col-12">
							<form:input class="form-control" path="search" placeholder="Search"/>
						</div>
					</div>
					
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minRate" class="form-control" placeholder="Min rate"/>
						</div>
						<div class="col-6">
							<form:input path="maxRate" class="form-control" placeholder="Max rate"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<div>
								<label>Pub <form:checkbox path="types" value="PUB"/></label>
								<label>Sushy <form:checkbox path="types" value="SUSHY"/></label>
								<label>Bar <form:checkbox path="types" value="BAR"/></label>
								<label>Cafe <form:checkbox path="types" value="CAFE"/></label>
								<label>Restaurant <form:checkbox path="types" value="RESTAURANT"/></label>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minOpen" class="form-control" placeholder="Min open"/>
						</div>
						<div class="col-6">
							<form:input path="maxOpen" class="form-control" placeholder="Max open"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minClose" class="form-control" placeholder="Min close"/>
						</div>
						<div class="col-6">
							<form:input path="maxClose" class="form-control" placeholder="Max close"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<form:select class="form-control" items="${meals}" path="mealsIds" element="div" itemLabel="title" itemValue="id"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
        					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
      					</div>
					</div>
				</form:form>
	<div class="col-7">
 				<div class="row">
  					<div class="col-6 text-center">
 							<button class="dropdown-toggle btn btn-outline-primary btn-sm" type="button" data-toggle="dropdown">Sort
 							</button>
 						<div class="dropdown-menu">
 								<custom:sort innerHtml="Name asc" paramValue="name"/>
 								<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
 							</div>
					</div>
 					<div class="col-6 text-center">
 						<custom:size posibleSizes="1,2,5,10" size="${cafes.size}" />
 					</div>
				</div>
 			</div>
 	</div>
		<div class = "col-9">
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