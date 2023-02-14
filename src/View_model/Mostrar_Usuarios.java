package View_model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import DAO_model.Empleado_DAO;
import DAO_model.Jornada_DAO;
import DAO_model.Usuario_DAO;
import DTO_model.Empleado_DTO;
import DTO_model.Jornada_DTO;
import DTO_model.Usuario_DTO;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class Mostrar_Usuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	// TABLA
	static DefaultTableModel dtm;
	private JTable table;
	//
	public static Empleado_DAO empDAO = new Empleado_DAO();
	static ArrayList<Empleado_DTO> empleados;
	public static Usuario_DAO usuDAO = new Usuario_DAO();
	static ArrayList<Usuario_DTO> usuarios;
	static ArrayList<String> nombresEmpleados = new ArrayList<String>();
	private JTextField tfFiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mostrar_Usuarios dialog = new Mostrar_Usuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mostrar_Usuarios() {
		setUndecorated(true);
		empleados = empDAO.listarTodos();
		usuarios = usuDAO.listarTodos();
		//

		//
		setBounds(100, 100, 623, 548);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(138, 153, 148));
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		//
		setResizable(false);
		setLocationRelativeTo(null);
		//
		// DEFAULT TABLE MODEL
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}
		};
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 168, 514, 261);
		contentPanel.add(scrollPane);
		// ************************************************
		// TABLA
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();
					// Obtener el registro correspondiente
					usuarios = usuDAO.listarTodos();
					Usuario_DTO loginEmpleado = usuarios.get(row);
					// Mostrar la ventana
					Autenticar autenticar_ventana = new Autenticar(loginEmpleado);
					autenticar_ventana.setVisible(true);
				}
			}
		});
		table.setModel(dtm);
		dtm.addColumn("Nombre");
		dtm.addColumn("Usuario");
		dtm.addColumn("Contraseña");
		// ************************************************
		Color rosa = new Color(220, 20, 60);
		JTableHeader header = table.getTableHeader();
		header.setBackground(rosa);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.DARK_GRAY);
		// ************************************************

		scrollPane.setViewportView(table);
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 71, 591, 2);
		contentPanel.add(separator_1_1_1);

		JLabel lblRegistrosDeEmpleados = new JLabel("ADMINISTRACIÓN DE USUARIOS");
		lblRegistrosDeEmpleados.setForeground(Color.WHITE);
		lblRegistrosDeEmpleados.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblRegistrosDeEmpleados.setBounds(20, 20, 357, 41);
		contentPanel.add(lblRegistrosDeEmpleados);

		JButton btnAtrs = new JButton("ATRÁS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnAtrs.setBorder(null);
		btnAtrs.setBackground(new Color(220, 20, 60));
		btnAtrs.setBounds(262, 500, 115, 38);
		contentPanel.add(btnAtrs);

		JLabel lblParaRestablecerUsuario = new JLabel(
				"Para restablecer usuario o contraseña, haga doble click en un registro.");
		lblParaRestablecerUsuario.setForeground(Color.WHITE);
		lblParaRestablecerUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblParaRestablecerUsuario.setBounds(62, 439, 537, 41);
		contentPanel.add(lblParaRestablecerUsuario);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(10, 488, 591, 2);
		contentPanel.add(separator_1_1_1_1);

		tfFiltro = new JTextField();
		tfFiltro.setBounds(52, 123, 236, 35);
		contentPanel.add(tfFiltro);
		tfFiltro.setColumns(10);

		JLabel lblBuscaLosUsuarios = new JLabel("Busca los usuarios que por la letra o palabra introducida:");
		lblBuscaLosUsuarios.setForeground(Color.WHITE);
		lblBuscaLosUsuarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblBuscaLosUsuarios.setBounds(52, 72, 537, 41);
		contentPanel.add(lblBuscaLosUsuarios);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreABuscar = tfFiltro.getText();
				dtm.setRowCount(0);
				usuarios = usuDAO.buscarUsuariosFiltro(nombreABuscar);
				llenarTabla();

			}
		});
		btnFiltrar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnFiltrar.setBorder(null);
		btnFiltrar.setBackground(new Color(251, 249, 255));
		btnFiltrar.setBounds(310, 123, 104, 35);
		contentPanel.add(btnFiltrar);
		
		JButton btnMostrar = new JButton("Mostrar Todo");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				tfFiltro.setText("");
				usuarios.clear();
				usuarios = usuDAO.listarTodos();
				llenarTabla();
			}
		});
		btnMostrar.setForeground(new Color(220, 20, 60));
		btnMostrar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnMostrar.setBorder(null);
		btnMostrar.setBackground(new Color(251, 249, 255));
		btnMostrar.setBounds(432, 123, 134, 35);
		contentPanel.add(btnMostrar);
	}

	// PARA PODER UTILIZAR LA TABLA
	public static void llenarTabla() {
		dtm.getDataVector().removeAllElements();
		if (usuarios.size() != 0) {
			for (Usuario_DTO _usuDTO : usuarios) {
				Object[] fila = new Object[3];
				int id_empleado = _usuDTO.getId_empleado();
				for (int i = 0; i < empleados.size(); i++) {
					if (empleados.get(i).getId_empleado() == id_empleado) {
						fila[0] = empleados.get(i).getNombre();
					}
				}
				fila[1] = _usuDTO.getUsuario();
				String asterisco = "";
				String pass = _usuDTO.getPassword();
				for(int i=pass.length(); i>0; i--) {
					asterisco = asterisco + "*";
				}
				fila[2] = asterisco;
				dtm.addRow(fila);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos para mostrar", "Advertencia",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
