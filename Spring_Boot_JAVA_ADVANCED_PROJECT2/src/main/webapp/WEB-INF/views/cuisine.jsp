<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
					<div class="col-3">
						<form:form action="/admin/cuisine" method="GET" modelAttribute="filter">
							<div class="form-group row">
								<div class="col-12">
									<form:input class="form-control" path="search" placeholder="Search"/>
								</div>
							</div>
						
						</form:form>
					</div>
			<div class="col-9">
				<form:form action="/admin/cuisine" method="POST" modelAttribute="cuisine">
					<custom:hiddenInputs excludeParams="name, _csrf"/>
						<div class="row">
							<div class="col-10 ml-auto" style="color:red;">
								<form:errors path="name" />
							</div>
						</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input class="form-control" id="name" path="name"/>
						</div>
					</div>
						<div class="form-group row">
							<div class="col-10 ml-auto">
								<button class="btn btn-sm btn-outline-success">Save</button>
								<a href="/admin/cuisine/cancel<custom:allParams/>" class="btn btn-sm btn-outline-warning">Cancel</a>
							</div>
						</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-9">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Option</th>
					</tr>
					<c:forEach var="cuisine" items="${cuisines.content}">
						<tr>
							<td>${cuisine.name}</td>
							<td class="text-center">
							<a href="/admin/cuisine/update/${cuisine.id}<custom:allParams/>" class="btn btn-outline-danger btn-sm">Update</a> 
							<a href="/admin/cuisine/delete/${cuisine.id}<custom:allParams/>" class="btn btn-outline-warning btn-sm">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
		<div class="col-3">
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
 						<custom:size posibleSizes="1,2,5,10" size="${cuisines.size}" />
 					</div>
				</div>
 			</div>
		</div>
		<div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${cuisines}"/>
 			</div>
 		</div>
	</div>
</body>
</html>