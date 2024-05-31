package connection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {
	private static String Driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String password = "root";
	
   public static void main(String[] args) {
	
	  try {
		  Scanner scr = new Scanner(System.in);
		  System.out.println("enter database name :");
		  String url ="jdbc:mysql://localhost:3306/"+scr.next();
		  Class.forName(Driver);
		  
		  Connection conn = DriverManager.getConnection(url, user, password);
		  System.out.println("enter table name :");
		  String sql = "delete from "+ scr.next() + " where id = ?";
		  PreparedStatement pmst = conn.prepareStatement(sql);
		  System.out.println("enter  your id :");
		  pmst.setInt(1, scr.nextInt());
		 
		int i=  pmst.executeUpdate();
		if (i>0) {
			System.out.println("deleted successfully");
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
