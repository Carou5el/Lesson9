package kulkov.JavaCore;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	private static Connection connection;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		DataBase.connect();
	}
	
	static void connect() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:lesson.db");
	}
	
}
