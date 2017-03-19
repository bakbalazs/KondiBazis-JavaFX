package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "konditerem")
public class Konditerem extends FoEntitas {

	private static final long serialVersionUID = 1L;

	public Konditerem() {
	}
	
	@Column(name = "felhasznalonev")
	private String felhasznalonev;
	
	@Column(name = "jelszo")
	private String jelszo;
	
	@Column(name = "konditeremNeve")
	private String konditeremNeve;

	public String getFelhasznalonev() {
		return felhasznalonev;
	}

	public void setFelhasznalonev(String felhasznalonev) {
		this.felhasznalonev = felhasznalonev;
	}

	public String getJelszo() {
		return jelszo;
	}

	public void setJelszo(String jelszo) {
		this.jelszo = jelszo;
	}

	public String getKonditeremNeve() {
		return konditeremNeve;
	}

	public void setKonditeremNeve(String konditeremNeve) {
		this.konditeremNeve = konditeremNeve;
	}
	
	
}
