package mouseListenerBallMovement;

public class Main {

	Screen screen;
	
	public static void main(String[] args) {
		Main main = new Main();
		Ball ball = new Ball(30, 30, 200 ,200);
		main.screen = new Screen(ball);
		Window window = new Window("Touch the Ball Game", main.screen);
		//main.gameCicle();
		
	}
	
	public void gameCicle(){
		while(true){
			screen.repaint();
		}
	}

}
