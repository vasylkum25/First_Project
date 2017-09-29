<%@ include file="header.jsp"%>
<div class = "container">
		<div class="row">
			<div class="col-12 mt-3">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Number</th>
						<th class="text-center">People</th>
						<th class="text-center">Free</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">Reserve</th>
					</tr>
					<c:forEach var="table" items="${tables.content}">
						<tr>
							<td>${table.number}</td>
							<td>${table.countOfPeople}</td>
							<td>${table.isFree}</td>
							<td><a href="/cafe/${table.cafe.id}">${table.cafe.name}</a></td>
			<c:if test="${table.isFree.equals(true)}">
							<td><button class="btn btn-outline-danger btn-sm">Reserve</button> 
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