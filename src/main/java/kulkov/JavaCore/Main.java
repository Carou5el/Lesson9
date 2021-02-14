package kulkov.JavaCore;

/*
	Создать класс кота
	Создать в бд таблицу с котами
		Поля таблицы.
		id  name    color(?)
		
	Написать метод извлечения котов
	Метод добавления котов
	Метод удаления котов
	Метод изменения котов
 */

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	private static Connection connection;
	
	public static void main(String[] args) throws SQLException {
		
		DataBase.connect();
		Statement statement = connection.createStatement();
		
	}
}
