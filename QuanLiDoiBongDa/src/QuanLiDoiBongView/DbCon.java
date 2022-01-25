package QuanLiDoiBongView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getConstructor().newInstance();
		String url = "jdbc:sqlserver://DESKTOP-4R7LTML\\SQLEXPRESS:1433;databaseName=quanlidondathang1";
		String user = "phipham";
		String password = "phamvanphi06122003";
		
		connection =DriverManager.getConnection(url, user, password);
		
			// TODO Auto-generated catch block
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
