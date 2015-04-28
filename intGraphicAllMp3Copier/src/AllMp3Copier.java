import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class AllMp3Copier implements ActionListener, Runnable{

	final static String SCAN_STRING = "Select directory to scan";
	final static String COPY_STRING = "Copy to...";
	
	JFrame frame;
	JButton choose, copy;
	File lastDirectory;
	JList<File> lista;
	DefaultListModel<File> model;
	JProgressBar bar;
	
	boolean running;
	
	public static void main(String[] args) {
		AllMp3Copier sim = new AllMp3Copier();
	}

	public AllMp3Copier (){
		model = new DefaultListModel<File>();
		
	    setLookAndFeel();
			
		frame = new JFrame("Song Information Manager");
		frame.setSize(500,240);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(createPanelMain());
		//frame.setResizable(false);
		frame.setVisible(true);
		
	}

	private void setLookAndFeel() {
		try {
            
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (UnsupportedLookAndFeelException e) {}
		    catch (ClassNotFoundException e) {}
		    catch (InstantiationException e) {}
		    catch (IllegalAccessException e) {}	
	}

	private Container createPanelMain() {
		JPanel pMain = new JPanel (new BorderLayout(20,20));
		JScrollPane pScroll = new JScrollPane(lista = new JList<File>(model));
		
		pMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		pMain.add(createPanelProgressBar(), BorderLayout.NORTH);
		pMain.add(pScroll, BorderLayout.CENTER);
		pMain.add(createPanelButtons(), BorderLayout.SOUTH);
		
		return pMain;
	}
	
	private Component createPanelProgressBar() {
		JPanel pBar = new JPanel ( new BorderLayout());
	
		pBar.add(bar = new JProgressBar(0, 1000));
		bar.setIndeterminate(true);
		
		return pBar;
	}

	private Component createPanelButtons() {
		JPanel pButtons = new JPanel (new BorderLayout());
		
		pButtons.add(choose = createButton(SCAN_STRING, "directory", true), BorderLayout.WEST);
		pButtons.add(copy = createButton(COPY_STRING, "ok", false), BorderLayout.EAST);
		
		return pButtons;
	}

	public JButton createButton(String title, String actionCommand, boolean active){
		
		JButton b = new JButton(title);
		b.addActionListener(this);
		b.setActionCommand(actionCommand);
		
		b.setEnabled(active);
		
		return b;
	}
	
	// --- FILE CHOOSER ---
	
	public JFileChooser createFileChooser(){
		JFileChooser filechooser = new JFileChooser();
		
		filechooser.setMultiSelectionEnabled(false);
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		filechooser.setDialogTitle("Select a MP3 containing directory");
		
		filechooser.setCurrentDirectory(lastDirectory);
		
		return filechooser;
	}
	
	public void chooseFolderLoad(){
		JFileChooser fc = createFileChooser();
		
		if ( fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION ){
			
			startThread();
			
			lastDirectory = fc.getCurrentDirectory();
						
			File f = fc.getSelectedFile();
			
			loadDirectory(f, model);
			
			terminateThread();
		
		}
		
		checkList();
	}

	public void chooseFolderSave() {
		
		JFileChooser fc = createFileChooser();
		
		if ( fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION ){
			
			lastDirectory = fc.getCurrentDirectory();
			
			startThread();
			
			for ( int i = 0 ; i < model.size(); i++){
				
				try {
					File newF = new File(fc.getSelectedFile().toString() + "\\" + model.get(i).getName());
					saveFile(model.get(i), newF);
					
				}catch (Exception e){
					JOptionPane.showMessageDialog(frame, "Error saving file !\n" + e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
			terminateThread();
			JOptionPane.showMessageDialog(frame,  "Files copied succesfully");
			
		}
		
		
	}
	

	// --- LOADING ---
	private void loadDirectory(File directory, DefaultListModel<File> list) {
		model.removeAllElements();
		loadFiles( directory, model );
	}

	private void loadFiles(File directory, DefaultListModel<File> list) {
		
		for ( File f : directory.listFiles()){
			
			if (f.isFile()){
				
				if (f.toString().toLowerCase().endsWith(".mp3")) list.addElement(f);
				
			}else if ( f.isDirectory() &&  f.listFiles() != null)
				loadFiles(f, list);
			
		}	

	}
	
	// --- SAVING ---
	private void saveFile(File file, File newF) throws Exception{
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(newF);
		
		int read;
		while (( read = fis.read()) != -1 ) {
			fos.write(read);
		}
		
		fis.close();
		fos.close();
		
	}
	
	// --- UTILITIES ---
	public void checkList(){
		
		if ( model.getSize() > 0 )
			copy.setEnabled(true);
		else
			copy.setEnabled(false);
		
	}
	
	// --- THREAD ---

	public void startThread(){
		running = true;
		(new Thread(this)).start();
	}
	
	public void terminateThread(){
		running = false;
	}
	
	public void run() {
		while(running){			
			frame.repaint();
			bar.repaint();
		}
	}	

	// --- LISTENERS ---

	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()){
			
		case "directory" : chooseFolderLoad(); 
			break;
		case "ok" : chooseFolderSave();
			break;
		}
	}
	
}
