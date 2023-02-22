<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="employeeInsert">
	<lable>id</lable>
	<input type="text" name="id" placeholder="Enter Employee Id"><br><br>
	<lable>Name</lable>
	<input type="text" name="name" placeholder="Enter Employee Name"><br><br>
	<lable>Birthday</lable>
	<input type="text" name="dob" placeholder="Enter Employee DOB"><br><br>
	<lable>Address</lable>
	<input type="text" name="address" placeholder="Enter Employee Address"><br><br>
	<lable>Gender</lable><br>
	<lable>Male</lable>
	<input type="radio" name="gender" value="male">&nbsp;
	<lable>Female</lable>
	<input type="radio" name="gender" value="female"><br><br>
	<lable>Salary</lable>
	<input type="text" name="salary" placeholder="Enter Employee Salary"><br><br>
	<input type="submit" value="register">
	</form>
</body>
</html>