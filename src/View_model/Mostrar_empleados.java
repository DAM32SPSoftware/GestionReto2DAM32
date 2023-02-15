package View_model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DAO_model.Empleado_DAO;
import DAO_model.Tipo_empleado_DAO;
import DTO_model.Empleado_DTO;
import DTO_model.Tipo_empleado_DTO;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class Mostrar_empleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	// TABLA
	static DefaultTableModel dtm;
	private JTable table;
	//
	public static Empleado_DAO empDAO = new Empleado_DAO();
	static ArrayList<Empleado_DTO> empleados;
	public static Tipo_empleado_DAO puestoDAO = new Tipo_empleado_DAO();
	static ArrayList<Tipo_empleado_DTO> puestos;
	// esto es para el click del header
	private boolean click = true;

	//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mostrar_empleados dialog = new Mostrar_empleados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mostrar_empleados() {
		setUndecorated(true);
		puestos = puestoDAO.listarTodos();
		empleados = empDAO.listarTodos();

		setBounds(100, 100, 914, 741);
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
		scrollPane.setBounds(55, 146, 778, 360);
		contentPanel.add(scrollPane);
		// ************************************************
		// TABLA
		table = new JTable(dtm);
		table.getTableHeader().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column = table.columnAtPoint(e.getPoint());
				if (e.getClickCount() == 2) {
					switch (column) {
					case 0:
						if (click) {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpAsc("nombre");
							table.getColumnModel().getColumn(column).setHeaderValue("Nombre \u25B2");
							llenarTabla();
							click = false;
							break;
						} else {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpDesc("nombre");
							table.getColumnModel().getColumn(column).setHeaderValue("Nombre \u25BC");
							llenarTabla();
							click = true;
							break;
						}

					case 1:
						if (click) {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpAsc("apellido");
							table.getColumnModel().getColumn(column).setHeaderValue("Apellido \u25B2");
							llenarTabla();
							click = false;
							break;
						} else {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpDesc("apellido");
							table.getColumnModel().getColumn(column).setHeaderValue("Apellido \u25BC");
							llenarTabla();
							click = true;
							break;
						}
					case 2:
						if (click) {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpAsc("dni");
							table.getColumnModel().getColumn(column).setHeaderValue("DNI \u25B2");
							llenarTabla();
							click = false;
							break;
						} else {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpDesc("dni");
							table.getColumnModel().getColumn(column).setHeaderValue("DNI \u25BC");
							llenarTabla();
							click = true;
							break;
						}
					case 3:
						if (click) {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpAsc("sueldo");
							table.getColumnModel().getColumn(column).setHeaderValue("Sueldo \u25B2");
							llenarTabla();
							click = false;
							break;
						} else {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpDesc("sueldo");
							table.getColumnModel().getColumn(column).setHeaderValue("Sueldo \u25BC");
							llenarTabla();
							click = true;
							break;
						}
					case 4:
						if (click) {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpAsc("fecha_entrada");
							table.getColumnModel().getColumn(column).setHeaderValue("Fecha Entrada \u25B2");
							llenarTabla();
							click = false;
							break;
						} else {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpDesc("fecha_entrada");
							table.getColumnModel().getColumn(column).setHeaderValue("Fecha Entrada \u25BC");
							llenarTabla();
							click = true;
							break;
						}
					case 5:
						if (click) {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpAsc("direccion");
							table.getColumnModel().getColumn(column).setHeaderValue("Direccion \u25B2");
							llenarTabla();
							click = false;
							break;
						} else {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpDesc("direccion");
							table.getColumnModel().getColumn(column).setHeaderValue("Direccion \u25BC");
							llenarTabla();
							click = true;
							break;
						}
					case 6:
						if (click) {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpAsc("ciudad");
							table.getColumnModel().getColumn(column).setHeaderValue("Ciudad \u25B2");
							llenarTabla();
							click = false;
							break;
						} else {
							dtm.setRowCount(0);
							empleados = empDAO.listarEmpDesc("ciudad");
							table.getColumnModel().getColumn(column).setHeaderValue("Ciudad \u25BC");
							llenarTabla();
							click = true;
							break;
						}

					}

				}

			}
		});
		table.setModel(dtm);
		dtm.addColumn("Nombre");
		dtm.addColumn("Apellido");
		dtm.addColumn("DNI");
		dtm.addColumn("Sueldo");
		dtm.addColumn("Fecha Entrada");
		dtm.addColumn("Direccion");
		dtm.addColumn("Ciudad");
		// ************************************************
		Color rosa = new Color(220, 20, 60);
		JTableHeader header = table.getTableHeader();
		header.setBackground(rosa);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.DARK_GRAY);

		scrollPane.setViewportView(table);
		JComboBox combo_tipo = new JComboBox();
		combo_tipo.setBounds(101, 616, 302, 35);
		for (int i = 0; i < puestos.size(); i++) {
			combo_tipo.addItem(puestos.get(i).getNombre_tipo());
		}
		contentPanel.add(combo_tipo);
		combo_tipo.insertItemAt("Seleccionar", 5);
		combo_tipo.setSelectedIndex(5);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 531, 880, 12);
		contentPanel.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 73, 880, 12);
		contentPanel.add(separator_1_1_1);

		JLabel lblSeleccionaElTipo = new JLabel("Selecciona el tipo de empleado para ver los registros");
		lblSeleccionaElTipo.setForeground(Color.WHITE);
		lblSeleccionaElTipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblSeleccionaElTipo.setBounds(55, 553, 401, 41);
		contentPanel.add(lblSeleccionaElTipo);

		JLabel lblRegistrosDeEmpleados = new JLabel("REGISTROS DE EMPLEADOS");
		lblRegistrosDeEmpleados.setForeground(Color.WHITE);
		lblRegistrosDeEmpleados.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblRegistrosDeEmpleados.setBounds(23, 22, 535, 41);
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
		btnAtrs.setBounds(409, 689, 115, 35);
		contentPanel.add(btnAtrs);

		JLabel lblClickAquPara = new JLabel("Click para mostrar todos los registros actuales");
		lblClickAquPara.setForeground(Color.WHITE);
		lblClickAquPara.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblClickAquPara.setBounds(491, 553, 342, 41);
		contentPanel.add(lblClickAquPara);

		JButton btnMostrarTodo = new JButton("MOSTRAR TODO");
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				combo_tipo.setSelectedIndex(0);
				empleados.clear();
				empleados = empDAO.listarTodos();
				llenarTabla();

			}
		});
		btnMostrarTodo.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnMostrarTodo.setBorder(null);
		btnMostrarTodo.setBackground(new Color(251, 249, 255));
		btnMostrarTodo.setBounds(545, 616, 231, 35);
		contentPanel.add(btnMostrarTodo);

		JLabel lblDobleClickEn = new JLabel(
				"Doble click en el nombre de la columna para ordenar los registros ascendente o descendente: ");
		lblDobleClickEn.setForeground(Color.WHITE);
		lblDobleClickEn.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDobleClickEn.setBounds(55, 95, 778, 41);
		contentPanel.add(lblDobleClickEn);
		combo_tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pos = combo_tipo.getSelectedIndex();
				Tipo_empleado_DTO _empleado = puestos.get(pos);
				empleados.clear();
				empleados = empDAO.listarPorTipo(_empleado);
				llenarTabla();
			}
		});
	}

	// PARA PODER UTILIZAR LA TABLA
	public static void llenarTabla() {
		dtm.getDataVector().removeAllElements();
		if (empleados.size() != 0) {
			for (Empleado_DTO empDTO : empleados) {
				Object[] fila = new Object[8];
				fila[0] = empDTO.getNombre();
				fila[1] = empDTO.getApellido();
				fila[2] = empDTO.getDni();
				fila[3] = empDTO.getSueldo();
				fila[4] = empDTO.getFecha_entrada();
				fila[5] = empDTO.getDireccion();
				fila[6] = empDTO.getCiudad();
				dtm.addRow(fila);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos para mostrar", "Advertencia",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
