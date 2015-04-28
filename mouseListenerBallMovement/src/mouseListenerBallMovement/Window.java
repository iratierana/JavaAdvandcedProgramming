package mouseListenerBallMovement;

import javax.swing.JFrame;

public class Window extends JFrame{

	Screen screen;
	
	public Window(String title, Screen screen){
		super(title);
		this.screen = screen;
		this.setLocation(100, 100);		
		this.setVisible (true);
		this.setContentPane(screen);
		this.pack();
		//this.addMouseMotionListener(screen);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
