<%@ include file="header.jsp"%>
<div style="background-color:#e3f2fd;">
<div class = "container">
		<div class="row" >
			<div class = "col-12">
				<h1>${cafesId.name}</h1>
			<div class="row" >
				<div class="form-group row">
					<div class="col-10 mr-auto">
						<a href="/cafe/${cafesId.id}/tables"><button class="btn btn-sm btn-outline-success">Table</button></a>
					</div>
				</div>
		<sec:authorize access="hasRole('ROLE_CAFE')">
				<div class="form-group row">
					<div class="col-10 mr-auto">
						<a href="/cafe/${cafesId.id}/order"><button class="btn btn-sm btn-outline-success">Order</button></a>
					</div>
				</div>
		</sec:authorize>		
			</div>	
		<div class="progress"  style="width: 350px;">
  			<div class="progress-bar progress-bar-striped bg-danger" role="progressbar" style="width: ${cafesId.rate*10}%" aria-valuenow="${cafesId.rate}" aria-valuemin="0" aria-valuemax="10">${cafesId.rate}</div>
		</div> 
				<h1>${cafesId.fullDescription}</h1>
				<h1>${cafesId.type}</h1>
				<h1>${cafesId.open} - ${cafesId.close}</h1><br>
				<span><img src="${cafesId.photoUrl}"></span>
				
			</div>
		</div>
		<div>
			<p class="mt-2">
				<a  data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample"><i class="fa fa-pencil" aria-hidden="true"></i>Add comment</a> 
			</p>
			<div class="collapse" id="collapseExample">
				<div class="card card-body">
					<form:form action="/cafe/${cafesId.id}" method="POST" modelAttribute="comment">
						<div class="mt-3">
							<div class="row" style="color: red;">
								<div class="col-10 ml-auto">
									<form:errors path="user"/>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="user">User:</label>
								<div class="col-10">
									<form:input class="form-control" id="user" path="user"/>
								</div>
							</div>
							<div class="row" style="color: red;">
								<div class="col-10 ml-auto">
									<form:errors path="rate"/>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="rate">Rate:</label>
								<div class="col-10">
									<form:input class="form-control" id="rate" path="rate"/>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-2 col-form-label" for="message">Message:</label>
								<div class="col-10">
									<form:textarea class="form-control" id="message" path="message" rows="4"/>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-10 ml-auto">
									<button class="btn btn-sm btn-outline-success">Save</button>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		
		<!--CommentToComment -->
		<c:forEach var="comment" items="${comments}">
		<c:set var="comments" value="${comment.childComment}" scope="request"/>
			<div class="row mt-2">
				<div class="col pl-0">
					<span class="text-primary font-weight-bold font-italic"><i class="fa fa-user-circle" aria-hidden="true"></i> ${comment.user}</span>
					<span class="text-dark small font-italic ml-3"><i class="fa fa-clock-o" aria-hidden="true"></i> ${comment.time}</span>
					<a class="text-dark ml-3" data-toggle="collapse" href="#collapseExample${comment.id}" aria-expanded="false" aria-controls="collapseExample${comment.id}"><i class="fa fa-pencil" aria-hidden="true"></i> <u>to comment</u></a>
					<div>${comment.message}</div>
					<div class="mt-2 mb-2 collapse" id="collapseExample${comment.id}">
						<div class="card card-body">
							<form:form action="/cafe/${cafesId.id}/${comment.id}" method="POST" modelAttribute="commentToComment">
								<div class="row" style="color: red;">
									<div class="col-10 ml-auto">
										<form:errors path="user"/>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-2 col-form-label" for="user">User:</label>
									<div class="col-10">
										<form:input class="form-control" id="user" path="user"/>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-2 col-form-label" for="message">Message:</label>
									<div class="col-10">
										<form:textarea class="form-control" id="message" path="message" rows="4"/>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-10 ml-auto">
										<button class="btn btn-sm btn-outline-success">Save</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="mr-3">
	 			<jsp:include page="comments.jsp"/>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>