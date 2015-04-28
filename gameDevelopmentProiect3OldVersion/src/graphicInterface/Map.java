package graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import objects.Object;
import objects.Platform;
import player.Enemy;
import player.Player;

public class Map extends JPanel{
	
	int width, height;
	int posX, posY;
	Player player;
	ArrayList<Enemy> enemyList;
	ArrayList<Object> objectsList;

	public Map(int width, int height, Player player, ArrayList<Enemy> enemyList, ArrayList<Object> objectsList){
		this.width = width/10 + width%10;
		this.height = height/10 + height%10;
		this.setPreferredSize(new Dimension(width/10 + width%10, height/10 + height%10));
		this.player = player;
		this.enemyList = enemyList;
		this.objectsList = objectsList;
	}
	
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void paint(Graphics g){
		ListIterator<Enemy> enemyListIt = enemyList.listIterator();
		ListIterator<Object> objectsListIt = objectsList.listIterator();
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(posX, posY, 60, 40);
		
		while(objectsListIt.hasNext()){
			Object object = objectsListIt.next();
			if(object instanceof Platform){
				g.setColor(Color.BLACK);
				g.fillRect(object.getPosX()/10, object.getPosY()/10, object.getWidth()/10, object.getHeight()/10);
			}
		}
		
		while(enemyListIt.hasNext()){
			Enemy enemy = enemyListIt.next();
			g.setColor(Color.RED);
			g.fillOval(enemy.getPosX()/10, enemy.getPosY()/10, 1, 1);
		}
		
		g.setColor(Color.YELLOW);
		g.fillOval(player.getPosX()/10, player.getPosY()/10, 3, 3);
	}

}
