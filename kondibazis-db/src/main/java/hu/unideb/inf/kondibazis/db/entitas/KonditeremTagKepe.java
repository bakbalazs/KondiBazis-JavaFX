package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.*;

@Entity
@Table(name = "konditeremtagkepe")
public class KonditeremTagKepe extends FoEntitas {

    private static final long serialVersionUID = 1L;

    public KonditeremTagKepe() {
    }

    @Lob
    @Column(name = "tagKep")
    private byte[] tagKep;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "konditeremTag_id")
    private KonditeremTag konditeremTag;

    public byte[] getTagKep() {
        return tagKep;
    }

    public void setTagKep(byte[] tagKep) {
        this.tagKep = tagKep;
    }

    public KonditeremTag getKonditeremTag() {
        return konditeremTag;
    }

    public void setKonditeremTag(KonditeremTag konditeremTag) {
        this.konditeremTag = konditeremTag;
    }
}
