package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Demo1 extends JPanel {
	
	final int NUMREPRODUCTORESINICIO = 50;
	final int NUMDESTRUCTORESINICIO = 1;
	
    private final static int ANCHO = 1300;

    private final static int ALTO = 650;

   

   ListaFiguras lista;

    public Demo1() {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        lista = new ListaFiguras();
        inicializar();
    }

    private void inicializar() {
    	Random generador = new Random();
    	
		for (int i = 0; i < NUMREPRODUCTORESINICIO; i++){
			float x= generador.nextFloat()*ANCHO;
			float y = generador.nextFloat()*ALTO;
			float vx = generador.nextFloat() * 500;
			float vy = (float) Math.sqrt(Math.pow(500.0,2.0)-Math.pow(vx,2.0));
			Figura f = new Bola(x,y,300,400);
			lista.add(f);
		}
		for (int i = 0; i < NUMDESTRUCTORESINICIO; i++){
			float x= generador.nextFloat()*ANCHO;
			float y = generador.nextFloat()*ALTO;
			Figura f = new Destructor(x,y,150,200);
			lista.add(f);
		}
		
	}

	private void fisica(float dt) {
		lista.actualizarPosiciones(dt);
        lista.detectarColisionesConMarco(ANCHO,ALTO);
        lista.detectarColisionesFiguras();
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, ANCHO, ALTO);
        lista.paint(g);
    }

    private void dibuja() throws Exception {
       
    	this.repaint();
    }

    public void cicloPrincipalJuego() throws Exception {
        long tiempoViejo = System.nanoTime();
        float dt = 0.01f;
        while (true) {
        	Thread.sleep(10);
        	fisica(dt);
            dibuja();
        }
    }

    public static void main(String[] args) throws Exception {
    	JFrame jf = new JFrame("Demo1");
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        Demo1 demo1 = new Demo1();
        jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
    }
}
