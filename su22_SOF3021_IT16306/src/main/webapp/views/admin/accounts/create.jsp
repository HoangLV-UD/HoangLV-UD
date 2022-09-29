<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16306 - Create Account</title>
<link rel="stylesheet"
	href="/su22_SOF3021_IT16306/css/bootstrap.min.css" />
</head>
<body>
	<c:if test="${!empty sessionScope.error }">
		<div class=" alert alert-danger">${ sessionScope.error }</div>
		<c:remove var="error" scope="session" />
	</c:if>

<c:if test="${!empty sessionScope.message }">
			<div class=" alert alert-success">${ sessionScope.message }</div>
			<c:remove var="message" scope="session" />
		</c:if>


	<form:form method="POST"
		action="/su22_SOF3021_IT16306/admin/accounts/store"
		modelAttribute="account">
		
		<section class="vh-100" style="background-color: #508bfc;">
			<div class=" py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<div>
									<label class="form-label">Full Name</label>
									<form:input path="fullname" type="text" class="form-control form-control-lg" />
									<form:errors path="fullname" class="text-danger"
										style="color: red;" ></form:errors>
								</div>
								<div>
									<label class="form-label">Email</label>
									<form:input path="email" type="email"
										class="form-control form-control-lg" />
									<form:errors path="email" class="text-danger"
										style="color: red;"></form:errors>
								</div>
								<div>
									<label class="form-label">Username</label>
									<form:input path="username" type="text"
										class="form-control form-control-lg" />
									<form:errors path="username" class="text-danger"
				style="color: red;"></form:errors>
		</div>
								</div>
								<div>
									<label class="form-label">Password</label>
									<form:password path="password"
										class="form-control form-control-lg" />
									<form:errors path="password" class="text-danger"
				style="color: red;"></form:errors>
								</div>
								<div>
									<label class="form-label">Photo</label>
									<form:input path="photo" type="file"
										class="form-control form-control-lg" />
									<form:errors path="photo" class="text-danger"
				style="color: red;"></form:errors>
								</div>
								<div>
									<label class="form-label">Admin</label>
									<form:select path="admin" class="form-control form-control-lg">
										<form:option value="0">Member</form:option>
										<form:option value="1">Admin</form:option>
									</form:select>
								</div>
								<button class="btn btn-primary btn-lg btn-block m-2">Save</button>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form:form>

	<script src="/su22_SOF3021_IT16306/js/jquery.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/popper.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/bootstrap.min.js"></script>
</body>
</html>