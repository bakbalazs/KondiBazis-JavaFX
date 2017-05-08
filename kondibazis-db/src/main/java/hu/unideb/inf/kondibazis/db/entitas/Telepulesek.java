package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "telepulesek")
public class Telepulesek extends FoEntitas {

	private static final long serialVersionUID = 1L;

	public Telepulesek() {
	}

	@Column(name = "iranyitoszam")
	private Integer iranyitoszam;

	@Column(name = "megye")
	private String megye;

	@Column(name = "telepulesnev")
	private String telepulesnev;

	public Integer getIranyitoszam() {
		return iranyitoszam;
	}

	public void setIranyitoszam(Integer iranyitoszam) {
		this.iranyitoszam = iranyitoszam;
	}

	public String getMegye() {
		return megye;
	}

	public void setMegye(String megye) {
		this.megye = megye;
	}

	public String getTelepulesnev() {
		return telepulesnev;
	}

	public void setTelepulesnev(String telepulesnev) {
		this.telepulesnev = telepulesnev;
	}

}
