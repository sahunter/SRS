package util;

import java.sql.*;
import java.io.*;

public class DBUtil {
	private static final long serialVersionUID = 1L;
	
	public static Connection getSqliteConnection(){
		String driver="org.sqlite.JDBC";
		String conStr="jdbc:sqlite:E:/sqlite/SRS.db";
		Connection conn=null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;			
	}
	public static Connection getMysqlConnection(){
		String driver="com.mysql.jdbc.Driver";
		
		String conStr="jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=utf-8&useSSL=false";
		Connection conn=null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;			
	}
}
