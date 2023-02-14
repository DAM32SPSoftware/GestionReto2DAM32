package View_model;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO_model.Usuario_DAO;
import DTO_model.Usuario_DTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class Autenticar extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfPass;
	private JTextField tfCodigo;
	//
	public static Usuario_DAO usuDAO = new Usuario_DAO();
	static ArrayList<Usuario_DTO> usuarios;
	private Usuario_DTO usuDTO;
	/**
	 * Create the frame.
	 */
	public Autenticar(Usuario_DTO _usuDTO) {
		setUndecorated(true);
		this.usuDTO = _usuDTO;
		usuDAO = new Usuario_DAO();
		//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(177, 16, 48));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//
		setResizable(false);
		setLocationRelativeTo(null);
		//
		JLabel lblIntroduzcaElCodigo = new JLabel("Introduzca el codigo de autentificación para");
		lblIntroduzcaElCodigo.setForeground(Color.WHITE);
		lblIntroduzcaElCodigo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblIntroduzcaElCodigo.setBounds(109, 10, 422, 41);
		contentPane.add(lblIntroduzcaElCodigo);

		JLabel lblPoderCambiarUsuario = new JLabel("poder cambiar usuario o contraseña.");
		lblPoderCambiarUsuario.setForeground(Color.WHITE);
		lblPoderCambiarUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPoderCambiarUsuario.setBounds(109, 40, 391, 41);
		contentPane.add(lblPoderCambiarUsuario);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 173, 486, 2);
		contentPane.add(separator_1_1_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("resources/advertencia.png"));
		lblNewLabel_1.setBounds(27, 21, 72, 71);
		contentPane.add(lblNewLabel_1);

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(166, 214, 267, 33);
		contentPane.add(tfUsuario);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNombre.setBounds(74, 210, 82, 41);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblApellido.setBounds(74, 265, 82, 41);
		contentPane.add(lblApellido);

		tfPass = new JTextField();
		tfPass.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfPass.setColumns(10);
		tfPass.setBounds(166, 269, 267, 33);
		contentPane.add(tfPass);

		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(109, 108, 162, 33);
		contentPane.add(tfCodigo);
		//
		tfUsuario.setEditable(false);
		tfPass.setEditable(false);
		//
		tfUsuario.setText(usuDTO.getUsuario());
		tfPass.setText(usuDTO.getPassword());
		//
		JButton btnOk = new JButton("VALIDAR");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoIngresado = tfCodigo.getText();
				int codigo = Integer.parseInt(codigoIngresado);
				if (usuDAO.verificarCodigo(codigo)) {
					tfUsuario.setEditable(true);
					tfPass.setEditable(true);
					JOptionPane.showMessageDialog(Autenticar.this, "Correcto. Puede modificar usuario o contraseña.", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(Autenticar.this, "Codigo de autentificación INCORRECTO.", "Advertencia",
							JOptionPane.INFORMATION_MESSAGE);
					//
					tfUsuario.setEditable(false);
					tfPass.setEditable(false);
					tfCodigo.setText("");
					//
				}
			}
		});
		btnOk.setForeground(new Color(220, 20, 60));
		btnOk.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setBounds(313, 106, 120, 35);
		contentPane.add(btnOk);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n_usuario = tfUsuario.getText();
				String n_pass = tfPass.getText();
				try {
					Usuario_DTO _usu = new Usuario_DTO(n_usuario, n_pass);
					usuDAO.actualizarUsuario(_usu, usuDTO.getId_empleado());
					//
					tfUsuario.setEditable(false);
					tfPass.setEditable(false);
					tfCodigo.setText("");
					//
					JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al actualizar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setForeground(new Color(220, 20, 60));
		btnGuardar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setBounds(166, 326, 120, 35);
		contentPane.add(btnGuardar);
		
		JButton btnAtrs = new JButton("ATRÁS");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnAtrs.setForeground(Color.WHITE);
		btnAtrs.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnAtrs.setBorder(null);
		btnAtrs.setBackground(new Color(0, 0, 0));
		btnAtrs.setBounds(318, 323, 115, 38);
		contentPane.add(btnAtrs);
	}
}
