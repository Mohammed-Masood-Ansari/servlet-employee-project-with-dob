<%@page import="com.netxs.Employee_Management.dto.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.netxs.Employee_Management.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to employee data</h1>
	
	<%
		EmployeeDao dao = new EmployeeDao();
		List<Employee> employees=dao.displayEmployee();
	%>
	
	<table border="2">
		<tr>
			<th>empId</th>
			<th>empName</th>
			<th>Address</th>
			<th>Gender</th>
			<th>Salary</th>
			<th>Birthday</th>
			<th>Delete</th>
		</tr>
		<%for(Employee employee:employees){%>
			<tr> 
				<td><%=employee.getEmployeeId()%></td>
				<td><%=employee.getName()%></td>
				<td><%=employee.getAddress()%></td>
				<td><%=employee.getGender()%></td>
				<td><%=employee.getSalary()%></td>
				<td><%=employee.getDob()%></td>
				<td><a href="deleteEmployee?id=<%=employee.getEmployeeId()%>">Delete</a></td>
			</tr>
	<%}%> 
	</table>
</body>
</html>