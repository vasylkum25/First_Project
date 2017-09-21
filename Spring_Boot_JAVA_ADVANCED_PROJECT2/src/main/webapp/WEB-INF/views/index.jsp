<%@ include file="header.jsp"%>
<body>
	
	
	<div class="container mt-3">
			<c:forEach var="cafe" items="${topFifse}">
		<div class="row">
			<div class="col-3">
					<h3><a href="/cafe/${cafe.id}">${cafe.name}</a></h3>
					</div>
					<div class="col-9">
					<div class="progress"  style="width: 300px;">
  <div class="progress-bar progress-bar-striped bg-danger" role="progressbar" style="width: ${cafe.rate*10}%" aria-valuenow="${cafe.rate}" aria-valuemin="0" aria-valuemax="10">${cafe.rate}</div>
		</div>
		</div>
			</div>
			
					<h5>${cafe.address}</h5>
					<h5>${cafe.shortDescription}</h5>
					<img src="${cafe.photoUrl}">
			</c:forEach>
<div>
<div class="row align-items-end mt-3">
<a href="/cafe" class="btn btn-outline-danger btn-lg btn-block">Cafes</a>
<a href="/meal" class="btn btn-outline-danger btn-lg btn-block">Meals</a>
</div>
</div>
	</div>
</body>
</html>