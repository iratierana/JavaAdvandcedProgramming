package main;

import java.awt.Color;
import java.awt.Graphics;


public class Destructor extends Figura {

	final int LADO = 10;
	int lado;
	
	public Destructor(float x, float y, float vx, float vy){
		super (x,y,vx,vy);
		forma = Form.CIRCLE;
		color = Color.red;
		lado = LADO;
	}

	@Override
	public void detectColisionWithWindow(int width, int height) {
		if (vx < 0 && x <= 0 || vx > 0 && x + lado >= width)
            vx = -vx;
        if (vy < 0 && y < 0 || vy > 0 && y + lado >= height)
            vy = -vy;
	}

	@Override
	public boolean detectColision(Figura figura) {
		boolean colision = false;
		float limX, limY;
		limX= figura.getLimX();
		limY = figura.getLimY();
		if (((x>figura.x && x<limX)||((x+lado)>figura.x && (x+lado)<limX)) &&
			((y>figura.y && y<limY)||((y+lado)>figura.y && (y+lado)<limY))){
			colision = true;
		}
		return colision;	
	}
	
	@Override
	public float getLimX() {
		
		return x+lado;
	}

	@Override
	public float getLimY() {
		
		return y+lado;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval((int)x, (int) y, lado, lado);
			
	}

	@Override
	public void inc(int i) {
		lado+=i;
		
	}
}
