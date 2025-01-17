package interfaz;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import analisisDatos.AnalisisDatos;
import dataBase.VistaDatos;
import dataBase.JDBC;
import dataBase.VistaDatos;

/**
 * dibuja los graficos de regresion lineal con los datos de la BD y los plotea
 * @author gorka
 *
 */
public class PanelGraficos extends JPanel{
	AnalisisDatos analisis;
	
	public PanelGraficos(){
		analisis = new AnalisisDatos();
 		analisis.analizarTodo();
 		
		this.setLayout(new GridLayout(2,2));
		this.add(Grafico4());        
		this.add(Grafico2());
		this.add(Grafico3());
		this.add(Grafico1());    	
	}
	/**
	 * muestra un historico de las temperaturas de los ultimos 3 dias
	 * @return
	 */

	private Component Grafico4() {List<Double> scores = new ArrayList<>();
    JDBC dbconnection = new JDBC();
    List<VistaDatos> vacas = dbconnection.getVistaTempAmb();
    if ((vacas.size()-144)<0){

        for (int i = 0; i < vacas.size(); i++) {
            scores.add((double) vacas.get(i).getValor());
        }
    }else{
    	for (int i = (vacas.size()-144); i < vacas.size(); i++) {  //se recogen 144 datos cada 3 dias
        scores.add((double) vacas.get(i).getValor());
        }
    }
	GraphPanel grafico4 = new GraphPanel(scores);
	grafico4.setBorder(BorderFactory.createTitledBorder("Historico temperaturas"));
	
	return grafico4;
	}
	 /**
	  * Realiza un grafico con la regresion lineal de la produccion en funcion de la temperatura
	  * @return
	  */
	private Component Grafico3() {

 		
 		String temperatura = analisis.getaTemp().getEcuacion();
		
		int i= 0;
		double grado0=0, grado1=0, grado2=0 ;
		StringTokenizer st = new StringTokenizer(temperatura,"+*x",true);
       while (st.hasMoreTokens()) {  
       	if (i==0){
           	grado0 = Double.parseDouble(st.nextToken());
       	}
       	if (i==1){
           	grado1 = Double.parseDouble(st.nextToken());
       	}
       	if (i==5){
           	grado2
           	= Double.parseDouble(st.nextToken());
       	}
       	i++;
       	st.nextToken();
       }
       Component miGraficador = new Graficador("Temperatura", -20.0, 55.0, "Temperatra �C","Producci�n", grado2, grado1, grado0);
       JPanel panel = new JPanel();
       panel.add(miGraficador);
       panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		
		return panel;
	}
	/**
	 * Realiza un grafico con la regresion lineal de la produccion en funcion de la ingesta
	 * @return
	 */
	private Component Grafico2() {
		
		int i= 0;
		double coeficiente=0, exponente=0 ;
		coeficiente = analisis.getaIng().getA();
		exponente = analisis.getaIng().getB();

       Component miGraficador = new Graficador("Ingesta", -1.0, 100.0, "Kg ingeridos","Producci�n", coeficiente, exponente);
       JPanel panel = new JPanel();
       panel.add(miGraficador);
       panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		
		return panel;
	}

    /**
     * Realiza un grafico con la regresion lineal de la produccion en funcion de la humedad
     */
	private Component Grafico1() {
		
 		String humedad = analisis.getaHum().getEcuacion();
 		
 		int i= 0;
 		double grado0=0, grado1=0, grado2=0 ;
 		StringTokenizer st = new StringTokenizer(humedad,"+*x",true);
        while (st.hasMoreTokens()) {  
        	if (i==0){
            	grado0 = Double.parseDouble(st.nextToken());
        	}
        	if (i==1){
            	grado1 = Double.parseDouble(st.nextToken());
        	}
        	if (i==5){
            	grado2 = Double.parseDouble(st.nextToken());
        	}
        	i++;
        	st.nextToken();
        }
        
        Component miGraficador = new Graficador("Humedad",0.0, 100.0,"Humedad relativa","Producci�n", grado2, grado1, grado0);
        JPanel panel = new JPanel();
        panel.add(miGraficador);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
 		
		return panel;
	}

}
