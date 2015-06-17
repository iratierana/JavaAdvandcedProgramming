package table;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class MiColumnModel extends DefaultTableColumnModel {
	MiRenderer renderer;
	
	public MiColumnModel(MiRenderer renderer) {
		super();
		this.renderer = renderer;
		this.addColumn(crearColumna("Nombre", 1));
		this.addColumn(crearColumna("Raza", 2));
	}
	
	private TableColumn crearColumna(String txt, int index) {
		TableColumn col = new TableColumn();
		col.setCellRenderer(renderer);
		col.setModelIndex(index);
		col.setHeaderValue(txt);
		return col;
	}
	
}
