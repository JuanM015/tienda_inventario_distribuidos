package proyecto_tienda_distribuidos;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.opencsv.CSVReader;

// ESTÁ CLASE ES LA DE SUMMATION

public class SubirElementosTienda {
	
	private static final int CHUNK_SIZE = 10000;

    private ExecutorService pool;
    public SubirElementosTienda() {
        pool = Executors.newFixedThreadPool(50);
    }

    public Double summation(){

		/*int chunks = (int) Math.floor(nums.length / CHUNK_SIZE);

		double sum = 0;

		List<Future<Double>> summers = new ArrayList<>();

		for (int c = 0; c < chunks; c++) {
			SumArray summer = new SumArray(Arrays.copyOfRange(nums, c * CHUNK_SIZE, (c + 1) * CHUNK_SIZE));
			Future<Double> futuro = pool.submit(summer);
			summers.add(futuro);
		}

		for (Future<Double> futuro : summers) {
			try {
				sum += futuro.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}*/

        return null;
    }
    
    
    private void leerArchivoCSV() {
    	
    	String miArchivo = "C:\\Users\\juanm\\OneDrive\\Documentos\\Universidad\\8vo Semestre\\Sistemas Distribuidos\\data.csv";
    //	CSVReader csvReader = new CSVReader(new FileReader(miArchivo));
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
