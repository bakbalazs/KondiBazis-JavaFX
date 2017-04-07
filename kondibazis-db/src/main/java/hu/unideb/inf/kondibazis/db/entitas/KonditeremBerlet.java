package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "konditeremBerlet")
public class KonditeremBerlet extends FoEntitas {

	private static final long serialVersionUID = 1L;

	public KonditeremBerlet() {
	}

	@Column(name = "berlet_neve")
	private String berletNeve;

	@Column(name = "menniOra")
	private int mennyiOra;

	@Column(name = "mennyiNap")
	private int mennyiNap;

	@Column(name = "mennyiHonap")
	private int mennyiHonap;

	@Column(name = "berletAra")
	private int berletAra;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "konditerem_id")
	private Konditerem konditerem;

	public String getBerletNeve() {
		return berletNeve;
	}

	public void setBerletNeve(String berletNeve) {
		this.berletNeve = berletNeve;
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

	public int getBerletAra() {
		return berletAra;
	}

	public void setBerletAra(int berletAra) {
		this.berletAra = berletAra;
	}

	public Konditerem getKonditerem() {
		return konditerem;
	}

	public void setKonditerem(Konditerem konditerem) {
		this.konditerem = konditerem;
	}

}
