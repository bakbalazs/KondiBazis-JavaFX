package hu.unideb.inf.kondibazis.db.entitas;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Közös ősként szolgál a többi entitás számára.
 * A csomagban lévő entitások ebből az entitásból származnak, ezért
 * mindegyik rendelkezni fog azokkal az adattaokkal amik itt szerepelnek.
 * A közös ős jelölését
 * a {@link javax.persistence.MappedSuperclass} annotáció jelöli.
 */
@MappedSuperclass
public class FoEntitas implements Serializable {

    /**
     * Alapértelmezett szerializációs azonosító.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Egyedi {@link java.lang.Long Long} tipusú azonosító.
     * Az adatbázisban a megfelelő tipusként fog
     * megjelenni a {@link javax.persistence.GeneratedValue} annotáció miatt.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Visszaadja az id-t.
     * @return Az adott entitás id-ja.
     */
    public Long getId() {
        return id;
    }

    /**
     * Beállítja az id-t.
     * @param id A beállítandó id.
     */
    public void setId(Long id) {
        this.id = id;
    }

}
