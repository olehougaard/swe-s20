package dk.via.sales.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public abstract class DataAccessObject {
	private static String JDBC_URL = "jdbc:postgresql://localhost/postgres?currentSchema=dk.via.sales";
	
	public DataAccessObject() {
	}
	
	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, "postgres", "password");
	}
}
