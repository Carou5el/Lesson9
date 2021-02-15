package kulkov.JavaCore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	static Connection connection;
	
	// Methods.
	public static void connect()    {
		try {
			// Регистрация JDBC-драйвера.
			Class.forName("org.sqlite.JDBC");
			// Подключение к БД.
			connection = DriverManager.getConnection("jdbc:sqlite:Cats.db");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB driver isn't register.");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	public static void close() throws SQLException {
		connection.close();
	}
}
