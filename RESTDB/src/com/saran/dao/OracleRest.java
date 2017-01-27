package com.saran.dao;

import java.sql.Connection;

import javax.naming.*;
import javax.sql.*;



public class OracleRest {

	private static DataSource Oracle308tube = null; //hold the database object
	private static Context context = null; //used to lookup the database connection in server
	
	
	private static DataSource Oracle308tubeConn() throws Exception {
		
		/**
		 * check to see if the database object is already defined...
		 * if it is, then return the connection, no need to look it up again.
		 */
		if (Oracle308tube != null) {
			return Oracle308tube;
		}
		
		try {
			
			if (context == null) {
				context = new InitialContext();
			}
			
			Oracle308tube = (DataSource) context.lookup("java:/comp/env/jdbc/Rest");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return Oracle308tube;
		
	}
	
	/**
	 * This method will return the connection to the Oracle 308tube schema
	 * Note that the scope is protected which means only java class in the
	 * dao package can use this method.
	 * 
	 * @return Connection to 308tube Oracle database.
	 */
	protected static Connection oraclePcPartsConnection() {
		Connection conn = null;
		try {
			conn = Oracle308tubeConn().getConnection();
			return conn;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
