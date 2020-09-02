package proyecto_tienda_distribuidos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.opencsv.CSVReader;

// ESTÁ CLASE ES LA DE SUMMATION

public class SubirElementosTienda implements Callable<Boolean>{

	private String[] informacion;

	public SubirElementosTienda(String[] registros) {
		super();
		this.informacion = registros;
	}

	private Boolean insert(String informacion[]) {
		
		boolean banderazo = false;

		for (int i = 0; i < informacion.length; i++) {
			
			String campos[] = informacion[i].split(",");
			
			int product_id = Integer.parseInt(campos[0]);
			String product_name = campos[1];
			String product_price = campos[2];
			String category_name = campos[3];
			int store_id = Integer.parseInt(campos[5]);
			String store_name = campos[6];

			int category_id = insertCategory(category_name);
						
			insertStore(store_id, store_name);

			insertProducts(product_id, product_name, category_id);
			
			insertProductStore(product_id, product_price, store_id);

		}

		banderazo = true;

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return banderazo;

	}

	private int insertCategory(String category_name) {
		int category_id=0;
		try {	
			String query = "INSERT INTO category (category_name) VALUES ('"+category_name+"')ON CONFLICT (category_name) DO UPDATE SET category_name='"+category_name+"' RETURNING category_id";
			ConexionDataBase.resultado = ConexionDataBase.sentencia.executeQuery(query);
			if(ConexionDataBase.resultado.next()) {
				category_id = ConexionDataBase.resultado.getInt("category_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category_id;
	}

	private void insertProductStore(int product_id, String product_price, int store_id) {
		  try {
			
			String query = "INSERT INTO product_stores VALUES ("+product_id+", '"+product_price+"', "+store_id+")";
			ConexionDataBase.sentencia.execute(query);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertProducts(int product_id, String product_name, int category_id) {
		try {
			
			String query = "INSERT INTO products VALUES ("+product_id+",'"+product_name+"', "+category_id+") ON CONFLICT (product_id) DO UPDATE SET product_name = '"+product_name+"', category_id="+category_id+"";
			ConexionDataBase.sentencia.execute(query);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertStore(int store_id, String store_name) {
		try {
			
			String query = "INSERT INTO store VALUES ("+store_id+",'"+store_name+"') ON CONFLICT (store_id) DO UPDATE SET store_name = '"+store_name+"'";
			ConexionDataBase.sentencia.execute(query);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private int obtenerCategoria(String category_name) {
//		int category_id = 0;
//		try {
//			Connection conexion = ConexionDataBase.crearConexion();
//			ConexionDataBase.sentencia = conexion.createStatement();
//			String query = "SELECT category_id FROM category where category_name='" + category_name + "'";
//			ConexionDataBase.resultado = ConexionDataBase.sentencia.executeQuery(query);
//
//			while (ConexionDataBase.resultado.next()) {
//				category_id = ConexionDataBase.resultado.getInt("category_id");
//			}
//
//			ConexionDataBase.cerrarConexion();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return category_id;
//	}

	@Override
	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		return insert(informacion);
	}
}
