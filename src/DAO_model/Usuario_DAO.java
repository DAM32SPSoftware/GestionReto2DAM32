package DAO_model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Connection_DB.Connection_SGL;
import DTO_model.Empleado_DTO;
import DTO_model.Jornada_DTO;
import DTO_model.Usuario_DTO;

public class Usuario_DAO implements Patron_DAO<Usuario_DTO> {
	// CONEXION
	private Connection_SGL conn = Connection_SGL.getInstancia();
	// CRUD
	private static final String SQL_UPDATE = "UPDATE login_empleado SET usuario = ?, password = ?, cod_autenticar =?  WHERE id_empleado = ?";
	private static final String SQL_UPDATEUSU = "UPDATE login_empleado SET usuario = ?, password = ? WHERE id_empleado = ?";
	// BUSQUEDAS
	private static final String SQL_FINDALL = "SELECT * FROM login_empleado";
	private static final String SQL_EMPLEBYNOM = "SELECT * FROM login_empleado WHERE id_empleado = ? ";
	private static final String SQL_GETDATA = "SELECT usuario, password FROM login_empleado WHERE id_empleado = ?";
	private static final String SQL_VALIDARCOD = "SELECT usuario, password FROM login_empleado WHERE cod_autenticar = ?";

	@Override
	public boolean insertar(Usuario_DTO t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(Object pk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Usuario_DTO t) {
		PreparedStatement ps = null;

		try {
			ps = conn.getCon().prepareStatement(SQL_UPDATE);
			ps.setString(1, t.getUsuario());
			ps.setString(2, t.getPassword());
			ps.setInt(3, t.getId_empleado());

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
	public Usuario_DTO buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario_DTO> listarTodos() {
		PreparedStatement ps = null;
		ArrayList<Usuario_DTO> TodosLogin = new ArrayList<Usuario_DTO>();

		try {
			ps = conn.getCon().prepareStatement(SQL_FINDALL);

			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Usuario_DTO _log = new Usuario_DTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				TodosLogin.add(_log);
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
		return TodosLogin;
	}

	public ArrayList<Usuario_DTO> listarPorNombre(Empleado_DTO id) {
		PreparedStatement ps = null;
		ArrayList<Usuario_DTO> TodosLogin = new ArrayList<Usuario_DTO>();

		try {
			ps = conn.getCon().prepareStatement(SQL_EMPLEBYNOM);
			ps.setInt(1, id.getId_empleado());
			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Usuario_DTO _log = new Usuario_DTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				TodosLogin.add(_log);
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
		return TodosLogin;
	}

	public boolean verificarCodigo(int cod_aut) {
		PreparedStatement ps = null;
		boolean codigoCorrecto = false;
		try {
			ps = conn.getCon().prepareStatement(SQL_VALIDARCOD);
			ps.setInt(1, cod_aut);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				codigoCorrecto = true;
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
		return codigoCorrecto;
	}

	public boolean actualizarUsuario(Usuario_DTO nuevo, int id) {
		PreparedStatement ps = null;

		try {
			ps = conn.getCon().prepareStatement(SQL_UPDATEUSU);
			ps.setString(1, nuevo.getUsuario());
			ps.setString(2, nuevo.getPassword());
			ps.setInt(3, id);

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

	public ArrayList<Usuario_DTO> buscarUsuariosFiltro(String nombre) {
		PreparedStatement ps = null;
		ArrayList<Usuario_DTO> usuariosFiltrados = new ArrayList<Usuario_DTO>();
		String SQL_EMPLEBYNOM = "SELECT * FROM login_empleado, empleados WHERE empleados.id_empleado = login_empleado.id_empleado AND empleados.nombre LIKE ?";
		try {
			ps = conn.getCon().prepareStatement(SQL_EMPLEBYNOM);
			ps.setString(1, nombre + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Usuario_DTO _log = new Usuario_DTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				usuariosFiltrados.add(_log);
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
		return usuariosFiltrados;
	}

}
