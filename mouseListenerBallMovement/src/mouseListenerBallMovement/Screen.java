package mouseListenerBallMovement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Screen extends JPanel implements MouseMotionListener{

	Ball ball;
	Color screenColor = Color.WHITE;
	
	public Screen(Ball ball){
		this.setPreferredSize(new Dimension(640, 480));
		this.ball = ball;
		this.addMouseMotionListener(this);
	}
	
	public void paint(Graphics g){
		g.setColor(screenColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(ball.getColor());
        g.fillOval(ball.posX, ball.posY, ball.width, ball.height);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		int distance = 0;
		int distanceX = 0;
		int distanceY = 0;
		distanceX = arg0.getX() - ball.getPosX() - (ball.getWidth()/2);
		distanceY = arg0.getY() - ball.getPosY() - (ball.getHeight()/2);
		distance = (int) Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
		if(distance < 50){
			if(distanceX < 0){
				ball.setPosX(ball.getPosX() + 2);
			}
			if(distanceX > 0){
				ball.setPosX(ball.getPosX() - 2);
			}
			if(distanceY < 0){
				ball.setPosY(ball.getPosY() + 2);
			}
			if(distanceY > 0){
				ball.setPosY(ball.getPosY() - 2);
			}
		}
		this.repaint();
		if(ball.getPosX() + (ball.getWidth()/2) < 30){
			ball.setPosX(ball.getPosX() + 2);
		}
		if(ball.getPosX() + (ball.getWidth()/2) > this.getWidth() - 30){
			ball.setPosX(ball.getPosX() - 2);
		}
		if(ball.getPosY() + (ball.getHeight()/2) < 30){
			ball.setPosY(ball.getPosY() + 2);
		}
		if(ball.getPosY() + (ball.getHeight()/2) > this.getHeight() - 30){
			ball.setPosY(ball.getPosY() - 2);
		}
		
		if (distance>200) ball.setColor(Color.YELLOW);
		else{
			if(distance>100) ball.setColor(Color.GREEN);
			else{
				if(distance>50) ball.setColor(Color.BLUE);
				else{
					if(distance>25) ball.setColor(Color.CYAN);
					else{
						if(distance>(ball.getWidth()/2)){
							ball.setColor(Color.BLACK);
							screenColor = Color.GRAY;
							Toolkit.getDefaultToolkit().beep();
							
						}
					}
				}
			}
		}
		
	}

}
