<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty sessionScope.error }">
		<div class=" alert alert-danger">
			${ sessionScope.error } 
		</div>
		<c:remove var="error" scope="session"/>
	</c:if>

 <c:if test="${!empty sessionScope.message }">
	<div class=" alert alert-success">
		${ sessionScope.message } 
	</div>
<c:remove var="message" scope="session"/>
</c:if> 
	<form:form method="POST" action="/su22_SOF3021_IT16306/admin/orderdetail/store"
		modelAttribute="orderdetail">

		<div>
			<label>order_id</label>
			<form:select path="order_id">
				<form:options itemLabel="address" itemValue="id" items="${oder}" />
			</form:select>
		</div>

		<div>
			<label>product_id</label>
			<form:select path="product_id">
				<form:options itemLabel="name" itemValue="id" items="${product}" />
			</form:select>
		</div>

		<div>
			<label>Price</label>
			<form:input path="price" />
		</div>

		<div>
			<label>quantity</label>
			<form:input path="quantity" />
		</div>



		<button>Thêm mới</button>

	</form:form>
</body>
</html>