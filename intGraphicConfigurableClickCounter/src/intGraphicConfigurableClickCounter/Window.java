
package intGraphicConfigurableClickCounter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener{

	JMenuBar bar;
	
	JMenu actionsBar;
	JMenu settingsBar;
	
	JMenu valuesBar;
	JMenu lenguagesBar;
	
	JMenuItem restart;
	JMenuItem invert;
	
	JMenuItem increment;
	JMenuItem color;
	JMenuItem superiorLimit;
	JMenuItem inferiorLimit;
	
	JMenuItem english;
	
	JMenuItem exit;
	
	JLabel text;
	
	JButton button;
	
	int incrementCantity = 1;
	int superiorLimitValue = 100000;
	int inferiorLimitValue = -100000;
	
	String [][] names;
	
	public Window(){
		this.setJMenuBar(createBar());
		this.setLocation(200, 200);
		this.setSize(640, 480);
		this.setContentPane(createWindowPane());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		button = new JButton ("Click");
		button.addActionListener(this);

		panel.add(button);
		
		return panel;
	}

	private JMenuBar createBar() {
		bar = new JMenuBar();
		bar.add(createActionsBar());
		bar.add(createSettingsBar());
		bar.add(Box.createHorizontalGlue());
		bar.add(exit = new JMenuItem("Exit"));
		exit.addActionListener(this);
		return bar;
	}

	private JMenu createActionsBar() {
		actionsBar = new JMenu ("Actions");
		actionsBar.add(restart = new JMenuItem ("Restart"));
		actionsBar.add(invert = new JMenuItem ("Invert"));
		
		restart.addActionListener(this);
		invert.addActionListener(this);
		
		return actionsBar;
	}

	private JMenu createSettingsBar() {
		settingsBar = new JMenu ("Settings");
		
		settingsBar.add(createValuesBar());
		settingsBar.add(createLenguageBar());
		
		return settingsBar;
	}

	private JMenu createValuesBar() {
		valuesBar = new JMenu("Values");
		
		valuesBar.add(increment = new JMenuItem ("Increment"));
		valuesBar.add(color = new JMenuItem ("Color"));
		valuesBar.add(superiorLimit = new JMenuItem ("Superior limit"));
		valuesBar.add(inferiorLimit = new JMenuItem ("Inferior limit"));
		
		increment.addActionListener(this);
		color.addActionListener(this);
		superiorLimit.addActionListener(this);
		inferiorLimit.addActionListener(this);
		
		return valuesBar;
	}

	private JMenu createLenguageBar() {
		lenguagesBar = new JMenu("Lenguages");
		
		lenguagesBar.add(english = new JMenuItem ("English"));
		
		english.addActionListener(this);
		
		return lenguagesBar;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()){
		case "Click":
			int value = Integer.parseInt(text.getText());
			value = value + incrementCantity;
			if(value > superiorLimitValue){
				value = superiorLimitValue;
			}
			if(value < inferiorLimitValue){
				value = inferiorLimitValue;
			}
			text.setText(String.valueOf(value));
			break;
		case "Restart":
			text.setText(String.valueOf(0));
			break;
			
		case "Invert":
			incrementCantity = - incrementCantity;
			break;
		
		case "Increment":
			String incrementRate = JOptionPane.showInputDialog(null, "Write the increment rate:");
			incrementCantity = Integer.parseInt(incrementRate);
			break;
		
		case "Color":
			Color backgroundColor = JColorChooser.showDialog(null, "Choose background color", Color.white);
		            if(backgroundColor != null){
		            	this.getContentPane().setBackground(backgroundColor);
		            }
			break;
		
		case "Superior limit":
			String superiorLimitChar = JOptionPane.showInputDialog(null, "Write the superior limit value:");
			superiorLimitValue = Integer.parseInt(superiorLimitChar);
			break;
		
		case "Inferior limit":
			String inferiorLimitChar = JOptionPane.showInputDialog(null, "Write the inferior limit value:");
			inferiorLimitValue = Integer.parseInt(inferiorLimitChar);
			break;
			
		case "English":
			System.out.println("English");
			break;
		
		case "Exit":
			dispose();
			break;
		}
	}

}
