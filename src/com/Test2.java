package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		String driver="oracle.jdbc.OracleDriver";
		Class.forName(driver);
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="password";
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		
		PreparedStatement ps = con.prepareStatement("select * from persons");
		ResultSet rs =ps.executeQuery();
		FileOutputStream os = new FileOutputStream("katrina_sat.jpeg");
		if(rs.next())
		{
		String name=rs.getString(1);
		InputStream is = rs.getBinaryStream(2);
		byte[] buffer = new byte[2048];
		while(is.read(buffer)>0)
		{
		os.write(buffer);
		}
		os.flush();
		System.out.println("image is available in :katrina_sat.jpeg");
		}
		con.close();
	
	}
}

	

