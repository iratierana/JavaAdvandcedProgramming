package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import player.Enemy;
import player.Player;
import objects.Object;
import objects.Platform;
import graphicInterface.Window;
import movements.Colision;

public class Main {
	
	Player player;
	ArrayList<Enemy> enemyList;
	ArrayList<Object> objectsList;
	Window window;

	public static void main(String[] args) {
		Main main = new Main();
		main.player = new Player(50, 50, 10, 1, Color.YELLOW);
		main.enemyList = new ArrayList<Enemy>();
		main.enemyList.add(new Enemy(300, 300, 5, 1, Color.GRAY));
		main.objectsList = new ArrayList<Object>();
		main.objectsList.add(new Platform(100, 100, 100, 100, 0, Color.BLUE));
		main.objectsList.add(new Platform(400, 200, 200, 200, 0, Color.BLUE));
		main.objectsList.add(new Platform(700, 100, 100, 100, 0, Color.BLUE));
		main.objectsList.add(new Platform(400, 600, 200, 200, 0, Color.BLUE));

		
		main.window = new Window("game", main.player, main.enemyList, main.objectsList);
		main.gameCicle();
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

			
			this.window.reloadScreen();

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
					window.dispose();
				}
			}
			
			
		}while(alive);
		
	}

}
