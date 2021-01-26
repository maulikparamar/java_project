package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class drive {
		private static Connection connection;
		public static void main(String[] args) {
			getConnection();
		}
		public static Connection getConnection() {
			String url = "com.mysql.jdbc.Driver";
			String db = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "";	
			try {
				Class.forName(url);
				connection = DriverManager.getConnection(db,username,password);
				System.out.println("connect");
				return connection;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}
}
