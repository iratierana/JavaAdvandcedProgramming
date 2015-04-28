package circlesGame;

import java.util.Random;

public class Circle {

	int x;
	int y;
	int radius;
	
	public Circle(){
		Random randomGenerator = new Random();
		
		do{
			x = randomGenerator.nextInt(640);
			y = randomGenerator.nextInt(480);
			radius = randomGenerator.nextInt(10);
			
		}while((x+radius<=639)&&(x-radius>=0)&&(y+radius<=479)&&(y-radius>=0));
		
		Screen.paintCircles();
	}
	
	public boolean checkHit(int x, int y){
		if((this.x+radius>=x)&&(this.x-radius<=x)){
			if((this.y+radius>=y)&&(this.y-radius<=y)){
				this.x = 1000;
				this.y = 1000;
				return true;
			
			}	
		}
		
		return false;
	}
}
