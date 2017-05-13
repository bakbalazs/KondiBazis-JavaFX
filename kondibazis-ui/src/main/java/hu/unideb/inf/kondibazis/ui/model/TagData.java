package hu.unideb.inf.kondibazis.ui.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TagData {

	 private long id;
	private StringProperty tagNeve;
	private StringProperty tagVezetekneve;
	private StringProperty tagKeresztneve;
	private StringProperty tagNeme;
	 private StringProperty tagKora;
	 private StringProperty berletVasarlasIdeje;
	private StringProperty berletLejaratiIdeje;
	 private StringProperty vasaroltBerletNeve;

	public TagData() {
		super();
		// TODO Auto-generated constructor stub
	}

	//
	public TagData(long id, String tagNeve, String tagVezetekneve, String tagKeresztneve ,String tagNeme, Integer tagKora,String vasaroltBerletNeve, LocalDate berletVasarlasideje , LocalDate berletLejaratiIdeje) {
		this.setId(id);
		this.tagNeve = new SimpleStringProperty(tagNeve);
		this.tagVezetekneve = new SimpleStringProperty(tagVezetekneve);
		this.tagKeresztneve = new SimpleStringProperty(tagKeresztneve);
		this.tagNeme = new SimpleStringProperty(tagNeme);
		this.tagKora = new SimpleStringProperty(tagKora.toString());
		this.berletVasarlasIdeje = new SimpleStringProperty(berletVasarlasideje.toString());
		this.berletLejaratiIdeje = new SimpleStringProperty(berletLejaratiIdeje.toString());
		this.vasaroltBerletNeve = new SimpleStringProperty(vasaroltBerletNeve);
	}

	public StringProperty getTagNeve() {
		return tagNeve;
	}

	public void setTagNeve(String tagNeve) {
		this.tagNeve.set(tagNeve);
	}

	public StringProperty getTagNeveProperty() {
		return tagNeve;
	}

	public StringProperty getTagVezetekneve() {
		return tagVezetekneve;
	}

	public void setTagVezetekneve(String tagVezetekneve) {
		this.tagVezetekneve.set(tagVezetekneve);
	}

	public StringProperty getTagVezetekneveProperty() {
		return tagVezetekneve;
	}

	public StringProperty getTagKeresztneve() {
		return tagKeresztneve;
	}

	public void setTagKeresztneve(String tagKeresztneve) {
		this.tagKeresztneve.set(tagKeresztneve);
	}

	public StringProperty getTagKeresztneveProperty() {
		return tagKeresztneve;
	}
	
	
	public StringProperty getTagKora() {
		return tagKora;
	}

	public void setTagKora(String tagKora) {
		this.tagKora.set(tagKora);
	}

	public StringProperty getTagKoraProperty() {
		return tagKora;
	}
	
	
	public StringProperty getBerletVasarlasIdeje() {
		return berletVasarlasIdeje;
	}

	public void setBerletVasarlasIdeje(String berletVasarlasIdeje) {
		this.berletVasarlasIdeje.set(berletVasarlasIdeje);
	}

	public StringProperty getBerletVasarlasIdejeProperty() {
		return berletVasarlasIdeje;
	}

	public StringProperty getBerletLejaratiIdeje() {
		return berletLejaratiIdeje;
	}

	public void setBerletLejaratiIdeje(String BerletLejaratiIdeje) {
		this.berletLejaratiIdeje.set(BerletLejaratiIdeje);
	}

	public StringProperty getBerletLejaratiIdejeProperty() {
		return berletLejaratiIdeje;
	}

	
	public StringProperty getTagNeme() {
		return tagNeme;
	}

	public void setTagNeme(String tagNeme) {
		this.tagNeme.set(tagNeme);
	}

	public StringProperty getTagNemeProperty() {
		return tagNeme;
	}

	

	
	public StringProperty getVasaroltBerletNeve() {
		return vasaroltBerletNeve;
	}

	public void setVasaroltBerletNeve(String vasaroltBerletNeve) {
		this.vasaroltBerletNeve.set(vasaroltBerletNeve);
	}

	public StringProperty getVasaroltBerletNeveProperty() {
		return vasaroltBerletNeve;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TagData{" +
				"id=" + id +
				", tagNeve=" + tagNeve +
				", tagVezetekneve=" + tagVezetekneve +
				", tagKeresztneve=" + tagKeresztneve +
				", tagNeme=" + tagNeme +
				", tagKora=" + tagKora +
				", berletVasarlasIdeje=" + berletVasarlasIdeje +
				", berletLejaratiIdeje=" + berletLejaratiIdeje +
				", vasaroltBerletNeve=" + vasaroltBerletNeve +
				'}';
	}
}
