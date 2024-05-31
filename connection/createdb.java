package connection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createdb {
	private static String Driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String password = "root";
	private static String url ="jdbc:mysql://localhost:3306/";
   public static void main(String[] args) {
	
	  try {
		  Scanner scr = new Scanner(System.in);
		  
		  Class.forName(Driver);
		  
		  Connection conn = DriverManager.getConnection(url, user, password);
		  System.out.println("enter database name :");
		  String sql = "create database "+scr.next();
		  PreparedStatement pmst = conn.prepareStatement(sql);
		int i=  pmst.executeUpdate();
		if (i>0) {
			System.out.println("database created");
		}else {
			System.out.println("error");
		}
		conn.close();
		pmst.close();
		  } catch (Exception e) {
		e.printStackTrace();
	
	}
}
}
