package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;

public class KonditeremBerletVo implements Serializable {

	private static final long serialVersionUID = 1L;

	public KonditeremBerletVo() {
	}

	private Long id;

	private String berletNeve;

	private int berletAra;

	private int mennyiAlkalom;

	private int mennyiNap;

	private int mennyiHonap;

	private String berletTipusa;

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

	public int getMennyiAlkalom() {
		return mennyiAlkalom;
	}

	public void setMennyiAlkalom(int mennyiAlkalom) {
		this.mennyiAlkalom = mennyiAlkalom;
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

	public String getBerletTipusa() {
		return berletTipusa;
	}

	public void setBerletTipusa(String berletTipusa) {
		this.berletTipusa = berletTipusa;
	}

	public KonditeremVo getKonditerem() {
		return konditerem;
	}

	public void setKonditerem(KonditeremVo konditerem) {
		this.konditerem = konditerem;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		KonditeremBerletVo that = (KonditeremBerletVo) o;

		if (berletAra != that.berletAra) return false;
		if (mennyiAlkalom != that.mennyiAlkalom) return false;
		if (mennyiNap != that.mennyiNap) return false;
		if (mennyiHonap != that.mennyiHonap) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (berletNeve != null ? !berletNeve.equals(that.berletNeve) : that.berletNeve != null) return false;
		if (berletTipusa != null ? !berletTipusa.equals(that.berletTipusa) : that.berletTipusa != null) return false;
		return konditerem != null ? konditerem.equals(that.konditerem) : that.konditerem == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (berletNeve != null ? berletNeve.hashCode() : 0);
		result = 31 * result + berletAra;
		result = 31 * result + mennyiAlkalom;
		result = 31 * result + mennyiNap;
		result = 31 * result + mennyiHonap;
		result = 31 * result + (berletTipusa != null ? berletTipusa.hashCode() : 0);
		result = 31 * result + (konditerem != null ? konditerem.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "KonditeremBerletVo{" +
				"id=" + id +
				", berletNeve='" + berletNeve + '\'' +
				", berletAra=" + berletAra +
				", mennyiAlkalom=" + mennyiAlkalom +
				", mennyiNap=" + mennyiNap +
				", mennyiHonap=" + mennyiHonap +
				", berletTipusa='" + berletTipusa + '\'' +
				'}';
	}
}
