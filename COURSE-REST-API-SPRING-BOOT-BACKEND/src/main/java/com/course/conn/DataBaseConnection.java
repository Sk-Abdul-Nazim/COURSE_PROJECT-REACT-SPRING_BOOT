package com.course.conn;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseConnection {
	
	private static String JDBC_MYSQL_Class = "com.mysql.jdbc.Driver";
	private static String JDBC_MYSQL_DATABASE = "jdbc:mysql://localhost:3306/CourseDemoReact";
	private static String JDBC_MYSQL_Username = "root";
	private static String JDBC_MYSQL_Password = "root";
	private static Driver driver = null;
	public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
	
		Connection con = null;
		
		
		Class<?> jdbcClass = Class.forName(JDBC_MYSQL_Class);
		
		driver = (Driver) jdbcClass.newInstance();
		
		DriverManager.registerDriver(driver);
		
		con = DriverManager.getConnection(JDBC_MYSQL_DATABASE, JDBC_MYSQL_Username, JDBC_MYSQL_Password);
		
		con.setAutoCommit(false);
	try { 
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return con;
	
  }
	
public static void close(Connection conn){	
		
		try {
			if (conn != null){
				conn.close();
			}

		} catch (SQLException e) {
			 e.printStackTrace();
		}
		
		
	}
	/*
	 * close the PreparedStatement 
	 * 
	 */
	public static void close(PreparedStatement stmt){
		try {

			if (stmt != null){
				stmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	/*
	 * close the ResultSet 
	 * 
	 */
	public static void close(ResultSet rs) {		 
		
		try {

			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			 e.printStackTrace();
		}		 
	}
	/*
	 * close the Statement 
	 * 
	 */
	public static void close(Statement stmt){		 
		try {

			if (stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/*
	 * used for rollback  
	 * 
	 */
	public static void rollBack(Connection conn)   {		  
	
		try {if (conn != null){
			conn.rollback();
		}
		} catch (SQLException e) {
			 e.printStackTrace();
			
			
		}
	}
	/*
	 *  commit the connection
	 * 
	 */
	public static void commit(Connection conn)  {
		
		try {

			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
