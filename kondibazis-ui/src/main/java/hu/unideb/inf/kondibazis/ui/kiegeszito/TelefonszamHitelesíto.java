package hu.unideb.inf.kondibazis.ui.kiegeszito;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex kifejezés segítségével viszgálja hogy a megadott telefonszám helyes-e.
 */
public class TelefonszamHitelesíto {

    /**
     * A minta amire illeszkedni kell.
     */
    private static Pattern minta;

    /**
     * Amire egyezik.
     */
    private static Matcher talalat;

    /**
     * A minta amire a mobil telefonszámnak illeszkednie kell.
     */
    private static final String MOBIL_TELEFONSZAM_MINTA = "(\\d{2}-)?(\\d{3}-)?\\d{4}";

    /**
     * A minta amire a vezetékes telefonszámnak illeszkednie kell.
     */
    private static final String VEZETEKES_TELEFONSZAM_MINTA = "(\\d{2}-)?(\\d{3}-)?\\d{3}";

    /**
     * Visszaadja hogy a beadott telefonszám illeszkedik-e a mintára vagy nem.
     * Ha Igaz értéket kapunk akkor illeszkedik, ha hamis értéket kapunk akkor nem illeszkedik.
     *
     * @param vizsgalandoSzoveg Az a szöveg amit vizsgálunk.
     * @return Igaz vagy hamis értéket adunk vissza.
     */
    public static boolean mobilHitelesitese(String vizsgalandoSzoveg) {
        minta = Pattern.compile(MOBIL_TELEFONSZAM_MINTA);
        talalat = minta.matcher(vizsgalandoSzoveg);
        return talalat.matches();
    }

    /**
     * Visszaadja hogy a beadott telefonszám illeszkedik-e a mintára vagy nem.
     * Ha Igaz értéket kapunk akkor illeszkedik, ha hamis értéket kapunk akkor nem illeszkedik.
     *
     * @param vizsgalandoSzoveg Az a szöveg amit vizsgálunk.
     * @return Igaz vagy hamis értéket adunk vissza.
     */
    public static boolean vezetekesHitelesitese(String vizsgalandoSzoveg) {
        minta = Pattern.compile(VEZETEKES_TELEFONSZAM_MINTA);
        talalat = minta.matcher(vizsgalandoSzoveg);
        return talalat.matches();
    }
}
