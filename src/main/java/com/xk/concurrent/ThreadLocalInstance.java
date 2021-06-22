package com.xk.concurrent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalInstance {

	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		protected Connection initialValue() {
			Connection connnection = null;
			try {
				connnection = DriverManager.getConnection("url");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connnection;
		};
	};

	public static Connection getConnectionHolder() {
		return connectionHolder.get();
	}
}
