package proyecto_tienda_distribuidos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Principal {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
			ConexionDataBase.crearConexion();
			MiTienda tienda = new MiTienda();
			long t1 = System.nanoTime();
			tienda.getArray();
			long t = System.nanoTime() - t1;

			System.out.println("t(ms) = " + t / 1000000 + " ms");

			// ConexionJDBC.cerrarConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
