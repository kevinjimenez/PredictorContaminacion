import java.io.IOException;

public class Red_Multicapa_Algoritmos_Geneticos {

	private Perceptron[] capaEntrada = new Perceptron[23];
	public Perceptron[] capaOculta1 = new Perceptron[22];
	public Perceptron[] capaSalida = new Perceptron[20];
	private double[] media = new double[capaEntrada.length];
	private double[] desviacionTipica = new double[capaEntrada.length];
	public int nConcordancias =0;
	
	
	public Red_Multicapa_Algoritmos_Geneticos(double factorAprendizaje){
		
		//Inicializacion de los perceptrones
		for(int i=0;i<capaEntrada.length;i++){
			capaEntrada[i] = new Perceptron(1,factorAprendizaje,true);
		}
		for(int i=0;i<capaOculta1.length;i++){
			capaOculta1[i] = new Perceptron(capaEntrada.length,factorAprendizaje,false);
		}
		for(int i=0;i<capaSalida.length;i++){
			capaSalida[i] = new Perceptron(capaOculta1.length,factorAprendizaje,false);
		}
		
		//Valores de las medias para la normalización de las variables de entrada
		media[0] = 6.5185;
		media[1] = 15.61418;
		media[2] = 1.819035;
		media[3] = 2.884224;
		media[4] = 9.41625;
		media[5] = 61.64472;
		media[6] = 0.943523;
		media[7] = 3.50152;
		media[8] = 2.406714;
		media[9] = 22.88742;
		media[10] = 16.06075;
		media[11] = 9.630922;
		media[12] = 1.932156;
		media[13] = 199.6069;
		media[14] = 6.392255;
		media[15] = 199.1424;
		media[16] = 2.884224;
		media[17] = 9.41625;
		media[18] = 61.64472;
		media[19] = 2.406714;
		media[20] = 69.89893;
		media[21] = 93.20988636;
		media[22] = 41.03984375;
		
		//Valores de las desviaciones típicas para la normalización de las variables de entrada
		desviacionTipica[0] = 3.44661;
		desviacionTipica[1] = 8.79654;
		desviacionTipica[2] = 4.762653;
		desviacionTipica[3] = 2.401469;
		desviacionTipica[4] = 5.899849;
		desviacionTipica[5] = 19.59447;
		desviacionTipica[6] = 2.874949;
		desviacionTipica[7] = 2.19562;
		desviacionTipica[8] = 1.82817;
		desviacionTipica[9] = 8.494445;
		desviacionTipica[10] = 6.841588;
		desviacionTipica[11] = 5.504168;
		desviacionTipica[12] = 0.996487;
		desviacionTipica[13] = 56.89032;
		desviacionTipica[14] = 2.311327;
		desviacionTipica[15] = 98.19887;
		desviacionTipica[16] = 2.401469;
		desviacionTipica[17] = 5.899849;
		desviacionTipica[18] = 19.59447;
		desviacionTipica[19] = 1.82817;
		desviacionTipica[20] = 16.177728;
		desviacionTipica[21] = 7.777116257;
		desviacionTipica[22] = 21.07218853;
	}
	
	
	//Devuelve los datos de entrada normalizados
	public double[] tratamientoDatosEntrada(double[] datosEntrada){
		double[] datosTratados = new double[datosEntrada.length];
		for(int i=0;i<datosEntrada.length;i++){
				datosTratados[i] = (datosEntrada[i]-media[i])/desviacionTipica[i];
		}
		return datosTratados;
	}
	
	
	public double[] tratamientoDatosSalida(double[] datosSalida){
		double[] datosTratados = new double[datosSalida.length];
		datosTratados[0] = (datosSalida[0]-media[3])/desviacionTipica[3];
		datosTratados[1] = (datosSalida[1]-media[4])/desviacionTipica[4];
		datosTratados[2] = (datosSalida[2]-media[5])/desviacionTipica[5];
		datosTratados[3] = (datosSalida[3]-media[8])/desviacionTipica[8];
		return datosTratados;
	}
	
	
	public void guardarRed() throws IOException{
		for(int i=0;i<capaOculta1.length;i++){
			for(int j=0;j<capaOculta1[i].peso.length;j++){
				System.out.println(capaOculta1[i].peso[j]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		
		for(int i=0;i<capaSalida.length;i++){
			for(int j=0;j<capaSalida[i].peso.length;j++){
				System.out.println(capaSalida[i].peso[j]);
			}
			System.out.println(" ");
		}
	}
	
	
	//Este método procesa los datos de entrada a través de la red neuronal pero no se hace ninguna corrección de pesos
	public double procesamientoDatos(double[] datosEntrada,double[] salidasEsperadas){
		double[] temp = new double[4];
		for(int i=0;i<4;i++){
			temp[i] = salidasEsperadas[i];
		}
		salidasEsperadas = new double[this.capaSalida.length];
		for(int i=0;i<4;i++)
			salidasEsperadas[i]=temp[i];
		if(salidasEsperadas[0]>=datosEntrada[3]+4*datosEntrada[3]){
			salidasEsperadas[0]=0;
			salidasEsperadas[1]=0;
			salidasEsperadas[2]=0;
			salidasEsperadas[3]=0;
			salidasEsperadas[4]=0;
		}
		else if(salidasEsperadas[0]>=datosEntrada[3]+3.5*datosEntrada[3]){
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=0;
			salidasEsperadas[2]=0;
			salidasEsperadas[3]=0;
			salidasEsperadas[4]=0;
		}
		else if(salidasEsperadas[0]>=datosEntrada[3]+3*datosEntrada[3]){
			salidasEsperadas[0]=0;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=0;
			salidasEsperadas[3]=0;
			salidasEsperadas[4]=0;
		}
		else if(salidasEsperadas[0]>=datosEntrada[3]+2.5*datosEntrada[3]){
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=0;
			salidasEsperadas[3]=0;
			salidasEsperadas[4]=0;
		}
		else if(salidasEsperadas[0]>=datosEntrada[3]+2*datosEntrada[3]){
			salidasEsperadas[0]=0;
			salidasEsperadas[1]=0;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=0;
			salidasEsperadas[4]=0;
		}
		else if(salidasEsperadas[0]>=datosEntrada[3]+1.5*datosEntrada[3]){
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=0;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=0;
			salidasEsperadas[4]=0;
		}
		else if(salidasEsperadas[0]>=datosEntrada[3]+1*datosEntrada[3]){
			salidasEsperadas[0]=0;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=0;
			salidasEsperadas[4]=0;
		}
		else if(salidasEsperadas[0]>=datosEntrada[3]+0.5*datosEntrada[3]){
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=0;
			salidasEsperadas[4]=0;
		}
		else if(datosEntrada[3]>=salidasEsperadas[0]+4*salidasEsperadas[0]){
			salidasEsperadas[0]=0;
			salidasEsperadas[1]=0;
			salidasEsperadas[2]=0;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=0;
		}
		else if(datosEntrada[3]>=salidasEsperadas[0]+3.5*salidasEsperadas[0]){
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=0;
			salidasEsperadas[2]=0;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=0;
		}
		else if(datosEntrada[3]>=salidasEsperadas[0]+3*salidasEsperadas[0]){
			salidasEsperadas[0]=0;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=0;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=0;
		}
		else if(datosEntrada[3]>=salidasEsperadas[0]+2.5*salidasEsperadas[0]){
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=0;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=0;
		}
		else if(datosEntrada[3]>=salidasEsperadas[0]+2*salidasEsperadas[0]){
			salidasEsperadas[0]=0;
			salidasEsperadas[1]=0;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=0;
		}
		else if(datosEntrada[3]>=salidasEsperadas[0]+1.5*salidasEsperadas[0]){
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=0;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=0;
		}
		else if(datosEntrada[3]>=salidasEsperadas[0]+1*salidasEsperadas[0]){
			salidasEsperadas[0]=0;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=0;
		}
		else if(datosEntrada[3]>=salidasEsperadas[0]+0.5*salidasEsperadas[0]){
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=0;
		}
		else{
			salidasEsperadas[0]=1;
			salidasEsperadas[1]=1;
			salidasEsperadas[2]=1;
			salidasEsperadas[3]=1;
			salidasEsperadas[4]=1;
		}
		
		
		if(salidasEsperadas[1]>=datosEntrada[4]+4*datosEntrada[4]){
			salidasEsperadas[5]=0;
			salidasEsperadas[6]=0;
			salidasEsperadas[7]=0;
			salidasEsperadas[8]=0;
			salidasEsperadas[9]=0;
		}
		else if(salidasEsperadas[1]>=datosEntrada[4]+3.5*datosEntrada[4]){
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=0;
			salidasEsperadas[7]=0;
			salidasEsperadas[8]=0;
			salidasEsperadas[9]=0;
		}
		else if(salidasEsperadas[1]>=datosEntrada[4]+3*datosEntrada[4]){
			salidasEsperadas[5]=0;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=0;
			salidasEsperadas[8]=0;
			salidasEsperadas[9]=0;
		}
		else if(salidasEsperadas[1]>=datosEntrada[4]+2.5*datosEntrada[4]){
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=0;
			salidasEsperadas[8]=0;
			salidasEsperadas[9]=0;
		}
		else if(salidasEsperadas[1]>=datosEntrada[4]+2*datosEntrada[4]){
			salidasEsperadas[5]=0;
			salidasEsperadas[6]=0;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=0;
			salidasEsperadas[9]=0;
		}
		else if(salidasEsperadas[1]>=datosEntrada[4]+1.5*datosEntrada[4]){
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=0;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=0;
			salidasEsperadas[9]=0;
		}
		else if(salidasEsperadas[1]>=datosEntrada[4]+1*datosEntrada[4]){
			salidasEsperadas[5]=0;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=0;
			salidasEsperadas[9]=0;
		}
		else if(salidasEsperadas[1]>=datosEntrada[4]+0.5*datosEntrada[4]){
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=0;
			salidasEsperadas[9]=0;
		}
		else if(datosEntrada[4]>=salidasEsperadas[1]+4*salidasEsperadas[1]){
			salidasEsperadas[5]=0;
			salidasEsperadas[6]=0;
			salidasEsperadas[7]=0;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=0;
		}
		else if(datosEntrada[4]>=salidasEsperadas[1]+3.5*salidasEsperadas[1]){
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=0;
			salidasEsperadas[7]=0;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=0;
		}
		else if(datosEntrada[4]>=salidasEsperadas[1]+3*salidasEsperadas[1]){
			salidasEsperadas[5]=0;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=0;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=0;
		}
		else if(datosEntrada[4]>=salidasEsperadas[1]+2.5*salidasEsperadas[1]){
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=0;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=0;
		}
		else if(datosEntrada[4]>=salidasEsperadas[1]+2*salidasEsperadas[1]){
			salidasEsperadas[5]=0;
			salidasEsperadas[6]=0;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=0;
		}
		else if(datosEntrada[4]>=salidasEsperadas[1]+1.5*salidasEsperadas[1]){
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=0;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=0;
		}
		else if(datosEntrada[4]>=salidasEsperadas[1]+1*salidasEsperadas[1]){
			salidasEsperadas[5]=0;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=0;
		}
		else if(datosEntrada[4]>=salidasEsperadas[1]+0.5*salidasEsperadas[1]){
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=0;
		}
		else{
			salidasEsperadas[5]=1;
			salidasEsperadas[6]=1;
			salidasEsperadas[7]=1;
			salidasEsperadas[8]=1;
			salidasEsperadas[9]=1;
		}
		
		
		
		if(salidasEsperadas[2]>=datosEntrada[5]+4*datosEntrada[5]){
			salidasEsperadas[10]=0;
			salidasEsperadas[11]=0;
			salidasEsperadas[12]=0;
			salidasEsperadas[13]=0;
			salidasEsperadas[14]=0;
		}
		else if(salidasEsperadas[2]>=datosEntrada[5]+3.5*datosEntrada[5]){
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=0;
			salidasEsperadas[12]=0;
			salidasEsperadas[13]=0;
			salidasEsperadas[14]=0;
		}
		else if(salidasEsperadas[2]>=datosEntrada[5]+3*datosEntrada[5]){
			salidasEsperadas[10]=0;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=0;
			salidasEsperadas[13]=0;
			salidasEsperadas[14]=0;
		}
		else if(salidasEsperadas[2]>=datosEntrada[5]+2.5*datosEntrada[5]){
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=0;
			salidasEsperadas[13]=0;
			salidasEsperadas[14]=0;
		}
		else if(salidasEsperadas[2]>=datosEntrada[5]+2*datosEntrada[5]){
			salidasEsperadas[10]=0;
			salidasEsperadas[11]=0;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=0;
			salidasEsperadas[14]=0;
		}
		else if(salidasEsperadas[2]>=datosEntrada[5]+1.5*datosEntrada[5]){
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=0;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=0;
			salidasEsperadas[14]=0;
		}
		else if(salidasEsperadas[2]>=datosEntrada[5]+1*datosEntrada[5]){
			salidasEsperadas[10]=0;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=0;
			salidasEsperadas[14]=0;
		}
		else if(salidasEsperadas[2]>=datosEntrada[5]+0.5*datosEntrada[5]){
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=0;
			salidasEsperadas[14]=0;
		}
		else if(datosEntrada[5]>=salidasEsperadas[2]+4*salidasEsperadas[2]){
			salidasEsperadas[10]=0;
			salidasEsperadas[11]=0;
			salidasEsperadas[12]=0;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=0;
		}
		else if(datosEntrada[5]>=salidasEsperadas[2]+3.5*salidasEsperadas[2]){
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=0;
			salidasEsperadas[12]=0;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=0;
		}
		else if(datosEntrada[5]>=salidasEsperadas[2]+3*salidasEsperadas[2]){
			salidasEsperadas[10]=0;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=0;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=0;
		}
		else if(datosEntrada[5]>=salidasEsperadas[2]+2.5*salidasEsperadas[2]){
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=0;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=0;
		}
		else if(datosEntrada[5]>=salidasEsperadas[2]+2*salidasEsperadas[2]){
			salidasEsperadas[10]=0;
			salidasEsperadas[11]=0;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=0;
		}
		else if(datosEntrada[5]>=salidasEsperadas[2]+1.5*salidasEsperadas[2]){
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=0;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=0;
		}
		else if(datosEntrada[5]>=salidasEsperadas[2]+1*salidasEsperadas[2]){
			salidasEsperadas[10]=0;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=0;
		}
		else if(datosEntrada[5]>=salidasEsperadas[2]+0.5*salidasEsperadas[2]){
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=0;
		}
		else{
			salidasEsperadas[10]=1;
			salidasEsperadas[11]=1;
			salidasEsperadas[12]=1;
			salidasEsperadas[13]=1;
			salidasEsperadas[14]=1;
		}
		
		if(salidasEsperadas[3]>=datosEntrada[8]+4*datosEntrada[8]){
			salidasEsperadas[15]=0;
			salidasEsperadas[16]=0;
			salidasEsperadas[17]=0;
			salidasEsperadas[18]=0;
			salidasEsperadas[19]=0;
		}
		else if(salidasEsperadas[3]>=datosEntrada[8]+3.5*datosEntrada[8]){
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=0;
			salidasEsperadas[17]=0;
			salidasEsperadas[18]=0;
			salidasEsperadas[19]=0;
		}
		else if(salidasEsperadas[3]>=datosEntrada[8]+3*datosEntrada[8]){
			salidasEsperadas[15]=0;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=0;
			salidasEsperadas[18]=0;
			salidasEsperadas[19]=0;
		}
		else if(salidasEsperadas[3]>=datosEntrada[8]+2.5*datosEntrada[8]){
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=0;
			salidasEsperadas[18]=0;
			salidasEsperadas[19]=0;
		}
		else if(salidasEsperadas[3]>=datosEntrada[8]+2*datosEntrada[8]){
			salidasEsperadas[15]=0;
			salidasEsperadas[16]=0;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=0;
			salidasEsperadas[19]=0;
		}
		else if(salidasEsperadas[3]>=datosEntrada[8]+1.5*datosEntrada[8]){
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=0;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=0;
			salidasEsperadas[19]=0;
		}
		else if(salidasEsperadas[3]>=datosEntrada[8]+1*datosEntrada[8]){
			salidasEsperadas[15]=0;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=0;
			salidasEsperadas[19]=0;
		}
		else if(salidasEsperadas[3]>=datosEntrada[8]+0.5*datosEntrada[8]){
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=0;
			salidasEsperadas[19]=0;
		}
		else if(datosEntrada[8]>=salidasEsperadas[3]+4*salidasEsperadas[3]){
			salidasEsperadas[15]=0;
			salidasEsperadas[16]=0;
			salidasEsperadas[17]=0;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=0;
		}
		else if(datosEntrada[8]>=salidasEsperadas[3]+3.5*salidasEsperadas[3]){
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=0;
			salidasEsperadas[17]=0;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=0;
		}
		else if(datosEntrada[8]>=salidasEsperadas[3]+3*salidasEsperadas[3]){
			salidasEsperadas[15]=0;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=0;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=0;
		}
		else if(datosEntrada[8]>=salidasEsperadas[3]+2.5*salidasEsperadas[3]){
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=0;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=0;
		}
		else if(datosEntrada[8]>=salidasEsperadas[3]+2*salidasEsperadas[3]){
			salidasEsperadas[15]=0;
			salidasEsperadas[16]=0;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=0;
		}
		else if(datosEntrada[8]>=salidasEsperadas[3]+1.5*salidasEsperadas[3]){
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=0;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=0;
		}
		else if(datosEntrada[8]>=salidasEsperadas[3]+1*salidasEsperadas[3]){
			salidasEsperadas[15]=0;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=0;
		}
		else if(datosEntrada[8]>=salidasEsperadas[3]+0.5*salidasEsperadas[3]){
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=0;
		}
		else{
			salidasEsperadas[15]=1;
			salidasEsperadas[16]=1;
			salidasEsperadas[17]=1;
			salidasEsperadas[18]=1;
			salidasEsperadas[19]=1;
		}
		double[] salidaCapaOculta1 = new double[capaOculta1.length];
		for(int i=0;i<capaOculta1.length;i++){
			salidaCapaOculta1[i] = capaOculta1[i].funcionActivacion(capaOculta1[i].funcionPropagacion(datosEntrada));
		}
		double[] salida = new double[capaSalida.length];
		for(int i=0;i<capaSalida.length;i++){
			salida[i] = capaSalida[i].funcionSalida(capaSalida[i].funcionActivacion(capaSalida[i].funcionPropagacion(salidaCapaOculta1)));
		}
		
		
		int errorTotal = 0;
		for(int i=0;i<this.capaSalida.length;i+=5){
			if(salida[i]!=salidasEsperadas[i] || salida[i+1]!=salidasEsperadas[i+1] || salida[i+2]!=salidasEsperadas[i+2] || salida[i+3]!=salidasEsperadas[i+3] || salida[i+4]!=salidasEsperadas[i+4])
				errorTotal+=1;
		}
		
		return errorTotal;

	}
	
	
	
	//Se transforma la cadena genetica de entrada en los pesos de la red neuronal y se sustituyen. La antigua configuracion de pesos se transforma en una cadena genetica y se devuelve.
	//Si las mutaciones están permitidas hay un riesgo bajo de que uno o varios pesos se cambien por un número aleatorio
	public double[] modificacionGenes(double[] cadenaGenetica, boolean mutacionesPermitidas){
		int contador=0;
		double[] viejaCadenaGenetica = new double[cadenaGenetica.length];
		for(int i=0;i<this.capaOculta1.length;i++){
			for(int j=0;j<this.capaOculta1[i].peso.length;j++){
				viejaCadenaGenetica[contador] = capaOculta1[i].peso[j];
				capaOculta1[i].peso[j] = cadenaGenetica[contador];
				if(mutacionesPermitidas){
					if(Math.floor(Math.random()*100)==5){
						capaOculta1[i].peso[j] = Math.random()*1000000000-Math.random()*1000000000;
					}
				}
				contador++;
			} 
		}
		for(int i=0;i<this.capaSalida.length;i++){
			for(int j=0;j<this.capaSalida[i].peso.length;j++){
				viejaCadenaGenetica[contador] = capaSalida[i].peso[j];
				capaSalida[i].peso[j] = cadenaGenetica[contador];
				if(mutacionesPermitidas){
					if(Math.floor(Math.random()*10)==5){
						capaSalida[i].peso[j] = Math.random()*1000000000-Math.random()*1000000000;
					}
				}
				contador++;
			}
		}
		return viejaCadenaGenetica;
	}

}
