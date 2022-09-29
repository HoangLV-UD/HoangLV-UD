<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IT16306-ListAccounts</title>
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
	<c:if test="${ empty data }">
		<p class="alert alert-warning">Không có dữ liệu</p>
	</c:if>
	<c:if test="${ !empty data }">
		<!-- <div class="row m-2">
		<a href="/su22_SOF3021_IT16306/admin/accounts/create" 
			class=" btn btn-primary"> Thêm </a>
	</div> -->

		<form:form method="POST"
			action="/su22_SOF3021_IT16306/admin/accounts/store"
			modelAttribute="account">
			<section class="vh-70" style="background-color: #508bfc;">
				<div class=" py-5 h-100">

					<div
						class="row d-flex justify-content-center align-items-center h-100">

						<div class="col-12 col-md-8 col-lg-6 col-xl-5">
							<div class="card shadow-2-strong" style="border-radius: 1rem;">
								<div class="card-body p-5 text-center">
									<div>
										<label class="form-label">Full Name</label>
										<form:input path="fullname" type="text"
											class="form-control form-control-lg" />
										<form:errors path="fullname" class="text-danger"
											style="color: red" />
									</div>
									<div>
										<label class="form-label">Email</label>
										<form:input path="email" type="email"
											class="form-control form-control-lg" />
										<form:errors path="email" class="text-danger"
											style="color: red" />
										</div>
									<div>
										<label class="form-label">Username</label>
										<form:input path="username" type="text"
											class="form-control form-control-lg" />
										<form:errors path="username" class="text-danger"
											style="color: red" />
									</div>
									<div>
										<label class="form-label">Password</label>
										<form:password path="password"
											class="form-control form-control-lg" />
										<form:errors path="password" class="text-danger"
											style="color: red" />
									</div>
									<div>
										<label class="form-label">Photo</label>
										<form:input path="photo" type="file"
											class="form-control form-control-lg" />
										<form:errors path="photo" class="text-danger"
											style="color: red" />
									</div>
									<div>
										<label class="form-label">Admin</label>
										<form:select path="admin" class="form-control form-control-lg">
											<form:option value="0">Member</form:option>
											<form:option value="1">Admin</form:option>
										</form:select>
									</div>
									<button class="btn btn-primary btn-lg btn-block m-2">Thêm
										Mới</button>

								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</form:form>

		<table class="table table-secondary m-2">
			<thead>
				<tr>
					<th>ID</th>
					<th>Fullname</th>
					<th>Username</th>
					<th>Email</th>
					<th>Photo</th>
					<th>Activated</th>
					<th>Role</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ data.content }" var="acc">
					<tr>
						<td>${ acc.id }</td>
						<td>${ acc.fullname }</td>
						<td>${ acc.username }</td>
						<td>${ acc.email }</td>
						<td><img src="${ acc.photo }" /></td>
						<td>${ acc.activated == 0 ? "Not Active" : "Active" }</td>
						<td>${ acc.admin == 1 ? "Admin" : "Member" }</td>
						<td><a
							href="/su22_SOF3021_IT16306/admin/accounts/edit/${acc.id}"
							class="btn btn-primary">Update</a></td>
						<td>
							<%-- <a href="/su22_SOF3021_IT16306/admin/accounts/delete/${ acc.id }"  class="btn btn-danger">Delete</a></td> --%>
							<button type="button" class="btn btn-danger"
								data-bs-toggle="modal"
								data-bs-target="#exampleModal_dl_${ acc.id }">Xóa</button> <!-- Modal -->
							<div class="modal fade" id="exampleModal_dl_${ acc.id }"
								tabindex="-1" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title text-danger fs-2 "
												id="exampleModalLabel">Nguy Hiểm</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">Bạn Có Muốn Xóa Account Này
											Không?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Thoát</button>
											<a class="btn btn-danger"
												href="/su22_SOF3021_IT16306/admin/accounts/delete/${ acc.id }"
												role="button">Xóa</a>
										</div>
									</div>
								</div>
							</div>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="row m-2">
			<ul class="pagination">
				<c:forEach var="i" begin="0" end="${ data.totalPages - 1 }">
					<li class="page-item"><a class="page-link"
						href="/su22_SOF3021_IT16306/admin/accounts/index?page=${ i }">
							${ i + 1 } </a></li>
				</c:forEach>
			</ul>
		</div>
	</c:if>

	<script src="/su22_SOF3021_IT16306/js/jquery.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/popper.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/bootstrap.min.js"></script>
</body>
</html>
