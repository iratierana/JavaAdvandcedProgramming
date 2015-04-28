package fileFolderDuplicatorWithProgressBarMine;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Window extends JFrame implements ActionListener, PropertyChangeListener{

	JProgressBar progressBar;
	JButton openButton, copyButton;
	String fileName;
	CopyTask copyTask;
	
	public Window(){
		
		this.setLocation(200, 200);
		this.setSize(320, 240);
		this.getContentPane().add(createWindowPane());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	private Component createWindowPane() {
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(progressBar = new JProgressBar(), BorderLayout.NORTH);
		panel.add(copyButton = new JButton("Copy"), BorderLayout.CENTER);
		copyButton.addActionListener(this);
		copyButton.setEnabled(false);
		panel.add(openButton = new JButton("Open"), BorderLayout.SOUTH);
		openButton.addActionListener(this);
		
		return panel;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}
	
	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Open":
			JFileChooser j= new JFileChooser();
	        j.showOpenDialog(j);
	        fileName = j.getSelectedFile().getAbsolutePath();
	        copyTask = new CopyTask(new File(fileName), new File(fileName + "Copy"), progressBar);
	        copyButton.setEnabled(true);
	        copyTask.addPropertyChangeListener(this);
			break;

		case "Copy":
            copyTask.execute();
			break;
			
		default:
			break;
		}
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
