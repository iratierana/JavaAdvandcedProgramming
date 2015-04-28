package windowBuilder;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Scrollbar;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Window extends JFrame{
	private JTable table;
	
	
	
	public Window() {
		getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnG = new JMenu("G1");
		menuBar.add(mnG);
		
		JMenu mnM = new JMenu("M1");
		mnG.add(mnM);
		
		JMenuItem mntmI = new JMenuItem("I1");
		mntmI.setIcon(new ImageIcon(Window.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		mnM.add(mntmI);
		
		JMenuItem mntmI_1 = new JMenuItem("I2");
		mntmI_1.setIcon(new ImageIcon(Window.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Background-Color-Black.png")));
		mnM.add(mntmI_1);
		
		JMenu mnM_1 = new JMenu("M2");
		mnG.add(mnM_1);
		
		JMenuItem mntmI_2 = new JMenuItem("I1");
		mnM_1.add(mntmI_2);
		
		JMenuItem mntmI_3 = new JMenuItem("I2");
		mnM_1.add(mntmI_3);
		
		JMenu mnG_1 = new JMenu("G2");
		menuBar.add(mnG_1);
		
		JMenuItem mntmO = new JMenuItem("O1");
		mnG_1.add(mntmO);
		
		JMenu mnG_3 = new JMenu("G4");
		menuBar.add(mnG_3);
		
		JCheckBoxMenuItem chckbxmntmO = new JCheckBoxMenuItem("O1");
		mnG_3.add(chckbxmntmO);
		
		JCheckBoxMenuItem chckbxmntmO_1 = new JCheckBoxMenuItem("O2");
		mnG_3.add(chckbxmntmO_1);
		
		JCheckBoxMenuItem chckbxmntmO_2 = new JCheckBoxMenuItem("O3");
		mnG_3.add(chckbxmntmO_2);
		getContentPane().setLayout(new GridLayout(2, 2, 10, 10));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblW = new JLabel("W");
		panel.add(lblW, BorderLayout.WEST);
		
		JLabel lblN = new JLabel("N");
		lblN.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblN, BorderLayout.NORTH);
		
		JLabel lblS = new JLabel("E");
		panel.add(lblS, BorderLayout.EAST);
		
		JLabel lblS_1 = new JLabel("S");
		lblS_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblS_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		panel_2.setBackground(new Color(0, 204, 51));
		panel_2.setForeground(new Color(255, 255, 51));
		panel.add(panel_2, BorderLayout.CENTER);
		
		JButton btnPushme = new JButton("PushMe");
		btnPushme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Haloo");
			}
		});
		btnPushme.setIcon(new ImageIcon(Window.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		getContentPane().add(btnPushme);
		
		JLabel lblL = new JLabel("L1");
		getContentPane().add(lblL);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JProgressBar progressBar = new JProgressBar();
		panel_1.add(progressBar, BorderLayout.NORTH);
		
		Scrollbar scrollbar = new Scrollbar();
		panel_1.add(scrollbar, BorderLayout.EAST);
		
		table = new JTable();
		panel_1.add(table, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
