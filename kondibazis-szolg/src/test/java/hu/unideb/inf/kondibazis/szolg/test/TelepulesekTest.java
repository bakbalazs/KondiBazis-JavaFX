package hu.unideb.inf.kondibazis.szolg.test;

import hu.unideb.inf.kondibazis.db.entitas.Telepulesek;
import hu.unideb.inf.kondibazis.db.tarolo.TelepulesekTarolo;
import hu.unideb.inf.kondibazis.szolg.impl.TelepulesekSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.vo.TelepulesekVo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelepulesekTest {

    @Mock
    private TelepulesekTarolo telepulesekTarolo;

    @Spy
    @InjectMocks
    private TelepulesekSzolgaltatasImpl telepulesekSzolgaltatas;

    private static Telepulesek telepulesekA;

    private static Telepulesek telepulesekB;

    private static Telepulesek telepulesekC;

    private static Telepulesek telepulesekD;

    private static List<Telepulesek> telepulesek = new ArrayList<>();


    @BeforeClass
    public static void setUpClass() {
        Telepulesek telepulesek1 = new Telepulesek();
        telepulesek1.setId(1L);
        telepulesek1.setIranyitoszam(2011);
        telepulesek1.setMegye("Megye Neve1");
        telepulesek1.setTelepulesnev("Település név1");

        telepulesekA = telepulesek1;

        Telepulesek telepulesek2 = new Telepulesek();
        telepulesek2.setId(2L);
        telepulesek2.setIranyitoszam(2012);
        telepulesek2.setMegye("Megye Neve2");
        telepulesek2.setTelepulesnev("Település név2");

        telepulesekB = telepulesek2;

        Telepulesek telepulesek3 = new Telepulesek();
        telepulesek3.setId(3L);
        telepulesek3.setIranyitoszam(2013);
        telepulesek3.setMegye("Megye Neve3");
        telepulesek3.setTelepulesnev("Település név3");

        telepulesekC = telepulesek3;

        Telepulesek telepulesek4 = new Telepulesek();
        telepulesek4.setId(4L);
        telepulesek4.setIranyitoszam(2014);
        telepulesek4.setMegye("Megye Neve4");
        telepulesek4.setTelepulesnev("Település név4");

        telepulesekD = telepulesek4;

        telepulesek.addAll(Arrays.asList(telepulesek1, telepulesek2, telepulesek3, telepulesek4));

    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(telepulesekTarolo.save(Mockito.any(Telepulesek.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((Telepulesek) args[0]).getId() == null) {
                        ((Telepulesek) args[0]).setId(91L);
                    }
                    return args[0];
                });

        Mockito.when(telepulesekTarolo.findByiranyitoszam(Mockito.any(Integer.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (args[0].equals(2010)) {
                        return telepulesekA;
                    } else {
                        return null;
                    }
                });

        Mockito.when(telepulesekTarolo.findBytelepulesnev(Mockito.any(String.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (args[0].equals("Település név1")) {
                        return telepulesekA;
                    } else {
                        return null;
                    }
                });


        Mockito.when(telepulesekTarolo.findAll())
                .thenAnswer(invocation -> Arrays.asList(telepulesekA, telepulesekB, telepulesekC, telepulesekD));

    }

    @Test
    public void keresIranyitoszamotTeszt() {

        TelepulesekVo vanIlyen = telepulesekSzolgaltatas.keresIranyitoszamot(2010);
        Assert.assertNotNull(vanIlyen);

        TelepulesekVo nincsIlyen = telepulesekSzolgaltatas.keresIranyitoszamot(2222);
        Assert.assertNull(nincsIlyen);

    }

    @Test
    public void osszesTelepulesTeszt() {
        List<TelepulesekVo> osszesTelepules = telepulesekSzolgaltatas.osszesTelepules();
        Assert.assertNotNull(osszesTelepules.size());
        Assert.assertEquals(4, osszesTelepules.size());
    }

}
