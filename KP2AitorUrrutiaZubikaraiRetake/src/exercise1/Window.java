package exercise1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Window extends JFrame implements ListSelectionListener{
	
	AbstractAction accSave, accLoad;
	JLabel levelLabel;
	
	JList<Person> personList;
	DefaultListModel<Person> listModel;
	
	JList<Signature> signatureList;
	DefaultListModel<Signature> signatureListModel;

	public Window(){
		this.createActions();
		this.setJMenuBar(createBar());
		this.getContentPane().add(createToolBar(),BorderLayout.NORTH);
		this.setLocation(200, 200);
		this.setSize(640, 480);
		this.getContentPane().add(createWindowPane());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createActions(){
		accSave = new MyAction ("Save", new ImageIcon("icons/.png"), "Save a file", KeyEvent.VK_S);
		accLoad = new MyAction ("Load", new ImageIcon("icons/.png"), "Load a file", KeyEvent.VK_L);
		
	}
	
	private JMenuBar createBar() {
		JMenuBar bar = new JMenuBar();
		
		bar.add(createFileBar());
		
		return bar;
	}

	private JMenu createFileBar() {
		JMenu menu = new JMenu("File");
		
		menu.add(accSave);
		menu.add(accLoad);
		
		return menu;
	}
	
	private Component createToolBar() {
		JToolBar toolBar = new JToolBar();
		
		toolBar.add(new JButton (accSave));
		toolBar.addSeparator(new Dimension (20,0));
		toolBar.add(new JButton (accLoad));
		toolBar.add(Box.createHorizontalGlue());

		return toolBar;
	}
	
	private Component createWindowPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.ORANGE), null));
		panel.setBackground(Color.WHITE);
		
		panel.add(levelLabel = new JLabel(), BorderLayout.NORTH);
		panel.add(createDataPanel(), BorderLayout.CENTER);
		
		return panel;
	}

	private Container createDataPanel() {
		JSplitPane panel = new JSplitPane();
		panel.setLeftComponent(createLeftSide());
		panel.setRightComponent(createRightSide());
		return panel;
	}

	private Component createLeftSide() {
		JPanel panel = new JPanel();
		listModel = new DefaultListModel<Person>();
		personList = new JList<Person>(listModel);
		personList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		personList.setSelectedIndex(0);
		personList.addListSelectionListener(this);
		personList.setVisibleRowCount(20);
		JScrollPane scrollPane = new JScrollPane(personList);
		//panel.setViewportView(personList);
		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}

	private Component createRightSide() {
		JPanel panel = new JPanel();
		signatureListModel = new DefaultListModel<Signature>();
		signatureList = new JList<Signature>(signatureListModel);
		signatureList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		signatureList.setSelectedIndex(0);
		signatureList.addListSelectionListener(this);
		signatureList.setVisibleRowCount(20);
		JScrollPane scrollPane = new JScrollPane(personList);
		//panel.setViewportView(personList);
		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Person person = personList.getSelectedValue();
		
		for(int i = 0; i < person.signatureList.size(); i++){
			signatureListModel.add(i, person.signatureList.get(i));
		}
	}
	
	private class MyAction extends AbstractAction {
		String text;
		public MyAction (String text, Icon imagen, String description, Integer nemonic){
			super(text,imagen);
			this.text = text;
			this.putValue( Action.SHORT_DESCRIPTION ,description);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch(arg0.getActionCommand()){
			case "Save":
				int kont = 0;
				
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("IT.txt"));
					
					bufferedWriter.write("IT 2 Grade");
					bufferedWriter.newLine();
					
					for(int i = 0; i < listModel.getSize(); i++){
						bufferedWriter.write(listModel.get(i).name + "," + listModel.get(i).secondName + "," + listModel.get(i).thirdName);
						bufferedWriter.newLine();
						for(int z = 0; z < listModel.get(i).signatureList.size(); z++){
							bufferedWriter.write(listModel.get(i).signatureList.get(z).name + "," + listModel.get(i).signatureList.get(z).mark);
							bufferedWriter.newLine();
						}
						bufferedWriter.newLine();
					}
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "Load":
				int cont = 0;
				JFileChooser j= new JFileChooser();
		        j.showOpenDialog(j);
		        String fileName = j.getSelectedFile().getAbsolutePath();
		        String line;
				
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
					if((line = bufferedReader.readLine()) != null) levelLabel.setText(line);
					while((line = bufferedReader.readLine()) != null) {
						listModel.addElement(new Person(line.split(",")));
						line = bufferedReader.readLine();
						do{
							if(line == "\n"){
								System.out.println("Reading space");
								break;
							}
							else{
								System.out.println(line);
								listModel.get(listModel.getSize() - 1).signatureList.add(new Signature(line.split(",")));
							}
						}while((line = bufferedReader.readLine()) != null);
					}
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
			
		}
	}
	
}
