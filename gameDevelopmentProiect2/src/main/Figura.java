package main;

import java.awt.Color;
import java.awt.Graphics;



public abstract class Figura {

	float x, y, vx,vy;
	Color color;
	Form forma;
	
	public Figura(float x,float y,float vx, float vy){
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVx() {
		return vx;
	}

	public void setVx(float vx) {
		this.vx = vx;
	}

	public float getVy() {
		return vy;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

	abstract public void detectColisionWithWindow(int ancho, int alto);

	public void updatePosition(float dt) {
		x += vx * dt;
        y += vy * dt;
	}

	abstract public boolean detectColision(Figura figura);

	abstract public float getLimX();
	abstract public float getLimY();

	abstract public void paint(Graphics g) ;

	abstract public void inc(int i) ;
}
