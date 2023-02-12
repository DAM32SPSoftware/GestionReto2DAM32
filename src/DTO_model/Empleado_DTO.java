package DTO_model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Empleado_DTO {
	private int id_empleado;
	private int id_tipo_empleado;
	private String nombre;
	private String apellido;
	private Double sueldo;
	private String dni;
	private String direccion;
	private String ciudad;
	private Date fecha_entrada;
	
	public Empleado_DTO() {
		super();
	}
	/**
	 * 
	 * @param id_empleado
	 * @param id_tipo_empleado
	 * @param nombre
	 * @param apellido
	 * @param sueldo
	 * @param dni
	 * @param fecha_entrada
	 * @param direccion
	 * @param ciudad
	 */
	public Empleado_DTO(int id_empleado, int id_tipo_empleado, String nombre, String apellido, 
			Double sueldo, String dni, Date fecha_entrada, String direccion, String ciudad) {
		this.id_empleado = id_empleado;
		this.id_tipo_empleado = id_tipo_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.dni = dni;
		this.fecha_entrada = fecha_entrada;
		this.direccion = direccion;
		this.ciudad = ciudad;
		
	}
	/**
	 * 
	 * @param id_tipo_empleado
	 * @param nombre
	 * @param apellido
	 * @param sueldo
	 * @param dni
	 * @param fecha_entrada
	 * @param direccion
	 * @param ciudad
	 * @param genero
	 */
	public Empleado_DTO(int id_tipo_empleado, String nombre, String apellido, 
			Double sueldo, String dni, String direccion, String ciudad, Date fecha_entrada) {
		this.id_tipo_empleado = id_tipo_empleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldo = sueldo;
		this.dni = dni;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.fecha_entrada = fecha_entrada;
	}
	//Getter Setter
	/**
	 * 
	 * @return id_empleado
	 */
	public int getId_empleado() {return id_empleado;}
	/**
	 * 
	 * @param id_empleado
	 */
	public void setId_empleado(int id_empleado) {this.id_empleado = id_empleado;}
	/**
	 * 
	 * @return id_tipo_empleado
	 */
	public int getId_tipo_empleado() {return id_tipo_empleado;}
	/**
	 * 
	 * @param id_tipo_empleado
	 */
	public void setId_tipo_empleado(int id_tipo_empleado) {this.id_tipo_empleado = id_tipo_empleado;}
	/**
	 *  
	 * @return nombre
	 */
	public String getNombre() {return nombre;}
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {this.nombre = nombre;}
	/**
	 * 
	 * @return apellido
	 */
	public String getApellido() {return apellido;}
	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {this.apellido = apellido;}
	/**
	 * 
	 * @return sueldo
	 */
	public Double getSueldo() {return sueldo;}
	/**
	 * 
	 * @param sueldo
	 */
	public void setSueldo(Double sueldo) {this.sueldo = sueldo;}
	/**
	 * 
	 * @return dni
	 */
	public String getDni() {return dni;}
	/**
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {this.dni = dni;}
	/**
	 * 
	 * @return fecha_entrada
	 */
	public Date getFecha_entrada() {return fecha_entrada;}
	/**
	 * 
	 * @param fecha_entrada
	 */
	public void setFecha_entrada(Date fecha_entrada) {this.fecha_entrada = fecha_entrada;}
	/**
	 * 
	 * @return direccion
	 */
	public String getDireccion() {return direccion;}
	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {this.direccion = direccion;}
	/**
	 * 
	 * @return ciudad
	 */
	public String getCiudad() {return ciudad;}
	/**
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {this.ciudad = ciudad;}
	/**
	 * Equals & hashCode
	 */
	@Override
	public int hashCode() {
		return Objects.hash(apellido, ciudad, direccion, dni, fecha_entrada, id_empleado, id_tipo_empleado, nombre,
				sueldo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado_DTO other = (Empleado_DTO) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(dni, other.dni)
				&& Objects.equals(fecha_entrada, other.fecha_entrada) && id_empleado == other.id_empleado
				&& id_tipo_empleado == other.id_tipo_empleado && Objects.equals(nombre, other.nombre)
				&& Objects.equals(sueldo, other.sueldo);
	}
	@Override
	public String toString() {
		return "Empleado_DTO [id_empleado=" + id_empleado + ", id_tipo_empleado=" + id_tipo_empleado + ", nombre="
				+ nombre + ", apellido=" + apellido + ", sueldo=" + sueldo + ", dni=" + dni + ", direccion=" + direccion
				+ ", ciudad=" + ciudad + ", fecha_entrada=" + fecha_entrada + "]";
	}
	
	
}
