package kulkov.JavaCore;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	private static Connection connection;
	
	private static void connect()   {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
