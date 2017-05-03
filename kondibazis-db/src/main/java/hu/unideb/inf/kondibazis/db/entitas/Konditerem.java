package hu.unideb.inf.kondibazis.db.entitas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "konditerem")
public class Konditerem extends FoEntitas {

	private static final long serialVersionUID = 1L;

	public Konditerem() {
	}

	@Column(name = "felhasznalonev", unique = true)
	private String felhasznalonev;

	@Column(name = "jelszo")
	private String jelszo;

	@Column(name = "konditeremNeve")
	private String konditeremNeve;

	@OneToMany(mappedBy = "konditerem", cascade = CascadeType.MERGE)
	private List<KonditeremTag> konditeremTagok;
	
	@OneToMany(mappedBy = "konditerem", cascade = CascadeType.MERGE)
	private List<KonditeremBerlet> konditeremBerletek;

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

	public List<KonditeremTag> getKonditeremTagok() {
		return konditeremTagok;
	}

	public void setKonditeremTagok(List<KonditeremTag> konditeremTagok) {
		this.konditeremTagok = konditeremTagok;
	}

	public List<KonditeremBerlet> getKonditeremBerletek() {
		return konditeremBerletek;
	}

	public void setKonditeremBerletek(List<KonditeremBerlet> konditeremBerletek) {
		this.konditeremBerletek = konditeremBerletek;
	}

	
	
}
