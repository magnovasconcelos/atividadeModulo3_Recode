package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Lopesv1985#";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agencia";

	public static Connection createConnectionToMySql() throws 
	Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection (DATABASE_URL,USERNAME,PASSWORD);
		return connection;
	}	
}