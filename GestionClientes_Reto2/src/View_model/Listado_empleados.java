package View_model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Listado_empleados extends JFrame {

	private JPanel contentPane;
	//TABLA
	private static DefaultTableModel dtm;
	private JTable table;
	//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado_empleados frame = new Listado_empleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Listado_empleados() {
		//DEFAULT TABLE MODEL
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 153, 148));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAquPuedesRealizar = new JLabel("CONSULTA DE EMPLEADOS");
		lblAquPuedesRealizar.setForeground(Color.WHITE);
		lblAquPuedesRealizar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblAquPuedesRealizar.setBounds(31, 20, 445, 41);
		contentPane.add(lblAquPuedesRealizar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 61, 976, 12);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 358, 976, -250);
		contentPane.add(scrollPane);
		//TABLA
		DefaultTableModel tableModel = tableModelCtor();
		JTable table = new JTable(tableModel);
		//
		scrollPane.setViewportView(table);
	}
	//PARA PODER UTILIZAR LA TABLA
	private DefaultTableModel tableModelCtor() {
		
        return null;
	}
}
