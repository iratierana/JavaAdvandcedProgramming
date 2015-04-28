package intGraphicVisualizeImages;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Window extends JFrame implements ItemListener, ActionListener, ListSelectionListener{

	JList<String> list;
	DefaultListModel<String> listModel;
	JLabel imagen;
	JPanel screenPanel;
	JButton button;
	JTextField textField;
	
	
	
	public Window(){
		this.setLocation(200, 200);
		this.setSize(640, 480);
		this.setContentPane(createWindowPane());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	private Container createWindowPane() {
		JSplitPane panel = new JSplitPane();
		panel.setDividerLocation(200);
		panel.setLeftComponent(createLeftSide());
		panel.setRightComponent(createScreen());
		return panel;
	}


	private Component createLeftSide() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createImagesChooser(), BorderLayout.NORTH);
		panel.add(createImagesList(), BorderLayout.CENTER);
		return panel;
	}
	
	private Component createImagesChooser(){
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(createTextField(),BorderLayout.CENTER);
		panel.add(createButton(),BorderLayout.EAST);
		return panel;
	}


	private Component createTextField() {
		JPanel panel = new JPanel();
		panel.add(textField = new JTextField(10));
		return panel;
	}


	private Component createButton() {
		JPanel panel = new JPanel();
		panel.add(button = new JButton("..."));
		button.addActionListener(this);
		
		return panel;
	}
	
	public void createFileChooser(){
		JFileChooser fileChooser = new JFileChooser();
		int selection = fileChooser.showOpenDialog(null);
		if(selection == fileChooser.APPROVE_OPTION){
			listModel.addElement(fileChooser.getSelectedFile().getName());
		}
	}

	private Component createImagesList() {		
		listModel = new DefaultListModel<String>();
		listModel.addElement("image1.png");
		listModel.addElement("image2.png");
		listModel.addElement("image3.png");
		listModel.addElement("image4.png");
		listModel.addElement("image5.png");
		listModel.addElement("image6.png");
		listModel.addElement("image7.png");
		listModel.addElement("image8.png");
		listModel.addElement("image9.png");
		listModel.addElement("image10.png");
		listModel.addElement("image11.png");
		listModel.addElement("image12.png");
		listModel.addElement("image13.png");
		listModel.addElement("image14.png");
		listModel.addElement("image15.png");
		listModel.addElement("image16.png");
		listModel.addElement("image17.png");
		listModel.addElement("image18.png");
		listModel.addElement("image19.png");
		
		list = new JList<String>(listModel);
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    list.setSelectedIndex(0);
	    list.addListSelectionListener(this);
		
	    JScrollPane listScrollPane = new JScrollPane(list);
	    
	    return listScrollPane;
	}


	private Component createScreen() {
		
		JScrollPane pImagen;
		imagen = new JLabel();
		
		
		pImagen =  new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pImagen.setViewportView(imagen);
		imagen.setHorizontalAlignment(JLabel.CENTER);
		imagen.setIcon (new ImageIcon("images/" + list.getSelectedValue()));
		return pImagen;
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()){
		case "...":
			createFileChooser();
			break;
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		imagen.setIcon (new ImageIcon("images/" + list.getSelectedValue()));
			
	}
}
