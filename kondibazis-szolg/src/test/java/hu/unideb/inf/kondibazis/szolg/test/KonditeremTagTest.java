package hu.unideb.inf.kondibazis.szolg.test;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagTarolo;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremBerletSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremTagSzolgaltatasImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KonditeremTagTest {

    @Mock
    private KonditeremTagTarolo konditeremTagTarolo;

    @Spy
    @InjectMocks
    private KonditeremTagSzolgaltatasImpl konditeremTagSzolgaltatas;

    @Spy
    @InjectMocks
    private KonditeremSzolgaltatasImpl konditeremSzolgaltatas;

    @Spy
    @InjectMocks
    private KonditeremBerletSzolgaltatasImpl konditeremBerletSzolgaltatas;

    private static KonditeremTag tesztKonditeremTag;

    private static Konditerem tesztKonditerem;

    private static KonditeremBerlet tesztBerlet1;

    private static KonditeremBerlet tesztBerlet2;

    @BeforeClass
    public static void setUpClass() {
//        KonditeremTag ujTag1 = new KonditeremTag();
//        ujTag1.setId(1L);
//        ujTag1.setTagVezeteknev("Ujtag1Vezeteknev");
//        ujTag1.setTagKeresztnev("Ujtag1Keresztnev");
//        ujTag1.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
//        ujTag1.setTagNeme("Férfi");
////        ujTag1.setTagSzuletesidatuma();
////        ujTag1.setTagKora();
////        ujTag1.setVasaroltBerletNeve();
//        ujTag1.setVasaroltBerletTipusa("Havi");
////        ujTag1.setBerletVasarlasideje();
////        ujTag1.setBerletVasarlasideje();
//        ujTag1.setTagVarosa("Varos1");
//        ujTag1.setTagMegyeje("Megye1");
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

//        Mockito.when(konditeremTarolo.findByFelhasznalonev(Mockito.any(String.class)))
//                .thenAnswer(invocation -> {
//                    Object[] args = invocation.getArguments();
//                    if (args[0].equals("TesztKonditerem")) {
//                        return tesztKonditerem;
//                    } else {
//                        return null;
//                    }
//                });
//
//        Mockito.when(konditeremTarolo.save(Mockito.any(Konditerem.class)))
//                .thenAnswer(invocation -> {
//                    Object[] args = invocation.getArguments();
//                    if (((Konditerem) args[0]).getId() == null) {
//                        ((Konditerem) args[0]).setId(87L);
//                    }
//                    return args[0];
//                });

    }

    @Test
    public void _1letrehozKonditeremTagotTeszt() {

    }

    @Test
    public void _2keresKonditeremTagokTeszt() {

    }

    @Test
    public void _3frissitKonditeremTagotTeszt() {

    }

    @Test
    public void _4konditeremOsszesTagjaTeszt() {

    }

    @Test
    public void _5konditeremTagBerlete() {

    }
}
