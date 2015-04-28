package main;

import java.awt.Color;
import java.util.ArrayList;

import objects.Object;
import objects.Player;
import objects.Platform;
import Graphics.Window;

public class Main {
	
	Window window;
	ArrayList<Object> objectsList;
	
	
	public final int EASTFRAME = 2;
	public final int WESTFRAME = 2;
	public final int NORTHFRAME = 22;
	public final int SOUTHFRAME = 3;
	

	public static void main(String[] args) {
		Main game = new Main();
		game.initialize();
	}
	
	public void initialize(){
		objectsList = new ArrayList<Object>();
		Player player = new Player(100, 100, 40, 40, 1);
		/*
		Rock rock = new Rock(10,10, 10, 10);
		obstaclesList.add(rock);
		Rock rock2 = new Rock(20,20, 10, 10);  
		obstaclesList.add(rock2);
		Rock rock3 = new Rock(30,30, 10, 10);
		obstaclesList.add(rock3);
		Rock rock4 = new Rock(40,40, 10, 10);
		obstaclesList.add(rock4);
		Rock rock5 = new Rock(50,50, 10, 10);
		obstaclesList.add(rock5);
		*/
		Platform platform1 = new Platform (200, 100, 100, 30);
		objectsList.add(platform1);
		Platform platform2 = new Platform (200, 500, 100, 30);
		objectsList.add(platform2);
		Platform platform3 = new Platform (200, 700, 100, 30);
		objectsList.add(platform3);
		Platform platform4 = new Platform (200, 900, 100, 30);
		objectsList.add(platform4);
		
		window = new Window("gameWindow1", player, objectsList);
		window.repaint();
	}

}