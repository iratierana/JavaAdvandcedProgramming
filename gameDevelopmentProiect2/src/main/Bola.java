package main;

import java.awt.Color;
import java.awt.Graphics;



public class Bola extends Figura {
	
	final int DIAMETER = 20;
	
	public Bola (float x, float y, float vx, float vy){
		super (x,y,vx,vy);
		forma = Form.CIRCLE;
		color = Color.blue;
	}

	@Override
	public void detectColisionWithWindow(int width, int height) {
		if (vx < 0 && x <= 0 || vx > 0 && x + DIAMETER >= width)
            vx = -vx;
        if (vy < 0 && y < 0 || vy > 0 && y + DIAMETER >= height)
            vy = -vy;
	}

	@Override
	public boolean detectColision(Figura figura) {
		boolean colision = false;
		float limX, limY;
		limX= figura.getLimX();
		limY = figura.getLimY();
		if (((x>figura.x && x<limX)||((x+DIAMETER)>figura.x && (x+DIAMETER)<limX)) &&
			((y>figura.y && y<limY)||((y+DIAMETER)>figura.y && (y+DIAMETER)<limY))){
			
			colision = true;
		}
		return colision;	
	}

	@Override
	public float getLimX() {
		
		return x+DIAMETER;
	}

	@Override
	public float getLimY() {
		
		return y+DIAMETER;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int) y, DIAMETER, DIAMETER);
		
	}

	@Override
	public void inc(int i) {
		// TODO Auto-generated method stub
		
	}
}
