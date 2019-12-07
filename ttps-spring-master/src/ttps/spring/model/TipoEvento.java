package ttps.spring.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoEvento implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String nombre;
	

	public TipoEvento() {
		
	}
	
	public TipoEvento(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
