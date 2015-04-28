package Graphics;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import objects.Object;
import objects.Player;;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener, ItemListener {
	
	public GameWindow gameWindow;
	
	public Window (String name, Player player, ArrayList<Object> objectsList){
		
		this.setTitle(name);  //DOES NOT WORK
		gameWindow = new GameWindow(player, objectsList);
		this.setLocation(0, 0);
		this.add(gameWindow);
		//this.setContentPane(gameWindow);
		//this.pack();
		this.setSize(640,480);
		//this.setResizable(false);
		this.setVisible(true);
		
		try {
			this.gameCicle();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
		gameWindow.repaint();
    }
	
	
	
	public void gameCicle() throws InterruptedException {
		while (true) {
        	Thread.sleep(50);
        	gameWindow.phisics();
        	this.repaint();
        }
		
	}

}
