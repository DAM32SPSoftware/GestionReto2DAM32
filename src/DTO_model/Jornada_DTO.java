package DTO_model;

import java.sql.Timestamp;
import java.util.Objects;

public class Jornada_DTO {
	private int id_jornada;
	private Timestamp hora_entrada;
	private Timestamp hora_salida;
	private int id_empleado;
	
	public Jornada_DTO() {
		super();
	}
	/**
	 * 
	 * @param id_jornada
	 * @param hora_entrada
	 * @param hora_salida
	 * @param id_empleado
	 */
	public Jornada_DTO(int id_jornada, Timestamp hora_entrada, Timestamp hora_salida, int id_empleado) {
		this.id_jornada =id_jornada;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.id_empleado = id_empleado;
	}
	//Getter y setTer
	/**
	 * 
	 * @return id_jornada
	 */
	public int getId_jornada() {return id_jornada;}
	/**
	 * 
	 * @param id_jornada
	 */
	public void setId_jornada(int id_jornada) {this.id_jornada = id_jornada;}
	/**
	 * 
	 * @return hora_entrada
	 */
	public Timestamp getHora_entrada() {return hora_entrada;}
	/**
	 * 
	 * @param hora_entrada
	 */
	public void setHora_entrada(Timestamp hora_entrada) {this.hora_entrada = hora_entrada;}
	/**
	 * 
	 * @return hora_salida
	 */
	public Timestamp getHora_salida() {return hora_salida;}
	/**
	 * 
	 * @param hora_salida
	 */
	public void setHora_salida(Timestamp hora_salida) {this.hora_salida = hora_salida;}
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
	//Equals y HashCode
	@Override
	public int hashCode() {
		return Objects.hash(hora_entrada, hora_salida, id_empleado, id_jornada);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jornada_DTO other = (Jornada_DTO) obj;
		return Objects.equals(hora_entrada, other.hora_entrada) && Objects.equals(hora_salida, other.hora_salida)
				&& id_empleado == other.id_empleado && id_jornada == other.id_jornada;
	}
	//ToString
	@Override
	public String toString() {
		return "Jornada_DTO [id_jornada=" + id_jornada + ", hora_entrada=" + hora_entrada + ", hora_salida="
				+ hora_salida + ", id_empleado=" + id_empleado + "]";
	}
	
}
