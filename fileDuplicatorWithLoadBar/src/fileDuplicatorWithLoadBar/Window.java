package fileDuplicatorWithLoadBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

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
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Window extends JFrame implements ActionListener{
	
	JTextField originAddressTextField, destinationAddressTextField;
	String originAddress, destinationAddress;
	JButton duplicateButton;
	JProgressBar progressBar;
	
	public Window(){
		this.setLocation(200, 200);
		this.setSize(640, 480);
		this.setContentPane(createWindowPane());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	private Container createWindowPane() {
		JPanel panel = new JPanel (new BorderLayout());
		panel.add(createWorkBar(), BorderLayout.NORTH);
		panel.add(createCentralPanel(), BorderLayout.CENTER);
		
		 
		
		return panel;
	}



	private Component createWorkBar() {
		JPanel panel = new JPanel();
		progressBar = new JProgressBar();
		panel.add(progressBar);
		return panel;
	}



	private Component createCentralPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createTextField(), BorderLayout.CENTER);
		panel.add(createButton(), BorderLayout.SOUTH);
		return panel;
	}



	private Component createTextField() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		originAddressTextField = new JTextField();
		originAddressTextField.setBackground(Color.white);
		panel.add(originAddressTextField);
		destinationAddressTextField = new JTextField();
		destinationAddressTextField.setBackground(Color.white);
		panel.add(destinationAddressTextField);
		return panel;
	}



	private Component createButton() {
		JPanel panel = new JPanel();
		duplicateButton = new JButton("Duplicate");
		duplicateButton.addActionListener(this);
		panel.add(duplicateButton);
		return panel;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean checkPoint1 = false, checkPoint2 = false;
		switch(arg0.getActionCommand()){
		case "Duplicate":
			if(!originAddressTextField.getText().equals("")){
				originAddress = originAddressTextField.getText();
				checkPoint1 = true;
			}
			if(!destinationAddressTextField.getText().equals("")){
				destinationAddress = destinationAddressTextField.getText();
				checkPoint2 = true;
			}
			if((!checkPoint1)||(!checkPoint2)){
				JOptionPane.showMessageDialog(this, "You haven´t introduced the parameters");
			}
			else{
				try {
					Duplicator duplicator = new Duplicator(originAddress);
					
					duplicator.duplicate(destinationAddress);
					
				} catch (FileNotFoundException e) {
					System.out.println("File not found!");
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		
	}
	
}
