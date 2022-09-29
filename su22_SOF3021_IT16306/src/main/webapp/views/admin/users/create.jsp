<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<form:form method="POST"
				modelAttribute="user" 
				action="/su22_SOF3021_IT16306/admin/users/store">
				<div>
					<label>Ho Ten</label>
					<form:input path="hoTen" name="hoTen"/>
					<form:errors path="hoTen" class="text-danger" style="color: red"/>
				</div>
				<div>
					<label>Dia Chi</label>
					<form:input path="diaChi" name="diaChi"/>
					<form:errors path="diaChi" class="text-danger" style="color: red"/>
				</div>
				<div>
					<label>Gioi Tinh</label>
					<form:radiobutton path="gioiTinh" name="gioiTinh" value="1" label="Nam"/>
					<form:radiobutton path="gioiTinh" name="gioiTinh" value="0" label="Nu"/>
				</div>
				
				<div>
					<label>email</label>
					<form:input path="email" name="email" type="email"/>
					<form:errors path="email" class="text-danger" style="color: red"/>
				</div>	
				<div>
					<label>Password</label>
					<form:password path="password" name="password"/>
					<form:errors path="password" class="text-danger" style="color: red"/>
				</div>
				<div>
					<label>SDT</label>
					<form:input path="sdt" name="sdt"/>
					<form:errors path="sdt" class="text-danger" style="color: red"/>
				
				</div>
				<div>
					<label>Avatar</label>
					<form:input path="avatar" name="avatar"/>
					<form:errors path="avatar" class="text-danger" style="color: red"/>
				</div>
				<form:button> submit</form:button>
	</form:form>
	
</body>
</html>