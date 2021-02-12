package kulkov.JavaCore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	private static Connection connection;
	
	public static void connect()   {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:lesson.db");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
