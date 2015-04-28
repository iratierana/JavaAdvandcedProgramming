
package intGraphicContactDiary;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JCheckBoxMenuItem;


public class Window extends JFrame implements ActionListener, ListSelectionListener{

	JList<Person> personList;
	DefaultListModel<Person> listModel;
	Dialog dialog;
	
	JMenuBar bar;
	
	JMenu addBar;
	JMenu deleteBar;
	JMenu exitBar;
	
	JMenuItem menuOption;
	
	Window window = this;
	
	AbstractAction accFriend, accFamiliar, accColleague, accDelete, accExit;
	private JCheckBoxMenuItem chckbxmntmCheckbox;

	
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
		accFriend = new MiAction ("Friend", new ImageIcon("icons/friend.png"), "Add Friend", KeyEvent.VK_C);
		accFamiliar = new MiAction ("Familiar", new ImageIcon("icons/family.png"), "Add Family Member", KeyEvent.VK_C);
		accColleague = new MiAction ("Colleague", new ImageIcon("icons/friend.png"), "Add Colleague", KeyEvent.VK_C);
		accDelete = new MiAction ("Delete", new ImageIcon("icons/delete.png"), "Delete Selected Person", KeyEvent.VK_C);
		accExit = new MiAction ("Exit", new ImageIcon("icons/exit.png"), "Exit the Program", KeyEvent.VK_C);
	}

	private Container createWindowPane() {
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

	private JMenuBar createBar() {
		bar = new JMenuBar();
		bar.add(createAddBar());
		bar.add(createDeleteBar());
		bar.add(Box.createHorizontalGlue());
		bar.add(createExitBar());
		
		return bar;
	}
	
	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		JButton button;
		button = (JButton) toolBar.add(new JButton (accFriend));
		button = (JButton) toolBar.add(new JButton (accFamiliar));
		button = (JButton) toolBar.add(new JButton (accColleague));
		toolBar.addSeparator(new Dimension (20,0));
		button = (JButton) toolBar.add(new JButton (accDelete));
		toolBar.add(Box.createHorizontalGlue());
		button = (JButton) toolBar.add(new JButton (accExit));

		return toolBar;
	}

	private JMenu createExitBar() {
		exitBar = new JMenu ("Exit Bar");
		menuOption = exitBar.add(accExit);
		exitBar.add(menuOption);
		/*
		exitBar.add(exit = new JMenuItem("Exit"));
		exit.addActionListener(this);
		*/
		return exitBar;
	}



	private JMenu createAddBar() {
		addBar = new JMenu ("Add bar");
		
		menuOption = addBar.add(accFriend);
		menuOption = addBar.add(accFamiliar);
		menuOption = addBar.add(accColleague);
		addBar.add(menuOption);
		
		/*
		addBar.add(friend = new JMenuItem ("Friend"));
		addBar.add(familiar = new JMenuItem ("Familiar"));
		addBar.add(colleague = new JMenuItem ("Colleague"));
		
		friend.addActionListener(this);
		familiar.addActionListener(this);
		colleague.addActionListener(this);
		*/
		return addBar;
	}

	private JMenu createDeleteBar() {
		deleteBar = new JMenu ("Delete Bar");
		{
			chckbxmntmCheckbox = new JCheckBoxMenuItem("checkBox");
			deleteBar.add(chckbxmntmCheckbox);
		}
		
		menuOption = deleteBar.add(accDelete);
		deleteBar.add(menuOption);
		/*
		deleteBar.add(delete = new JMenuItem ("Delete"));
		
		delete.addActionListener(this);
		*/
		return deleteBar;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()){
		
		case "Friend":
			Friend friend = new Friend();
			dialog = new Dialog(friend, this, true);
			listModel.addElement(friend);
			break;
			
		case "Familiar":
			Familiar familiar = new Familiar();
			dialog = new Dialog(familiar, this, true);
			listModel.addElement(familiar);
			break;
			
		case "Colleague":
			Colleague colleague = new Colleague();
			dialog = new Dialog(colleague, this, true);
			listModel.addElement(colleague);
			break;
			
		case "Delete":
			listModel.remove(personList.getSelectedIndex());
			break;
		
		case "Exit":
			dispose();
			break;
		}
	}



	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
	}
	
	private class MiAction extends AbstractAction {
		String text;
		public MiAction (String text, Icon imagen, String description, Integer nemonic){
			super(text,imagen);
			this.text = text;
			this.putValue( Action.SHORT_DESCRIPTION ,description);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch(arg0.getActionCommand()){
			case "Friend":
				Friend friend = new Friend();
				dialog = new Dialog(friend, window, true);
				listModel.addElement(friend);
				break;
			case "Familiar":
				Familiar familiar = new Familiar();
				dialog = new Dialog(familiar, window, true);
				listModel.addElement(familiar);
				break;
			case "Colleague":
				Colleague colleague = new Colleague();
				dialog = new Dialog(colleague, window, true);
				listModel.addElement(colleague);
				break;
			case "Delete":
				listModel.removeElementAt(personList.getSelectedIndex());
				break;
			case "Exit":
				window.dispose();
				break;
			}
			
			
		}
	}

}
