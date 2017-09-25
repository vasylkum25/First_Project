<%@ include file="header.jsp"%>
<div class = "container">
		<div class="row" >
			<div class = "col-12">
				<h1>${cafesId.name}</h1>
				<div class="form-group row">
							<div class="col-10 mr-auto">
								<a href="/cafe/${cafesId.id}/tables"><button class="btn btn-sm btn-outline-success">Table</button></a>
							</div>
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
		<div class="row">
			<div class="col-12">
		<form:form action="/cafe/${cafesId.id }" method="POST" modelAttribute="comment">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="user">User:</label>
						<div class="col-10">
							<form:input class="form-control" path="user"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="rate">Rate:</label>
						<div class="col-10">
							<form:textarea class="form-control" path="rate"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="message">Message:</label>
						<div class="col-10">
							<form:textarea class="form-control" path="message"/>
						</div>
					</div>
						<div class="form-group row">
							<div class="col-10 ml-auto">
								<button class="btn btn-sm btn-outline-success">Add comment</button>
							</div>
						</div>
				</form:form>
				</div>
		</div>
		<c:forEach var="comment" items="${comments}">
			<dl class="row">
					 <dt class="col-sm-3">${comment.user}</dt>
		<dd class="col-sm-9"><p class="font-italic small">${comment.time}</p></dd>
		</dl>
		<dl class="row">
			<dd class="col-sm-12">${comment.message}</dd>
		</dl>
		</c:forEach>
		</div>
		
</body>
</html>