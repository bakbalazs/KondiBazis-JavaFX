package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;

public class KonditeremBerletVo implements Serializable {

	private static final long serialVersionUID = 1L;

	public KonditeremBerletVo() {
	}

	private Long id;

	private String berletNeve;

	private int berletAra;

	private int mennyiOra;

	private int mennyiNap;

	private int mennyiHonap;

	private KonditeremVo konditerem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBerletNeve() {
		return berletNeve;
	}

	public void setBerletNeve(String berletNeve) {
		this.berletNeve = berletNeve;
	}

	public int getBerletAra() {
		return berletAra;
	}

	public void setBerletAra(int berletAra) {
		this.berletAra = berletAra;
	}

	public int getMennyiOra() {
		return mennyiOra;
	}

	public void setMennyiOra(int mennyiOra) {
		this.mennyiOra = mennyiOra;
	}

	public int getMennyiNap() {
		return mennyiNap;
	}

	public void setMennyiNap(int mennyiNap) {
		this.mennyiNap = mennyiNap;
	}

	public int getMennyiHonap() {
		return mennyiHonap;
	}

	public void setMennyiHonap(int mennyiHonap) {
		this.mennyiHonap = mennyiHonap;
	}

	public KonditeremVo getKonditerem() {
		return konditerem;
	}

	public void setKonditerem(KonditeremVo konditerem) {
		this.konditerem = konditerem;
	}

	@Override
	public String toString() {
		return "KonditeremBerletVo [berletNeve=" + berletNeve + ", berletAra=" + berletAra + ", mennyiOra=" + mennyiOra
				+ ", mennyiNap=" + mennyiNap + ", mennyiHonap=" + mennyiHonap + ", konditerem=" + konditerem + "]";
	}

}
