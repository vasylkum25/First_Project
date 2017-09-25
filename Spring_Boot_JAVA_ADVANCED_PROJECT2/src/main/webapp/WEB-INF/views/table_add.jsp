<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12">
				<form:form action="/admin/table" method="POST" modelAttribute="table">
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
							<form:select class="form-control" id="cafe" path="cafe" items="${cafes}"/>
						</div>
					</div>
					<div class="form-group row">
					<div class="col-10 mr-left">
					<button class="btn btn-sm btn-outline-success">Save</button>
					<button class="btn btn-sm btn-outline-warning">Cancel</button>
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
						<th class="text-center">Reserve</th>
					</tr>
					<c:forEach var="table" items="${tables}">
						<tr>
							<td>${table.number}</td>
							<td>${table.countOfPeople}</td>
							<td>${table.isFree}</td>
							<td><a href="/cafe/${table.cafe.id}">${table.cafe.name}</a></td>
							<td>${table.name}</td>
							<td>${table.phone}</td>
							<td class="text-center">
								<a href="/admin/table/update/${table.id}" class="btn btn-outline-success btn-sm">Update</a>
								<a href="/admin/table/delete/${table.id}" class="btn btn-outline-danger btn-sm">Delete</a>
							</td>
							<c:if test="${table.isFree.equals(true)}">
							<td><a href="/admin/table"  class="btn btn-outline-danger btn-sm">Reserve</a> 
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
	</div>
</body>
</html>