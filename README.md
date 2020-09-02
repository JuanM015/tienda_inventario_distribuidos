# tienda_inventario_distribuidos

1. Los archivos de ejecución o necesarios para el desarrollo y funcionamiento de la aplicación están ubicados en la carpeta *archivos*, la base de datos se ejecutará de
manera automática cuando la aplicación sea encendida.
2. El archivo nombrado como: *RegistrosBase.csv* contiene el total de 8000 registros, no será necesario cambiar la ruta ni nada de ninguna manera, puesto que esta viene
dentro de la carpeta *archivos* y se ejecutará de igual manera por sí sólo.
3. En la clase: *MiTienda* están las variables configurables que son: *private static final int CHUNK_SIZE = 2000* y el *this.pool = Executors.newFixedThreadPool(5);*
________________________________________________________________________
private static final int CHUNK_SIZE = 2000;
	private boolean banderazo;
	private ExecutorService pool;

	public MiTienda() {
		super();
		this.pool = Executors.newFixedThreadPool(5);
		banderazo = true;
	}
  ______________________________________________________________________
  
  4. En la clase *ConexionBaseDatos* los archivos configurables son: *URL, USER, PASS* 
  
  static final String URL = "jdbc:postgresql://localhost:5432/[NOMBRE BASE DATOS]";
  
  En mi caso es así:
  
static final String URL = "jdbc:postgresql://localhost:5432/base_datos_tienda";
static final String USER = "postgres";
static final String PASS = "admin";
  
  5. Se adjunto la librería para postgres usada, <span style="color: red"> ella sí se deberá añadir manualmente a la aplicación </span> 
  6. Por último para ejecutar la aplicación es a través de la clase: *Principal*, simplemente dandole en la opción de *Run*
  
  
  Nota: Por parte de los dos agradecemos la asesoría, sin embargo aún quedamos con dudas al respecto, sería posible sí después de mirar la entrega en otra asesoría revisar ello.
 Agradezco la atención prestada.
