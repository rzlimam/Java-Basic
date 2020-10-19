package day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	private final String url = "jdbc:postgresql://localhost:5432/IndomaretDB";
	private final String username = "postgres";
	private final String password = "postgres";
	private Connection connection = null;
	
	public Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			if(connection != null)
				return connection;
		} catch (SQLException e) {
			System.out.println("Koneksi gagal "+e.getMessage());
			return null;
		}
		return null;
		
	}
	
	public void closeConnection() {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Connection cant close");
			}
	}

}
