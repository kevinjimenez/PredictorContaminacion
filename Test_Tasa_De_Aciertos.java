import java.io.IOException;
import java.util.Scanner;

public class Test_Tasa_Aciertos {

public static int nDatosAprendizaje=2000;
	
	public static void main(String args[]) throws IOException{
		Red_Multicapa_Algoritmos_Geneticos redNeuronal = new Red_Multicapa_Algoritmos_Geneticos(0.1);
		Scanner sc = new Scanner(System.in);
		int co=0;
		double tasaAcierto=0;
		double[][] datosEntrada = new double[nDatosAprendizaje][23];
		double[][] datosSalida = new double[nDatosAprendizaje][4];
		
		for(int i=0;i<redNeuronal.capaOculta1.length;i++){
			for(int j=0;j<redNeuronal.capaOculta1[i].peso.length;j++){
				redNeuronal.capaOculta1[i].peso[j] = sc.nextDouble();
			}
		}
		for(int i=0;i<redNeuronal.capaSalida.length;i++){
			for(int j=0;j<redNeuronal.capaSalida[i].peso.length;j++){
				redNeuronal.capaSalida[i].peso[j] = sc.nextDouble();
			}
		}
		redNeuronal.guardarRed();
		for(int i=0;i<nDatosAprendizaje;i++){
			for(int j=0;j<23;j++){
				datosEntrada[i][j] = sc.nextDouble();
			}
			datosEntrada[i] = redNeuronal.tratamientoDatosEntrada(datosEntrada[i]);
			for(int j=0;j<4;j++){
				datosSalida[i][j] = sc.nextDouble();
			}
			datosSalida[i] = redNeuronal.tratamientoDatosSalida(datosSalida[i]);
		}
		tasaAcierto=0;
		for(int i=0;i<nDatosAprendizaje;i++){
			tasaAcierto += redNeuronal.procesamientoDatos(datosEntrada[i], datosSalida[i]);
		}
		redNeuronal.guardarRed();
		System.out.println("Tasa de acierto: "+tasaAcierto);
	}
}
