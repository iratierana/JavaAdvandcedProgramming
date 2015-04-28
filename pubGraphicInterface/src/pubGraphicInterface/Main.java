package pubGraphicInterface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.soap.Text;

public class Main implements ActionListener{
	
	JFrame window;
	JPanel foodButtons;
	JLabel price;
	JPanel panel;
	ImageIcon imageIcon;
	ArrayList<Product> productList;
	ListIterator<Product> productListIt;
	int total = 0;
	
	public static void main(String[] args) {
		Main main = new Main();

	}
	
	public Main(){
		productList = new ArrayList<Product>();
		window = new JFrame("Paco´s Pub");
		window.setLocation(0, 0);
		window.setSize(400,400);
		window.setContentPane(createPanel());
		window.setResizable(false);
		window.setVisible(true);
		window.pack();
	}
	private Container createPanel() {
		panel = new JPanel(new BorderLayout());
		panel.add(createPricePanel(),BorderLayout.NORTH);
		panel.add(createFoodPanel(),BorderLayout.CENTER);
		return panel;
	}
	private Container createPricePanel() {
		price = new JLabel();
		price.setText("0");
		return price;
	}
	private Container createFoodPanel() {
		foodButtons = new JPanel(new GridLayout(2,2));
		JButton food1 = new JButton();
		JButton food2 = new JButton();
		JButton food3 = new JButton();
		JButton food4 = new JButton();
		
		imageIcon = new ImageIcon("./image/beer.jpg");
		food1.setIcon(imageIcon);
		food1.setText("beer");
		food1.addActionListener(this);
		
		imageIcon = new ImageIcon("./image/pintxo.jpg");
		food2.setIcon(imageIcon);
		food2.setText("pintxo");
		food2.addActionListener(this);
		
		imageIcon = new ImageIcon("./image/wine.jpg");
		food3.setIcon(imageIcon);
		food3.setText("wine");
		food3.addActionListener(this);
		
		imageIcon = new ImageIcon("./image/total.jpg");
		food4.setIcon(imageIcon);
		food4.setText("total");
		food4.addActionListener(this);
		
		foodButtons.add(food1);
		foodButtons.add(food2);
		foodButtons.add(food3);
		foodButtons.add(food4);
		
		return foodButtons;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Product product;
		productListIt = productList.listIterator();
		
		switch(arg0.getActionCommand()){
		case "beer":
			product = new Product("Beer", 3);
			productList.add(product);
			total = total + 3;
			break;
		case "pintxo":
			product = new Product("Pintxo", 2);
			productList.add(product);
			total = total + 2;
			break;
		case "wine":
			product = new Product("Wine", 1);
			productList.add(product);
			total = total + 1;
			break;
		case "total":
			total = 0;
			break;
		}
		
		price.setText(Integer.toString(total));
		
	}

}
