package kulkov.JavaCore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	private static Connection connection;
	
	public static void connect()    {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:Cats.db");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException throwables) {
			
			throwables.printStackTrace();
			
		}
	}
	
	public static void close() throws SQLException {
		
		connection.close();
		
	}
}
