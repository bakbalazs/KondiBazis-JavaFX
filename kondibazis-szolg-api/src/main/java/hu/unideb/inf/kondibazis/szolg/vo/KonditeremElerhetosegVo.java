package hu.unideb.inf.kondibazis.szolg.vo;

import java.io.Serializable;

public class KonditeremElerhetosegVo implements Serializable {

	private static final long serialVersionUID = 1L;

	public KonditeremElerhetosegVo() {
	}

	private String megyeNeve;

	private Integer iranyitoSzam;

	private String varosNeve;

	private String utcaNeve;

	private Integer hazSzam;

	private Integer emelet;

	private Integer ajto;

	private String telefonszam;

	private String emailCim;

	private String weboldalLink;

	private String facebookOldalLink;

	private KonditeremVo konditerem;

	public String getMegyeNeve() {
		return megyeNeve;
	}

	public void setMegyeNeve(String megyeNeve) {
		this.megyeNeve = megyeNeve;
	}

	public Integer getIranyitoSzam() {
		return iranyitoSzam;
	}

	public void setIranyitoSzam(Integer iranyitoSzam) {
		this.iranyitoSzam = iranyitoSzam;
	}

	public String getVarosNeve() {
		return varosNeve;
	}

	public void setVarosNeve(String varosNeve) {
		this.varosNeve = varosNeve;
	}

	public String getUtcaNeve() {
		return utcaNeve;
	}

	public void setUtcaNeve(String utcaNeve) {
		this.utcaNeve = utcaNeve;
	}

	public Integer getHazSzam() {
		return hazSzam;
	}

	public void setHazSzam(Integer hazSzam) {
		this.hazSzam = hazSzam;
	}

	public Integer getEmelet() {
		return emelet;
	}

	public void setEmelet(Integer emelet) {
		this.emelet = emelet;
	}

	public Integer getAjto() {
		return ajto;
	}

	public void setAjto(Integer ajto) {
		this.ajto = ajto;
	}

	public String getTelefonszam() {
		return telefonszam;
	}

	public void setTelefonszam(String telefonszam) {
		this.telefonszam = telefonszam;
	}

	public String getEmailCim() {
		return emailCim;
	}

	public void setEmailCim(String emailCim) {
		this.emailCim = emailCim;
	}

	public String getWeboldalLink() {
		return weboldalLink;
	}

	public void setWeboldalLink(String weboldalLink) {
		this.weboldalLink = weboldalLink;
	}

	public String getFacebookOldalLink() {
		return facebookOldalLink;
	}

	public void setFacebookOldalLink(String facebookOldalLink) {
		this.facebookOldalLink = facebookOldalLink;
	}

	public KonditeremVo getKonditerem() {
		return konditerem;
	}

	public void setKonditerem(KonditeremVo konditerem) {
		this.konditerem = konditerem;
	}

	@Override
	public String toString() {
		return "KonditeremElerhetosegVo [megyeNeve=" + megyeNeve + ", iranyitoSzam=" + iranyitoSzam + ", varosNeve="
				+ varosNeve + ", utcaNeve=" + utcaNeve + ", hazSzam=" + hazSzam + ", emelet=" + emelet + ", ajto="
				+ ajto + ", telefonszam=" + telefonszam + ", emailCim=" + emailCim + ", weboldalLink=" + weboldalLink
				+ ", facebookOldalLink=" + facebookOldalLink + ", konditerem=" + konditerem + "]";
	}

}
