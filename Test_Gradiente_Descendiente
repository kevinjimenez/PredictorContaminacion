import java.io.IOException;
import java.util.Scanner;


public class Test_Gradiente_Descendiente {

	public static int nDatosAprendizaje=900;
	
	public static void main(String args[]) throws IOException{
		Red_Multicapa_Gradiente_Descendiente redNeuronal = new Red_Multicapa_Gradiente_Descendiente(0.1);
		
		Scanner sc = new Scanner(System.in);
		
		/*
		for(int i=0;i<redNeuronal.capaOculta1.length;i++){
			for(int j=0;j<redNeuronal.capaOculta1[i].peso.length;j++){
				redNeuronal.capaOculta1[i].peso[j] = sc.nextDouble();
			}
		}
		for(int i=0;i<redNeuronal.capaSalida.length;i++){
			for(int j=0;j<redNeuronal.capaSalida[i].peso.length;j++){
				redNeuronal.capaSalida[i].peso[j] = sc.nextDouble();
			}
		}*/
		int co=0;
		double tasaAcierto=0;
		boolean esUltima=false;
			double[][] datosEntrada = new double[nDatosAprendizaje][23];
			double[][] datosSalida = new double[nDatosAprendizaje][4];
			for(int j=0;j<nDatosAprendizaje;j++){
			for(int i=0;i<23;i++){
				datosEntrada[j][i] = sc.nextDouble();
			}
			datosEntrada[j]=redNeuronal.tratamientoDatosEntrada(datosEntrada[j]);
			for(int i=0;i<4;i++){
				datosSalida[j][i] = sc.nextDouble();
			}
			datosSalida[j] = redNeuronal.tratamientoDatosSalida(datosSalida[j]);
			}
			for(int k=0;k<10;k++){
			for(int i=0;i<nDatosAprendizaje;i++){
				for(int j=0;j<4;j++){
					tasaAcierto = redNeuronal.aprendizaje(datosEntrada[i], datosSalida[i]);
				}
			}
			}
			redNeuronal.guardarRed();
			System.out.println("Tasa de acierto: "+tasaAcierto);
		}
	
}
