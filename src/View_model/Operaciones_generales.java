package View_model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO_model.Empleado_DAO;
import DAO_model.Tipo_empleado_DAO;
import DTO_model.Empleado_DTO;
import DTO_model.Tipo_empleado_DTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Operaciones_generales extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfSueldo;
	private JTextField tfEntrada;
	private JTextField tfDNI;
	private JComboBox combo;
	//
	public static Empleado_DAO empDAO = new Empleado_DAO();
	public static Tipo_empleado_DAO puestoDAO = new Tipo_empleado_DAO();
	static ArrayList<Tipo_empleado_DTO> puestos;
	static ArrayList<Empleado_DTO> empleados;
	private JTextField tfDireccion;
	private JTextField tfCiudad;
	private JTextField tfId;
	Empleado_DTO emp_dto;

	//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operaciones_generales frame = new Operaciones_generales();
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
	public Operaciones_generales() {
		setUndecorated(true);
		puestos = puestoDAO.listarTodos();
		empleados = empDAO.listarTodos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 153, 148));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//
		setResizable(false);
		setLocationRelativeTo(null);
		//
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNombre.setBounds(21, 323, 82, 41);
		contentPane.add(lblNombre);

		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfNombre.setColumns(10);
		tfNombre.setBounds(113, 327, 267, 33);
		contentPane.add(tfNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblApellido.setBounds(21, 378, 82, 41);
		contentPane.add(lblApellido);

		tfApellido = new JTextField();
		tfApellido.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfApellido.setColumns(10);
		tfApellido.setBounds(113, 382, 267, 33);
		contentPane.add(tfApellido);

		JLabel lblEmail = new JLabel("Sueldo");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEmail.setBounds(475, 156, 82, 41);
		contentPane.add(lblEmail);

		tfSueldo = new JTextField();
		tfSueldo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfSueldo.setColumns(10);
		tfSueldo.setBounds(582, 160, 303, 33);
		contentPane.add(tfSueldo);

		JLabel lblActivo = new JLabel("Tipo de Empleado");
		lblActivo.setForeground(Color.WHITE);
		lblActivo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblActivo.setBounds(21, 207, 150, 41);
		contentPane.add(lblActivo);

		JLabel lblFecha = new JLabel("Fecha Entrada");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFecha.setBounds(475, 320, 125, 41);
		contentPane.add(lblFecha);

		tfEntrada = new JTextField();
		tfEntrada.setToolTipText("Fecha de Entrada");
		tfEntrada.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfEntrada.setColumns(10);
		tfEntrada.setBounds(625, 325, 260, 31);
		contentPane.add(tfEntrada);

		JLabel lblltimaActualizacin = new JLabel("DNI");
		lblltimaActualizacin.setForeground(Color.WHITE);
		lblltimaActualizacin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblltimaActualizacin.setBounds(21, 436, 46, 41);
		contentPane.add(lblltimaActualizacin);

		tfDNI = new JTextField();
		tfDNI.setToolTipText("Fecha de Entrada");
		tfDNI.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfDNI.setColumns(10);
		tfDNI.setBounds(113, 441, 267, 31);
		contentPane.add(tfDNI);

		JLabel lblAquPuedesRealizar = new JLabel("TRAMITAR EMPLEADOS");
		lblAquPuedesRealizar.setForeground(Color.WHITE);
		lblAquPuedesRealizar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblAquPuedesRealizar.setBounds(21, 27, 952, 41);
		contentPane.add(lblAquPuedesRealizar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 68, 952, 12);
		contentPane.add(separator_1);

		combo = new JComboBox();
		combo.setBounds(21, 258, 359, 29);
		for (int i = 0; i < puestos.size(); i++) {
			combo.addItem(puestos.get(i).getId_tipo() + " - " + puestos.get(i).getNombre_tipo());
		}
		contentPane.add(combo);
		JComboBox combo_buscar = new JComboBox();
		combo_buscar.setBounds(21, 568, 359, 29);
		contentPane.add(combo_buscar);
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBackground(new Color(255, 255, 255));
		btnAgregar.setBorder(null);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setForeground(new Color(0, 128, 0));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty() || tfSueldo.getText().isEmpty() || tfDNI.getText().isEmpty() || tfDireccion.getText().isEmpty() || tfCiudad.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					return;
					}
				// String id = tfId.getText();
				// Integer num_id = Integer.parseInt(id);
				int tipo = puestos.get(combo.getSelectedIndex()).getId_tipo();
				String nombre = tfNombre.getText();
				String apellido = tfApellido.getText();
				String sueldo = tfSueldo.getText();
				double num_sueldo = Double.parseDouble(sueldo);
				String dni = tfDNI.getText();
				String direccion = tfDireccion.getText();
				String ciudad = tfCiudad.getText();
				Date fecha = new Date(System.currentTimeMillis());
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());

				try {
						Empleado_DTO _emp = new Empleado_DTO(tipo, nombre, apellido, num_sueldo, dni, direccion, ciudad,
								fecha);
						empDAO.insertar(_emp);
						JOptionPane.showMessageDialog(null, "Empleado AGREGADO con éxito.", "Información",
								JOptionPane.INFORMATION_MESSAGE);
						empleados = empDAO.listarTodos();
						combo_buscar.removeAllItems();
					

				} catch (Exception ex) {
				}

				for (int i = 0; i < empleados.size(); i++) {
					combo_buscar.addItem(empleados.get(i).getNombre() + " " + empleados.get(i).getApellido());
				}
				limpiar();
			}
		});
		btnAgregar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnAgregar.setBounds(744, 401, 141, 33);
		contentPane.add(btnAgregar);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setBorder(null);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
				try {
					empDAO.borrar(Integer.parseInt(tfId.getText()));
					JOptionPane.showMessageDialog(null, "Empleado ELIMINADO con éxito.", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					empleados = empDAO.listarTodos();
					combo_buscar.removeAllItems();

				} catch (Exception ex) {
				}

				for (int i = 0; i < empleados.size(); i++) {
					combo_buscar.addItem(empleados.get(i).getNombre() + " " + empleados.get(i).getApellido());
				}
				limpiar();
			}
		});
		btnEliminar.setForeground(new Color(255, 69, 0));
		btnEliminar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnEliminar.setBounds(239, 612, 141, 33);
		contentPane.add(btnEliminar);

		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBackground(new Color(255, 255, 255));
		btnModificar.setBorder(null);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = emp_dto.getId_empleado();
				int tipo = puestos.get(combo.getSelectedIndex()).getId_tipo();
				String nombre = tfNombre.getText();
				String apellido = tfApellido.getText();
				String sueldo = tfSueldo.getText();
				double num_sueldo = Double.parseDouble(sueldo);
				String dni = tfDNI.getText();
				String direccion = tfDireccion.getText();
				String ciudad = tfCiudad.getText();
				Date fecha = new Date(System.currentTimeMillis());
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());

				try {
					Empleado_DTO _emp = new Empleado_DTO(id, tipo, nombre, apellido, num_sueldo, dni, fecha, ciudad,
							direccion);
					empDAO.actualizar(_emp);
					JOptionPane.showMessageDialog(null, "Empleado MODIFICADO con éxito.", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					empleados = empDAO.listarTodos();
					combo_buscar.removeAllItems();

				} catch (Exception ex) {
				}

				for (int i = 0; i < empleados.size(); i++) {
					combo_buscar.addItem(empleados.get(i).getNombre() + " " + empleados.get(i).getApellido());
				}
				limpiar();
			}
		});
		btnModificar.setForeground(new Color(220, 20, 60));
		btnModificar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnModificar.setBounds(21, 612, 141, 33);
		contentPane.add(btnModificar);

		JLabel lblRealizarOperacionesCon = new JLabel(
				"Realizar operaciones con los empleados. Utilizar el selector para eliminar o modificar un empleado.");
		lblRealizarOperacionesCon.setForeground(Color.WHITE);
		lblRealizarOperacionesCon.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblRealizarOperacionesCon.setBounds(31, 68, 942, 41);
		contentPane.add(lblRealizarOperacionesCon);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(21, 110, 952, 12);
		contentPane.add(separator_1_1);

		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBackground(new Color(255, 255, 255));
		btnLimpiar.setBorder(null);
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setForeground(new Color(100, 149, 237));
		btnLimpiar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnLimpiar.setBounds(665, 612, 141, 33);
		contentPane.add(btnLimpiar);

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
		btnAtrs.setBounds(858, 611, 115, 35);
		contentPane.add(btnAtrs);

		tfDireccion = new JTextField();
		tfDireccion.setToolTipText("Fecha de Entrada");
		tfDireccion.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(582, 212, 303, 31);
		contentPane.add(tfDireccion);

		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDireccin.setBounds(475, 207, 82, 41);
		contentPane.add(lblDireccin);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblCiudad.setBounds(475, 262, 82, 41);
		contentPane.add(lblCiudad);

		tfCiudad = new JTextField();
		tfCiudad.setToolTipText("Fecha de Entrada");
		tfCiudad.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfCiudad.setColumns(10);
		tfCiudad.setBounds(582, 267, 303, 31);
		contentPane.add(tfCiudad);

		JLabel lblId = new JLabel("Identificador");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblId.setBounds(21, 156, 115, 41);
		contentPane.add(lblId);

		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfId.setColumns(10);
		tfId.setBounds(146, 160, 234, 33);
		contentPane.add(tfId);

		JLabel lblSeleccionaUnEmpleado = new JLabel(
				"Selecciona un empleado para modificar sus datos o eliminarlo.\r\n");
		lblSeleccionaUnEmpleado.setForeground(Color.WHITE);
		lblSeleccionaUnEmpleado.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblSeleccionaUnEmpleado.setBounds(21, 513, 493, 41);
		contentPane.add(lblSeleccionaUnEmpleado);
		for (int i = 0; i < empleados.size(); i++) {
			combo_buscar.addItem(empleados.get(i).getNombre() + " " + empleados.get(i).getApellido());
		}
		combo_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pos = combo_buscar.getSelectedIndex();
				emp_dto = empleados.get(pos);
				for (int i = 0; i < puestos.size(); i++) {
					if (puestos.get(i).getId_tipo() == empleados.get(combo_buscar.getSelectedIndex())
							.getId_tipo_empleado()) {
						combo.setSelectedIndex(i);
					}
				}
				tfId.setText("" + emp_dto.getId_empleado());
				tfNombre.setText(emp_dto.getNombre());
				tfApellido.setText(emp_dto.getApellido());
				tfDNI.setText(emp_dto.getDni());
				tfSueldo.setText("" + emp_dto.getSueldo());
				tfDireccion.setText(emp_dto.getDireccion());
				tfCiudad.setText(emp_dto.getDireccion());
				tfEntrada.setText("" + emp_dto.getFecha_entrada());
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
	}

	public void limpiar() {
		combo.setSelectedIndex(0);
		tfId.setText("");
		tfNombre.setText("");
		tfApellido.setText("");
		tfSueldo.setText("");
		tfEntrada.setText("");
		tfDNI.setText("");
		tfDireccion.setText("");
		tfCiudad.setText("");
	}
}
