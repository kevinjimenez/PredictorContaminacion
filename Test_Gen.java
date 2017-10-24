import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Test_Algoritmos_Geneticos {

	public static int nDatosAprendizaje=2000;
		
		public static void main(String args[]) throws IOException{
			FileWriter fichero = null;
			PrintWriter pw = null;
			Poblacion_Redes_Neuronales p = new Poblacion_Redes_Neuronales(nDatosAprendizaje);
			int cont=0;
			boolean primeraVez =true;
			double fallo=0;
			while(true){
				// Esta línea se uso para recopilar los datos destinados a las gráficas
				fichero = new FileWriter("C:/Users/Carlos/Desktop/estadisticaEsEsta20.txt",true);
				pw = new PrintWriter(fichero);
				cont++;
				fallo = p.nuevaGeneracion(primeraVez);;
				primeraVez=false;
				System.out.println("GENERACION   "+cont);
				if(cont%100==0){
					pw.println(fallo);
				}
				pw.close();
				fichero.close();
			}
		
		}
}
