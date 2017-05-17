package hu.unideb.inf.kondibazis.szolg.test;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremBerletTarolo;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremBerletSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremBerletMapper;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KonditeremBerletTest {

    @Mock
    private KonditeremBerletTarolo konditeremBerletTarolo;

    @Mock
    private KonditeremTarolo konditeremTarolo;

    @Spy
    @InjectMocks
    private KonditeremBerletSzolgaltatasImpl konditeremBerletSzolgaltatas;

    @Spy
    @InjectMocks
    private KonditeremSzolgaltatasImpl konditeremSzolgaltatas;

    private static Konditerem tesztKonditeremA;

    private static Konditerem tesztKonditeremB;

    private static KonditeremBerlet tesztKonditeremBerletA;

    private static KonditeremBerlet tesztKonditeremBerletB;

    private static KonditeremBerlet tesztKonditeremBerletC;

    private static List<KonditeremBerlet> tesztKonditeremABerletei = new ArrayList<>();

    private static List<KonditeremBerlet> tesztKonditeremBBerletei = new ArrayList<>();

    @BeforeClass
    public static void setUpClass() {

        Konditerem ujKonditerem1 = new Konditerem();
        ujKonditerem1.setId(1L);
        ujKonditerem1.setKonditeremNeve("TezstKonditeremNev");
        ujKonditerem1.setFelhasznalonev("TesztKonditerem");
        ujKonditerem1.setJelszo("TesztJelszo");
        ujKonditerem1.setRegisztralasDatuma(LocalDate.now());
        ujKonditerem1.setKonditeremTagok(new ArrayList<>());
        ujKonditerem1.setKonditeremBerletek(new ArrayList<>());

        tesztKonditeremA = ujKonditerem1;

        Konditerem ujKonditerem2 = new Konditerem();
        ujKonditerem2.setId(2L);
        ujKonditerem2.setKonditeremNeve("TezstKonditeremNev2");
        ujKonditerem2.setFelhasznalonev("TesztKonditerem2");
        ujKonditerem2.setJelszo("TesztJelszo2");
        ujKonditerem2.setRegisztralasDatuma(LocalDate.now());
        ujKonditerem2.setKonditeremTagok(new ArrayList<>());
        ujKonditerem2.setKonditeremBerletek(new ArrayList<>());

        tesztKonditeremB = ujKonditerem2;

        KonditeremBerlet ujKonditeremBerlet = new KonditeremBerlet();
        ujKonditeremBerlet.setId(3L);
        ujKonditeremBerlet.setBerletNeve("TesztHavi");
        ujKonditeremBerlet.setBerletAra(10000);
        ujKonditeremBerlet.setBerletTipusa("Havi");
        ujKonditeremBerlet.setMennyiAlkalom(0);
        ujKonditeremBerlet.setMennyiHonap(1);
        ujKonditeremBerlet.setMennyiNap(0);
        ujKonditeremBerlet.setKonditerem(tesztKonditeremA);

        tesztKonditeremBerletA = ujKonditeremBerlet;

        KonditeremBerlet ujKonditeremBerlet2 = new KonditeremBerlet();
        ujKonditeremBerlet2.setId(4L);
        ujKonditeremBerlet2.setBerletNeve("Teszt2Napos");
        ujKonditeremBerlet2.setBerletAra(10000);
        ujKonditeremBerlet2.setBerletTipusa("2 napos");
        ujKonditeremBerlet2.setMennyiAlkalom(0);
        ujKonditeremBerlet2.setMennyiHonap(0);
        ujKonditeremBerlet2.setMennyiNap(2);
        ujKonditeremBerlet2.setKonditerem(tesztKonditeremA);

        tesztKonditeremBerletB = ujKonditeremBerlet2;

        KonditeremBerlet ujKonditeremBerlet3 = new KonditeremBerlet();
        ujKonditeremBerlet3.setId(5L);
        ujKonditeremBerlet3.setBerletNeve("Teszt5Alkalmas");
        ujKonditeremBerlet3.setBerletAra(1000);
        ujKonditeremBerlet3.setBerletTipusa("5 alkalmas");
        ujKonditeremBerlet3.setMennyiAlkalom(5);
        ujKonditeremBerlet3.setMennyiHonap(0);
        ujKonditeremBerlet3.setMennyiNap(0);
        ujKonditeremBerlet3.setKonditerem(tesztKonditeremA);

        tesztKonditeremBerletC = ujKonditeremBerlet3;

        tesztKonditeremA.getKonditeremBerletek().addAll(Arrays.asList(tesztKonditeremBerletA, tesztKonditeremBerletB, tesztKonditeremBerletC));

        tesztKonditeremB.getKonditeremBerletek().addAll(Arrays.asList(tesztKonditeremBerletA, tesztKonditeremBerletB));

        tesztKonditeremABerletei.addAll(Arrays.asList(tesztKonditeremBerletA, tesztKonditeremBerletB, tesztKonditeremBerletC));

        tesztKonditeremBBerletei.add(tesztKonditeremBerletA);

    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(konditeremBerletTarolo.save(Mockito.any(KonditeremBerlet.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((KonditeremBerlet) args[0]).getId() == null) {
                        ((KonditeremBerlet) args[0]).setId(91L);
                    }
                    return args[0];
                });

        Mockito.when(konditeremBerletTarolo.findOne(Mockito.any(Long.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    switch (((Long) args[0]).intValue()) {
                        case 7:
                            return tesztKonditeremABerletei.get(0);
                        case 8:
                            return tesztKonditeremABerletei.get(1);
                        case 9:
                            return tesztKonditeremABerletei.get(2);
                        default:
                            return null;
                    }
                });

        Mockito.when(konditeremBerletTarolo.findByKonditerem(Mockito.any(Konditerem.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((Konditerem) args[0]).getId().equals(tesztKonditeremA.getId())) {
                        return tesztKonditeremABerletei;
                    } else if (((Konditerem) args[0]).getId().equals(tesztKonditeremB.getId())) {
                        return tesztKonditeremBBerletei;
                    } else {
                        return null;
                    }
                });

        Mockito.when(konditeremBerletTarolo.findAll())
                .thenAnswer(invocation -> Arrays.asList(tesztKonditeremBerletA, tesztKonditeremBerletB, tesztKonditeremBerletC));

    }

    @Test
    public void _1letrehozKonditeremBerletetTeszt() {
        KonditeremBerletVo ujKonditeremBerlet = new KonditeremBerletVo();

        ujKonditeremBerlet.setBerletNeve("Új bérlet");
        ujKonditeremBerlet.setBerletTipusa("Uj bérlet típusa");
        ujKonditeremBerlet.setBerletAra(1000);
        ujKonditeremBerlet.setMennyiHonap(1);
        ujKonditeremBerlet.setMennyiNap(0);
        ujKonditeremBerlet.setMennyiAlkalom(0);
        ujKonditeremBerlet.setKonditerem(KonditeremMapper.toVo(tesztKonditeremA));

        KonditeremBerletVo mentett = konditeremBerletSzolgaltatas.letrehozBerletet(ujKonditeremBerlet);

        Assert.assertNotNull(mentett);
        Assert.assertNotNull(mentett.getId());
    }

    @Test
    public void _2frissitKonditeremBerletTeszt() {
        KonditeremBerletVo ujKonditeremBerlet = new KonditeremBerletVo();

        ujKonditeremBerlet.setBerletNeve("Új bérlet");
        ujKonditeremBerlet.setBerletTipusa("Uj bérlet típusa");
        ujKonditeremBerlet.setBerletAra(1000);
        ujKonditeremBerlet.setMennyiHonap(1);
        ujKonditeremBerlet.setMennyiNap(0);
        ujKonditeremBerlet.setMennyiAlkalom(0);
        ujKonditeremBerlet.setKonditerem(KonditeremMapper.toVo(tesztKonditeremA));

        KonditeremBerletVo mentett = konditeremBerletSzolgaltatas.letrehozBerletet(ujKonditeremBerlet);

        mentett.setBerletNeve("Módosított név");

        KonditeremBerletVo frissitett = konditeremBerletSzolgaltatas.frissitKonditeremBerletet(mentett);

        Assert.assertEquals("Módosított név", frissitett.getBerletNeve());
    }

    @Test
    public void _3keresKonditeremBerletTeszt() {

        KonditeremBerletVo leszIlyenBerlet = konditeremBerletSzolgaltatas.keresBerletet(7L);

        Assert.assertNotNull(leszIlyenBerlet);

        KonditeremBerletVo nemLeszIlyenBerlet = konditeremBerletSzolgaltatas.keresBerletet(20L);

        Assert.assertNull(nemLeszIlyenBerlet);
    }

    @Test
    public void _4keresKonditeremOsszesBerelete() {

        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremA);

        List<KonditeremBerletVo> konditeremBerletei = konditeremBerletSzolgaltatas.konditeremOsszesBerlete(konditerem);

        Assert.assertNotNull(konditeremBerletei);
        Assert.assertEquals(3, konditeremBerletei.size());
    }

    @Test(expected=NullPointerException.class)
    public void _5torolKonditeremBerletTeszt(){

        try {
            konditeremBerletSzolgaltatas.torolKonditeremBerletet(KonditeremBerletMapper.toVo(tesztKonditeremABerletei.get(0)));
        } catch (NullPointerException npe) {
            Assert.fail();
        }

        KonditeremBerletVo berlet = new KonditeremBerletVo();

        konditeremBerletSzolgaltatas.torolKonditeremBerletet(berlet);

    }

}
