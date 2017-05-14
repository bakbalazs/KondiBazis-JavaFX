package hu.unideb.inf.kondibazis.db.entitas;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Column(name = "berletAra")
    private int berletAra;

    @Column(name = "mennyiAlkalom")
    private int mennyiAlkalom;

    @Column(name = "mennyiNap")
    private int mennyiNap;

    @Column(name = "mennyiHonap")
    private int mennyiHonap;

    @Column(name = "berletTipusa")
    private String berletTipusa;

    @ManyToOne()
    private Konditerem konditerem;

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

    public Konditerem getKonditerem() {
        return konditerem;
    }

    public void setKonditerem(Konditerem konditerem) {
        this.konditerem = konditerem;
    }

    @Override
    public String toString() {
        return "KonditeremBerlet{" +
                "berletNeve='" + berletNeve + '\'' +
                ", berletAra=" + berletAra +
                ", mennyiAlkalom=" + mennyiAlkalom +
                ", mennyiNap=" + mennyiNap +
                ", mennyiHonap=" + mennyiHonap +
                ", berletTipusa='" + berletTipusa + '\'' +
                ", konditerem=" + konditerem +
                '}';
    }
}
