package DTO_model;

import java.util.Objects;

public class Tipo_empleado_DTO {
	public int id_empleado;
	public String nombre_tipo;
	//
	public Tipo_empleado_DTO() {
		super();
	}
	/**
	 * 
	 * @param id_empleado
	 * @param nombre_tipo
	 */
	public Tipo_empleado_DTO(int id_empleado, String nombre_tipo) {
		this.id_empleado = id_empleado;
		this.nombre_tipo = nombre_tipo;
	}
	//GETTERS SETTER
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
	 * @return nombre_tipo
	 */
	public String getNombre_tipo() {return nombre_tipo;}
	/**
	 * 
	 * @param nombre_tipo
	 */
	public void setNombre_tipo(String nombre_tipo) {this.nombre_tipo = nombre_tipo;}
	
	//EQUALS HASH CODE
	@Override
	public int hashCode() {
		return Objects.hash(id_empleado, nombre_tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo_empleado_DTO other = (Tipo_empleado_DTO) obj;
		return id_empleado == other.id_empleado && Objects.equals(nombre_tipo, other.nombre_tipo);
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Tipo_empleado_DTO [id_empleado=" + id_empleado + ", nombre_tipo=" + nombre_tipo + "]";
	}

}
