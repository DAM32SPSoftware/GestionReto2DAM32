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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Operaciones_generales extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfSueldo;
	private JTextField tfEntrada;
	private JTextField tfDNI;
	private JTextField textField_5;
	//
	public static Empleado_DAO empDAO = new Empleado_DAO();
	public static Tipo_empleado_DAO puestoDAO = new Tipo_empleado_DAO();
	static ArrayList<Tipo_empleado_DTO> puestos;
	private JTextField tfDireccion;
	private JTextField tfCiudad;
	private JTextField tfId;
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
		puestos = puestoDAO.listarTodos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 153, 148));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNombre.setBounds(31, 383, 82, 41);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfNombre.setColumns(10);
		tfNombre.setBounds(123, 387, 267, 33);
		contentPane.add(tfNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblApellido.setBounds(31, 438, 82, 41);
		contentPane.add(lblApellido);
		
		tfApellido = new JTextField();
		tfApellido.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfApellido.setColumns(10);
		tfApellido.setBounds(123, 442, 267, 33);
		contentPane.add(tfApellido);
		
		JLabel lblEmail = new JLabel("Sueldo");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEmail.setBounds(478, 332, 82, 41);
		contentPane.add(lblEmail);
		
		tfSueldo = new JTextField();
		tfSueldo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfSueldo.setColumns(10);
		tfSueldo.setBounds(585, 336, 303, 33);
		contentPane.add(tfSueldo);
		
		JLabel lblActivo = new JLabel("Tipo de Empleado");
		lblActivo.setForeground(Color.WHITE);
		lblActivo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblActivo.setBounds(31, 267, 150, 41);
		contentPane.add(lblActivo);
		
		JLabel lblFecha = new JLabel("Fecha Entrada");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFecha.setBounds(478, 496, 125, 41);
		contentPane.add(lblFecha);
		
		tfEntrada = new JTextField();
		tfEntrada.setToolTipText("Fecha de Entrada");
		tfEntrada.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfEntrada.setColumns(10);
		tfEntrada.setBounds(628, 501, 260, 31);
		contentPane.add(tfEntrada);
		
		JLabel lblltimaActualizacin = new JLabel("DNI");
		lblltimaActualizacin.setForeground(Color.WHITE);
		lblltimaActualizacin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblltimaActualizacin.setBounds(31, 496, 46, 41);
		contentPane.add(lblltimaActualizacin);
		
		tfDNI = new JTextField();
		tfDNI.setToolTipText("Fecha de Entrada");
		tfDNI.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfDNI.setColumns(10);
		tfDNI.setBounds(123, 501, 267, 31);
		contentPane.add(tfDNI);
		
		JLabel lblAquPuedesRealizar = new JLabel("TRAMITAR EMPLEADOS");
		lblAquPuedesRealizar.setForeground(Color.WHITE);
		lblAquPuedesRealizar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblAquPuedesRealizar.setBounds(21, 27, 952, 41);
		contentPane.add(lblAquPuedesRealizar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 68, 952, 12);
		contentPane.add(separator_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(21, 151, 369, 33);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setBounds(434, 150, 141, 33);
		contentPane.add(btnNewButton);
		
		JComboBox combo = new JComboBox();
		combo.setBounds(31, 318, 359, 29);
		for (int i = 0; i < puestos.size(); i++) {
			combo.addItem(puestos.get(i).getId_empleado() + " - "+ puestos.get(i).getNombre_tipo());
        }
		contentPane.add(combo);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setForeground(new Color(0, 128, 0));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String id = tfId.getText();
				//Integer num_id = Integer.parseInt(id);
				int tipo = puestos.get(combo.getSelectedIndex()).getId_empleado();
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
					Empleado_DTO _emp = new Empleado_DTO(tipo, nombre, apellido, num_sueldo, dni, direccion, ciudad, fecha);
					empDAO.insertar(_emp);
					JOptionPane.showMessageDialog(null, "Empleado AGREGADO con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Operación calcelada.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAgregar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnAgregar.setBounds(47, 612, 141, 33);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(new Color(255, 69, 0));
		btnEliminar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnEliminar.setBounds(462, 612, 141, 33);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setForeground(new Color(220, 20, 60));
		btnModificar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnModificar.setBounds(254, 612, 141, 33);
		contentPane.add(btnModificar);
		
		JLabel lblRealizarOperacionesCon = new JLabel("Realizar operaciones con los empleados. Utilizar 'buscar' para eliminar o modificar un empleado introduciendo su nombre.");
		lblRealizarOperacionesCon.setForeground(Color.WHITE);
		lblRealizarOperacionesCon.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblRealizarOperacionesCon.setBounds(31, 68, 942, 41);
		contentPane.add(lblRealizarOperacionesCon);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(21, 110, 952, 12);
		contentPane.add(separator_1_1);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(4, 15, 15));
		lblNewLabel.setIcon(new ImageIcon("resources/id.png"));
		lblNewLabel.setBounds(585, 182, 303, 132);
		contentPane.add(lblNewLabel);
		
		tfDireccion = new JTextField();
		tfDireccion.setToolTipText("Fecha de Entrada");
		tfDireccion.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(585, 388, 303, 31);
		contentPane.add(tfDireccion);
		
		JLabel lblDireccin = new JLabel("Dirección");
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblDireccin.setBounds(478, 383, 82, 41);
		contentPane.add(lblDireccin);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblCiudad.setBounds(478, 438, 82, 41);
		contentPane.add(lblCiudad);
		
		tfCiudad = new JTextField();
		tfCiudad.setToolTipText("Fecha de Entrada");
		tfCiudad.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfCiudad.setColumns(10);
		tfCiudad.setBounds(585, 443, 303, 31);
		contentPane.add(tfCiudad);
		
		JLabel lblId = new JLabel("Identificador");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblId.setBounds(31, 216, 115, 41);
		contentPane.add(lblId);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfId.setColumns(10);
		tfId.setBounds(156, 220, 234, 33);
		contentPane.add(tfId);
		
		
	}
}
