package Graphics;

import gameZone.GameZone;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JPanel;

import objects.Object;
import objects.Player;

public class GameWindow extends JPanel implements ActionListener, ItemListener , KeyListener{

	final int WINDOWWIDTH = 640;
	final int WINDOWHEIGHT = 480;
	final int GAMEZONEWIDTH = WINDOWWIDTH;
	final int GAMEZONEHEIGHT = 960;
	GameZone gameZone;
	Player player;
	ArrayList<Object> objectsList;
	ListIterator<Object> objectsListIt;
	
	
	public GameWindow(Player player, ArrayList<Object> objectsList){
		gameZone = new GameZone();
		this.player = player;
		this.objectsList = objectsList;
		this.setSize(WINDOWWIDTH, WINDOWHEIGHT);
		this.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	public void paint(Graphics g) {
		gameZone.paint(g, player, objectsList);
    }
	
	public void phisics() {
		objectsListIt = objectsList.listIterator();
		player.phisics(GAMEZONEWIDTH, GAMEZONEHEIGHT, objectsList);
		
		while(objectsListIt.hasNext()){
			Object object = objectsListIt.next();
			object.phisics(GAMEZONEWIDTH, GAMEZONEHEIGHT, objectsList);
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()){
		case KeyEvent.VK_UP:
			
			if(((player.posY + player.width)>= GAMEZONEHEIGHT)||(player.detectColisionWithObjectsSouth(objectsList))){
				player.speedY = -20;
			}
			break;
			
		case KeyEvent.VK_DOWN:
			
			break;
		
		case KeyEvent.VK_RIGHT:
			player.speedX = 10;
			break;
		
		case KeyEvent.VK_LEFT:
			player.speedX = -10;
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
