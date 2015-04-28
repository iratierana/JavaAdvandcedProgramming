package intGraphicSimpleMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

public class Main implements ActionListener {
	JFrame window;
	JMenuBar bar;
	JMenu menuFile, menuEdit, menuExit;
	JMenuItem optionMenu;
	JMenu subMenu;
	JToolBar toolBar;
	JButton button;
	
	public static void main(String[] args) {
		Main main = new Main();

	}
	
	public Main(){
		
		window = new JFrame ("Menu");
		window.setJMenuBar(createMenuBar());
		window.getContentPane().add(toolBar());
		window.setLocation(200, 200);
		window.setSize(640, 480);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Component toolBar() {
		toolBar = new JToolBar("ToolBar");
		button = new JButton("Button");
		toolBar.add(button);
		
		return toolBar;
	}

	private JMenuBar createMenuBar() {
		bar = new JMenuBar();
		bar.add(createMenuFile());
		bar.add(createMenuEdit());
		bar.add(Box.createHorizontalGlue());
		bar.add(createMenuExit());
		return bar;
	}
	
	private JMenu createMenuFile(){
		menuFile = new JMenu ("File");
		menuFile.add(createMenuFileInside());
		return menuFile;
		
	}
	
	private JMenuItem createMenuFileInside() {
		optionMenu = new JMenuItem("Sub");
		
		return optionMenu;
	}

	private JMenu createMenuEdit() {
		menuEdit = new JMenu ("Edit");
		return menuEdit;
	}
	
	private JMenu createMenuExit() {
		JMenuItem op;
		menuExit = new JMenu ("Exit");
		
		op = menuExit.add("Exit");
		op.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
				
			}
		});
		return menuExit;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
