<%@ include file="header.jsp"%>
	<div class="container mt-3">
		<div class="card text-white bg-warning mb-3" style="max-width: 45rem;">
			<div class="col-12 mt-3">
				<form:form action="/registration" method="POST" modelAttribute="registration">
					<div class="form-group row">
						<label class="col-3 col-form-label" for="email">Email:</label>
						 <div class="col-sm-9">
							<form:input class="form-control" id="email" path="email" placeholder="Email"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-3 col-form-label" for="password">Password:</label>
						<div class="col-9">
							<form:password class="form-control" id="password" path="password"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-3 col-form-label" for="repeatPassword">Repeat password:</label>
						<div class="col-9">
							<form:password class="form-control" id="repeatPassword" path="repeatPassword"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Register</button>
							<a href="/login" class="btn btn-sm btn-outline-primary">Login</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>