package com.netxs.Employee_Management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netxs.Employee_Management.service.EmployeeService;

@WebServlet("/deleteEmployee")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		EmployeeService employeeService=new EmployeeService();
		employeeService.deleteEmployee(id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("employeedisplay.jsp");
		dispatcher.forward(req, resp);
	}

}
