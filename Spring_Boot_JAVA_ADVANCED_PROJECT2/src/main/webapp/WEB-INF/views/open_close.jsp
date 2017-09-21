<%@ include file="header.jsp"%>

<div class = "container">
<div class="row" >
			<div class = "col-12">
				<form:form action="/admin/open_close" method="POST" modelAttribute="open_close">
				<div class="form-group row">
					<label class="col-2 col-form-label" for="time">Time:</label> 
					<div class="col-10">
						<form:input class="form-control" id="time" path="time"/>
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
	<div class="row" >
		<div class = "col-12">
			<table class= "table table-bordered">
				<tr>
					<th class = "text-center">Time</th>
					<th class = "text-center">Option</th>
				</tr>
					<c:forEach var="open_close"  items="${opens}">
				<tr>
					<td>${open_close.time}</td>
					<td>
					<a href = "/admin/open_close/update/${open_close.id }"  class="btn btn-outline-danger btn-sm">Update</a>
						<a href = "/admin/open_close/delete/${open_close.id }" class="btn btn-outline-warning btn-sm">Delete</a>
					</td>
				</tr>
					</c:forEach>
			</table>
		</div>
	
	</div>
</div>
</body>
</html>