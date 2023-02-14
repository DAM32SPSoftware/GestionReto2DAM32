package DTO_model;

import java.util.Objects;

public class Usuario_DTO {
	private String usuario;
	private String password;
	private int cod_autenticar;
	private int id_empleado;
	/**
	 * super();
	 */
	public Usuario_DTO() {
		super();
	}

	/**
	 * 
	 * @param usuario
	 * @param password
	 * @param cod_autenticar
	 * @param id_empleado
	 */
	public Usuario_DTO(String usuario, String password, int cod_autenticar, int id_empleado) {
		this.usuario = usuario;
		this.password = password;
		this.cod_autenticar = cod_autenticar;
		this.id_empleado = id_empleado;
	}

	public Usuario_DTO(String n_usuario, String n_pass) {
		this.usuario = n_usuario;
		this.password = n_pass;
	}
	// getter y setter
	/**
	 * 
	 * @return id_empleado
	 */
	public int getId_empleado() {
		return id_empleado;
	}

	/**
	 * 
	 * @param id_empleado
	 */
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	/**
	 * 
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return cod_autenticar
	 */
	public int getCod_autenticar() {
		return cod_autenticar;
	}

	/**
	 * 
	 * @param cod_autenticar
	 */
	public void setCod_autenticar(int cod_autenticar) {
		this.cod_autenticar = cod_autenticar;
	}
	// equals y hashcode
	@Override
	public int hashCode() {
		return Objects.hash(cod_autenticar, id_empleado, password, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario_DTO other = (Usuario_DTO) obj;
		return cod_autenticar == other.cod_autenticar && id_empleado == other.id_empleado && password == other.password
				&& Objects.equals(usuario, other.usuario);
	}

	// ToString
	@Override
	public String toString() {
		return "Usuario_DTO [id_empleado=" + id_empleado + ", usuario=" + usuario + ", password=" + password
				+ ", cod_autenticar=" + cod_autenticar + "]";
	}

}
