package intGraphicRaffle;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener{
	
	JFrame window;
	JLabel text;
	Button buttons[][];
	JButton exit;
	int total = 0;
	final static int ROW = 10;
	final static int COL = 5;
	
	
	public static void main(String[] args) {
		Main main = new Main("Riffle");

	}
	
	public Main(String title){
		window = new JFrame(title);
		window.setSize(320,240);
		window.setLocation(100, 100);
		
		window.setContentPane(createWindowPanel());
		initialize();
		
		
		window.setVisible (true);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initialize() {
		int x,y;
		
		for(x = 0; x < ROW; x++){
			for(y = 0; y < COL; y++){
				buttons[x][y].button.setText("");
			}
		}
		
	}

	private Container createWindowPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,40,20));
		
		panel.add(createText(),BorderLayout.NORTH);
		panel.add(createMatrix(),BorderLayout.CENTER);
		panel.add(createButton(),BorderLayout.SOUTH);
		
		return panel;
}

	private Component createText() {
		text = new JLabel("");
		return text;
	}

	private Component createMatrix() {
		JPanel panel = new JPanel(new GridLayout(ROW,COL));
		int x,y;
		
		buttons = new Button[ROW][COL];
		
		for(x = 0; x < ROW; x++){
			for(y = 0; y < COL; y++){
				buttons[x][y].button.addActionListener(this);
				panel.add(buttons[x][y].button);
				buttons[x][y].value = (int)(Math.random()*35000);
				if(buttons[x][y].value%2!=0){
					buttons[x][y].value = 0;
				}
			}
		}
		
		return panel;
	}

	private Component createButton() {
		exit = new JButton("Exit");
		exit.addActionListener(this);
		return exit;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand() == "Exit"){
			window.dispose();
		}
		else{
			Button aux = (Button) arg0.getSource();
			if(aux.value == 0){
				
			}
			else{
				total = total + aux.value;
				aux.button.setText(String.valueOf(aux.value));
				text.setText(String.valueOf(total));
			}
		}
	}

}
