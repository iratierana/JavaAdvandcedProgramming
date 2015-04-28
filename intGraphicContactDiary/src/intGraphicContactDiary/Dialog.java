package intGraphicContactDiary;

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

public class Dialog extends JDialog implements ActionListener{
	
	JButton ok;
	JButton cancel;
	
	JTextField name = null;
	JTextField surname = null;
	JTextField parentesc = null;
	JTextField department = null;
	
	Friend friend;
	Familiar familiar;
	Colleague colleague;

	public Dialog(Friend friend, JFrame window, boolean mode){
		super(window, mode);
		this.friend = friend;
		this.setLocation(300, 300);
		this.setSize(200, 200);
		this.getContentPane().add(createFriendDataPanel(), BorderLayout.CENTER);
		this.getContentPane().add(createButtonsPanel(), BorderLayout.SOUTH);
		this.setVisible(true);
		this.setModal(false); 
	}

	private Component createFriendDataPanel() {
		JPanel panel = new JPanel(new GridLayout(2,1,5,5));
		panel.add(createNamePanel());
		panel.add(createSurnamePanel());
		
		return panel;
	}

	public Dialog(Familiar familiar, JFrame window, boolean mode){
		super(window, mode);
		this.familiar = familiar;
		this.setLocation(200, 200);
		this.setSize(200, 200);
		this.getContentPane().add(createFamiliarDataPanel(), BorderLayout.CENTER);
		this.getContentPane().add(createButtonsPanel(), BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	private Component createFamiliarDataPanel() {
		JPanel panel = new JPanel(new GridLayout(2,1,5,5));
		panel.setBackground(Color.white);
		panel.add(createNamePanel());
		panel.add(createParentescPanel());
		
		return panel;
	}
	
	public Dialog(Colleague colleague, JFrame window, boolean mode){
		super(window, mode);
		this.colleague = colleague;
		this.setLocation(200, 200);
		this.setSize(200, 200);
		this.getContentPane().add(createColleagueDataPanel(), BorderLayout.CENTER);
		this.getContentPane().add(createButtonsPanel(), BorderLayout.SOUTH);
		this.setVisible(true);
	}

	private Component createColleagueDataPanel() {
		JPanel panel = new JPanel(new GridLayout(3,1,5,5));
		panel.setBackground(Color.white);
		panel.add(createNamePanel());
		panel.add(createSurnamePanel());
		panel.add(createDepartmentPanel());
		
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
