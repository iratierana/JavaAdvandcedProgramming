package createList;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main implements ItemListener, ListSelectionListener {

	
	JFrame window;
	JButton add;
	JButton delete;
	JList<String> personList;
	String[] names = {""};
	ArrayList people;
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.window();

	}
	
	public void window(){
		window = new JFrame("Animal Especies");
		window.setSize(500,400);
		window.setLocation(100, 100);
		
		window.setContentPane(createWindowPanel());
		
		
		window.setVisible (true);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container createWindowPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,40,20));
		
		panel.add(createCenterWindow(),BorderLayout.CENTER);
		panel.add(createSouth(),BorderLayout.SOUTH);
		
		return panel;
	}

	private Component createCenterWindow() {
		JScrollPane panel = new JScrollPane();
		
		personList = new JList<String>(names);
		panel.add(personList);
		personList.addListSelectionListener(this);
		panel.setViewportView(personList);
		return panel;
	}

	
	private Component createSouth() {
		JPanel panel = new JPanel(new GridLayout(1,2));
		add = new JButton("Add");
		delete = new JButton("Delete");
		
		panel.add(add);
		panel.add(delete);
		
		return panel;
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
