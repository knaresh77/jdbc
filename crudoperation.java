package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class crudoperation {
	private static String Driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String password = "root";
    public static void main(String[] args) {
		int ch;
    	do {
    		System.out.println("crud operations");
    		System.out.println("*******************");
			display();
			Scanner scr = new Scanner(System.in);
			System.out.println("enter your choice");
			ch= Integer.parseInt(scr.next());
			System.out.println("*******************");
			
			switch(ch) {
			case 1 :
				createdb();
				break;
			case 2 :
				dropdb();
				break;
			case 3 :
				createtable();
				break;
			case 4 :
				droptable();
				break;
			case 5 :
				insert();
				break;
			case 6 :
				update();
				break;
			case 7 :
				delete();
				break;
			case 8 :
				getall();
				break;
			case 9 :
				getbyid();
				break;
			case 10 :
				System.exit(0);
				break;
				default:
					System.out.println("invalid");
					break;
			}
		} while (ch>0);
	}

	private static void getbyid() {
		 try {
			  Scanner scr = new Scanner(System.in);
			  System.out.println("enter database name :");
			  String url ="jdbc:mysql://localhost:3306/"+scr.next();
			  Class.forName(Driver);
			  
			  Connection conn = DriverManager.getConnection(url, user, password);
			  System.out.println("enter table name :");
			  String sql = "select * from "+ scr.next()+" where id=?";
			  PreparedStatement pmst = conn.prepareStatement(sql);
			  System.out.println("enter your id :");
			  pmst.setInt(1, scr.nextInt());
			  ResultSet rs = pmst.executeQuery();
		      while (rs.next()) {
				System.out.println("**********************");
			    System.out.println("Id    : " +rs.getInt("id"));
				System.out.println("Name  : " +rs.getString("name"));
				System.out.println("Email : " +rs.getString("email"));
			}
			conn.close();
			pmst.close();
			  } catch (Exception e) {
			e.printStackTrace();
		
			
		}
		
	}

	private static void getall() {
		 try {
			  Scanner scr = new Scanner(System.in);
			  System.out.println("enter database name :");
			  String url ="jdbc:mysql://localhost:3306/"+scr.next();
			  Class.forName(Driver);
			  
			  Connection conn = DriverManager.getConnection(url, user, password);
			  System.out.println("enter table name :");
			  String sql = "select * from "+ scr.next();
			  PreparedStatement pmst = conn.prepareStatement(sql);
			  ResultSet rs = pmst.executeQuery();
		     while (rs.next()) {
		    	 System.out.println("**********************");
					System.out.println("Id    : " +rs.getInt("id"));
					System.out.println("Name  : " +rs.getString("name"));
					System.out.println("Email : " +rs.getString("email"));
			}
			conn.close();
			pmst.close();
			  } catch (Exception e) {
			e.printStackTrace();
		
			
		}
		
	}

	private static void delete() {
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

	private static void update() {

		  try {
			  Scanner scr = new Scanner(System.in);
			  System.out.println("enter database name :");
			   String url ="jdbc:mysql://localhost:3306/"+scr.next();
			  Class.forName(Driver);
			  
			  Connection conn = DriverManager.getConnection(url, user, password);
			  System.out.println("enter table  name :");
			  String sql = "update  "+scr.next()+" set name =? ,email=? where id=?";
			  PreparedStatement pmst = conn.prepareStatement(sql);
			  System.out.println("enter name :");
			  pmst.setString(1, scr.next());
			  System.out.println("enter email :");
			  pmst.setString(2, scr.next());
			  System.out.println("enter id :");
			  pmst.setInt(3, scr.nextInt());
			int i=  pmst.executeUpdate();
			if (i>0) {
				System.out.println("table updated sucessfully");
			}else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			  } catch (Exception e) {
			e.printStackTrace();
		
			
		}
		
	}

	private static void insert() {

		  try {
			  Scanner scr = new Scanner(System.in);
			  System.out.println("enter database name :");
			  String url ="jdbc:mysql://localhost:3306/"+scr.next();
			  Class.forName(Driver);
			  
			  Connection conn = DriverManager.getConnection(url, user, password);
			  System.out.println("enter table name :");
			  String sql = "insert into "+ scr.next() + "(id,name,email) values(?,?,?)";
			  PreparedStatement pmst = conn.prepareStatement(sql);
			  System.out.println("enter  your id :");
			  pmst.setInt(1, scr.nextInt());
			  System.out.println("enter  your name :");
			  pmst.setString(2, scr.next());
			  System.out.println("enter  your email :");
			  pmst.setString(3, scr.next());
			int i=  pmst.executeUpdate();
			if (i>0) {
				System.out.println("inserted successfully");
			}else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			  } catch (Exception e) {
			e.printStackTrace();
		
			
		}
		
	}

	private static void droptable() {
		 try {
			  Scanner scr = new Scanner(System.in);
			  System.out.println("enter database name :");
			  String url ="jdbc:mysql://localhost:3306/"+scr.next();
			  Class.forName(Driver);
			  
			  Connection conn = DriverManager.getConnection(url, user, password);
			  System.out.println("enter table name :");
			  String sql = "drop table "+ scr.next() ;
			  PreparedStatement pmst = conn.prepareStatement(sql);
			int i=  pmst.executeUpdate();
			if (i==0) {
				System.out.println("table  deleted");
			}else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			  } catch (Exception e) {
			e.printStackTrace();
		
			
		}
	}

	private static void createtable() {
		 try {
			  Scanner scr = new Scanner(System.in);
			  System.out.println("enter database name :");
			  String url ="jdbc:mysql://localhost:3306/"+scr.next();
			  Class.forName(Driver);
			  
			  Connection conn = DriverManager.getConnection(url, user, password);
			  System.out.println("enter table name :");
			  String sql = "create table "+ scr.next() + "(id int,name varchar(20),email varchar(30))";
			  PreparedStatement pmst = conn.prepareStatement(sql);
			int i=  pmst.executeUpdate();
			if (i==0) {
				System.out.println("table  created");
			}else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			  } catch (Exception e) {
			e.printStackTrace();
		
			
		}
	
		
	}

	private static void dropdb() {
		 try {
			  Scanner scr = new Scanner(System.in);
			  String url ="jdbc:mysql://localhost:3306/";
			  Class.forName(Driver);
			  
			  Connection conn = DriverManager.getConnection(url, user, password);
			  System.out.println("enter database name :");
			  String sql = "drop database "+scr.next();
			  PreparedStatement pmst = conn.prepareStatement(sql);
			int i=  pmst.executeUpdate();
			if (i==0) {
				System.out.println("database deleted");
			}else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			  } catch (Exception e) {
			e.printStackTrace();
		
		}
	
		
		
	}

	private static void createdb() {
		 try {
			  Scanner scr = new Scanner(System.in);
			  String url ="jdbc:mysql://localhost:3306/";
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

	private static void display() {
		System.out.println("\t1.create database ");
		System.out.println("\t2.drop database ");
		System.out.println("\t3.create table");
		System.out.println("\t4.drop table");
		System.out.println("\t5.Insertion ");
		System.out.println("\t6.update");
		System.out.println("\t7.delete");
		System.out.println("\t8.getall");
		System.out.println("\t9.getby id");
		System.out.println("\t10.exit");
	}
}
