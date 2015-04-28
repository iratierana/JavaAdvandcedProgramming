package objects;

import java.awt.Color;
import java.util.ArrayList;

public class Player extends Object{

	String name = "Player";
	
	public Player(int posX, int posY, int width, int height, int weight) {
		super(Color.yellow, posX, posY, width, height, weight);
		// TODO Auto-generated constructor stub
	}
	
	public boolean detectColisionWithObjectsSouth(ArrayList<Object> objectsList) {
		objectsListIt = objectsList.listIterator();
		Object object;
		while(objectsListIt.hasNext()){
			object = (Object) objectsListIt.next();
			if(object.southColision(this, object)){
				return true;
			}
		}
		return false;
	}

}
