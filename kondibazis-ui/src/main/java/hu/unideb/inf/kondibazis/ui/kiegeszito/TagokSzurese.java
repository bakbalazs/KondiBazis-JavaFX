// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kiegeszito;

import hu.unideb.inf.kondibazis.ui.model.TagAdatok;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TagokSzurese {

    public static FilteredList<TagAdatok> lejartBerletuTagok;

    public static FilteredList<TagAdatok> aktivBerletuTagok;

    public static FilteredList<TagAdatok> lejartBerletesNok;

    public static FilteredList<TagAdatok> aktivBerletesNok;

    public static FilteredList<TagAdatok> noiTagok;

    public static FilteredList<TagAdatok> lejartBerletesFerfiak;

    public static FilteredList<TagAdatok> aktivBerletesFerfiak;

    public static FilteredList<TagAdatok> ferfiTagok;

    public static FilteredList<TagAdatok> alkalmasBerletek;

    public static FilteredList<TagAdatok> idokorlatosBerletek;

    public static FilteredList<TagAdatok> alkalmasBerletesNok;

    public static FilteredList<TagAdatok> alkalmasBerletesFerfiak;

    public static FilteredList<TagAdatok> idokorlatosBerletesFerfiak;

    public static FilteredList<TagAdatok> idokorlatosBerletesNok;

    public static FilteredList<TagAdatok> lejartAlkalmasTagok;

    public static FilteredList<TagAdatok> lejartIdokorlatosTagok;

    public static FilteredList<TagAdatok> aktivAlkalmasTagok;

    public static FilteredList<TagAdatok> aktivIdokorlatosTagok;

    public static FilteredList<TagAdatok> alkalmasAktivNoiTagok;

    public static FilteredList<TagAdatok> alkalmasLejartNoiTagok;

    public static FilteredList<TagAdatok> idokorlatosAktivNoiTagok;

    public static FilteredList<TagAdatok> idokorlatosLejartNoiTagok;

    public static FilteredList<TagAdatok> alkalmasAktivFerfiTagok;

    public static FilteredList<TagAdatok> alkalmasLejartFerfiTagok;

    public static FilteredList<TagAdatok> idokorlatosAktivFerfiTagok;

    public static FilteredList<TagAdatok> idokorlatosLejartFerfiTagok;

    public static void szuresek(ObservableList<TagAdatok> tagTablazatAdatok) {
        LocalDate maiNap = LocalDate.now();
        DateTimeFormatter datumFormatum = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        noiTagok = new FilteredList<>(tagTablazatAdatok, tagok -> true);
        ferfiTagok = new FilteredList<>(tagTablazatAdatok, tagok -> true);

        aktivBerletuTagok = new FilteredList<>(tagTablazatAdatok, tagok -> true);
        aktivBerletesNok = new FilteredList<>(aktivBerletuTagok, tagok -> true);
        aktivBerletesFerfiak = new FilteredList<>(aktivBerletuTagok, tagok -> true);

        lejartBerletuTagok = new FilteredList<>(tagTablazatAdatok, tagok -> true);
        lejartBerletesNok = new FilteredList<>(lejartBerletuTagok, tagok -> true);
        lejartBerletesFerfiak = new FilteredList<>(lejartBerletuTagok, tagok -> true);

        alkalmasBerletek = new FilteredList<>(tagTablazatAdatok, tagok -> true);

        idokorlatosBerletek = new FilteredList<>(tagTablazatAdatok, tagok -> true);

        alkalmasBerletesNok = new FilteredList<>(noiTagok, tagok -> true);
        alkalmasBerletesFerfiak = new FilteredList<>(ferfiTagok, tagok -> true);

        idokorlatosBerletesNok = new FilteredList<>(noiTagok, tagok -> true);
        idokorlatosBerletesFerfiak = new FilteredList<>(ferfiTagok, tagok -> true);

        lejartAlkalmasTagok = new FilteredList<>(lejartBerletuTagok, tagok -> true);
        lejartIdokorlatosTagok = new FilteredList<>(lejartBerletuTagok, tagok -> true);

        aktivAlkalmasTagok = new FilteredList<>(aktivBerletuTagok, tagok -> true);
        aktivIdokorlatosTagok = new FilteredList<>(aktivBerletuTagok, tagok -> true);

        alkalmasAktivNoiTagok = new FilteredList<>(aktivAlkalmasTagok, tagok -> true);
        alkalmasLejartNoiTagok = new FilteredList<>(lejartAlkalmasTagok, tagok -> true);

        idokorlatosAktivNoiTagok = new FilteredList<>(aktivIdokorlatosTagok, tagok -> true);
        idokorlatosLejartNoiTagok = new FilteredList<>(lejartIdokorlatosTagok, tagok -> true);

        alkalmasAktivFerfiTagok = new FilteredList<>(aktivAlkalmasTagok, tagok -> true);
        alkalmasLejartFerfiTagok = new FilteredList<>(lejartAlkalmasTagok, tagok -> true);

        idokorlatosAktivFerfiTagok = new FilteredList<>(aktivIdokorlatosTagok, tagok -> true);
        idokorlatosLejartFerfiTagok = new FilteredList<>(lejartIdokorlatosTagok, tagok -> true);

        // ha null a abérlet akkor a lejárt bérletet nééze ha nem null akkor a vasaroltat

        ferfiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));

        noiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));

        alkalmasBerletek.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Alkalmas"));

        idokorlatosBerletek.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Időkorlátos"));

        aktivBerletuTagok.setPredicate(tag -> Integer.parseInt(tag.getMennyiAlkalom().getValue()) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), datumFormatum).compareTo(maiNap) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), datumFormatum).compareTo(maiNap) > 0);

        aktivBerletesNok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));

        aktivBerletesFerfiak.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));

        lejartBerletuTagok.setPredicate(tag -> LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), datumFormatum).compareTo(maiNap) == -1 || Integer.parseInt(tag.getMennyiAlkalom().getValue()) == 0);

        lejartBerletesNok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));

        lejartBerletesFerfiak.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));

        alkalmasBerletesNok.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Alkalmas"));

        alkalmasBerletesFerfiak.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Alkalmas"));

        idokorlatosBerletesNok.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Időkorlátos"));
        idokorlatosBerletesFerfiak.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Időkorlátos"));

        lejartAlkalmasTagok.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Alkalmas"));
        lejartIdokorlatosTagok.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Időkorlátos"));

        aktivAlkalmasTagok.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Alkalmas"));
        aktivIdokorlatosTagok.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Időkorlátos"));

        alkalmasAktivNoiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));
        alkalmasLejartNoiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));
        idokorlatosAktivNoiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));
        idokorlatosLejartNoiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));

        alkalmasAktivFerfiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));
        alkalmasLejartFerfiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));
        idokorlatosAktivFerfiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));
        idokorlatosLejartFerfiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));
    }
}
