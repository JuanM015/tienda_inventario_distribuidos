package proyecto_tienda_distribuidos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MiTienda {

	private static final int CHUNK_SIZE = 2000;
	private boolean banderazo;
	private ExecutorService pool;

	public MiTienda() {
		super();
		this.pool = Executors.newFixedThreadPool(5);
		banderazo = true;
	}

	public void particionar(String registros[]) {

		int chunks = (int) Math.floor(registros.length / CHUNK_SIZE);
		List<Future<Boolean>> myListFinish = new ArrayList<>();
		for (int c = 0; c < chunks; c++) {
			String nRegistro[] = Arrays.copyOfRange(registros, c * CHUNK_SIZE, (c + 1) * CHUNK_SIZE);
			SubirElementosTienda ci = new SubirElementosTienda(nRegistro);
			Future<Boolean> future = pool.submit(ci);
			myListFinish.add(future);
		}

		try {
			for (Future<Boolean> future : myListFinish) {
				banderazo = future.get();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getArray() {
		BufferedReader bufferLectura = null;
		String[]campos=null;
		int size = 2000;
        try {
            bufferLectura = new BufferedReader(new FileReader(".\\src\\archivos\\RegistrosBase.csv"));
            String linea = bufferLectura.readLine();
            linea = bufferLectura.readLine();
            int i = 0;
            
            while(linea != null ) {
            	campos = new String[size];
            	i = 0;
            
            	while (linea != null && i<size && banderazo) {
            		campos[i] = linea;
            		i=i+1;
            		linea = bufferLectura.readLine();
            	}
            	
            	banderazo = false;
            	particionar(campos);
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
	}
	
}
