package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener{
	
	JFrame window;
	JLabel text;
	JButton one, two, three, four, five, six, seven, eight, nine, whiteLeft, zero, whiteRight;
	JButton plus, minus, multiply, divide, equals;

	public static void main(String[] args) {
		Calculator calculator = new Calculator("Calculator", 100, 100);

	}
	
	public Calculator(String title, int posX, int posY) {
		window = new JFrame(title);
		window.setSize(600, 400);
		window.setLocation(posX, posY);
		
		window.setContentPane(createWindowPanel());
		
		window.setVisible(true);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private Container createWindowPanel(){
		JPanel panel = new JPanel (new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(10,20,40,20));
		text = new JLabel("0");
		text.setFont(new Font("calibri", Font.PLAIN, 20));
		text.setForeground(Color.black);
		text.setHorizontalAlignment(JLabel.RIGHT);
		
		
		
		panel.add(text,BorderLayout.NORTH);
		panel.add(createNumbersButtonPanel(),BorderLayout.CENTER);
		panel.add(createActionsButtonPanel(),BorderLayout.EAST);
		return panel;

	}
	
	private Component createNumbersButtonPanel() {
		JPanel panel = new JPanel (new GridLayout(4,3));
		panel.setBackground(Color.white);
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		whiteLeft = new JButton(" ");
		zero = new JButton("0");
		whiteRight = new JButton(" ");
		
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		zero.addActionListener(this);
		
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(four);
		panel.add(five);
		panel.add(six);
		panel.add(seven);
		panel.add(eight);
		panel.add(nine);
		panel.add(whiteLeft);
		panel.add(zero);
		panel.add(whiteRight);
		
		return panel;

		
	}
	
	private Component createActionsButtonPanel() {
		JPanel panel = new JPanel (new GridLayout(5,1));
		panel.setBackground(Color.white);
		
		
		plus = new JButton("+");
		minus = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		equals = new JButton("=");
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		equals.addActionListener(this);
		
		panel.add(plus);
		panel.add(minus);
		panel.add(multiply);
		panel.add(divide);
		panel.add(equals);
		
		return panel;
		
	}

	public void actionPerformed(ActionEvent evt) {
	    Object src = evt.getSource();
	    if(text.getText()=="0"){
	    	text.setText("");
	    }
	    if (src == one) {
	    	text.setText(text.getText() + "1");
	    }
	    if (src == two) {
	    	text.setText(text.getText() + "2");
	    }
	    if (src == three) {
	    	text.setText(text.getText() + "3");
	    }
	    if (src == four) {
	    	text.setText(text.getText() + "4");
	    }
	    if (src == five) {
	    	text.setText(text.getText() + "5");
	    }
	    if (src == six) {
	    	text.setText(text.getText() + "6");
	    }
	    if (src == seven) {
	    	text.setText(text.getText() + "7");
	    }
	    if (src == eight) {
	    	text.setText(text.getText() + "8");
	    }
	    if (src == nine) {
	    	text.setText(text.getText() + "9");
	    }
	    if (src == zero) {
	    	text.setText(text.getText() + "0");
	    }
	    if (src == plus) {
	    	text.setText(text.getText() + "+");
	    }
	    if (src == minus) {
	    	text.setText(text.getText() + "-");
	    }
	    if (src == multiply) {
	    	text.setText(text.getText() + "*");
	    }
	    if (src == divide) {
	    	text.setText(text.getText() + "/");
	    }
	    if (src == equals) {
	    	text.setText(text.getText() + "=");
	    }
	  }

	

}
