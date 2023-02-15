package DAO_model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection_DB.Connection_SGL;
import DTO_model.Empleado_DTO;
import DTO_model.Tipo_empleado_DTO;

public class Empleado_DAO implements Patron_DAO<Empleado_DTO> {
	// CONEXION
	private Connection_SGL conn = Connection_SGL.getInstancia();
	// CRUD
	private static final String SQL_INSERT = "INSERT INTO empleados (id_tipo_empleado, nombre, apellido, sueldo, dni, direccion, ciudad, fecha_entrada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM empleados WHERE `id_empleado` =?";
	private static final String SQL_UPDATE = "UPDATE `empleados` SET `id_tipo_empleado` = ?, `nombre` = ?, `apellido` = ?, `sueldo` = ?, `dni` = ?, `fecha_entrada` = ?, `direccion` = ?, `ciudad` = ? WHERE `id_empleado` = ?";
	// BUSQUEDAS
	private static final String SQL_FINDALL = "SELECT * FROM empleados";
	private static final String SQL_FIND = "SELECT * FROM empleados WHERE nombre = ?";
	private static final String SQL_EMPLEBYTIPO = "SELECT * FROM empleados WHERE id_tipo_empleado = ? ";
	private static final String SQL_FINDBYNAME = "SELECT * FROM empleados WHERE nombre = ? ";
	// private static final String SQL_FINDBYFILTRO = "SELECT * FROM empleados where
	// Nombre like ? AND Apellido like ? AND Sueldo like ? AND DNI like ? AND
	// Gerente = ? AND FechaEntrada like ?";
	private static final String SQL_FINDLAST = "SELECT MAX(idEmpleado) FROM empleados;";
 
	@Override
	public boolean insertar(Empleado_DTO t) {
		PreparedStatement ps = null;
		try {
			ps = conn.getCon().prepareStatement(SQL_INSERT);
			// ps.setInt(1, t.getId_empleado());
			ps.setInt(1, t.getId_tipo_empleado());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellido());
			ps.setDouble(4, t.getSueldo());
			ps.setString(5, t.getDni());
			ps.setString(6, t.getDireccion());
			ps.setString(7, t.getCiudad());
			ps.setDate(8, t.getFecha_entrada());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean borrar(Object pk) {
		PreparedStatement ps = null;
		try {
			ps = conn.getCon().prepareStatement(SQL_DELETE);
			ps.setInt(1, (int) pk);
			int filas = ps.executeUpdate();

			if (filas > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean actualizar(Empleado_DTO t) {
		PreparedStatement ps = null;

		try {
			ps = conn.getCon().prepareStatement(SQL_UPDATE);
			ps.setInt(1, t.getId_tipo_empleado());
			ps.setString(2, t.getNombre());
			ps.setString(3, t.getApellido());
			ps.setDouble(4, t.getSueldo());
			ps.setString(5, t.getDni());
			ps.setDate(6, t.getFecha_entrada());
			ps.setString(7, t.getDireccion());
			ps.setString(8, t.getCiudad());
			ps.setInt(9, t.getId_empleado());

			if (ps.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Empleado_DTO buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Empleado_DTO> listarTodos() {
		PreparedStatement ps = null;
		ArrayList<Empleado_DTO> TodosEmpleados = new ArrayList<Empleado_DTO>();

		try {
			ps = conn.getCon().prepareStatement(SQL_FINDALL);

			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Empleado_DTO _emp = new Empleado_DTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9));
				TodosEmpleados.add(_emp);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
		}
		return TodosEmpleados;
	}

	public ArrayList<Empleado_DTO> listarPorTipo(Tipo_empleado_DTO tipo) {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;
		ArrayList<Empleado_DTO> TodosEmpleados = new ArrayList<Empleado_DTO>();

		try {
			ps = conn.getCon().prepareStatement(SQL_EMPLEBYTIPO);
			ps.setInt(1, tipo.getId_tipo());

			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Empleado_DTO _emp = new Empleado_DTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9));
				TodosEmpleados.add(_emp);
			}

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
		}
		return TodosEmpleados;
	}

	public ArrayList<Empleado_DTO> listarEmpAsc(String col) {
		PreparedStatement ps = null;
		ArrayList<Empleado_DTO> EmpleadosAsc = new ArrayList<Empleado_DTO>();
		String SQL_DATOSASC = "SELECT * FROM empleados ORDER BY " + col + " ASC";
		try {
			ps = conn.getCon().prepareStatement(SQL_DATOSASC);

			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Empleado_DTO _emp = new Empleado_DTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9));
				EmpleadosAsc.add(_emp);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
		}
		return EmpleadosAsc;
	}
	
	public ArrayList<Empleado_DTO> listarEmpDesc(String col) {
		PreparedStatement ps = null;
		ArrayList<Empleado_DTO> EmpleadosAsc = new ArrayList<Empleado_DTO>();
		String SQL_DATOSASC = "SELECT * FROM empleados ORDER BY " + col + " DESC";
		try {
			ps = conn.getCon().prepareStatement(SQL_DATOSASC);

			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Empleado_DTO _emp = new Empleado_DTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9));
				EmpleadosAsc.add(_emp);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
		}
		return EmpleadosAsc;
	}
	
	public ArrayList<Empleado_DTO> listarPorNombre(Empleado_DTO nom) {
		// TODO Auto-generated method stub

		PreparedStatement ps = null;
		ArrayList<Empleado_DTO> TodosEmpleados = new ArrayList<Empleado_DTO>();

		try {
			ps = conn.getCon().prepareStatement(SQL_FINDBYNAME);
			ps.setString(1, nom.getNombre());

			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Empleado_DTO _emp = new Empleado_DTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9));
				TodosEmpleados.add(_emp);
			}

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
		}
		return TodosEmpleados;
	}
}
