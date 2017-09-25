<%@ include file="header.jsp"%>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Number</th>
						<th class="text-center">People</th>
						<th class="text-center">Free</th>
						<th class="text-center">Cafe</th>						
					</tr>
						<tr>
							<td>${tables.number}</td>
							<td>${tables.countOfPeople}</td>
							<td>${tables.isFree}</td>
							<td><a href="/cafe/${tables.cafe.id}">${tables.cafe.name}</a></td>
						</tr>
				</table>
			</div>
		</div>
</body>
</html>