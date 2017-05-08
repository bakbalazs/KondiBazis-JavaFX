package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;

public class TelepulesekVo implements Serializable {

	private static final long serialVersionUID = 1L;

	public TelepulesekVo() {
	}

	private Integer iranyitoszam;

	private String megye;

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

	@Override
	public String toString() {
		return "TelepulesekVo [iranyitoszam=" + iranyitoszam + ", megye=" + megye + ", telepulesnev=" + telepulesnev
				+ "]";
	}

	
	
}
