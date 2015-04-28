import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends JFrame implements ActionListener{
	
	JFrame window;
	JLabel text;
	JButton increment, decrement, exit, one, three, five;
	int incrementDecrementValue;

	public static void main(String[] args) {
		Main exercise = new Main("Incremental Click Counter", 100, 100);

	}
	
	public Main(String title, int posX, int posY) {
		window = new JFrame(title);
		window.setSize(600, 400);
		window.setLocation(posX, posY);
		
		window.setContentPane(createWindowPanel());
		
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private Container createWindowPanel(){
		JPanel panel = new JPanel (new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,40,20));
		text = new JLabel("0");
		text.setFont(new Font("calibri", Font.PLAIN, 20));
		text.setForeground(Color.black);
		text.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		panel.add(text,BorderLayout.CENTER);
		panel.add(createNumbersButtonPanel(),BorderLayout.EAST);
		panel.add(createActionsButtonPanel(),BorderLayout.SOUTH);
		return panel;

	}
	
	private Component createNumbersButtonPanel() {
		JPanel panel = new JPanel (new GridLayout(3,1));
		panel.setBackground(Color.white);
		
		one = new JButton("1");
		three = new JButton("3");
		five = new JButton("5");
		
		one.addActionListener(this);
		three.addActionListener(this);
		five.addActionListener(this);
		
		panel.add(one);
		panel.add(three);
		panel.add(five);
		
		return panel;

		
	}
	
	private Component createActionsButtonPanel() {
		JPanel panel = new JPanel (new GridLayout(1,3));
		panel.setBackground(Color.white);
		
		
		increment = new JButton("Increment");
		decrement = new JButton("Decrement");
		exit = new JButton("Exit");
		
		increment.addActionListener(this);
		decrement.addActionListener(this);
		exit.addActionListener(this);
		
		panel.add(increment);
		panel.add(decrement);
		panel.add(exit);
		
		return panel;
		
	}

	public void actionPerformed(ActionEvent evt) {
	    Object src = evt.getSource();
	    
	    if (src == one) {
	    	incrementDecrementValue = 1;
	    }
	    if (src == three) {
	    	incrementDecrementValue = 3;
	    }
	    if (src == five) {
	    	incrementDecrementValue = 5;
	    }
	    if (src == increment) {
	    	int value = Integer.parseInt(text.getText());
			text.setText(String.valueOf(value + incrementDecrementValue));
	    }
	    if (src == decrement) {
	    	int value = Integer.parseInt(text.getText());
	    	text.setText(String.valueOf(value - incrementDecrementValue));
	    }
	    if (src == exit) {
	    	window.setVisible(false);
	    }
	  }


}
