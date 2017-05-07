package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "konditeremElerhetoseg")
public class KonditeremElerhetoseg extends FoEntitas {

	private static final long serialVersionUID = 1L;

	public KonditeremElerhetoseg() {
	}

	@Column(name = "megye_Neve")
	private String megyeNeve;

	@Column(name = "iranyitoSzam")
	private Integer iranyitoSzam;

	@Column(name = "varos_neve")
	private String varosNeve;

	@Column(name = "utca_Neve")
	private String utcaNeve;

	@Column(name = "haz_Szam")
	private Integer hazSzam;

	@Column(name = "emelet")
	private Integer emelet;

	@Column(name = "ajto")
	private Integer ajto;

	@Column(name = "telefonszam")
	private String telefonszam;

	@Column(name = "emailCim")
	private String emailCim;

	@Column(name = "weboldalLink")
	private String weboldalLink;

	@Column(name = "facebookOldalLink")
	private String facebookOldalLink;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "konditerem_id")
	private Konditerem konditerem;

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

	public Konditerem getKonditerem() {
		return konditerem;
	}

	public void setKonditerem(Konditerem konditerem) {
		this.konditerem = konditerem;
	}

	@Override
	public String toString() {
		return "KonditeremElerhetoseg [megyeNeve=" + megyeNeve + ", iranyitoSzam=" + iranyitoSzam + ", varosNeve="
				+ varosNeve + ", utcaNeve=" + utcaNeve + ", hazSzam=" + hazSzam + ", emelet=" + emelet + ", ajto="
				+ ajto + ", telefonszam=" + telefonszam + ", emailCim=" + emailCim + ", weboldalLink=" + weboldalLink
				+ ", facebookOldalLink=" + facebookOldalLink + ", konditerem=" + konditerem + "]";
	}

}
