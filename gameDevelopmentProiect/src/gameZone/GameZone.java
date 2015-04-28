package gameZone;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;

import objects.Object;
import objects.Player;

public class GameZone {
	ListIterator<Object> objectsListIt;
	final int WINDOWWIDTH = 640;
	final int WINDOWHEIGHT = 480;
	final int GAMEZONEWIDTH = WINDOWWIDTH;
	final int GAMEZONEHEIGHT = 960;
	final int FRAME = 30;
	public int posY;

	public void paint(Graphics g,Player player, ArrayList<Object> objectsList) {
		calibratePosY(player);
		paintGameZone(g);
		paintObjectsList(g, objectsList);
		paintPlayer(g, player);
		
	}
	
	private void calibratePosY(Player player) {
		while(player.posY <= this.posY + FRAME){
			if(posY == 0){
				break;
			}
			else{
				posY--;
			}
		}
		
		while(player.posY >= this.posY + WINDOWHEIGHT - FRAME){
			if(posY == GAMEZONEHEIGHT - WINDOWHEIGHT){
				break;
			}
			else{
				posY++;
			}
		}
		
	}

	public void paintGameZone(Graphics g){
		g.setColor(Color.WHITE);
        g.fillRect(0, 0, GAMEZONEWIDTH, GAMEZONEHEIGHT);
	}
	
	public void paintPlayer(Graphics g, Player player) {
		g.setColor(player.color);
		g.fillRect(player.posX, player.posY - this.posY, player.width, player.height);
	}
	
	public void paintObjectsList(Graphics g, ArrayList<Object> objectsList){
		objectsListIt = objectsList.listIterator();
		
		while(objectsListIt.hasNext()){
			paintObject(g, objectsListIt.next());
		}
	}
	
	public void paintObject(Graphics g, Object object){
		g.setColor(object.color);
		g.fillRect(object.posX, object.posY - this.posY, object.width, object.height);
	
	}
	
}
