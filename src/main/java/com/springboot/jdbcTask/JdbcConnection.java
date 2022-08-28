package com.springboot.jdbcTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {


		private static JdbcConnection connect;
		private static String url;
		private static String username;
		private static String password;
		private static String driver;

		private JdbcConnection() {
			url = "jdbc:mysql://localhost:3307/finzly_developerscourse";
			username = "root";
			password = "3244";
			driver = "com.mysql.cj.jdbc.Driver";
		}
		public static Connection getConnection() {
			try {
				connect = new JdbcConnection();
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, username, password);
				return con;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
