package createList;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyAdapter extends JLabel implements ListCellRenderer<Person>{

	@Override
	public Component getListCellRendererComponent(JList<? extends Person> list,
			Person value, int index, boolean isSelected, boolean cellHasFocus) {
		
		Person p = (Person) value;
		
		this.setText(p.toString());
		
		setFont(new Font("Calibri", Font.ITALIC, 16));
		setBackground(isSelected ? Color.CYAN : Color.WHITE);
		setForeground(isSelected ? Color.white : Color.BLACK);
		setOpaque(true);
		
		return this;
		
	}
	

}
