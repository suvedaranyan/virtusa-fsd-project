package com.yrrhelp.dbconn;

import java.util.*;

import com.yrrhelp.models.Product;

import java.sql.*;

public class Dbconn 
{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/gstbilling";
	static final String USER = "root";
	static final String PASS = "";
	static Scanner sc=new Scanner(System.in);
	
    //Extract data from database
	public static List<Product> extract() throws SQLException
	{
		Connection conn = getDbConn();
		Statement stmt = conn.createStatement();
	    String sql;
	    sql = "SELECT ID, Name, Price, GST FROM Products";
	    ResultSet rs = stmt.executeQuery(sql);
	    List<Product> listOfProducts = new ArrayList<>();
	    while(rs.next())
	    {
		    String id  = rs.getString("ID");
		    String name = rs.getString("Name");
		    Double price = rs.getDouble("Price");
		    Integer gst = rs.getInt("GST");
		    Product p = new Product(id, name, price, gst);
		    System.out.print("ID: " + id);
		    System.out.print(", Name: " + name);
		    System.out.print(", Price: " + price);
		    System.out.println(", GST: " + gst);
		    listOfProducts.add(p);
	    }
	    return listOfProducts;
	}
	
	//Edit data from database
	public static void edit(Integer id, Double price, Integer gst) throws SQLException
	{
		Connection conn = getDbConn();
		Statement stmt = conn.createStatement();
	    String sql;
	    sql = "SELECT Name, Price, GST FROM Products WHERE ID="+id;
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next())
	    {
		    String name = rs.getString("Name");
		    int price_old = rs.getInt("Price");
		    int gst_old = rs.getInt("GST");
		    System.out.print("ID: " + id);
		    System.out.print(", Name: " + name);
		    System.out.print(", Price: " + price_old);
		    System.out.println(", GST: " + gst_old);
	    }
//	    System.out.print("Enter price to be edited");
//	    int price=sc.nextInt();
//	    System.out.print("Enter gst to be edited");
//	    int gst=sc.nextInt();
	    sql = "UPDATE Products SET Price=\'"+price+"\', GST=\'"+gst+"\' WHERE ID=\'"+id+"\'";
	    stmt.executeUpdate(sql);
	}
	
	//Add data from database
	public static void add(String name, Double price, Integer gst) throws SQLException
	{
		Connection conn = getDbConn();
		Statement stmt = conn.createStatement();
	    String sql;
	    sql = "SELECT MAX(ID) AS max FROM Products";
	    ResultSet rs = stmt.executeQuery(sql);
	    rs.next();
	    int id=rs.getInt("max")+1;
//	    System.out.print("\nEnter name to be added: ");
//	    String name=sc.next();
//	    System.out.print("Enter price to be added: ");
//	    int price=sc.nextInt();
//	    System.out.print("Enter gst to be added: ");
//	    int gst=sc.nextInt();
	    sql = "INSERT INTO Products VALUES(\'"+id+"\',\'"+name+"\',\'"+price+"\',\'"+gst+"\')";
	    stmt.executeUpdate(sql);
	}
	
	//Delete data from database
	public static void delete(Integer id) throws SQLException
	{
		Connection conn = getDbConn();
		Statement stmt = conn.createStatement();
	    String sql;
	    sql = "DELETE FROM Products WHERE ID="+id;
	    stmt.executeUpdate(sql);
	}
	
	public static Connection getDbConn() 
	{
		Connection conn = null;
		try
		{
			
			Class.forName(JDBC_DRIVER);
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    
		    //Extract data from database
//		    extract(conn);
		    
		    //Edit data from database
//		    System.out.print("Enter ID to be edited");
//		    int id=sc.nextInt();
//		    edit(conn,id);
		    
		    //Add data from database
//		    add(conn);
		    
		    //Delete data from database
//		    System.out.print("\nEnter ID to be deleted");
//		    id=sc.nextInt();
//		    delete(conn,id);
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}
}

