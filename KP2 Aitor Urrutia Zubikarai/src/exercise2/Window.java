package exercise2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	
	Window window;
	
	JMenuBar bar;
	
	JMenu edit;
	JMenu exit;
	
	AbstractAction accAdd, accDelete, accExit;
	
	JLabel totalArea, label;
	
	Screen screen;
	
	JList<Figure> figureList;
	DefaultListModel<Figure> listModel;
	
	
	public Window(){
		window = this;
		this.setJMenuBar(createBar());
		this.setLocation(200, 200);
		this.setSize(640, 480);
		this.setVisible(true);
		this.setContentPane(createWindowPane());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private JMenuBar createBar() {
		bar = new JMenuBar();
		bar.add(createEditBar());
		bar.add(createExitBar());
		bar.add(Box.createHorizontalGlue());
		return bar;
	}

	private JMenu createEditBar() {
		edit = new JMenu ("Edit");
		
		edit.add(accAdd);
		edit.add(accDelete);
	
		return edit;
	}
	
	private JMenu createExitBar() {
		exit = new JMenu ("Exit");
		
		exit.add(accExit);
	
		return exit;
	}
	
	public void createActions(){
		accAdd = new MiAction ("Add", new ImageIcon("icons/edit_add.png"), "Add figure", KeyEvent.VK_PLUS);
		accDelete = new MiAction ("Delete", new ImageIcon("icons/edit_remove.png"), "Delete selected figure", KeyEvent.VK_MINUS);
		accExit = new MiAction ("Exit", new ImageIcon("icons/exit.png"), "Exit aplication", KeyEvent.VK_F4);
		
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
		panel.add(createToolBar(), BorderLayout.NORTH);
		panel.add(createFigureList(), BorderLayout.CENTER);
		panel.add(createAreaLabel(), BorderLayout.SOUTH);
		return panel;
	}
	
	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar();
		JButton button;
		button = (JButton) toolBar.add(new JButton (accAdd));
		button = (JButton) toolBar.add(new JButton (accDelete));
		toolBar.add(Box.createHorizontalGlue());
		button = (JButton) toolBar.add(new JButton (accExit));

		return toolBar;
	}
	
	private Component createFigureList() {
		JPanel panel = new JPanel();
		listModel = new DefaultListModel<Figure>();
		figureList = new JList<Figure>(listModel);
		figureList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		figureList.setSelectedIndex(0);
		figureList.addListSelectionListener(this);
		figureList.setVisibleRowCount(20);
		JScrollPane scrollPane = new JScrollPane(figureList);
		//panel.setViewportView(personList);
		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}

	private Component createAreaLabel() {
		JPanel panel = new JPanel();
		panel.add(label = new JLabel("Total area: "));
		panel.add(totalArea = new JLabel("0"));
		return panel;
	}

	private Component createScreen() {
		JPanel panel = new JPanel();
		panel.add(screen = new Screen(listModel));
		return panel;
	}

	private class MiAction extends AbstractAction {
		String text;
		public MiAction (String text, Icon imagen, String description, Integer nemonic){
			super(text,imagen);
			this.text = text;
			this.putValue(Action.SHORT_DESCRIPTION ,description);
			this.putValue(Action.MNEMONIC_KEY, nemonic);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch(arg0.getActionCommand()){
			case "Add":
				//crear un dialog
				//listModel.addElement(figure);
				totalArea.setText(String.valueOf(recalculateArea()));
				break;
			case "Delete":
				listModel.removeElementAt(figureList.getSelectedIndex());
				break;
			case "Exit":
				window.dispose();
				break;
			}
		}

		private float recalculateArea() {
			float totalArea = 0;
			for(int i=0; i< listModel.getSize(); i++){
				totalArea = totalArea + listModel.get(i).getArea();
				
			}
			return totalArea;
			
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
