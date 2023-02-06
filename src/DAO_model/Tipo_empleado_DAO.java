package DAO_model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection_DB.Connection_SGL;
import DTO_model.Empleado_DTO;
import DTO_model.Tipo_empleado_DTO;

public class Tipo_empleado_DAO implements Patron_DAO<Tipo_empleado_DTO>{
	//CONEXION
	private Connection_SGL conn = Connection_SGL.getInstancia();
	//CRUD
	private static final String SQL_INSERT = "INSERT INTO tipo_empleado (id_tipo, nombre_tipo) VALUES (?, ?)";
	//BUSQUEDAS
	private static final String SQL_FINDALL = "SELECT * FROM tipo_empleado";
	@Override
	public boolean insertar(Tipo_empleado_DTO t) {
		PreparedStatement ps = null;
		try {
			ps = conn.getCon().prepareStatement(SQL_INSERT);
			ps.setInt(1, t.getId_empleado());
            ps.setString(2, t.getNombre_tipo());
            if(ps.executeUpdate()>0) {
            	return true;
            }
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		finally {
            try {
                if (ps!=null) ps.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		return false;
	}
	@Override
	public boolean borrar(Object pk) {
		// TODO Auto-generated method stub
				return false;
	}
	@Override
	public boolean actualizar(Tipo_empleado_DTO t) {
		// TODO Auto-generated method stub
				return false;
	}
	@Override
	public Tipo_empleado_DTO buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Tipo_empleado_DTO> listarTodos(){
		PreparedStatement ps = null;
        ArrayList<Tipo_empleado_DTO> TodosPuestos = new ArrayList<Tipo_empleado_DTO>();
        
        try {
            ps = conn.getCon().prepareStatement (SQL_FINDALL);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()==true) {
            	Tipo_empleado_DTO _puesto = new Tipo_empleado_DTO(rs.getInt(1),rs.getString(2)); 
            	TodosPuestos.add(_puesto);
            }
            rs.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(ps != null) ps.close();
            }catch(Exception e){    
            }
        }
        return TodosPuestos;
	}	
}
