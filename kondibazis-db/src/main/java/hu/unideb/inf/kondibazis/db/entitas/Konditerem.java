package hu.unideb.inf.kondibazis.db.entitas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@OneToMany(mappedBy = "konditerem")
	private List<KonditeremBerlet> konditeremBerlet;

	@OneToMany(mappedBy = "konditerem")
	private List<KonditeremTag> konditeremTag;

	@OneToOne
	private KonditeremElerhetoseg konditeremElerhetoseg;

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

	public List<KonditeremBerlet> getKonditeremBerlet() {
		return konditeremBerlet;
	}

	public void setKonditeremBerlet(List<KonditeremBerlet> konditeremBerlet) {
		this.konditeremBerlet = konditeremBerlet;
	}

	public List<KonditeremTag> getKonditeremTag() {
		return konditeremTag;
	}

	public void setKonditeremTag(List<KonditeremTag> konditeremTag) {
		this.konditeremTag = konditeremTag;
	}

	public KonditeremElerhetoseg getKonditeremElerhetoseg() {
		return konditeremElerhetoseg;
	}

	public void setKonditeremElerhetoseg(KonditeremElerhetoseg konditeremElerhetoseg) {
		this.konditeremElerhetoseg = konditeremElerhetoseg;
	}

	@Override
	public String toString() {
		return "Konditerem [felhasznalonev=" + felhasznalonev + ", jelszo=" + jelszo + ", konditeremNeve="
				+ konditeremNeve + ", konditeremBerlet=" + konditeremBerlet + ", konditeremTag=" + konditeremTag
				+ ", konditeremElerhetoseg=" + konditeremElerhetoseg + "]";
	}

}
