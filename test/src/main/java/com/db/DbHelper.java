package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private String password, url, userName, port;
	private Connection con;
	private static DbHelper helperInstance = null;
	
	/**
	 * Helper(url,portNo,Username,password)
	 * 
	 * @param url
	 * @param port
	 * @param userName
	 * @param password
	 */
	private DbHelper(String url, String port, String userName, String password) {

		this.url = url;
		this.port = port;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * getInstance(url,portNo,Username,password)
	 * 
	 * @param url
	 * @param port
	 * @param userName
	 * @param password
	 * @return
	 */
	public static DbHelper getInstance(String url, String port, String userName, String password) {
		if (helperInstance == null) {
			helperInstance = new DbHelper(url, port, userName, password);
		}
		return helperInstance;
	}

	/**
	 * connect(String dataBaseName)
	 * 
	 * @param db
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection Connect(String db) throws ClassNotFoundException, SQLException {
		if (con == null || con.isClosed()) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url + port + "/" + db, userName, password);
		}
		return con;
	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException {
		con.close();
	}
}