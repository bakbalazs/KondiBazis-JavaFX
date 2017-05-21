package hu.unideb.inf.kondibazis.szolg.test;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremElerhetoseg;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremElerhetosegTarolo;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremElerhetosegSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremSzolgaltatasImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KonditeremElerhetosegTest {

    @Mock
    private KonditeremElerhetosegTarolo konditeremElerhetosegTarolo;

    @Spy
    @InjectMocks
    private KonditeremElerhetosegSzolgaltatasImpl konditeremElerhetosegSzolgaltatas;

    @Spy
    @InjectMocks
    private KonditeremSzolgaltatasImpl konditeremSzolgaltatas;

    private static KonditeremElerhetoseg tesztElerhetoseg1;

    private static KonditeremElerhetoseg tesztElerhetoseg2;

    private static Konditerem tesztKonditerem;

    @BeforeClass
    public static void setUpClass(){

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
    public void _1letrehozKonditeremElerhetoseget(){

    }

    @Test
    public void _2keresKonditeremElerhetoseget(){

    }

    @Test
    public void _3frissitKonditeremElerhetoseget(){

    }

}
