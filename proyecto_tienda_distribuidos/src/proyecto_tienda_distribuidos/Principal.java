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
			tienda.particionar(getArray());
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

	private static String[] getArray() {
		BufferedReader bufferLectura = null;
		String[]campos=new String[10000];
        try {
            bufferLectura = new BufferedReader(new FileReader(".\\src\\archivos\\RegistrosBase.csv"));
            String linea = bufferLectura.readLine();
            linea = bufferLectura.readLine();
            int i = 0;
            
            while (linea != null) {
                campos[i] = linea;
                i=i+1;
                linea = bufferLectura.readLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return campos;
	}
}
