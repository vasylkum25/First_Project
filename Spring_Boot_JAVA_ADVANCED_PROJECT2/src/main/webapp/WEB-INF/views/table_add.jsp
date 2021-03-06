<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
			<div class="col-6">
 				<div class="row">
 					<div class="col-6 text-center">
 						<custom:size posibleSizes="1,2,5,10" size="${tables.size}" />
 					</div>
				</div>
 			</div>
				<form:form action="/profile/ownCafe/${cafe.id}/tables" method="POST" modelAttribute="table">
				<div class="form-group row">
						<label class="col-2 col-form-label" for="number">Number:</label>
						<div class="col-10">
							<form:input class="form-control" id="number" path="number"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="countOfPeople">People:</label>
						<div class="col-10">
							<form:input class="form-control" id="countOfPeople" path="countOfPeople"/>
						</div>
					</div>
					<div class="form-group row">
					<label class="col-2 col-form-label" for="isFree">Reserve:</label>
						<div class="col-10">
							<form:input class="form-control" id="isFree" path="isFree"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="cafe">Cafe:</label>
						<div class="col-10">
						<form:select class="form-control"  path="cafe"  items="${ownCafes}" itemValue="name" itemLabel="name"/>
					</div>
					</div>
					<div class="form-group row">
					<div class="col-10 mr-left">
					<button class="btn btn-sm btn-outline-success">Save</button>
					<a href = "/profile/ownCafe/${cafe.id}/tables/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
					</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Number</th>
						<th class="text-center">People</th>
						<th class="text-center">Free</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">User name</th>
						<th class="text-center">User phone</th>
						<th class="text-center">Options</th>
						<th class="text-center">Order</th>
						<th class="text-center">Reserve</th>
					</tr>
					<c:forEach var="table" items="${tables.content}">
						<tr>
							<td>${table.number}</td>
							<td>${table.countOfPeople}</td>
							<td>${table.isFree}</td>
							<td><a href="/cafe/${table.cafe.id}">${table.cafe.name}</a></td>
							<td>${table.name}</td>
							<td>${table.phone}</td>
							<td class="text-center">
								<a href="/profile/ownCafe/${table.cafe.id}/tables/update/${table.id}" class="btn btn-outline-success btn-sm">Update</a>
								<a href="/profile/ownCafe/${table.cafe.id}/tables/${table.id}/delete" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
							<td>
					<c:if test="${table.isFree.equals(true)}">
									<a href="/profile/ownCafe/${table.cafe.id}/table/${table.id}/order"><button class="btn btn-sm btn-outline-success">Order</button></a>
					</c:if>		
							</td>
							<c:if test="${table.isFree.equals(true)}">
							<td><a href="/profile/ownCafe/${table.cafe.id}/tables/${table.id}"  class="btn btn-outline-danger btn-sm">Reserve</a> 
							<i class="col-3 text-left" style="color:red;">This table are reserved</i></td>
			</c:if>
			<c:if test="${table.isFree.equals(false)}">
							<td><a href="/cafe/${table.cafe.id}/tables/${table.id}" class="btn btn-outline-success btn-sm">Free</a></td>
			</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${tables}"/>
 			</div>
 		</div>
	</div>
</body>
</html>