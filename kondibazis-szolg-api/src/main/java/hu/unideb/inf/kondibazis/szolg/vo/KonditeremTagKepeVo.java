package hu.unideb.inf.kondibazis.szolg.vo;


import java.io.Serializable;
import java.util.Arrays;

public class KonditeremTagKepeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public KonditeremTagKepeVo() {
    }

    private byte[] tagKep;

    private KonditeremTagVo konditeremTag;

    public byte[] getTagKep() {
        return tagKep;
    }

    public void setTagKep(byte[] tagKep) {
        this.tagKep = tagKep;
    }

    public KonditeremTagVo getKonditeremTag() {
        return konditeremTag;
    }

    public void setKonditeremTag(KonditeremTagVo konditeremTag) {
        this.konditeremTag = konditeremTag;
    }

    @Override
    public String toString() {
        return "KonditeremTagKepeVo{" +
                "tagKep=" + Arrays.toString(tagKep) +
                ", konditeremTag=" + konditeremTag +
                '}';
    }
}
