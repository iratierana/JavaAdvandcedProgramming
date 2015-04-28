package exercise2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

public class Screen extends JFrame{

	DefaultListModel<Figure> listModel;
	
	public Screen (DefaultListModel<Figure> listModel){
		this.listModel = listModel;
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillOval(0, 0, 300, 300);
		
		for(int i=0; i<listModel.getSize();i++){
			if(listModel.get(i) instanceof Circle){
				Circle figure = (Circle) listModel.get(i);
				g.setColor(Color.BLACK);
		        g.fillOval(figure.getPosX(), figure.getPosY(), (int)(figure.getRadio()*2), (int)(figure.getRadio()*2));
			}
			if(listModel.get(i) instanceof Square){
				Square figure = (Square) listModel.get(i);
				g.setColor(Color.GREEN);
				g.fillRect(figure.getPosX(), figure.getPosY(), (int) figure.getSide1(), (int) figure.getSide2());
			}
		}
    }
	
}
