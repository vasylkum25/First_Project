<%@ include file="header.jsp"%>

<div class = "container">
		<div class="row" >
			<div class = "col-12">
				<form actoin="/admin/user" method="POST">
				<div class="form-group row">
					<label class="col-2 col-form-label" for="name">Name:</label> 
					<div class="col-10">
						<input class="form-control" id ="name" name="name">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="lastName">Last Name:</label> 
					<div class="col-10">
						<input class="form-control" id ="lastName" name="lastName">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="login">Login:</label> 
					<div class="col-10">
						<input class="form-control" id ="login" name="login">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="password">Password:</label> 
					<div class="col-10">
						<input class="form-control" id ="password" name="password">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="phone">Phone:</label> 
					<div class="col-10">
						<input class="form-control" id ="phone" name="phone">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="email">Email:</label> 
					<div class="col-10">
						<input class="form-control" id ="email" name="email">
					</div>
				</div>
				
					<div class="form-group row">
					<div class="col-10 mr-left">
					<button class="btn btn-sm btn-outline-success">Save</button>
					</div>
					</div>
				
				</form>
			</div>
		</div>
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Name</th>
					<th class = "text-center">Last Name</th>
					<th class = "text-center">Login</th>
					<th class = "text-center">Password</th>
					<th class = "text-center">Phone</th>
					<th class = "text-center">Email</th>
					<th class = "text-center">Option</th>
				</tr>
					<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.name}</td>
						<td>${user.lastName}</td>
						<td>${user.login}</td>
						<td>${user.password}</td>
						<td>${user.phone}</td>
						<td>${user.email}</td>
						<td class = "text-center">
						<a href = "/admin/user/update/${user.id }"  class="btn btn-outline-danger btn-sm">Update</a>
						<a href = "/admin/user/delete/${user.id }" class="btn btn-outline-warning btn-sm">Delete</a>
						</td>
					</tr>
					</c:forEach>
			</table>
		</div>
	
	</div>
</div>
</body>
</html>