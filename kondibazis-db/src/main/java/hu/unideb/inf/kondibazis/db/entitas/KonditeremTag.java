package hu.unideb.inf.kondibazis.db.entitas;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "konditeremTag")
public class KonditeremTag extends FoEntitas {

	private static final long serialVersionUID = 1L;

	public KonditeremTag() {
	}

	@Column(name = "tageVezetekneve")
	private String tagVezeteknev;

	@Column(name = "tagKeresztneve")
	private String tagKeresztnev;

	@Column(name = "tagNeme")
	private String tagNeme;

	@Column(name = "tagKora")
	private int tagKora;

	@Column(name = "tagSzuletesidatum")
	private LocalDate tagSzuletesidatuma;

	@Column(name = "bereletVasarlasideje")
	private LocalDate berletVasarlasideje;

	@Column(name = "vasaroltBereletneve")
	private String vasaroltBerletNeve;

	@Lob
	@Column(name = "tagKep")
	private byte[] tagKep;
	
	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH },
			fetch=FetchType.LAZY)
	@JoinColumn(name="konditerem_id")
	private Konditerem konditerem;

	public String getTagVezeteknev() {
		return tagVezeteknev;
	}

	public void setTagVezeteknev(String tagVezeteknev) {
		this.tagVezeteknev = tagVezeteknev;
	}

	public String getTagKeresztnev() {
		return tagKeresztnev;
	}

	public void setTagKeresztnev(String tagKeresztnev) {
		this.tagKeresztnev = tagKeresztnev;
	}

	public String getTagNeme() {
		return tagNeme;
	}

	public void setTagNeme(String tagNeme) {
		this.tagNeme = tagNeme;
	}

	public int getTagKora() {
		return tagKora;
	}

	public void setTagKora(int tagKora) {
		this.tagKora = tagKora;
	}

	public LocalDate getTagSzuletesidatuma() {
		return tagSzuletesidatuma;
	}

	public void setTagSzuletesidatuma(LocalDate tagSzuletesidatuma) {
		this.tagSzuletesidatuma = tagSzuletesidatuma;
	}

	public LocalDate getBerletVasarlasideje() {
		return berletVasarlasideje;
	}

	public void setBerletVasarlasideje(LocalDate berletVasarlasideje) {
		this.berletVasarlasideje = berletVasarlasideje;
	}

	public byte[] getTagKep() {
		return tagKep;
	}

	public void setTagKep(byte[] tagKep) {
		this.tagKep = tagKep;
	}

	public String getVasaroltBerletNeve() {
		return vasaroltBerletNeve;
	}

	public void setVasaroltBerletNeve(String vasaroltBerletNeve) {
		this.vasaroltBerletNeve = vasaroltBerletNeve;
	}

}
