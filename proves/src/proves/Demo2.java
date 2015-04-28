package proves;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Demo2 extends JPanel implements KeyListener{

    private final static int ANCHO = 512;

    private final static int ALTO = 384;

    private final static int DIAMETRO = 20;
    
    private final static int ANCHOPALA = 60;
    
    private final static int GROSORPALA = 20;
    
    private final static int POSINIPALAY = 344;
    
    private final static int POSINIPALAX = 240;
    
    private float x, y;
    private int px,py,incX;

    private float vx, vy;

    public Demo2()  {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        x = 10;
        y = 20;
        vx = 300;
        vy = 400;
        px = POSINIPALAX;
        py = POSINIPALAY;
        incX = 10;
        
        
    }

    private void fisica(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (vx < 0 && x <= 0 || vx > 0 && x + DIAMETRO >= ANCHO)
            vx = -vx;
        
        if (vy < 0 && y < 0 || vy > 0 && y + DIAMETRO >= ALTO 
        		|| vy>0 && (y+DIAMETRO>=py&&(x>px&&x<px+ANCHOPALA)))
            vy = -vy;
        
        if (incX<0){
        	px = ((px+incX)<0 )? 0 : px+incX;
        }
        if (incX>0){
        	px = ((px+incX+ANCHOPALA)>ANCHO)?ANCHO-ANCHOPALA : px+incX;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, ANCHO, ALTO);
        g.setColor(Color.RED);
        g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
        g.setColor(Color.GREEN);
        g.fillRect(px,py,ANCHOPALA,GROSORPALA);
    }

    private void dibuja() throws Exception {
    	/*
        SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    paintImmediately(0, 0, ANCHO, ALTO);
                }
            });
        */
    	repaint();
    }

    public void cicloPrincipalJuego() throws Exception {
        long tiempoViejo = System.nanoTime();
        while (true) {
            /*long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
            tiempoViejo = tiempoNuevo;
            */
        	Thread.sleep(10);
        	float dt = 0.01f;
        	fisica(dt);
            dibuja();
            
        }
    }

    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("Demo1");
        jf.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        jf.setResizable(false);
        Demo2 demo1 = new Demo2();
        jf.setContentPane(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.setFocusable(true);
        demo1.addKeyListener(demo1);
        demo1.cicloPrincipalJuego();
    }

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			incX = -20;
		if  (e.getKeyCode() == KeyEvent.VK_RIGHT)
			incX = 20;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			incX = 0;
		if  (e.getKeyCode() == KeyEvent.VK_RIGHT)
			incX = 0;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
