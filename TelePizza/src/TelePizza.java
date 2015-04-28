import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class TelePizza implements ActionListener, ItemListener {

	JFrame window;
	JComboBox<String> size, special;
	JCheckBox ingredients[];
	JRadioButton place[];
	ButtonGroup placeGroup;
	JTextField textField;
	JButton confirm;
	
	
	public static void main(String[] args) {
		TelePizza telePizza = new TelePizza("TelePizza",100,100);
	}
	
	public TelePizza(String title, int posX,int posY){
		window = new JFrame(title);
		window.setSize(500,400);
		window.setLocation(posX, posY);
		
		window.setContentPane(createWindowPanel());
		
		
		window.setVisible (true);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private Container createWindowPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,40,20));
		
		panel.add(createComboBox(),BorderLayout.NORTH);
		panel.add(createCheckBox(),BorderLayout.CENTER);
		panel.add(createRadioButton(),BorderLayout.SOUTH);
		
		return panel;
	}
	
	private Component createComboBox() {
		String[] sizes = {"size1", "size2", "size3"};
		String[] specials = {"special1", "Special2", "special3"};
		JPanel panel = new JPanel (new GridLayout(1,2,10,0));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.CYAN),
				BorderFactory.createTitledBorder("Places")));
		panel.setBackground(Color.white);
		
		size = new JComboBox<String>(sizes);
		special = new JComboBox<String>(specials);
		
		panel.add(size);
		panel.add(special);
		return panel;
	}

	private Component createCheckBox() {
		JPanel panel = new JPanel (new GridLayout(3,2,10,10));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.YELLOW),
				BorderFactory.createTitledBorder("Ingredients")));
		panel.setBackground(Color.white);
		
		ingredients = new JCheckBox[6];
		ingredients[0] = new JCheckBox("Ingredient1");
		ingredients[1] = new JCheckBox("Ingredient2");
		ingredients[2] = new JCheckBox("Ingredient3");
		ingredients[3] = new JCheckBox("Ingredient4");
		ingredients[4] = new JCheckBox("Ingredient5");
		ingredients[5] = new JCheckBox("Ingredient6");
		
		
		panel.add(ingredients[0]);
		panel.add(ingredients[1]);
		panel.add(ingredients[2]);
		panel.add(ingredients[3]);
		panel.add(ingredients[4]);
		panel.add(ingredients[5]);
		return panel;
	}

	private Component createRadioButton() {
		JPanel panel = new JPanel (new GridLayout(2,1,10,0));
		JPanel panelSuperior = new JPanel (new GridLayout(1,3,10,0));
		JPanel panelInferior = new JPanel (new FlowLayout());
		textField = new JTextField();
		panelSuperior.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GREEN),
				BorderFactory.createTitledBorder("Places")));
		panelSuperior.setBackground(Color.WHITE);
		
		place = new JRadioButton[2];
		place[0] = new JRadioButton("Take in the local factory");
		place[1] = new JRadioButton("Take it in: ");
		place[0].addItemListener(this);
		place[1].addItemListener(this);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(place[0]);
		buttonGroup.add(place[1]);
		
		panelSuperior.add(place[0]);
		panelSuperior.add(place[1]);
		panelSuperior.add(textField);
		
		confirm = new JButton("Confirm");
		confirm.addActionListener(this);
		panelInferior.add(confirm);
		
		panel.add(panelSuperior);
		panel.add(panelInferior);
		return panel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange()==ItemEvent.SELECTED) {
			if (e.getSource()==place[1]) {
				textField.setEditable(true);
			} else {
				textField.setEditable(false);
				textField.setText("");
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==confirm) {
			System.out.println("Uouuuuu");
		}
	}
}
