// CHECKSTYLE:OFF
package hu.unideb.inf.kondibazis.ui.kiegeszito;

import hu.unideb.inf.kondibazis.ui.model.TagAdatok;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TagokSzurese {

    public static FilteredList<TagAdatok> lejartBerletuek;
    public static FilteredList<TagAdatok> lejartAlkalmasBerletuek;
    public static FilteredList<TagAdatok> lejartIdokorlatosBerletuek;

    public static FilteredList<TagAdatok> aktivBerletuek;
    public static FilteredList<TagAdatok> aktivAlkalmasBerletuek;
    public static FilteredList<TagAdatok> aktivIdokorlatosBerletuek;

    public static FilteredList<TagAdatok> nok;
    public static FilteredList<TagAdatok> ferfiak;

    public static FilteredList<TagAdatok> alkalmasBerletuek;
    public static FilteredList<TagAdatok> idokorlatosBerletuek;

    public static FilteredList<TagAdatok> alkalmasNoBerletuek;
    public static FilteredList<TagAdatok> idokorlatosNoBerletuek;
    public static FilteredList<TagAdatok> alkalmasFerfiBerletuek;
    public static FilteredList<TagAdatok> idokorlatosFerfiBerletuek;

    public static FilteredList<TagAdatok> alkalmasNokLejart;
    public static FilteredList<TagAdatok> idokorlatosNokLejart;

    public static FilteredList<TagAdatok> alkalmasFerfiLejart;
    public static FilteredList<TagAdatok> idokorlatosFerfiLejart;

    public static FilteredList<TagAdatok> ferfiakLejart;
    public static FilteredList<TagAdatok> nokLejart;

    public static FilteredList<TagAdatok> alkalmasNokAktiv;
    public static FilteredList<TagAdatok> idokorlatosNokAktiv;

    public static FilteredList<TagAdatok> alkalmasFerfiAktiv;
    public static FilteredList<TagAdatok> idokorlatosFerfiAktiv;

    public static FilteredList<TagAdatok> ferfiakAktiv;
    public static FilteredList<TagAdatok> nokAktiv;

    private static ObservableList<TagAdatok> lejartBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> alkalmasBerletuLejartTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> idokorlatosBerletuLejartTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> aktivBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> alkalmasBerletuAktivTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> idokorlatosBerletuAktivTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> noiTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> ferfiTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> alkalmasBerletesTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> idokorlatosBerletesTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> alkalmasNoiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> alkalmasFerfiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> idokorlatosNoiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> idokorlatosFerfiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> lejartAlkalmasNoiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> lejartIdokorlatosNoiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> lejartAlkalmasFerfiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> lejartIdokorlatosFerfiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> lejartFerfiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> lejartNoiBerletuTagok = FXCollections.observableArrayList();

    private static ObservableList<TagAdatok> aktivAlkalmasNoiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> aktivIdokorlatosNoiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> aktivAlkalmasFerfiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> aktivIdokorlatosFerfiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> aktivFerfiBerletuTagok = FXCollections.observableArrayList();
    private static ObservableList<TagAdatok> aktivNoiBerletuTagok = FXCollections.observableArrayList();

    public static void szuresek(ObservableList<TagAdatok> tagTablazatAdatok) {
        LocalDate maiNap = LocalDate.now();
        DateTimeFormatter datumFormatum = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<TagAdatok> alkalmasLejartLista = new ArrayList<>();
        List<TagAdatok> idokorlatosLejartLista = new ArrayList<>();

        alkalmasLejartLista.clear();
        idokorlatosLejartLista.clear();

        List<TagAdatok> alkalmasAktivLista = new ArrayList<>();
        List<TagAdatok> idokorlatosAktivLista = new ArrayList<>();

        alkalmasAktivLista.clear();
        idokorlatosAktivLista.clear();

        List<TagAdatok> noiTagokLista = new ArrayList<>();
        List<TagAdatok> ferfiTagokLista = new ArrayList<>();

        noiTagokLista.clear();
        ferfiTagokLista.clear();

        List<TagAdatok> alkalmasBerletuLista = new ArrayList<>();
        List<TagAdatok> idokorlatosBerletuLista = new ArrayList<>();

        alkalmasBerletuLista.clear();
        idokorlatosBerletuLista.clear();

        List<TagAdatok> alkalmasNoiBerletuLista = new ArrayList<>();
        List<TagAdatok> idokorlatosNoiBerletuLista = new ArrayList<>();

        alkalmasNoiBerletuLista.clear();
        idokorlatosNoiBerletuLista.clear();

        List<TagAdatok> alkalmasFerfiBerletuLista = new ArrayList<>();
        List<TagAdatok> idokorlatosFerfiBerletuLista = new ArrayList<>();

        alkalmasFerfiBerletuLista.clear();
        idokorlatosFerfiBerletuLista.clear();

        List<TagAdatok> alkalmasLejartNoiBerletuLista = new ArrayList<>();
        List<TagAdatok> idokorlatosLejartNoiBerletuLista = new ArrayList<>();

        alkalmasLejartNoiBerletuLista.clear();
        idokorlatosLejartNoiBerletuLista.clear();

        List<TagAdatok> alkalmasLejartFerfiBerletuLista = new ArrayList<>();
        List<TagAdatok> idokorlatosLejartFerfiBerletuLista = new ArrayList<>();

        alkalmasLejartFerfiBerletuLista.clear();
        idokorlatosLejartFerfiBerletuLista.clear();

        List<TagAdatok> lejartFerfiBerletesLista = new ArrayList<>();
        List<TagAdatok> lejartNoiBerletesLista = new ArrayList<>();

        lejartFerfiBerletesLista.clear();
        lejartNoiBerletesLista.clear();

        List<TagAdatok> aktivNoiBerletesLista = new ArrayList<>();
        List<TagAdatok> aktivFerfiBerletesLista = new ArrayList<>();
        List<TagAdatok> idokorlatosAktivFerfiBerletuLista = new ArrayList<>();
        List<TagAdatok> alkalmasAktivFerfiBerletuLista = new ArrayList<>();
        List<TagAdatok> idokorlatosAktivNoiBerletuLista = new ArrayList<>();
        List<TagAdatok> alkalmasAktivNoiBerletuLista = new ArrayList<>();


        aktivNoiBerletesLista.clear();
        aktivFerfiBerletesLista.clear();
        idokorlatosAktivFerfiBerletuLista.clear();
        alkalmasAktivFerfiBerletuLista.clear();
        idokorlatosAktivNoiBerletuLista.clear();
        alkalmasAktivNoiBerletuLista.clear();

        for (TagAdatok tag : tagTablazatAdatok) {
            if (tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                alkalmasLejartLista.add(tag);
            }
            if (tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                idokorlatosLejartLista.add(tag);
            }

            if (tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) > 0) || (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0) || (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0)) {
                alkalmasAktivLista.add(tag);
            }

            if (tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0)) {
                idokorlatosAktivLista.add(tag);
            }
            if (tag.getTagNeme().equals("Nő")) {
                noiTagokLista.add(tag);
            }
            if (tag.getTagNeme().equals("Férfi")) {
                ferfiTagokLista.add(tag);
            }
            if (tag.getVasaroltBerletNeve().contains("Alkalmas")) {
                alkalmasBerletuLista.add(tag);
            }
            if (tag.getVasaroltBerletNeve().contains("Időkorlátos")) {
                idokorlatosBerletuLista.add(tag);
            }
            if (tag.getVasaroltBerletNeve().contains("Alkalmas") && tag.getTagNeme().equals("Nő")) {
                alkalmasNoiBerletuLista.add(tag);
            }
            if (tag.getVasaroltBerletNeve().contains("Időkorlátos") && tag.getTagNeme().equals("Nő")) {
                idokorlatosNoiBerletuLista.add(tag);
            }
            if (tag.getVasaroltBerletNeve().contains("Alkalmas") && tag.getTagNeme().equals("Férfi")) {
                alkalmasFerfiBerletuLista.add(tag);
            }
            if (tag.getVasaroltBerletNeve().contains("Időkorlátos") && tag.getTagNeme().equals("Férfi")) {
                idokorlatosFerfiBerletuLista.add(tag);
            }
            if (tag.getTagNeme().equals("Nő") && tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                alkalmasLejartNoiBerletuLista.add(tag);
            }
            if (tag.getTagNeme().equals("Nő") && tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                idokorlatosLejartNoiBerletuLista.add(tag);
            }
            if (tag.getTagNeme().equals("Férfi") && tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                alkalmasLejartFerfiBerletuLista.add(tag);
            }
            if (tag.getTagNeme().equals("Férfi") && tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                idokorlatosLejartFerfiBerletuLista.add(tag);
            }
            if ((tag.getTagNeme().equals("Férfi") && tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) || tag.getTagNeme().equals("Férfi") && tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                lejartFerfiBerletesLista.add(tag);
            }
            if ((tag.getTagNeme().equals("Nő") && tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) || tag.getTagNeme().equals("Nő") && tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) == 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) < 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == -1)) {
                lejartNoiBerletesLista.add(tag);
            }

            if (tag.getTagNeme().equals("Nő") && tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0)) {
                alkalmasAktivNoiBerletuLista.add(tag);
            }
            if (tag.getTagNeme().equals("Nő") && tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0)) {
                idokorlatosAktivNoiBerletuLista.add(tag);
            }
            if (tag.getTagNeme().equals("Férfi") && tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0)) {
                alkalmasAktivFerfiBerletuLista.add(tag);
            }
            if (tag.getTagNeme().equals("Férfi") && tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0)) {
                idokorlatosAktivFerfiBerletuLista.add(tag);
            }
            if ((tag.getTagNeme().equals("Férfi") && tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0)) || tag.getTagNeme().equals("Férfi") && tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0)) {
                aktivFerfiBerletesLista.add(tag);
            }
            if ((tag.getTagNeme().equals("Nő") && tag.getVasaroltBerletNeve().contains("Időkorlátos") && (LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0)) || tag.getTagNeme().equals("Nő") && tag.getVasaroltBerletNeve().contains("Alkalmas") && (Integer.parseInt(tag.getMennyiAlkalom()) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) > 0 || LocalDate.parse(tag.getBerletLejaratiIdeje(), datumFormatum).compareTo(maiNap) == 0)) {
                aktivNoiBerletesLista.add(tag);
            }
        }

        if (!lejartBerletuTagok.isEmpty() || !ferfiTagok.isEmpty() || !alkalmasBerletuLejartTagok.isEmpty() || !idokorlatosBerletuLejartTagok.isEmpty() || !aktivBerletuTagok.isEmpty() || !alkalmasBerletuAktivTagok.isEmpty() || !idokorlatosBerletuAktivTagok.isEmpty() || !noiTagok.isEmpty() || !alkalmasBerletesTagok.isEmpty() || !idokorlatosBerletesTagok.isEmpty() || !alkalmasNoiBerletuTagok.isEmpty() || !alkalmasFerfiBerletuTagok.isEmpty() || !idokorlatosNoiBerletuTagok.isEmpty() || !idokorlatosFerfiBerletuTagok.isEmpty() || !lejartAlkalmasNoiBerletuTagok.isEmpty() || !lejartIdokorlatosNoiBerletuTagok.isEmpty() || !lejartAlkalmasFerfiBerletuTagok.isEmpty() || !lejartIdokorlatosFerfiBerletuTagok.isEmpty() || !lejartFerfiBerletuTagok.isEmpty() || !lejartNoiBerletuTagok.isEmpty() || !aktivAlkalmasNoiBerletuTagok.isEmpty() || !aktivIdokorlatosNoiBerletuTagok.isEmpty() || !aktivAlkalmasFerfiBerletuTagok.isEmpty() || !aktivIdokorlatosFerfiBerletuTagok.isEmpty() || !aktivFerfiBerletuTagok.isEmpty() || !aktivNoiBerletuTagok.isEmpty()) {
            lejartBerletuTagok.clear();
            ferfiTagok.clear();
            alkalmasBerletuLejartTagok.clear();
            idokorlatosBerletuLejartTagok.clear();
            aktivBerletuTagok.clear();
            alkalmasBerletuAktivTagok.clear();
            idokorlatosBerletuAktivTagok.clear();
            noiTagok.clear();

            alkalmasBerletesTagok.clear();
            idokorlatosBerletesTagok.clear();
            alkalmasNoiBerletuTagok.clear();
            alkalmasFerfiBerletuTagok.clear();
            idokorlatosNoiBerletuTagok.clear();
            idokorlatosFerfiBerletuTagok.clear();
            lejartAlkalmasNoiBerletuTagok.clear();
            lejartIdokorlatosNoiBerletuTagok.clear();
            lejartAlkalmasFerfiBerletuTagok.clear();
            lejartIdokorlatosFerfiBerletuTagok.clear();
            lejartFerfiBerletuTagok.clear();
            lejartNoiBerletuTagok.clear();

            aktivAlkalmasNoiBerletuTagok.clear();
            aktivIdokorlatosNoiBerletuTagok.clear();
            aktivAlkalmasFerfiBerletuTagok.clear();
            aktivIdokorlatosFerfiBerletuTagok.clear();
            aktivFerfiBerletuTagok.clear();
            aktivNoiBerletuTagok.clear();
        }

        lejartBerletuTagok.addAll(alkalmasLejartLista);
        lejartBerletuTagok.addAll(idokorlatosLejartLista);

        aktivBerletuTagok.addAll(alkalmasAktivLista);
        aktivBerletuTagok.addAll(idokorlatosAktivLista);

        alkalmasBerletuAktivTagok.addAll(alkalmasAktivLista);
        idokorlatosBerletuAktivTagok.addAll(idokorlatosAktivLista);

        alkalmasBerletuLejartTagok.addAll(alkalmasLejartLista);
        idokorlatosBerletuLejartTagok.addAll(idokorlatosLejartLista);

        noiTagok.addAll(noiTagokLista);
        ferfiTagok.addAll(ferfiTagokLista);

        alkalmasBerletesTagok.addAll(alkalmasBerletuLista);
        idokorlatosBerletesTagok.addAll(idokorlatosBerletuLista);

        alkalmasNoiBerletuTagok.addAll(alkalmasNoiBerletuLista);
        idokorlatosNoiBerletuTagok.addAll(idokorlatosNoiBerletuLista);

        alkalmasFerfiBerletuTagok.addAll(alkalmasFerfiBerletuLista);
        idokorlatosFerfiBerletuTagok.addAll(idokorlatosFerfiBerletuLista);

        lejartAlkalmasNoiBerletuTagok.addAll(alkalmasLejartNoiBerletuLista);
        lejartIdokorlatosNoiBerletuTagok.addAll(idokorlatosLejartNoiBerletuLista);

        lejartAlkalmasFerfiBerletuTagok.addAll(alkalmasLejartFerfiBerletuLista);
        lejartIdokorlatosFerfiBerletuTagok.addAll(idokorlatosLejartFerfiBerletuLista);

        lejartFerfiBerletuTagok.addAll(lejartFerfiBerletesLista);
        lejartNoiBerletuTagok.addAll(lejartNoiBerletesLista);

        aktivAlkalmasNoiBerletuTagok.addAll(alkalmasAktivNoiBerletuLista);
        aktivIdokorlatosNoiBerletuTagok.addAll(idokorlatosAktivNoiBerletuLista);
        aktivAlkalmasFerfiBerletuTagok.addAll(alkalmasAktivFerfiBerletuLista);
        aktivIdokorlatosFerfiBerletuTagok.addAll(idokorlatosAktivFerfiBerletuLista);
        aktivFerfiBerletuTagok.addAll(aktivFerfiBerletesLista);
        aktivNoiBerletuTagok.addAll(aktivNoiBerletesLista);

        lejartBerletuek = new FilteredList<>(lejartBerletuTagok, tagAdatok -> true);
        lejartAlkalmasBerletuek = new FilteredList<>(alkalmasBerletuLejartTagok, tagAdatok -> true);
        lejartIdokorlatosBerletuek = new FilteredList<>(idokorlatosBerletuLejartTagok, tagAdatok -> true);

        aktivBerletuek = new FilteredList<>(aktivBerletuTagok, tagAdatok -> true);
        aktivAlkalmasBerletuek = new FilteredList<>(alkalmasBerletuAktivTagok, tagAdatok -> true);
        aktivIdokorlatosBerletuek = new FilteredList<>(idokorlatosBerletuAktivTagok, tagAdatok -> true);


        nok = new FilteredList<>(noiTagok, tagAdatok -> true);
        ferfiak = new FilteredList<>(ferfiTagok, tagAdatok -> true);

        alkalmasBerletuek = new FilteredList<>(alkalmasBerletesTagok, tagAdatok -> true);
        idokorlatosBerletuek = new FilteredList<>(idokorlatosBerletesTagok, tagAdatok -> true);

        alkalmasNoBerletuek = new FilteredList<>(alkalmasNoiBerletuTagok, tagAdatok -> true);
        idokorlatosNoBerletuek = new FilteredList<>(idokorlatosNoiBerletuTagok, tagAdatok -> true);

        alkalmasFerfiBerletuek = new FilteredList<>(alkalmasFerfiBerletuTagok, tagAdatok -> true);
        idokorlatosFerfiBerletuek = new FilteredList<>(idokorlatosFerfiBerletuTagok, tagAdatok -> true);

        alkalmasNokLejart = new FilteredList<>(lejartAlkalmasNoiBerletuTagok, tagAdatok -> true);
        idokorlatosNokLejart = new FilteredList<>(lejartIdokorlatosNoiBerletuTagok, tagAdatok -> true);

        alkalmasFerfiLejart = new FilteredList<>(lejartAlkalmasFerfiBerletuTagok, tagAdatok -> true);
        idokorlatosFerfiLejart = new FilteredList<>(lejartIdokorlatosFerfiBerletuTagok, tagAdatok -> true);

        ferfiakLejart = new FilteredList<>(lejartFerfiBerletuTagok, tagAdatok -> true);
        nokLejart = new FilteredList<>(lejartNoiBerletuTagok, tagAdatok -> true);

        alkalmasNokAktiv = new FilteredList<>(aktivAlkalmasNoiBerletuTagok, tagAdatok -> true);
        idokorlatosNokAktiv = new FilteredList<>(aktivIdokorlatosNoiBerletuTagok, tagAdatok -> true);

        alkalmasFerfiAktiv = new FilteredList<>(aktivAlkalmasFerfiBerletuTagok, tagAdatok -> true);
        idokorlatosFerfiAktiv = new FilteredList<>(aktivIdokorlatosFerfiBerletuTagok, tagAdatok -> true);

        ferfiakAktiv = new FilteredList<>(aktivFerfiBerletuTagok, tagAdatok -> true);
        nokAktiv = new FilteredList<>(aktivNoiBerletuTagok, tagAdatok -> true);

    }
}
