package circlesGame;
import javax.swing.*; 

import java.awt.*; 
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Screen extends JFrame { 

	public Screen() { 
		super("Circles Game"); 
		setSize(640,480); 
		setVisible(true); 
	} 
	
	
	public void paint(Graphics g) { 
		 // Cambiamos el color del fondo del framse 
		getContentPane().setBackground(Color.white); 
		// Dibujamos texto 
		Font f = new Font("Arial", Font.BOLD + Font.ITALIC, 14); 
		g.setFont(f); 
		g.drawString("Tenemos los mejores profes de Java",24,160); 
		// Dibujamos líneas 
		g.setColor(Color.red); 
		g.drawLine(24,135,265,135); 
		g.setColor(Color.blue); 
		g.drawLine(24,175,265,175); 
		// Dibujamos un rectángulo 
		g.setColor(Color.black); 
		g.drawRect(12,119,265,70); 
		// Dibujamos un triángulo (polígono) 
		 int[] xCoords = new int[4]; 
		 int[] yCoords = new int[4]; 
		xCoords[0]=150; 
		yCoords[0]=35; 
		xCoords[1]=100; 
		yCoords[1]=100; 
		xCoords[2]=200; 
		yCoords[2]=100; 
		g.setColor(Color.green); 
		g.drawPolygon(xCoords,yCoords,3); 
		// Dibujamos óvalos 
		g.setColor(Color.orange); 
		g.fillOval(107,200,85,85); 
		g.setColor(Color.black); 
		g.drawOval(120,220,20,10); 
		g.drawOval(158,220,20,10); 
		 // Dibujamos un arco 
		g.drawArc(128,235,40,35,190,160); 
	} 
	
	public static void paintCircles(Graphics g, Circle circle){
		
	}
	
	public static void screenMain() { 
		Screen mf = new Screen(); 
		mf.repaint(); 
		mf.addWindowListener( new WindowAdapter() { 
		 public void windowClosing( WindowEvent evt ){ 
		 System.exit( 0 );} 
		}); 
	}

}

