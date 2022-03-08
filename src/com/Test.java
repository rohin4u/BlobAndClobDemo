package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
		
		String driver="oracle.jdbc.OracleDriver";
		Class.forName(driver);
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="password";
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		
		String sqlQuery="insert into persons values(?,?)";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setString(1,"Katrina");
		
		File f = new File("F://image1.jpg");
		FileInputStream fis = new FileInputStream(f);
		ps.setBinaryStream(2,fis);
		System.out.println("inserting image from :"+f.getAbsolutePath());
		int updateCount=ps.executeUpdate();
		if(updateCount==1)
		{
			System.out.println("Record Inserted");
		}
		else
		{
			System.out.println("Record Not Inserted");
		}
			
	
	}
}

	

