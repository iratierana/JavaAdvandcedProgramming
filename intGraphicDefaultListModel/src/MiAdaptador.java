import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


@SuppressWarnings("serial")
public class MiAdaptador extends JLabel implements ListCellRenderer<String> {

	boolean isSelected;
	boolean cellhasFocus;
	
	@Override
	public Component getListCellRendererComponent(JList<? extends String> arg0,
			String arg1, int arg2, boolean arg3, boolean arg4) {
		
		this.setBackground(isSelected ? Color.red : Color.WHITE);
		setOpaque(true);
		
		return this;
	}
}
