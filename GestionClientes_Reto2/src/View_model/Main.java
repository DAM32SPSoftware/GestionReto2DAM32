package View_model;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import javax.swing.border.EtchedBorder;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		//
		Image imgIcon = Toolkit.getDefaultToolkit().getImage("resources/logoapp2.png");
        setIconImage(imgIcon);
		ImageIcon imgLogo = new ImageIcon("resources/logoapp2.png");
		//
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 534, 634);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(138, 153, 148));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//
		setTitle("Gestor de Empleados");
		setResizable(false);
		setLocationRelativeTo(null);
		//
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(4, 15, 15));
		lblNewLabel.setIcon(new ImageIcon("resources/letrero.png"));
		lblNewLabel.setBounds(32, -23, 432, 235);
		contentPane.add(lblNewLabel);
		
		JButton btnEmpleados = new JButton("Listado de Empleados");
		btnEmpleados.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnEmpleados.setBorder(null);
		btnEmpleados.setBackground(new Color(251, 249, 255));
		btnEmpleados.setBounds(137, 247, 231, 41);
		contentPane.add(btnEmpleados);
		
		JLabel lblTeEncuentrasEn = new JLabel("Menú de empleados, escoge una opción:");
		lblTeEncuentrasEn.setForeground(Color.WHITE);
		lblTeEncuentrasEn.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblTeEncuentrasEn.setBounds(89, 173, 330, 41);
		contentPane.add(lblTeEncuentrasEn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 169, 468, 12);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 212, 468, 12);
		contentPane.add(separator_1);
		
		JButton btnOperacionesConEmpleados = new JButton("Operaciones Generales");
		btnOperacionesConEmpleados.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnOperacionesConEmpleados.setBorder(null);
		btnOperacionesConEmpleados.setBackground(new Color(251, 249, 255));
		btnOperacionesConEmpleados.setBounds(137, 315, 231, 41);
		contentPane.add(btnOperacionesConEmpleados);
		
		JButton btnHorarios = new JButton("Horarios");
		btnHorarios.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnHorarios.setBorder(null);
		btnHorarios.setBackground(new Color(251, 249, 255));
		btnHorarios.setBounds(137, 384, 231, 41);
		contentPane.add(btnHorarios);
		
		JButton btnBsquedas = new JButton("Búsquedas");
		btnBsquedas.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnBsquedas.setBorder(null);
		btnBsquedas.setBackground(new Color(251, 249, 255));
		btnBsquedas.setBounds(137, 451, 231, 41);
		contentPane.add(btnBsquedas);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnSalir.setBorder(null);
		btnSalir.setBackground(new Color(220, 20, 60));
		btnSalir.setBounds(184, 540, 140, 35);
		contentPane.add(btnSalir);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(22, 518, 468, 12);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("resources/help2.png"));
		lblNewLabel_1.setBounds(458, 540, 32, 35);
		contentPane.add(lblNewLabel_1);
		//
	}
}
