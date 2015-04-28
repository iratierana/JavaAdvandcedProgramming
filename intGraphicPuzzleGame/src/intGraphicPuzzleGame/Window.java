package intGraphicPuzzleGame;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener{

	final int ROWS = 4;
	final int COLS = 3;
	int holeX, holeY;
	int pieces[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,0}};
	JPanel panel; 
	
	public Window(){
		super ("Puzzle");
		this.setLocation(100,100);
		this.setSize(420,300);
		pieces = new int [ROWS] [COLS];
		initializePieces();
		
		this.setContentPane(createWindowPanel());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void initializePieces() {
		Random generator = new Random();
		for (int i = 0; i < ROWS; i++){
			for (int j = 0; j < COLS; ){ //va colocando las piezas en modo random
				int piece = generator.nextInt(11)+1; 
				if (!included(piece)){
					pieces[i][j]= piece;
					j++;
				}
				if (i==ROWS-1&& j==COLS-1){ //una vez llegado a la derecha abajo, pone el hueco, y guarda la posicion
					pieces[i][j]=0;
					holeX = i;
					holeY = j;
					return;
				}
			}
		}
	}
	private boolean included(int piece) {
		for (int i = 0; i < ROWS; i++){
			for (int j = 0; j < COLS; j++){
				if (pieces[i][j]== piece){
					return true;
				}
			}
		}
		return false;
	}
	private Container createWindowPanel() {
		panel = new JPanel (new GridLayout (ROWS,COLS,5,5));
		JButton button;
		for (int i = 0; i < ROWS; i++){
			for (int j = 0; j < COLS; j++){ //cada casilla tiene un numero, le asigna la foto correspondiente
				String name = "tigre"+pieces[i][j]+".png";
				ImageIcon imagen = new ImageIcon ("images/" + name);
				button = new JButton(imagen);
				button.addActionListener(this);
				button.setActionCommand(i+" "+j);
				panel.add(button);
			}
		}
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int mov;
		String comando = e.getActionCommand();
		int i = Integer.valueOf(comando.substring(0, comando.indexOf(' '))).intValue();
		int j = Integer.valueOf(comando.substring(comando.indexOf(' ')+1)).intValue();
		if ((mov = valid(i,j))!=0){
			JButton boton =(JButton)e.getSource(); 
			Icon imagen = boton.getIcon();
			
			((JButton)panel.getComponent(holeX * COLS + holeY)).setIcon(imagen);
			boton.setIcon(null);
			holeX= i;
			holeY = j;
		}else{
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
			Toolkit.getDefaultToolkit().beep();
		}
		
	}
	private int valid(int i, int j) {
		
		if (((i-1)==holeX)&&(j == holeY)) return 1;
		
		if ((i== holeX)&&((j-1)==holeY)) return 2;
		
		if (((i+1)==holeX) && (j==holeY))  return 3;
		
		if ((i== holeX) && ((j+1)== holeY)) return 4;
		
		return 0;
	}


}
