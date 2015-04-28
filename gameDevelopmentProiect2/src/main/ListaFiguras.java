package main;

import java.awt.Graphics;
import java.util.ArrayList;



public class ListaFiguras {
	
	ArrayList<Figura> lista;
	
	public ListaFiguras (){
		lista = new ArrayList<Figura>();
	}
	public void add( Figura f){
		lista.add(f);
	}
	public void actualizarPosiciones(float dt) {
		for (Figura f: lista){
			f.updatePosition(dt);
		}
	}
	public void detectarColisionesConMarco(int ancho, int alto) {
		for (Figura f: lista){
			f.detectColisionWithWindow(ancho, alto);
		}
	}
	public void detectarColisionesFiguras() {
		ArrayList<Figura> borrar = new ArrayList<Figura>();
		
		for (int i = 0; i<(lista.size()-1); i++){
			Figura f = lista.get(i);
			for (int j= i+1; j< lista.size(); j++){
				Figura g = lista.get(j);
				if (f.detectColision(g)){
					colisionar(f,g,borrar);
				}
			}
		}
		lista.removeAll(borrar);
		
	}
	private void colisionar(Figura f, Figura g, ArrayList<Figura> borrar) {
		if (f instanceof Destructor){
			if (g instanceof Bola){
				f.inc(2);
				borrar.add(g);
			}
		}else if (g instanceof Bola){
			
			float vxf = f.getVx(); float vyf = f.getVy();
			float vxg = g.getVx(); float vyg = g.getVy();
			f.setVx(vxg); f.setVy(vyg);
			g.setVx(vxf); g.setVy(vyf);
			
		}else{
			g.inc(2);
			borrar.add(f);
		}
	}
	public void paint(Graphics g) {
		for (Figura f : lista){
			f.paint(g);
		}
		
	}
}
