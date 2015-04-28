package exercise1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{

	ArrayList<Coin> coinList;
	JComboBox <Coin> originComboBox;
	JComboBox <Coin> destinationComboBox;
	JTextField originTextField;
	JTextField destinationTextField;
	JButton change;
	
	
	public Window(){
		this.initializeCoins();
		this.setLocation(200, 200);
		this.setSize(640, 480);
		this.setContentPane(createWindowPane());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void initializeCoins(){
		coinList = new ArrayList<Coin>();
		coinList.add(new Coin("Euro", 1));
		coinList.add(new Coin("USDolar", (float) 1.5029));
		coinList.add(new Coin("Lira", 1));
		//Hacer con todas
	}
	
	
	
	private Container createWindowPane() {
		JPanel panel = new JPanel (new BorderLayout());
		panel.add(createWorkPanel(), BorderLayout.CENTER);
		panel.add(createButtonPanel(), BorderLayout.SOUTH);
		
		return panel;
	}

	private Container createWorkPanel() {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(createLeftPanel());
		panel.add(createRightPanel());
		return panel;
	}

	private Component createLeftPanel() {
		JPanel panel = new JPanel(new GridLayout(2,1));
		originComboBox = new JComboBox<Coin>(coinList);
		panel.add(originComboBox);
		originTextField = new JTextField(30);
		panel.add(originTextField);
		
		return panel;
	}



	private Component createRightPanel() {
		JPanel panel = new JPanel(new GridLayout(2,1));
		destinationComboBox = new JComboBox<Coin>(coinList);
		panel.add(destinationComboBox);
		destinationTextField = new JTextField(30);
		panel.add(destinationTextField);
		
		return panel;
	}



	private Component createButtonPanel() {
		JPanel panel = new JPanel();
		change = new JButton("Change");
		change.addActionListener(this);
		panel.add(change);
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int originIndex;
		int destinationIndex;
		
		if(arg0.getActionCommand().equals("Change")){
			float valueOr = Integer.parseInt(originTextField.getText());
			float valueDest;
			destinationIndex = destinationComboBox.getSelectedIndex();
			valueDest = ((Coin)originComboBox.getSelectedItem()).change(valueOr, ((Coin)destinationComboBox.getSelectedItem()).getValue());
			destinationTextField.setText(String.valueOf(valueDest));
		}
		
	}
}
