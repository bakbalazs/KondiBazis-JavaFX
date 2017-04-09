package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;
import java.util.List;

public class KonditeremVo implements Serializable {

	private static final long serialVersionUID = 1L;

	public KonditeremVo() {
	}

	private String felhasznalonev;

	private String jelszo;

	private String konditeremNeve;

	private List<KonditeremBerletVo> konditeremBerlet;

	private List<KonditeremTagVo> konditeremTag;

//	private KonditeremElerhetoseg konditeremElerhetoseg;

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

	public List<KonditeremBerletVo> getKonditeremBerlet() {
		return konditeremBerlet;
	}

	public void setKonditeremBerlet(List<KonditeremBerletVo> konditeremBerlet) {
		this.konditeremBerlet = konditeremBerlet;
	}

	public List<KonditeremTagVo> getKonditeremTag() {
		return konditeremTag;
	}

	public void setKonditeremTag(List<KonditeremTagVo> konditeremTag) {
		this.konditeremTag = konditeremTag;
	}

//	public KonditeremElerhetoseg getKonditeremElerhetoseg() {
//		return konditeremElerhetoseg;
//	}
//
//	public void setKonditeremElerhetoseg(KonditeremElerhetoseg konditeremElerhetoseg) {
//		this.konditeremElerhetoseg = konditeremElerhetoseg;
//	}

	@Override
	public String toString() {
		return "Konditerem [felhasznalonev=" + felhasznalonev + ", jelszo=" + jelszo + ", konditeremNeve="
				+ konditeremNeve + ", konditeremBerlet=" + konditeremBerlet + ", konditeremTag=" + konditeremTag
				+ ", konditeremElerhetoseg=" + "]";
	}

}
