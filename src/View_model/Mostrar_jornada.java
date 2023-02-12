package View_model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO_model.Empleado_DAO;
import DAO_model.Jornada_DAO;
import DTO_model.Empleado_DTO;
import DTO_model.Jornada_DTO;
import DTO_model.Tipo_empleado_DTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JTable;

public class Mostrar_jornada extends JDialog {

	private final JPanel contentPanel = new JPanel();
	// TABLA
	static DefaultTableModel dtm;
	private JTable table;
	//
	public static Empleado_DAO empDAO = new Empleado_DAO();
	static ArrayList<Empleado_DTO> empleados;
	public static Jornada_DAO jornadaDAO = new Jornada_DAO();
	static ArrayList<Jornada_DTO> jornada;
	static ArrayList<String> nombresEmpleados = new ArrayList<String>();

	//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Mostrar_jornada dialog = new Mostrar_jornada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Mostrar_jornada() {
		empleados = empDAO.listarTodos();
		jornada = jornadaDAO.listarTodos();
		//
		for (Empleado_DTO empleado : empleados) {
			nombresEmpleados.add(empleado.getNombre());
		}
		//
		setBounds(100, 100, 920, 548);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(138, 153, 148));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		scrollPane.setBounds(62, 115, 752, 237);
		contentPanel.add(scrollPane);
		// ************************************************
		// TABLA
		table = new JTable(dtm);
		table.setModel(dtm);
		dtm.addColumn("Nombre");
		dtm.addColumn("Hora Entrada");
		dtm.addColumn("Hora Salida");
		// ************************************************
		scrollPane.setViewportView(table);
		JComboBox combo_nom = new JComboBox();
		combo_nom.setBounds(460, 395, 354, 29);
		for (int i = 1; i < empleados.size(); i++) {
			combo_nom.addItem(empleados.get(i).getNombre());
		}
		contentPanel.add(combo_nom);

		combo_nom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pos = combo_nom.getSelectedIndex();
				Empleado_DTO empDTO = empleados.get(pos);
				jornada = jornadaDAO.listarPorNombre(empDTO);
				llenarTabla();
			}
		});

		JLabel lblHorarioLaboral = new JLabel("HORARIO LABORAL");
		lblHorarioLaboral.setForeground(Color.WHITE);
		lblHorarioLaboral.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblHorarioLaboral.setBounds(23, 23, 535, 41);
		contentPanel.add(lblHorarioLaboral);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 74, 880, 12);
		contentPanel.add(separator_1_1_1);

		JLabel lblSeleccionaUnEmpleado = new JLabel("Selecciona un empleado para mostrar su registro:");
		lblSeleccionaUnEmpleado.setForeground(Color.WHITE);
		lblSeleccionaUnEmpleado.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblSeleccionaUnEmpleado.setBounds(62, 387, 388, 41);
		contentPanel.add(lblSeleccionaUnEmpleado);

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
		btnAtrs.setBounds(699, 466, 115, 35);
		contentPanel.add(btnAtrs);

	}

	// PARA PODER UTILIZAR LA TABLA
	public static void llenarTabla() {
		dtm.getDataVector().removeAllElements();
		if (jornada.size() != 0) {
			for (Jornada_DTO jorDTO : jornada) {
				Object[] fila = new Object[3];
				int id_empleado = jorDTO.getId_empleado();
				// Verifico si el indice esta dentro de los limites
				if (id_empleado >= 0 && id_empleado < nombresEmpleados.size()) {
					// Busco el nombre correspondiente al ID del empleado
					String nombre = nombresEmpleados.get(id_empleado);
					fila[0] = nombre;
				} else {
					fila[0] = "ID de empleado no válido";
				}
				fila[1] = jorDTO.getHora_entrada();
				fila[2] = jorDTO.getHora_salida();
				dtm.addRow(fila);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay datos para mostrar", "Advertencia",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
