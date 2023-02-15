package DAO_model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connection_DB.Connection_SGL;
import DTO_model.Empleado_DTO;
import DTO_model.Jornada_DTO;

public class Jornada_DAO implements Patron_DAO<Jornada_DTO> {
	// CONEXION
	private Connection_SGL conn = Connection_SGL.getInstancia();
	// BUSQUEDAS
	private static final String SQL_FINDALL = "SELECT * FROM jornada";
	private static final String SQL_EMPLEBYNOM = "SELECT * FROM jornada WHERE id_empleado = ? ";
	@Override
	public boolean insertar(Jornada_DTO t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(Object pk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Jornada_DTO t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Jornada_DTO buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Jornada_DTO> listarTodos() {
		PreparedStatement ps = null;
		ArrayList<Jornada_DTO> TodosJornada = new ArrayList<Jornada_DTO>();

		try {
			ps = conn.getCon().prepareStatement(SQL_FINDALL);

			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Jornada_DTO _jor = new Jornada_DTO(rs.getInt(1), rs.getTimestamp(2), rs.getTimestamp(3), rs.getInt(4));
				TodosJornada.add(_jor);
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
		return TodosJornada;
	}
	
	public ArrayList<Jornada_DTO> listarPorNombre(Empleado_DTO id) {
		PreparedStatement ps = null;
		ArrayList<Jornada_DTO> TodosJornada = new ArrayList<Jornada_DTO>();

		try {
			ps = conn.getCon().prepareStatement(SQL_EMPLEBYNOM);
			ps.setInt(1, id.getId_empleado());
			ResultSet rs = ps.executeQuery();
			while (rs.next() == true) {
				Jornada_DTO _jor = new Jornada_DTO(rs.getInt(1), rs.getTimestamp(2), rs.getTimestamp(3), rs.getInt(4));
				TodosJornada.add(_jor);
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
		return TodosJornada;
	}

}
