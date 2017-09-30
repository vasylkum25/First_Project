<%@ include file="header.jsp"%>

<div class = "container">
<div class="row" >
	<div class="col-3">
		<form:form action="/admin/open_close" method="GET" modelAttribute="filter">
			<div class="form-group row">
				<div class="col-12">
					<form:input class="form-control" path="search" placeholder="Search"/>
				</div>
			</div>
		</form:form>
	</div>
			<div class = "col-12">
				<form:form action="/admin/open_close" method="POST" modelAttribute="open_close">
					<custom:hiddenInputs excludeParams="time, _csrf"/>
					<div class="row" >
						<div class="col-10 ml-auto" style="color: red;">
							<form:errors path="time"/>
						</div>
					</div>
				<div class="form-group row">
					<label class="col-2 col-form-label" for="time">Time:</label> 
					<div class="col-10">
						<form:input class="form-control" id="time" path="time"/>
					</div>
				</div>
					<div class="form-group row">
					<div class="col-10 mr-left">
					<button class="btn btn-sm btn-outline-success">Save</button>
					<a class="btn btn-sm btn-outline-success" href = "/admin/open_close/cancel<custom:allParams/>">Cancel</a>
					</div>
					</div>
				</form:form>
			</div>
		</div>
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Time</th>
					<th class = "text-center">Option</th>
				</tr>
					<c:forEach var="open_close"  items="${opens.content}">
				<tr>
					<td>${open_close.time}</td>
					<td>
					<a href = "/admin/open_close/update/${open_close.id}"  class="btn btn-outline-danger btn-sm">Update</a>
					<a href = "/admin/open_close/delete/${open_close.id}" class="btn btn-outline-warning btn-sm">Delete</a>
					</td>
				</tr>
					</c:forEach>
			</table>
		</div>
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
 						<custom:size posibleSizes="1,2,5,10" size="${opens.size}" />
 					</div>
				</div>
 			</div>
		</div>
	<div class="row">
 			<div class="col-12 text-center">
 				<custom:pageable page="${opens}"/>
 			</div>
 		</div>

</body>
</html>