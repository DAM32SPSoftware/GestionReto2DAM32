package Connection_DB;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connection_SGL {
	private static Connection_SGL instancia = null;
	private static Connection conn;
	//*********************
	//Entrar en el gestor de la bd para localizar los datos de acceso:
	//http://localhost/phpmyadmin
	//*********************
	private Connection_SGL() {
		String host = "127.0.0.1";
		String user="root";
		String pass="";
		String db="reto2dam32";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String newConnectionURL = "jdbc:mysql://" + host + "/" + db + "?" + "user=" + user + "&password=" + pass;
			conn = DriverManager.getConnection(newConnectionURL);
		}catch (Exception e) {
			System.out.println("Error al abrir la conexión.");
		}
	}
	//
	public static Connection_SGL getInstancia() {
		if (instancia == null) {
			instancia = new Connection_SGL();
		}
		return instancia;
	}
	public Connection getCon() {
		return conn;
	}
	//
	public void cerrarConexion() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexión");
		}
	}
}
