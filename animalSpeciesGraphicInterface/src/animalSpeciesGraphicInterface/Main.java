package animalSpeciesGraphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main implements ItemListener, ListSelectionListener{
	
	JFrame window;
	JLabel text;
	JComboBox<String> especies;
	JList<String> especiesList;
	JList<String> list;
	JScrollPane panelScroll;
	String[] especiesTypes = {"especiesA", "especiesE", "especiesI"};
	String[] especiesA = {"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10"};
	String[] especiesE = {"e1","e2","e3","e4","e5","e6","e7","e8","e9","e10"};
	String[] especiesI = {"i1","i2","i3","i4","i5","i6","i7","i8","i9","i10"};

	public static void main(String[] args) {
		Main main = new Main();
		main.createWindow();
	}
	
	public void createWindow(){
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
		panel.add(createLabel(),BorderLayout.SOUTH);
		
		return panel;
	}

	private Component createCenterWindow() {
		//JSplitPane panel = 
		JPanel panel =new JPanel(new GridLayout(1,2));
		panel.add(createLeftPart());
		panel.add(createRightPart());
		
		return panel;
	}

	private Component createRightPart() {
		JPanel panel = new JPanel();
		
		especiesList = new JList<String>(especiesA);
		panel.add(especiesList);
		especiesList.addListSelectionListener(this);
		panelScroll.setViewportView(especiesA);
		return panel;
	}


	private Component createLeftPart() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createComboBox(), BorderLayout.NORTH);
		return panel;
	}

	private Component createComboBox() {
		JPanel panel = new JPanel();
		
		especies = new JComboBox<String>(especiesTypes);
		
		panel.add(especies);
		return panel;
	}

	private Component createLabel() {
		JPanel panel = new JPanel();
		text = new JLabel(" ");
		text.setBackground(Color.white);
		panel.add(text);
		return panel;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		switch(especies.getSelectedIndex()){
		case 0:
			list = new JList<String>(especiesA);
			break;
		case 1:
			list = new JList<String>(especiesE);
			break;
		case 2:
			list = new JList<String>(especiesI);
			break;
		}
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelScroll.setViewportView(list);
		
	}

}
