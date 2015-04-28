package exercise2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dialog extends JDialog implements ActionListener{  //este es un dialogo anterior que tenia hecho y que he intentado cambiarlo para este programa pero no me ha dado tiempo

	JButton ok;
	JButton cancel;
	
	Circle circle;
	Square square;
	
	public Dialog(Circle circle, JFrame window, boolean mode){
		super(window, mode);
		this.circle = circle;
		this.setLocation(300, 300);
		this.setSize(200, 200);
		this.getContentPane().add(createSquareDataPanel(), BorderLayout.CENTER);
		this.getContentPane().add(createButtonsPanel(), BorderLayout.SOUTH);
		this.setVisible(true);
		this.setModal(false); 
	}

	private Component createSquareDataPanel() {
		JPanel panel = new JPanel(new GridLayout(4,1,5,5));
		panel.add(createDescriptionPanel());
		panel.add(createXPositionPanel());
		panel.add(createYPositionPanel());
		panel.add(createRadioPanel());
		
		return panel;
	}

	public Dialog(Square square, JFrame window, boolean mode){
		super(window, mode);
		this.familiar = familiar;
		this.setLocation(200, 200);
		this.setSize(200, 200);
		this.getContentPane().add(createFamiliarDataPanel(), BorderLayout.CENTER);
		this.getContentPane().add(createButtonsPanel(), BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	private Component createFamiliarDataPanel() {
		JPanel panel = new JPanel(new GridLayout(4,1,5,5));
		panel.setBackground(Color.white);
		panel.add(createDescriptionPanel());
		panel.add(createXPositionPanel());
		panel.add(createYPositionPanel());
		panel.add(createSide1Panel());
		panel.add(createside2Panel());
		
		return panel;
	}
	
	private Component createButtonsPanel() {
		JPanel panel = new JPanel();
		panel.add(ok = new JButton("Ok"));
		panel.add(cancel = new JButton("Cancel"));
		ok.addActionListener(this);
		cancel.addActionListener(this);
		return panel;
	}
	
	private Component createNamePanel() {
		JPanel panel = new JPanel (new GridLayout(1,1));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN),
				BorderFactory.createTitledBorder("Name")));
		panel.setBackground(Color.white);
		panel.add(name = new JTextField(), BorderLayout.CENTER);
		
		return panel;
	}
	
	private Component createSurnamePanel() {
		JPanel panel = new JPanel (new GridLayout(1,1));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN),
				BorderFactory.createTitledBorder("Surname")));
		panel.setBackground(Color.white);
		panel.add(surname = new JTextField(), BorderLayout.CENTER);
		
		return panel;
	}
	
	private Component createParentescPanel() {
		JPanel panel = new JPanel (new GridLayout(1,1));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN),
				BorderFactory.createTitledBorder("Parentesc")));
		panel.setBackground(Color.white);
		panel.add(parentesc = new JTextField(), BorderLayout.CENTER);
		
		return panel;
	}
	
	private Component createDepartmentPanel() {
		JPanel panel = new JPanel (new GridLayout(1,1));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN),
				BorderFactory.createTitledBorder("Surname")));
		panel.setBackground(Color.white);
		panel.add(department = new JTextField(), BorderLayout.CENTER);
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Ok"){
			if(friend!=null){
				friend.name = name.getText();
				friend.surname = surname.getText();
			}
			if(familiar!=null){
				familiar.name = name.getText();
				familiar.parentesc = parentesc.getText();
			}
			if(colleague!=null){
				colleague.name = surname.getText();
				colleague.surname = surname.getText();
				colleague.department = department.getText();
			}
			this.dispose();
		}
		if(e.getActionCommand()=="Cancel"){
			this.dispose();
		}
		
	}
	
}
