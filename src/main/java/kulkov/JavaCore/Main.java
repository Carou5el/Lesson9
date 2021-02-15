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
import java.sql.*;

public class Main {
	private static Connection connection;
	private static Statement statement;
	private static String primaryLoad = "CREATE TABLE Cats2 (CatID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name TEXT NOT NULL, Color TEXT NOT NULL);";
	
	public static void main(String[] args) {
		
		Cat cat1 = new Cat("Bars", "Black");
		Cat cat2= new Cat("Mars", "Gray");
		Cat cat3 = new Cat("Kars", "Blue");
		Cat cat4 = new Cat("Fars", "Orage");
		
//		createDB();
//
//		insertNewItem(cat1);
//		insertNewItem(cat2);
//		insertNewItem(cat3);
//		insertNewItem(cat4);

//		deleteItem(2);

//		updateItem(3, cat4);
		
		showDB();
		
	}
	
	static void showDB()    {
		connect();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Cats2");
			while(rs.next())    {
				System.out.print(rs.getInt(1));
				System.out.printf("\t");
				System.out.print(rs.getString(2));
				System.out.printf("\t");
				System.out.print(rs.getString(3));
				System.out.printf("\n");
			}
			close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	static void insertNewItem(Cat cat1) {
		connect();
		
		try {
			// Работа через подготовленные запросы.
			statement = connection.createStatement();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Cats2 (Name, Color) values (?, ?);");
			ps.setString(1, cat1.getName());
			ps.setString(2, cat1.getColor());
			ps.executeUpdate();
			close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	static void deleteItem(int n) {
		connect();
		
		try {
			// Работа через подготовленные запросы.
			statement = connection.createStatement();
			PreparedStatement ps = connection.prepareStatement(("DELETE FROM Cats2 WHERE CatID = " + Integer.toString(n)));
			ps.executeUpdate();
			close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	static void updateItem(int n, Cat cat) {
		connect();
		
		try {
			// Работа через подготовленные запросы.
			statement = connection.createStatement();
			PreparedStatement ps = connection.prepareStatement(("UPDATE Cats2 SET Name = ?, Color = ? WHERE CatID = " + Integer.toString(n)));
			ps.setString(1, cat.getName());
			ps.setString(2, cat.getColor());
			ps.executeUpdate();
			close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	static void createDB()  {
		// Подключаемся к БД.
		connect();
		
		// Для выполнения запросов к БД необходим объект Statement.
		// Выполняем запрос на создание БД.
		// Закрываем подключение.
		// Обрабатываем исклюения в случае появления.
		try {
			
			statement = connection.createStatement();
			statement.executeUpdate(primaryLoad);
			close();
			
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		
		
//		ResultSet rs = statement.executeQuery("SELECT * FROM Cats");
//		System.out.printf("CatID\tName\n");
//		while(rs.next())    {
//			System.out.println(rs.getInt(1) + "\t\t" + rs.getString("Name"));
//		}
//		DataBase.close();
	}
	
	static void connect()    {
		try {
			// Регистрация JDBC-драйвера.
			Class.forName("org.sqlite.JDBC");
			// Подключение к БД.
			connection = DriverManager.getConnection("jdbc:sqlite:Cats2.db");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB driver isn't register.");
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	static void close() throws SQLException {
		connection.close();
	}
}
