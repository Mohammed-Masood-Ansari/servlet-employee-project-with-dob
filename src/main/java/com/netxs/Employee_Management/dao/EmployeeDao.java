package com.netxs.Employee_Management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.netxs.Employee_Management.connection.EmployeeConnection;
import com.netxs.Employee_Management.dto.Employee;

public class EmployeeDao {
	
	public void insertEmployee(Employee employee)
	{
		System.out.println(employee.getDob());
		Date dob=null;
		java.sql.Date date = null;
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			dob = formatter.parse(employee.getDob());
			date= new java.sql.Date(dob.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/employee-management";
			String user="root";
			String pass="root";
			Connection connection=DriverManager.getConnection(url,user,pass);
			
			String insert="insert into employee values("+employee.getEmployeeId()+",'"+employee.getName()+"','"+employee.getAddress()+"','"+employee.getGender()+"',"+employee.getSalary()+",'"+date+"')";
			Statement statement=connection.createStatement();
			statement.execute(insert);
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public List<Employee> displayEmployee()
	{
		Connection connection=EmployeeConnection.getConnection();
		
		
		
		try {
			
			Statement statement=connection.createStatement();
			
			String select="select * from employee";
			
			ResultSet resultSet=statement.executeQuery(select);
			
			List<Employee> employees=new ArrayList<Employee>();
			
			while(resultSet.next())
			{
				Employee employee=new Employee();
				
				java.sql.Date date = resultSet.getDate("employeeDob");
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				String myDob = dateFormat.format(date);
				
				employee.setEmployeeId(resultSet.getInt("employeeId"));
				employee.setName(resultSet.getString("employeeName"));
				employee.setAddress(resultSet.getString("employeeAddress"));
				employee.setGender(resultSet.getString("employeeGender"));
				employee.setDob(myDob);
				employee.setSalary(resultSet.getDouble("employeeSalary"));
				
				employees.add(employee);
			}
			return employees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteEmployee(int id)
	{
		Connection connection=EmployeeConnection.getConnection();
		
		String delete="delete from employee where employeeId="+id+"";
		
		try {
			Statement statement=connection.createStatement();
			int id1=statement.executeUpdate(delete);
			if(id1!=0)
			{
				System.out.println("Data is deleted");
			}
			else
			{
				System.out.println("Data is not deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
