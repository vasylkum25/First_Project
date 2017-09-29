<%@ include file="header.jsp"%>
<div class = "container  mt-3">
		<div class="row" >
			<div class = "col-12">
				<form:form action="/profile/ownMeal/add" method="POST" modelAttribute="meal">
				<div class="row">
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="title"/>
						</div>
					</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="title">Title:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="title" path="title"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="description">Description:</label> 
					<div class="col-10">
						<form:textarea class="form-control" id ="description" path="description" rows="5"></form:textarea>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="price">Price:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="price" path="price"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="weight">Weight:</label> 
					<div class="col-10">
						<form:input class="form-control" id ="weight" path="weight"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="cuisine">Cuisine:</label> 
					<div class="col-10">
						<form:select class="form-control"  path="cuisine"  items="${cuisines}"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="ingredients">Ingredients:</label> 
					<div class="col-10">
					<form:select class="form-control" path="ingredients" items="${ingredients}" miltiple="miltiple"/>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="cafe">Cafe:</label> 
					<div class="col-10">
					<form:select class="form-control" path="cafe" items="${cafes}" itemValue="name" itemLabel="name"/>
					</div>
				</div>
					<div class="form-group row">
					<div class="col-10 mr-left">
					<button class="btn btn-sm btn-outline-success">Save</button>
					<a href="/profile/ownMeal/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
					</div>
					</div>
				
				</form:form>
			</div>
		</div>
		</div>
	
	
</body>
</html>