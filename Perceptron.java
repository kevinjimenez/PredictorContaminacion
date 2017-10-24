public class Perceptron {

	public double[] peso;
	public double factorAprendizaje;

	public Perceptron(int entrada,double factorAprendizaje,boolean esEntrada){
		peso = new double[entrada];
		if(!esEntrada)
			for(int i=0;i<entrada;i++){
				peso[i] = Math.random()*100000000-Math.random()*100000000;
			}
		this.factorAprendizaje=factorAprendizaje;
		if(esEntrada){
			for(int i=0;i<entrada;i++)
				peso[i] =1;
		}
		
	}
	
	
	public double funcionPropagacion(double[] entradas){
		double resultado=0;
		for(int i=0;i<peso.length;i++){
			resultado+=peso[i]*entradas[i];
		}
		return resultado;
	}
	
	
	public double funcionActivacion(double salidaFPropagacion){
		return Math.tanh(salidaFPropagacion);
	}
	
	
	public double funcionSalida(double salidaFActivacion){
		if(salidaFActivacion>0)
			return 1;
		else
			return 0;
		
	}
	
	
	public void aprendizaje(double incrementoSalida,double[] salida){
		for(int i=0;i<peso.length;i++){
			peso[i] = peso[i]+(factorAprendizaje*(incrementoSalida*salida[i]));
		}
	}
}
