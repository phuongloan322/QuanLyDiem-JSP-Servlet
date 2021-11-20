package utils;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class DBConnection {
	private static String url = "jdbc:mysql://localhost:3306/husc?useUnicode=true&characterEncoding=UTF-8";
	private static String loginID = "root";
	private static String password = "";
	
	private static Connection cnn = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnn = (Connection) DriverManager.getConnection(url, loginID, password);
			
		} catch (Exception e) {
			System.out.println("Lỗi nạp Driver");
			e.printStackTrace();
		}
		return cnn;
	}
	
	public static void main(String[] args) {
		System.out.println(DBConnection.getConnection());
	}
}
