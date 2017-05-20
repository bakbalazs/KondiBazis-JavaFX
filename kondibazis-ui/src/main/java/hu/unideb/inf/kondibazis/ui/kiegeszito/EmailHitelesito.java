package hu.unideb.inf.kondibazis.ui.kiegeszito;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailHitelesito {

    /**
     *
     */
    private static final String EMAIL_MINTA =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     *
     * @param beadottSzoveg
     * @return
     */
    public static boolean ervenyesites(String beadottSzoveg){

        Pattern minta = Pattern.compile(EMAIL_MINTA);

        Matcher egyezes = minta.matcher(beadottSzoveg);

        return egyezes.matches();
    }

}
