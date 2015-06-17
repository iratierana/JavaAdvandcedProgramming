package table;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class Main extends JFrame implements TableModelListener {
	JTable tabla;
	MiRenderer renderer;
	MiColumnModel columnModel;
	MiTableModel tableModel;
	ArrayList<TableRow> lista;

	public Main() {
		super("prueba");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(rellenar());
		setVisible(true);
	}
	
	private JPanel rellenar() {
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane();
		//Para que cargue del txt pon null. Para que cargue de DB no pongas nada
		cargarLista();
		cargarTabla();
		scroll.setViewportView(tabla);
		panel.add(scroll);
		return panel;
	}
	
	private void cargarTabla() {
		tabla = new JTable();
		renderer = new MiRenderer();
		columnModel = new MiColumnModel(renderer);
		tableModel = new MiTableModel(lista, columnModel);
		tableModel.addTableModelListener(this);
		tabla.setModel(tableModel);
	}
	
	public void cargarLista(String hola) {
		try {
			lista = new ArrayList<>();
			BufferedReader reader = new BufferedReader(new FileReader("txt.txt"));
			String txt;
			while ((txt = reader.readLine())!=null) {
				String data [] = txt.split("[$]");
				TableRow row = new TableRow(data[0], data[1]);
				lista.add(row);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarLista() {
		try {
			lista = new ArrayList<>();
			//Connection conn = DriverManager.getConnection("localhost", "java", "prueba");
			Connection conn = DriverManager.getConnection("jdbc:mysql://cowtek.mooo.com:3306/COWTEK", "aitorurrutia", "ondarru");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM vaca");
			while (rs.next()) lista.add(new TableRow(rs.getString("Nombre"), rs.getString("Raza")));
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		String sql = "SELECT * FROM ?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://cowtek.mooo.com:3306/COWTEK", "aitorurrutia", "ondarru");
			conn.setAutoCommit(false);
			ps1 = conn.prepareStatement(sql);
			ps1.setString(1, "Vaca");
			ps1.executeQuery();
			ps2 = conn.prepareStatement(sql);
			ps2.setString(1, "Vaca2");
			ps2.executeQuery();
			
			conn.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps1 != null) ps1.close();
				if (ps2 != null) ps2.close();
				if (conn!= null) conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
