package br.com.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbcDriver());
			return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb","sa","");
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
// create table CALOTEIRO (id int GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1) PRIMARY KEY, nome varchar(50), email varchar(50), devendo int, datadivida DATE);