package hu.unideb.inf.kondibazis.ui.kiegeszito;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex kifejezés segítségével viszgálja hogy a megadott e-mailcím helyes-e.
 */
public class EmailHitelesito {

    /**
     * A minta amire az e-mail címnek illeszkednie kell.
     */
    private static final String EMAIL_MINTA =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Visszaadja hogy a beadott e-mailcím  illeszkedik-e a mintára vagy nem.
     * Ha Igaz értéket kapunk akkor illeszkedik, ha hamis értéket kapunk akkor nem illeszkedik.
     *
     * @param beadottSzoveg Az a szöveg amit vizsgálunk.
     * @return Igaz vagy hamis értéket adunk vissza.
     */
    public static boolean ervenyesites(String beadottSzoveg) {

        Pattern minta = Pattern.compile(EMAIL_MINTA);

        Matcher egyezes = minta.matcher(beadottSzoveg);

        return egyezes.matches();
    }

}
