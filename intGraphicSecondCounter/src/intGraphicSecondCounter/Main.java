package intGraphicSecondCounter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {
	
	JFrame window;
	JLabel text;
	JButton buttonPlus, buttonMinus;
	int direction = 1;
	int seconds;
	boolean counting = false;
	
	public static void main(String[] args) {
		Main secondCounter = new Main(300,100);

	}
	
	public Main(int posX, int posY){
		 window = new JFrame("Click Counter");
		 window.setSize(640,480);
		 window.setLocation(posX, posY);
		 
		 window.setContentPane(createWindowPane());
		 
		 window.setVisible (true);
		 
		 
		 
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private Container createWindowPane() {
		JPanel panel = new JPanel (new BorderLayout());
		text = new JLabel("0");
		text.setFont(new Font("calibri", Font.CENTER_BASELINE, 80));
		text.setForeground(Color.cyan);
		text.setHorizontalAlignment(JLabel.CENTER);
		
		
		panel.add(text, BorderLayout.CENTER);
		panel.add(createButtonPanel(),BorderLayout.SOUTH);

		panel.setBackground(Color.yellow);
		 
		
		return panel;
	}

	private Component createButtonPanel() {
		JPanel panel = new JPanel();
		buttonPlus = new JButton ("Start");
		buttonPlus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				counting = true;
				secondsCounter();
			}
			
			
		});
		
		buttonMinus = new JButton ("Stop");
		buttonMinus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				counting = false;
				
			}
			
			
		});

		panel.add(buttonMinus);
		panel.add(buttonPlus);
		return panel;
	}

	private void secondsCounter(){
		while (counting == true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			text.setText(String.valueOf(seconds));
			seconds++;
			
		}
	}
	
}

