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
import javax.swing.table.JTableHeader;

import Connection_DB.Connection_SGL;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

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
	private JTextField tfId;

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
		setUndecorated(true);
		empleados = empDAO.listarTodos();
		jornada = jornadaDAO.listarTodos();
		//
		for (Empleado_DTO empleado : empleados) {
			nombresEmpleados.add(empleado.getNombre());
		}
		//
		setBounds(100, 100, 920, 584);
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
		scrollPane.setBounds(62, 96, 752, 237);
		contentPanel.add(scrollPane);
		// ************************************************
		// TABLA
		table = new JTable(dtm);
		table.setModel(dtm);
		dtm.addColumn("Nombre");
		dtm.addColumn("Hora Entrada");
		dtm.addColumn("Hora Salida");
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
		JComboBox combo_nom = new JComboBox();
		combo_nom.setBounds(438, 362, 211, 29);
		for (int i = 1; i < empleados.size(); i++) {
			combo_nom.addItem(empleados.get(i).getNombre());
		}
		contentPanel.add(combo_nom);

		combo_nom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pos = combo_nom.getSelectedIndex();
				try {
					Empleado_DTO empDTO = empleados.get(pos);
					jornada = jornadaDAO.listarPorNombre(empDTO);
					llenarTabla();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
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
		lblSeleccionaUnEmpleado.setBounds(62, 354, 388, 41);
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
		btnAtrs.setBounds(371, 524, 115, 38);
		contentPanel.add(btnAtrs);

		JButton btnInformeGeneral = new JButton("Informe General");
		btnInformeGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JasperPrint jasperPrint = null;
		        // Genera un PDF que se guarda en la carpeta del proyecto JasperPrint
		        try {
		            jasperPrint = JasperFillManager.fillReport("src\\View_model\\InformeGeneral.jasper", null,
		                    Connection_SGL.getInstancia().getCon());
		        } catch (JRException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
		        JRPdfExporter exp = new JRPdfExporter();
		        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("InformeGeneralPDF.pdf"));
		        JOptionPane.showMessageDialog(null, "Informe generado y almacenado", "PDF Guardado", JOptionPane.PLAIN_MESSAGE);
		        try {
		            exp.exportReport();
		        } catch (

		        JRException e1) {
		        }*/
			}
		});
		btnInformeGeneral.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnInformeGeneral.setBorder(null);
		btnInformeGeneral.setBackground(new Color(251, 249, 255));
		btnInformeGeneral.setBounds(62, 405, 220, 41);
		contentPanel.add(btnInformeGeneral);

		JButton btnInformePorEmpleado = new JButton("Informe RRHH");
		btnInformePorEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JasperPrint jasperPrint = null;
		        // Genera un PDF que se guarda en la carpeta del proyecto JasperPrint
		        try {
		            jasperPrint = JasperFillManager.fillReport("src\\View_model\\InformeRRHH.jasper", null,
		                    Connection_SGL.getInstancia().getCon());
		        } catch (JRException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
		        JRPdfExporter exp = new JRPdfExporter();
		        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("InformeRRHHPDF.pdf"));
		        JOptionPane.showMessageDialog(null, "Informe generado y almacenado", "PDF Guardado", JOptionPane.PLAIN_MESSAGE);
		        try {
		            exp.exportReport();
		        } catch (

		        JRException e1) {
		        }*/
			}
		});
		btnInformePorEmpleado.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnInformePorEmpleado.setBorder(null);
		btnInformePorEmpleado.setBackground(new Color(251, 249, 255));
		btnInformePorEmpleado.setBounds(62, 451, 219, 41);
		contentPanel.add(btnInformePorEmpleado);
		
		JButton btnMostrar = new JButton("Mostrar Todo");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				combo_nom.setSelectedIndex(0);
				jornada.clear();
				jornada = jornadaDAO.listarTodos();
				llenarTabla();
			}
		});
		btnMostrar.setForeground(new Color(220, 20, 60));
		btnMostrar.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnMostrar.setBorder(null);
		btnMostrar.setBackground(new Color(251, 249, 255));
		btnMostrar.setBounds(680, 362, 134, 29);
		contentPanel.add(btnMostrar);
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(30, 502, 880, 12);
		contentPanel.add(separator_1_1_1_1);
		
		JButton btnInformeJornadaLaboral = new JButton("Informe Jornada Laboral");
		btnInformeJornadaLaboral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*JasperPrint jasperPrint = null;
		        Map <String, Object> parametros = new HashMap(); parametros.put ("Parameter1", Integer.valueOf(tfId.getText()));
		        try {
		            jasperPrint = JasperFillManager.fillReport("src\\View_model\\InformeJornada.jasper", null,
		                    Connection_SGL.getInstancia().getCon());
		        } catch (JRException e1) {
		            // TODO Auto-generated catch block
		            e1.printStackTrace();
		        }
		        JRPdfExporter exp = new JRPdfExporter();
		        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("InformeJornada.pdf"));
		        JOptionPane.showMessageDialog(null, "Informe generado y almacenado", "PDF Guardado", JOptionPane.PLAIN_MESSAGE);
		        try {
		            exp.exportReport();
		        } catch (

		        JRException e1) {
		        }*/
			}
		});
		btnInformeJornadaLaboral.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnInformeJornadaLaboral.setBorder(null);
		btnInformeJornadaLaboral.setBackground(new Color(251, 249, 255));
		btnInformeJornadaLaboral.setBounds(582, 451, 232, 41);
		contentPanel.add(btnInformeJornadaLaboral);
		
		tfId = new JTextField();
		tfId.setBounds(337, 451, 211, 41);
		contentPanel.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblIdDeEmpleado = new JLabel("Introduce ID de Empleado para generar Informe:\r\n");
		lblIdDeEmpleado.setForeground(Color.WHITE);
		lblIdDeEmpleado.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblIdDeEmpleado.setBounds(337, 401, 388, 41);
		contentPanel.add(lblIdDeEmpleado);

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
