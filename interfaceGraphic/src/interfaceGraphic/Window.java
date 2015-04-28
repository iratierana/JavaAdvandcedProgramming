package interfaceGraphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Window extends JFrame{
	
	AbstractAction acc;

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
		acc = new MyAction ("Title", new ImageIcon("icons/.png"), "LongTitle", KeyEvent.VK_C);
		
	}
	
	private JMenuBar createBar() {
		JMenuBar bar = new JMenuBar();
		
		bar.add(createFirstBar());
		bar.add(Box.createHorizontalGlue());
		bar.add(createLastBar());
		
		return bar;
	}

	private JMenu createFirstBar() {
		JMenu menu = new JMenu("First Bar");
		
		menu.add(acc);
		
		return menu;
	}

	private JMenu createLastBar() {
		JMenu menu = new JMenu("Last Bar");
		
		menu.add(acc);
		
		return menu;
	}
	
	private Component createToolBar() {
		JToolBar toolBar = new JToolBar();
		
		toolBar.add(new JButton (acc));
		toolBar.addSeparator(new Dimension (20,0));
		toolBar.add(new JButton (acc));
		toolBar.add(Box.createHorizontalGlue());
		toolBar.add(new JButton (acc));

		return toolBar;
	}
	
	private Component createWindowPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.ORANGE),
				BorderFactory.createTitledBorder("MyDemo")));
		panel.setBackground(Color.WHITE);
		
		panel.add(new JTextField("Write here"), BorderLayout.NORTH);
		panel.add(createCheckBox(), BorderLayout.CENTER);
		panel.add(new JButton(acc), BorderLayout.SOUTH);
		
		return panel;
	}

	private Component createCheckBox() {
		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.YELLOW),
				BorderFactory.createTitledBorder("MyCheckBoxDemo")));
		panel.setBackground(Color.WHITE);
		
		panel.add(new JCheckBox(acc));
		panel.add(new JCheckBox(acc));
		panel.add(new JCheckBox(acc));
		panel.add(new JCheckBox(acc));
		panel.add(new JCheckBox(acc));
		panel.add(new JCheckBox(acc));
		
		return panel;
	}
	
}
