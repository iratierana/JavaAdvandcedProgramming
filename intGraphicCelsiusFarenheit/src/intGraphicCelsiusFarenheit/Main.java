package intGraphicCelsiusFarenheit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{

	JFrame window;
	JRadioButton celcius, farenheit;
	ButtonGroup placeGroup;
	JTextField textField;
	JButton confirm;
	
	Temperature temperature;
	
	public static void main(String[] args) {
		Main main = new Main("Temperature conversor");

	}
	
	public Main(String title){
		temperature = new Temperature();
		window = new JFrame(title);
		window.setSize(320,240);
		window.setLocation(100, 100);
		
		window.setContentPane(createWindowPanel());
		
		
		window.setVisible (true);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container createWindowPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,40,20));
		
		panel.add(createText(),BorderLayout.NORTH);
		panel.add(createRadioButton(),BorderLayout.CENTER);
		panel.add(createButton(),BorderLayout.SOUTH);
		
		return panel;
	}

	private Component createText() {
		textField = new JTextField("");
		return textField;
	}

	private Component createRadioButton() {
		JPanel panel = new JPanel (new GridLayout(1,2));
		
		celcius = new JRadioButton("Celcius");
		farenheit = new JRadioButton("Farenheit");
		celcius.addActionListener(this);
		farenheit.addActionListener(this);
		
		celcius.setSelected(true);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(celcius);
		buttonGroup.add(farenheit);
		
		panel.add(celcius);
		panel.add(farenheit);
		return panel;
	}

	private Component createButton() {
		confirm = new JButton("Convert");
		confirm.addActionListener(this);
		return confirm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int value = 0;
		String text;
		if(e.getActionCommand() == "Convert"){
			text = textField.getText();
			value = Integer.valueOf(text);
			if(celcius.isSelected()){
				textField.setText(Integer.toString(temperature.celciusToFarenheit(value)));
			}
			if(farenheit.isSelected()){
				textField.setText(Integer.toString(temperature.farenheitToCelcius(value)));
			}
		}
		
	}

}
