package objects;

import java.awt.Color;

public class Rock extends Object{
	
	public int width, height;

	public Rock(int posX, int posY, int width, int height) {
		super(Color.black, posX, posY, width, height, 1);
	}

}
