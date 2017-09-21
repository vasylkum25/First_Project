<%@ include file="header.jsp"%>

<div class = "container mt-3">
		<div class="row" >
			<div class = "col-12">
				<form:form action="/profile/ownCafe/add" method="POST" modelAttribute="cafe">
				<div class="form-group row">
					<label class="col-2 col-form-label" for="name">Name:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="name" path="name"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="address">Address:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="address" path="address"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="fullDescription">fullDescription:</label> 
					<div class="col-10">
						<form:textarea class="form-control" id ="fullDescription" path="fullDescription" rows="5"></form:textarea>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="shortDescription">shortDescription:</label> 
					<div class="col-10">
						<form:textarea class="form-control" id ="shortDescription" path="shortDescription" rows="3"></form:textarea>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="phone">Phone:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="phone" path="phone"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="web">Web:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="web" path="web"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="open">Open:</label> 
					<div class="col-10">
						<form:select class="form-control" path="open" items="${times}"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="close">Close:</label> 
					<div class="col-10">
						<form:select class="form-control" path="close" items="${times}"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="type">Type:</label> 
					<div class="col-10">
						<form:select class="form-control" path="type" items="${types}"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="photoUrl">PhotoUrl:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="photoUrl" path="photoUrl"/>
					</div>
				</div>
				
					<div class="form-group row">
					<div class="col-10 mr-left">
					<button class="btn btn-sm btn-outline-success">Save</button>
					<a href="/profile/ownCafe/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
					</div>
					</div>
				</form:form>
			</div>
		</div>
	
		</div>
</body>
</html>