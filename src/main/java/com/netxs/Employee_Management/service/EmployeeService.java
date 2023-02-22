package com.netxs.Employee_Management.service;

import java.util.List;

import com.netxs.Employee_Management.dao.EmployeeDao;
import com.netxs.Employee_Management.dto.Employee;

public class EmployeeService {
	
	EmployeeDao dao=new EmployeeDao();
	
	public void insertEmployee(Employee employee)
	{
		dao.insertEmployee(employee);
	}
	public List<Employee> displayEmployee()
	{
		return	dao.displayEmployee();
	}
	public void deleteEmployee(int id)
	{
		dao.deleteEmployee(id);
	}
}
