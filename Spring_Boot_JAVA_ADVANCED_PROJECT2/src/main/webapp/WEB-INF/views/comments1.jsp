<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:forEach var="comment" items="${comments}">
<c:set var="comments" value="${comment.childComment}" scope="request"/>
	<div class="row mt-2 ml-3">
		<div class="col">
			<span class="text-primary font-weight-bold font-italic"><i class="fa fa-user-circle" aria-hidden="true"></i> ${comment.user}</span>
			<span class="text-dark small font-italic ml-3"><i class="fa fa-clock-o" aria-hidden="true"></i> ${comment.time}</span>
			<a class="text-dark ml-3" data-toggle="collapse" href="#collapseExample${comment.id}" aria-expanded="false" aria-controls="collapseExample${comment.id}"><i class="fa fa-pencil" aria-hidden="true"></i> <u>to comment</u></a>
			<div>${comment.message}</div>
			<div class="mt-2 mb-2 collapse" id="collapseExample${comment.id}">
				<div class="card card-body">
					<form:form action="/meal/${oneMeal.id}/${comment.id}" method="POST" modelAttribute="commentToComment">
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
			<jsp:include page="comments1.jsp"/>
		</div>
	</div>
</c:forEach>