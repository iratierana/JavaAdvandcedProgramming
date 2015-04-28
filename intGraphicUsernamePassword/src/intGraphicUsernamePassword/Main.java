package intGraphicUsernamePassword;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener{

	JFrame window;
	JLabel usernameText;
	JLabel passwordText;
	JTextField usernameTextField;
	JTextField passwordTextField;
	JButton ok, cancel, exit;
	
	public static void main(String[] args) {
		Main main = new Main("Access Control");

	}
	
	public Main(String title){
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
		
		panel.add(createCenter(),BorderLayout.CENTER);
		panel.add(createButtons(),BorderLayout.SOUTH);
		
		return panel;
	}

	private Component createCenter() {
		JPanel panel = new JPanel (new GridLayout(2,2));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN),
				BorderFactory.createTitledBorder("Identification")));
		
		usernameText = new JLabel("Username:");
		usernameTextField = new JTextField("");
		
		passwordText = new JLabel("Password:");
		passwordTextField = new JTextField("");
		
		panel.add(usernameText);
		panel.add(usernameTextField);
		panel.add(passwordText);
		panel.add(passwordTextField);
		return panel;
	}

	private Component createButtons() {
		JPanel panel = new JPanel();
		ok = new JButton("Ok");
		ok.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		panel.add(ok);
		panel.add(cancel);
		panel.add(exit);
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "Ok"){
			if((usernameTextField.getText().equals("username"))&&(passwordTextField.getText().equals("password"))){
				JOptionPane.showMessageDialog( null, "Correct" );
			}
			else{
				JOptionPane.showMessageDialog( null, "Incorrect" );
			}
		}
		if(e.getActionCommand() == "Cancel"){
			usernameTextField.setText("");
			passwordTextField.setText("");
		}
		if(e.getActionCommand() == "Exit"){
			window.setVisible(false);
		}
		
	}

}

