package hu.unideb.inf.kondibazis.ui.kiegeszito;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelefonszamHitelesíto {

    private static Pattern minta;
    private static Matcher ma;

    // 11
    private static final String MOBIL_TELEFONSZAM_MINTA = "(\\d{2}-)?(\\d{3}-)?\\d{4}";

    // 10
    private static final String VEZETEKES_TELEFONSZAM_MINTA = "(\\d{2}-)?(\\d{3}-)?\\d{3}";

    public static boolean mobilHitelesitese(String vizsgalandoSzoveg) {
        minta = Pattern.compile(MOBIL_TELEFONSZAM_MINTA);
        ma = minta.matcher(vizsgalandoSzoveg);
        return ma.matches();
    }

    public static boolean vezetekesHitelesitese(String vizsgalandoSzoveg) {
        minta = Pattern.compile(VEZETEKES_TELEFONSZAM_MINTA);
        ma = minta.matcher(vizsgalandoSzoveg);
        return ma.matches();
    }
}
