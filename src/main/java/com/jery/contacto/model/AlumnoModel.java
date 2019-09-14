package com.jery.contacto.model;

// TODO: Auto-generated Javadoc
/**
 * The Class AlumnoModel.
 */
public class AlumnoModel {
	
	/** The id. */
	private int id;
	
	/** The nombre. */
	private String nombre;
	
	/** The apellido oaterno. */
	private String apellidoPaterno;
	
	/** The apeliido materno. */
	private String apellidoMaterno;
	
	/** The edad. */
	private int edad;
	
	/** The correo. */
	private String correo;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the apellido oaterno.
	 *
	 * @return the apellido oaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Sets the apellido oaterno.
	 *
	 * @param apellidoOaterno the new apellido oaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * Gets the apeliido materno.
	 *
	 * @return the apeliido materno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Sets the apeliido materno.
	 *
	 * @param apeliidoMaterno the new apeliido materno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Sets the edad.
	 *
	 * @param edad the new edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Gets the correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Sets the correo.
	 *
	 * @param correo the new correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Instantiates a new alumno model.
	 *
	 * @param id the id
	 * @param nombre the nombre
	 * @param apellidoOaterno the apellido oaterno
	 * @param apeliidoMaterno the apeliido materno
	 * @param edad the edad
	 * @param correo the correo
	 */
	public AlumnoModel(int id, String nombre, String apellidoPaterno, String apellidoMaterno, int edad,
			String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.edad = edad;
		this.correo = correo;
	}
	
/**
 * Instantiates a new alumno model.
 */
public AlumnoModel() {
	// TODO Auto-generated constructor stub
}
}
