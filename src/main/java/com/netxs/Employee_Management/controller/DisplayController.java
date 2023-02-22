package com.netxs.Employee_Management.controller;

import com.netxs.Employee_Management.dao.EmployeeDao;
import com.netxs.Employee_Management.dto.Employee;

public class DisplayController {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		
		
		for(Employee employee:dao.displayEmployee()) {
			System.out.println(employee.getGender());
		}
	}
}
