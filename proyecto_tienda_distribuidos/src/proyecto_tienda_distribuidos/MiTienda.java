package proyecto_tienda_distribuidos;

public class MiTienda {
	
	 private double result;
	    private double[] numbers;

	    public MiTienda() {
	    }

	    public MiTienda(double[] numbers) {
	        this.numbers = numbers;
	    }

	    private double sum(double array[]){
	        double sum = 0;

	        for (double num:array) {
	            sum +=num;
	        }

	        try {
	            Thread.sleep((long)(Math.random()*1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        return sum;
	    }

	    public Double call() throws Exception {
	        System.out.println("sumando....");
	        return sum(numbers);
	    }

	    public double getResult() {
	        return result;
	    }

}
