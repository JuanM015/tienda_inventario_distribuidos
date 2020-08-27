package proyecto_tienda_distribuidos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class main2 {
	   
	   
	public static final char SEPARATOR=';';
	public static final char QUOTE='"';

	   public static void main(String[] args) {

		   
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("C:\\Users\\juanm\\OneDrive\\Documentos\\Universidad\\8vo Semestre\\Sistemas Distribuidos\\data.csv"));
			String[] nextLine = null;

			int i = 1;
			while ((nextLine = reader.readNext()) != null) {
			//	System.out.println(Arrays.toString(nextLine).replace("[","").replace("]","").replace(",", "\n").replace(" ", ""));
				System.out.println(nextLine[i]);
				i++;
			}

		} catch (Exception e) {

		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		   
	   }
}