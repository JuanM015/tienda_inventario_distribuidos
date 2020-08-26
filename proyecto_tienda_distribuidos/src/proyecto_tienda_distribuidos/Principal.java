package proyecto_tienda_distribuidos;

import java.sql.Connection;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		
		 try {
	            Connection conexion = conexionDataBase.crearConexion();

	            String query = "INSERT INTO category (category_name) VALUES ('prueba')";
	            conexionDataBase.sentencia.execute(query);
	            System.out.println("GUARDADO EXITOSO");
	            conexionDataBase.cerrarConexion();

	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

}
