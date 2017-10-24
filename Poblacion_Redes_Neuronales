import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Poblacion_Redes_Neuronales {

	public ArrayList<Red_Multicapa_Algoritmos_Geneticos> poblacionInicial = new ArrayList<Red_Multicapa_Algoritmos_Geneticos>();
	public int nDatosEntrada;
	public double[][] memoriaDatos;
	public boolean primeraVez = true;
	double datosEntrada[][];
	double datosSalida[][];
	Scanner sc = new Scanner(System.in);
	
	//Al crear la poblacion se inicializa a cada unos de los especímenes
	public Poblacion_Redes_Neuronales(int nDatosEntrada){
		datosEntrada = new double[nDatosEntrada][23];
		datosSalida = new double[nDatosEntrada][4];
		for(int i=0;i<20;i++)
			poblacionInicial.add(new Red_Multicapa_Algoritmos_Geneticos(0.1));
		this.nDatosEntrada=nDatosEntrada;
		
		//Descomentar si no queremos partir de 0 en el aprendizaje
		
		/*
		for(int i=0;i<poblacionInicial.get(0).capaOculta1.length;i++){
			for(int j=0;j<poblacionInicial.get(0).capaOculta1[i].peso.length;j++){
				poblacionInicial.get(0).capaOculta1[i].peso[j] = sc.nextDouble();
			}
		}
		for(int i=0;i<poblacionInicial.get(0).capaSalida.length;i++){
			for(int j=0;j<poblacionInicial.get(0).capaSalida[i].peso.length;j++){
				poblacionInicial.get(0).capaSalida[i].peso[j] = sc.nextDouble();
			}
		}
		*/
		
	}
	
	
	//Se seleccionan los especímenes más aptos para que se reproduzcan entre ellos, luego se buscan los peores especímenes y se sustituyen por los descendientes de los más aptos
	public double  nuevaGeneracion(boolean primeraVez) throws IOException{
		
		
		if(primeraVez){
			//Recopilamos los datos de entranamiento
			for(int i=0;i<nDatosEntrada;i++){
				for(int j=0;j<23;j++){
					datosEntrada[i][j] = sc.nextDouble(); 
				}
				 datosEntrada[i]=poblacionInicial.get(0).tratamientoDatosEntrada(datosEntrada[i]);
				for(int j=0;j<4;j++){
					datosSalida[i][j] = sc.nextDouble();
				}
				 datosSalida[i]=poblacionInicial.get(0).tratamientoDatosSalida(datosSalida[i]);
			}
		}
		
		
		//Buscamos los especimenes más aptos para que se reproduzcan
		int especimenApto1=-1,especimenApto2=-1;
		double errorApto1=0,errorApto2=0;
		for(int i=0;i<poblacionInicial.size();i++){
			poblacionInicial.get(i).nConcordancias=0;
			double error=0;
			for(int j=0;j<nDatosEntrada;j++){
				error+=poblacionInicial.get(i).procesamientoDatos(datosEntrada[j], datosSalida[j]);
			}
			if(especimenApto1==-1 || errorApto1>error){
				especimenApto1=i;
				errorApto1=error;
			}
			else if(especimenApto2==-1 || errorApto2>error){
				especimenApto2=i;
				errorApto2=error;
			}
			
		}
		
		//Ahora se lleva la reproducción acabo entrecruzando sus genes de forma aleatoria
		double[] nuevaCadenaGenetica1 = new double[poblacionInicial.get(0).capaOculta1.length*poblacionInicial.get(0).capaOculta1[0].peso.length+poblacionInicial.get(0).capaSalida.length*poblacionInicial.get(0).capaSalida[0].peso.length];
		double[] nuevaCadenaGenetica2 = new double[poblacionInicial.get(0).capaOculta1.length*poblacionInicial.get(0).capaOculta1[0].peso.length+poblacionInicial.get(0).capaSalida.length*poblacionInicial.get(0).capaSalida[0].peso.length];
		int puntoEntrecruzamiento = (int)(Math.floor(Math.random()*nuevaCadenaGenetica1.length)+1);
		double[] cadenaGeneticaEspecimen1 = new double[nuevaCadenaGenetica1.length];
		double[] cadenaGeneticaEspecimen2 = new double[nuevaCadenaGenetica1.length];
		int contador=0;
		for(int j=0;j<poblacionInicial.get(especimenApto1).capaOculta1.length;j++){
			for(int k=0;k<poblacionInicial.get(especimenApto1).capaOculta1[j].peso.length;k++){
				cadenaGeneticaEspecimen1[contador] = poblacionInicial.get(especimenApto1).capaOculta1[j].peso[k];
				contador++;
			}
		}
		for(int j=0;j<poblacionInicial.get(especimenApto1).capaSalida.length;j++){
			for(int k=0;k<poblacionInicial.get(especimenApto1).capaSalida[j].peso.length;k++){
				cadenaGeneticaEspecimen1[contador] = poblacionInicial.get(especimenApto1).capaSalida[j].peso[k];
				contador++;
			}
		}
		contador=0;
		for(int j=0;j<poblacionInicial.get(especimenApto2).capaOculta1.length;j++){
			for(int k=0;k<poblacionInicial.get(especimenApto2).capaOculta1[j].peso.length;k++){
				cadenaGeneticaEspecimen2[contador] = poblacionInicial.get(especimenApto2).capaOculta1[j].peso[k];
				contador++;
			}
		}
		for(int j=0;j<poblacionInicial.get(especimenApto2).capaSalida.length;j++){
			for(int k=0;k<poblacionInicial.get(especimenApto2).capaSalida[j].peso.length;k++){
				cadenaGeneticaEspecimen2[contador] = poblacionInicial.get(especimenApto2).capaSalida[j].peso[k];
				contador++;
			}
		}
		contador=0;
		for(int i=0;i<puntoEntrecruzamiento;i++){
			nuevaCadenaGenetica1[i] = cadenaGeneticaEspecimen1[i];
		}
		for(int i=puntoEntrecruzamiento;i<nuevaCadenaGenetica1.length;i++){
			nuevaCadenaGenetica1[i] = cadenaGeneticaEspecimen2[i];
		}
		for(int i=0;i<puntoEntrecruzamiento;i++){
			nuevaCadenaGenetica2[i] = cadenaGeneticaEspecimen2[i];
		}
		for(int i=puntoEntrecruzamiento;i<nuevaCadenaGenetica1.length;i++){
			nuevaCadenaGenetica2[i]=cadenaGeneticaEspecimen1[i];
		}
		
		
		
		//Buscamos los dos especímenes menos aptos de la poblacion
		int especimenNoApto1=-1,especimenNoApto2=-1;
		double errorNoApto1=0,errorNoApto2=0;
		for(int i=0;i<poblacionInicial.size();i++){
			poblacionInicial.get(i).nConcordancias=0;
			double error=0;
			for(int j=0;j<nDatosEntrada;j++){
				error+=poblacionInicial.get(i).procesamientoDatos(datosEntrada[j], datosSalida[j]);
			}
			if(especimenNoApto1==-1 || errorNoApto1<error){
				especimenNoApto1=i;
				errorNoApto1=error;
			}
			else if(especimenNoApto2==-1 || errorNoApto2<error){
				especimenNoApto2=i;
				errorNoApto2=error;
			}
		}
		
		
		
		//Ahora sustituimos los dos menos aptos por la nueva generación de especímenes. Siempre que estos sean más aptos.
		//Además habrá cierto riesgo de mutación al escribir los nuevos genes
		double errorEspecimen1=0,errorEspecimen2=0;
		double[] viejaCadena1 = poblacionInicial.get(especimenNoApto1).modificacionGenes(nuevaCadenaGenetica1,true);
		double[] viejaCadena2 = poblacionInicial.get(especimenNoApto2).modificacionGenes(nuevaCadenaGenetica2,true);
		poblacionInicial.get(especimenNoApto2).nConcordancias=0;
		poblacionInicial.get(especimenNoApto1).nConcordancias=0;
		for(int i=0;i<nDatosEntrada;i++){
			errorEspecimen1+=poblacionInicial.get(especimenNoApto1).procesamientoDatos(datosEntrada[i], datosSalida[i]);
			errorEspecimen2+=poblacionInicial.get(especimenNoApto2).procesamientoDatos(datosEntrada[i], datosSalida[i]);
		}
		boolean cambiado=true;
		if(errorEspecimen1<errorNoApto1){
			System.out.println("Cambiamos en la poblacion el especimen 1");
			cambiado=false;
		}
		if(errorEspecimen2<errorNoApto2){
			System.out.println("Cambiamos en la poblacion el especimen 2");
			cambiado=false;
		}
		if(errorEspecimen1<errorNoApto2 && cambiado){
			poblacionInicial.get(especimenNoApto1).modificacionGenes(viejaCadena1,false);
			poblacionInicial.get(especimenNoApto2).modificacionGenes(nuevaCadenaGenetica1,false);
			System.out.println("Cambiamos en la poblacion el especimen 2");
		}
		if(errorEspecimen2<errorNoApto1 && cambiado){
			poblacionInicial.get(especimenNoApto2).modificacionGenes(viejaCadena2,false);
			poblacionInicial.get(especimenNoApto1).modificacionGenes(nuevaCadenaGenetica2,false);
			System.out.println("Cambiamos en la poblacion el especimen 1");
		}
		
		especimenApto1=-1;especimenApto2=-1;
		errorApto1=0;errorApto2=0;
		for(int i=0;i<poblacionInicial.size();i++){
			double error=0;
			for(int j=0;j<nDatosEntrada;j++){
				error+=poblacionInicial.get(i).procesamientoDatos(datosEntrada[j], datosSalida[j]);
			}
			if(especimenApto1==-1 || errorApto1>error){
				especimenApto1=i;
				errorApto1=error;
			}
			else if(especimenApto2==-1 || errorApto2>error){
				especimenApto2=i;
				errorApto2=error;
			}
			
		}
		
		poblacionInicial.get(especimenApto1).nConcordancias=0;
		double errorFin=0;
		poblacionInicial.get(especimenApto1).nConcordancias=0;
		for(int i=0;i<nDatosEntrada;i++){
			errorFin+=poblacionInicial.get(especimenApto1).procesamientoDatos(datosEntrada[i], datosSalida[i]);
		}
		System.out.println("Error mejor especimen 1:"+ errorFin);
		System.out.println("No concordancias: "+poblacionInicial.get(especimenApto1).nConcordancias);
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		poblacionInicial.get(especimenApto1).guardarRed();
		
		
		//Esta parte de código no es totalmente necesaria, lo que hace es que exista una probabilidad muy baja de que haya una extinción de la población excepto del individuo más apto.
		// Biene a ser una forma de agilizar las mutaciones
		if((Math.floor(Math.random()*1000))==5){
			System.out.println("Introducimos nuevos individuos");
			Red_Multicapa_Algoritmos_Geneticos redMejor = poblacionInicial.get(especimenApto1);
			poblacionInicial.clear();
			poblacionInicial.add(redMejor);
			for(int i=0;i<19;i++){
				poblacionInicial.add(new Red_Multicapa_Algoritmos_Geneticos(0.1));
			}
		}
			return errorFin;
		}
		
		
}
