package graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JPanel;

import player.Enemy;
import player.Player;
import objects.Object;

public class Screen extends JPanel{
	
	final int WINDOWWIDTH = 640;
	final int WINDOWHEIGHT = 480;
	final int GAMEZONEWIDTH = WINDOWWIDTH + 1000;
	final int GAMEZONEHEIGHT = WINDOWHEIGHT + 1000;
	final int frame = 30;
	
	Player player;
	ArrayList<Enemy> enemyList;
	ArrayList<Object> objectsList;
	ListIterator<Object> objectsListIt;
	
	int focusPosX, focusPosY;

	public Screen(Player player, ArrayList<Enemy> enemyList, ArrayList<Object> objectsList) {
		this.player = player;
		this.enemyList = enemyList;
		this.objectsList = objectsList;
		this.setPreferredSize(new Dimension(WINDOWWIDTH, WINDOWHEIGHT));
	}
	
	public void paint(Graphics g){
		focusPlayer();
		paintGameZone(g);
		paintObjectsList(g);
		paintPlayer(g, player);
		paintEnemyList(g, enemyList);
	}

	public int getFocusPosX() {
		return focusPosX;
	}

	public void setFocusPosX(int focusPosX) {
		this.focusPosX = focusPosX;
	}

	public int getFocusPosY() {
		return focusPosY;
	}

	public void setFocusPosY(int focusPosY) {
		this.focusPosY = focusPosY;
	}

	public void paintGameZone(Graphics g){
		Dimension dimension = this.getSize();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GAMEZONEWIDTH, GAMEZONEHEIGHT);
		//g.setColor(Color.WHITE);
        //g.fillRect(frame - focusPosX, frame - focusPosY, GAMEZONEWIDTH - (2*frame) + focusPosX + WINDOWWIDTH, GAMEZONEHEIGHT - (2*frame) + focusPosY + WINDOWHEIGHT);
	}
	
	public void paintPlayer(Graphics g, Player player) {
		g.setColor(player.getColor());
		g.fillOval(player.getPosX() - player.getRadio() - focusPosX, player.getPosY() - player.getRadio() - focusPosY, player.getRadio() * 2, player.getRadio() * 2);
	}
	
	private void paintEnemyList(Graphics g, ArrayList<Enemy> enemyList) {
		ListIterator enemyListIt = enemyList.listIterator();
		
		while(enemyListIt.hasNext()) paintEnemy(g, (Enemy) enemyListIt.next());
		
	}
	
	public void paintEnemy(Graphics g, Enemy enemy) {
		g.setColor(enemy.getColor());
		g.fillOval(enemy.getPosX() - enemy.getRadio() - focusPosX, enemy.getPosY() - enemy.getRadio() - focusPosY, enemy.getRadio() * 2, enemy.getRadio() * 2);
	}
	
	public void paintObjectsList(Graphics g){
		objectsListIt = objectsList.listIterator();
		
		while(objectsListIt.hasNext()) paintObject(g, objectsListIt.next());
	}
	
	public void paintObject(Graphics g, Object object){
		g.setColor(object.getColor());
		g.fillRect(object.getPosX() - focusPosX, object.getPosY() - focusPosY, object.getWidth(), object.getHeight());
	
	}
	
	private void focusPlayer(){
		if(player.getPosX() - focusPosX < frame){
			if(focusPosX > 0) focusPosX = player.getPosX() - frame;
		}
		if(focusPosX + WINDOWWIDTH - player.getPosX() < frame){
			if(focusPosX + WINDOWWIDTH < GAMEZONEWIDTH) focusPosX = player.getPosX() + frame - WINDOWWIDTH;
		}
		if(player.getPosY() - focusPosY < frame){
			if(focusPosY > 0) focusPosY = player.getPosY() - frame;
		}
		if(focusPosY + WINDOWHEIGHT - player.getPosY() < frame){
			if(focusPosY + WINDOWHEIGHT < GAMEZONEHEIGHT) focusPosY = player.getPosY() + frame - WINDOWHEIGHT;
		}
	}
	
}
