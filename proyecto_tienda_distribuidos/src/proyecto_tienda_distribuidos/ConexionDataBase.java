package proyecto_tienda_distribuidos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDataBase {

	static final String URL = "jdbc:postgresql://localhost:5432/base_datos_tienda";
	static final String USER = "postgres";
	static final String PASS = "admin";
	static Statement sentencia = null;
	static Connection conexion = null;
	static ResultSet resultado = null;

	public static Connection crearConexion() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		conexion = DriverManager.getConnection(URL, USER, PASS);
		if (conexion != null) {
			System.out.print("Conexion establecida...");
			sentencia = conexion.createStatement();
			crearBaseDatos();

			return conexion;
		}
		return null;
	}

	public static void cerrarConexion() {
		conexion = null;
		if(resultado!=null) {
			try {
				resultado.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		if(sentencia!=null) {
			try {
				sentencia.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if(conexion!=null) {
			try {
				conexion.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
		}
	
	}
	
	private static void crearBaseDatos() {
		try {
			
			String query = "DROP TABLE IF EXISTS product_stores;\r\n" + 
					"DROP TABLE IF EXISTS products;\r\n" + 
					"DROP TABLE IF EXISTS category;\r\n" + 
					"DROP TABLE IF EXISTS store;\r\n" + 
					"\r\n" + 
					"CREATE TABLE category\r\n" + 
					"(\r\n" + 
					"    category_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,\r\n" + 
					"    category_name varchar(250) UNIQUE,\r\n" + 
					"    primary key (category_id)\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"CREATE TABLE store\r\n" + 
					"(\r\n" + 
					"    store_id int,\r\n" + 
					"    store_name varchar(250),\r\n" + 
					"    primary key (store_id)\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"CREATE TABLE products\r\n" + 
					"(\r\n" + 
					"    product_id int primary key,\r\n" + 
					"    product_name varchar(250),\r\n" + 
					"    category_id int,\r\n" + 
					"    CONSTRAINT fk_category\r\n" + 
					"    FOREIGN KEY(category_id) \r\n" + 
					"    REFERENCES category(category_id)\r\n" + 
					");\r\n" + 
					"\r\n" + 
					"CREATE TABLE product_stores\r\n" + 
					"(\r\n" + 
					"    product_id int,\r\n" + 
					"    product_price varchar(250),\r\n" + 
					"    store_id int,\r\n" + 
					"    CONSTRAINT fk_product\r\n" + 
					"      FOREIGN KEY(product_id) \r\n" + 
					"      REFERENCES products(product_id),\r\n" + 
					"    CONSTRAINT fk_store\r\n" + 
					"      FOREIGN KEY(store_id) \r\n" + 
					"      REFERENCES store(store_id)\r\n" + 
					");";
			ConexionDataBase.sentencia.execute(query);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
