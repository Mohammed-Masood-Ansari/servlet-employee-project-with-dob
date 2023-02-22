package com.netxs.Employee_Management.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netxs.Employee_Management.dto.Employee;
import com.netxs.Employee_Management.service.EmployeeService;
@WebServlet("/employeeInsert")
public class EmployeeController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		
		String address=req.getParameter("address");
		String gender=req.getParameter("gender");
		
		//dob taking from frontend
		String dob=req.getParameter("dob").toString();
		
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		PrintWriter printWriter=resp.getWriter();
		
		printWriter.write("<html><body>");
		
		Employee employee=new Employee();
		employee.setEmployeeId(id);
		employee.setName(name);
		employee.setDob(dob);
		employee.setAddress(address);
		employee.setGender(gender);
		employee.setSalary(salary);
		
		EmployeeService employeeService=new EmployeeService();
		
		employeeService.insertEmployee(employee);
		
		printWriter.write("<h3>Data Inserted Sucessfully</h3>");
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("empoyeeInsert.jsp");
		dispatcher.include(req, resp);
	}
	
	

}
