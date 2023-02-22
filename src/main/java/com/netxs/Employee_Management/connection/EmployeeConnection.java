package com.netxs.Employee_Management.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class EmployeeConnection {
	
	public static Connection getConnection()
	{
		try {
			Driver driver = new Driver();
			
			DriverManager.registerDriver(driver);
			
			String url="jdbc:mysql://localhost:3306/employee-management";
			String user="root";
			String pass="root";
			
			Connection connection=DriverManager.getConnection(url,user,pass);
			if(connection!=null)
			{
				return connection;
			}
			else
			{
				System.out.println("Please enter valid enter id & pass");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
