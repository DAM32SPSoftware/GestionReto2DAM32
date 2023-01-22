package View_model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Operaciones_generales extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 153, 148));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNombre.setBounds(31, 154, 82, 41);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(123, 158, 267, 33);
		contentPane.add(textField);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblApellido.setBounds(31, 214, 82, 41);
		contentPane.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(123, 214, 267, 33);
		contentPane.add(textField_1);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblEmail.setBounds(31, 276, 82, 41);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(123, 276, 267, 33);
		contentPane.add(textField_2);
		
		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setForeground(Color.WHITE);
		lblActivo.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblActivo.setBounds(31, 337, 82, 41);
		contentPane.add(lblActivo);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(123, 349, 21, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblFecha = new JLabel("Fecha Creación");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblFecha.setBounds(31, 388, 125, 41);
		contentPane.add(lblFecha);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Fecha de Entrada");
		textField_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(166, 388, 224, 31);
		contentPane.add(textField_3);
		
		JLabel lblltimaActualizacin = new JLabel("Última Actualización");
		lblltimaActualizacin.setForeground(Color.WHITE);
		lblltimaActualizacin.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblltimaActualizacin.setBounds(31, 439, 171, 41);
		contentPane.add(lblltimaActualizacin);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Fecha de Entrada");
		textField_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(212, 439, 178, 31);
		contentPane.add(textField_4);
		
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
		textField_5.setBounds(491, 154, 316, 33);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setBounds(831, 154, 141, 33);
		contentPane.add(btnNewButton);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnAgregar.setBounds(491, 214, 141, 33);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnEliminar.setBounds(491, 279, 141, 33);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnModificar.setBounds(666, 214, 141, 33);
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
		btnLimpiar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnLimpiar.setBounds(666, 279, 141, 33);
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
		btnAtrs.setBounds(858, 501, 115, 35);
		contentPane.add(btnAtrs);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(4, 15, 15));
		lblNewLabel.setIcon(new ImageIcon("resources/id.png"));
		lblNewLabel.setBounds(491, 328, 316, 142);
		contentPane.add(lblNewLabel);
	}
}
