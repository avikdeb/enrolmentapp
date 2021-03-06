package com.avik.enrolmentapp.manager;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AppDBConnectionMgr {

	private static DataSource dataSource;
	private static Connection connection;
	
	//Private constructor
	private AppDBConnectionMgr() {
		
	}
	
	public static Connection getConnection() {
		
		try {
			
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/enrolmentapp");
			connection = dataSource.getConnection();
					
		} catch(NamingException e) {
			
			e.printStackTrace();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return connection;
	}
	
	public static AppDBConnectionMgr getInstance() {
	
		AppDBConnectionMgr instance = new AppDBConnectionMgr();
		return instance;
	}
	
	public void closeConnection(Connection con) {
		
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
