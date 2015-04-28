package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import player.Enemy;
import player.Player;
import objects.Object;


public class Window extends JFrame implements KeyListener{
	
	Screen screen;
	Player player;
	Map map;
	ArrayList<Enemy> enemyList;
	ArrayList<Object> objectsList;
	final int KEYSTRENGTHVALUE = 10;
	JLabel secondsLabel;
	long firstMiliSecond;
	long lastMiliSecond;
	int seconds;
	
	public Window (String name, Player player, ArrayList<Enemy> enemyList, ArrayList<Object> objectsList){
		
		this.player = player;
		this.enemyList = enemyList;
		this.objectsList = objectsList;
		this.setLocation(50, 50);
		this.setContentPane(setPane());
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.addKeyListener(this);
		
		firstMiliSecond = System.currentTimeMillis();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private Container setPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(setScreen(new Screen(player, enemyList, objectsList)), BorderLayout.CENTER);
		panel.add(dataPanel(), BorderLayout.EAST);
		return panel;
	}

	private Component dataPanel() {
		JPanel panel = new JPanel(new GridLayout(2,1,10,10));
		panel.add(timerPanel());
		panel.add(map = new Map(screen.GAMEZONEWIDTH, screen.GAMEZONEHEIGHT, player, enemyList, objectsList));
		return panel;
	}

	private Component timerPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		secondsLabel = new JLabel();
		panel.add(secondsLabel, BorderLayout.CENTER);
		return panel;
	}

	public void reloadScreen() {
		screen.repaint();
		lastMiliSecond = System.currentTimeMillis();
		seconds = (int) ((lastMiliSecond - firstMiliSecond)/1000);
		secondsLabel.setText(Integer.toString(seconds));
		map.setPosX(screen.getFocusPosX()/10 + screen.getFocusPosX()%10);
		map.setPosY(screen.getFocusPosY()/10 + screen.getFocusPosY()%10);
		map.repaint();
		
	}
	
	private void gameCicle() {
		Random generator = new Random();
		boolean alive = true;
		ListIterator<Enemy> enemyListIt = enemyList.listIterator();
		ListIterator<Object> objectsListIt = objectsList.listIterator();
		double changeTime = System.currentTimeMillis() + 5000;
		
		do{
			enemyListIt = enemyList.listIterator();
			objectsListIt = objectsList.listIterator();
			
			player.strengthToMovements();
			while(objectsListIt.hasNext()) player.checkColision(objectsListIt.next());

			while(enemyListIt.hasNext()){
				Enemy enemy = enemyListIt.next();
				enemy.movements(player);
				objectsListIt = objectsList.listIterator();
				while(objectsListIt.hasNext()) enemy.checkColision(objectsListIt.next());
			}

			
			this.reloadScreen();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(changeTime < System.currentTimeMillis()) {
				enemyListIt = enemyList.listIterator();
				while(enemyListIt.hasNext()) ((Enemy) enemyListIt.next()).addWeight(1);
				float r = generator.nextFloat();
				float g = generator.nextFloat();
				float b = generator.nextFloat();
				Color randomColor = new Color(r, g, b);
				enemyList.add(new Enemy(300, 300, 5, 1, randomColor));
				changeTime = System.currentTimeMillis() + 5000;
			}
			
			enemyListIt = enemyList.listIterator();
			while(enemyListIt.hasNext()){
				if(player.checkPosition((Enemy) enemyListIt.next())){
					alive = false;
					this.dispose();
				}
			}
			
			
		}while(alive);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()){
		
		case KeyEvent.VK_UP:
			
			player.setStrengthYNegative(KEYSTRENGTHVALUE);
			
			break;
			
		case KeyEvent.VK_DOWN:
			
			player.setStrengthYPositive(KEYSTRENGTHVALUE);
			
			break;
		
		case KeyEvent.VK_RIGHT:
			
			player.setStrengthXPositive(KEYSTRENGTHVALUE);
			
			break;
		
		case KeyEvent.VK_LEFT:

			player.setStrengthXNegative(KEYSTRENGTHVALUE);
			
			break;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		switch(arg0.getKeyCode()){
		
		case KeyEvent.VK_UP:
			
			player.setStrengthYNegative(0);
			
			break;
			
		case KeyEvent.VK_DOWN:
			
			player.setStrengthYPositive(0);
			
			break;
		
		case KeyEvent.VK_RIGHT:
			
			player.setStrengthXPositive(0);
			
			break;
		
		case KeyEvent.VK_LEFT:

			player.setStrengthXNegative(0);
			
			break;
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public Screen getScreen() {
		return screen;
	}

	public Screen setScreen(Screen screen) {
		this.screen = screen;
		return screen;
	}
	
}
