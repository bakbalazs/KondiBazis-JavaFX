package hu.unideb.inf.kondibazis.ui.kiegeszito;

import hu.unideb.inf.kondibazis.ui.model.TagData;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TagokSzurese {

    public static FilteredList<TagData> lejartBerletuTagok;

    public static FilteredList<TagData> aktivBerletuTagok;

    public static FilteredList<TagData> lejartBerletesNok;

    public static FilteredList<TagData> aktivBerletesNok;

    public static FilteredList<TagData> noiTagok;

    public static FilteredList<TagData> lejartBerletesFerfiak;

    public static FilteredList<TagData> aktivBerletesFerfiak;

    public static FilteredList<TagData> ferfiTagok;

    public static FilteredList<TagData> alkalmasBerletek;

    public static FilteredList<TagData> idokorlatosBerletek;

    public static FilteredList<TagData> alkalmasBerletesNok;

    public static FilteredList<TagData> alkalmasBerletesFerfiak;

    public static FilteredList<TagData> idokorlatosBerletesFerfiak;

    public static FilteredList<TagData> idokorlatosBerletesNok;

    public static FilteredList<TagData> lejartAlkalmasTagok;

    public static FilteredList<TagData> lejartIdokorlatosTagok;

    public static FilteredList<TagData> aktivAlkalmasTagok;

    public static FilteredList<TagData> aktivIdokorlatosTagok;

    public static FilteredList<TagData> alkalmasAktivNoiTagok;

    public static FilteredList<TagData> alkalmasLejartNoiTagok;

    public static FilteredList<TagData> idokorlatosAktivNoiTagok;

    public static FilteredList<TagData> idokorlatosLejartNoiTagok;

    public static FilteredList<TagData> alkalmasAktivFerfiTagok;

    public static FilteredList<TagData> alkalmasLejartFerfiTagok;

    public static FilteredList<TagData> idokorlatosAktivFerfiTagok;

    public static FilteredList<TagData> idokorlatosLejartFerfiTagok;

    public static void szuresek(ObservableList<TagData> tagTablazatAdatok) {
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

        ferfiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));

        noiTagok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));

        alkalmasBerletek.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Alkalmas"));

        idokorlatosBerletek.setPredicate(tag -> tag.getVasaroltBerletNeve().toString().contains("Időkorlátos"));

        aktivBerletuTagok.setPredicate(tag -> LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), datumFormatum).compareTo(maiNap) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), datumFormatum).compareTo(maiNap) > 0);

        aktivBerletesNok.setPredicate(tag -> tag.getTagNeme().toString().contains("Nő"));

        aktivBerletesFerfiak.setPredicate(tag -> tag.getTagNeme().toString().contains("Férfi"));

        lejartBerletuTagok.setPredicate(tag -> LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje().getValue(), datumFormatum).compareTo(maiNap) == -1);

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
