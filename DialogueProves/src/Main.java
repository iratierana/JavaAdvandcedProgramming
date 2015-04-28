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
import javax.swing.JTextField;


public class Main extends JFrame implements ActionListener{
	
	JFrame window;
	JButton buttonOne, buttonTwo, buttonThree, buttonFour;
	JButton buttonFive, buttonSix, buttonSeven;
	JTextField textField1, textField2;

	public static void main(String[] args) {
		Main program = new Main();
		program.program();

	}

	private void program() {
		window = new JFrame("Dialogue Proves");
		window.setSize(640,480);
		window.setLocation(300, 200);
		 
		window.setContentPane(createWindowPanel());
		 
		window.setVisible (true);
		 
		 
		 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private Container createWindowPanel() {
		JPanel panel = new JPanel (new BorderLayout());
		
		
		panel.add(createButtonPanel(),BorderLayout.SOUTH);
		
		panel.add(createTextFieldPanel(),BorderLayout.CENTER);

		panel.setBackground(Color.yellow);
		 
		
		return panel;
	}
	
	private Component createTextFieldPanel() {
		JTextField panel = new JTextField();
		textField1 = new JTextField();
		textField2 = new JTextField();
		
		textField1.setForeground(Color.cyan);
		textField2.setForeground(Color.cyan);
		
		textField1.setSize(500, 100);
		textField1.setLocation(50, 20);
		 
		textField2.setSize(500, 100);
		textField2.setLocation(50, 220);
		
		panel.add(textField1);
		panel.add(textField2);
		return panel;
	}

	private Component createButtonPanel() {
		JPanel panel = new JPanel();
		buttonOne = new JButton ("One");
		buttonTwo = new JButton ("Two");
		buttonThree = new JButton ("Three");
		buttonFour = new JButton ("Four");
		buttonFive = new JButton ("Five");
		buttonSix = new JButton ("Six");
		buttonSeven = new JButton ("Seven");
		
		buttonOne.setActionCommand("one");
		buttonOne.addActionListener(null );

		panel.add(buttonOne);
		panel.add(buttonTwo);
		panel.add(buttonThree);
		panel.add(buttonFour);
		panel.add(buttonFive);
		panel.add(buttonSix);
		panel.add(buttonSeven);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
