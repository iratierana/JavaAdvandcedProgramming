package table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MiTableModel extends AbstractTableModel {
	ArrayList<TableRow> list;
	MiColumnModel cols;
	
	public MiTableModel(ArrayList<TableRow> list, MiColumnModel model) {
		this.list = list;
		this.cols = model;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols.getColumnCount();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getValueAt(int x, int y) {
		String ret = null;
		switch (y) {
		case 0: ret = list.get(x).hola; break;
		case 1: ret = list.get(x).adios; break;
		}
		return ret;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: list.get(rowIndex).hola = (String) aValue; break;
		case 1: list.get(rowIndex).adios = (String) aValue; break;
		}		
		this.fireTableCellUpdated(rowIndex, columnIndex);
	}
	
}
