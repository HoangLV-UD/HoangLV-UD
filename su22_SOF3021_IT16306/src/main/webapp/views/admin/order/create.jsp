<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		action="/su22_SOF3021_IT16306/admin/order/store"
		modelAttribute="order">
		<div>
			<label>Account_id</label>
			<form:select path="user_id">
				<form:options itemLabel="username" itemValue="id" items="${acc}" />
				<form:errors path="user_id" class="text-danger" style="color: red"/>
			</form:select>
		</div>

		<div>
			<label>Date</label>
			<form:input path="create_date" type="date" />
			<form:errors path="create_date" class="text-danger" style="color: red"/>
		</div>

		<div>
			<label>Địa chỉ</label>
			<form:input path="address" />
			<form:errors path="address" class="text-danger" style="color: red"/>
		</div>

		<form:button> Thêm Mới</form:button>

	</form:form>

	<script src="/su22_SOF3021_IT16306/js/jquery.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/popper.min.js"></script>
	<script src="/su22_SOF3021_IT16306/js/bootstrap.min.js"></script>

</body>
</html>