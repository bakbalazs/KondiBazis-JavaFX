package hu.unideb.inf.kondibazis.szolg.test;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremElerhetoseg;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremElerhetosegTarolo;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremElerhetosegSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremElerhetosegVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KonditeremElerhetosegTest {

    @Mock
    private KonditeremElerhetosegTarolo konditeremElerhetosegTarolo;

    @Spy
    @InjectMocks
    private KonditeremElerhetosegSzolgaltatasImpl konditeremElerhetosegSzolgaltatas;

    private static Konditerem tesztKonditeremA;

    private static Konditerem tesztKonditeremB;

    private static KonditeremElerhetoseg tesztElerhetosegA;

    private static KonditeremElerhetoseg tesztElerhetosegB;

    private static KonditeremElerhetoseg tesztElerhetosegC;

    private static List<KonditeremElerhetoseg> tesztElerhetosegeiA = new ArrayList<>();

    private static List<KonditeremElerhetoseg> tesztElerhetosegeiB = new ArrayList<>();

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
        ujKonditerem1.setKonditeremElerhetosegek(new ArrayList<>());

        tesztKonditeremA = ujKonditerem1;

        Konditerem ujKonditerem2 = new Konditerem();
        ujKonditerem2.setId(2L);
        ujKonditerem2.setKonditeremNeve("TezstKonditeremNev2");
        ujKonditerem2.setFelhasznalonev("TesztKonditerem2");
        ujKonditerem2.setJelszo("TesztJelszo2");
        ujKonditerem2.setRegisztralasDatuma(LocalDate.now());
        ujKonditerem2.setKonditeremTagok(new ArrayList<>());
        ujKonditerem2.setKonditeremBerletek(new ArrayList<>());
        ujKonditerem2.setKonditeremElerhetosegek(new ArrayList<>());

        tesztKonditeremB = ujKonditerem2;

        KonditeremElerhetoseg ujKonditeremElerhetoseg1 = new KonditeremElerhetoseg();
        ujKonditeremElerhetoseg1.setId(3L);
        ujKonditeremElerhetoseg1.setKonditeremVarosanakIranyitoSzama(2010);
        ujKonditeremElerhetoseg1.setKonditeremVarosanakNeve("VarosNeve");
        ujKonditeremElerhetoseg1.setKonditeremVarosanakMegyeje("MegyeNeve");
        ujKonditeremElerhetoseg1.setKonditeremCime("KodniteremCíme1");
        ujKonditeremElerhetoseg1.setKonditremTelefonszam("+12-34-567-8910");
        ujKonditeremElerhetoseg1.setKonditremEmailCim("E-mail cím");
        ujKonditeremElerhetoseg1.setKonditeremWeboldalLink("WeboldalLink");
        ujKonditeremElerhetoseg1.setKonditeremFacebookOldalLink("FacebookOldalLink");
        ujKonditeremElerhetoseg1.setKonditerem(tesztKonditeremA);

        tesztElerhetosegA = ujKonditeremElerhetoseg1;

        KonditeremElerhetoseg ujKonditeremElerhetoseg2 = new KonditeremElerhetoseg();
        ujKonditeremElerhetoseg2.setId(4L);
        ujKonditeremElerhetoseg2.setKonditeremVarosanakIranyitoSzama(2010);
        ujKonditeremElerhetoseg2.setKonditeremVarosanakNeve("VarosNeve");
        ujKonditeremElerhetoseg2.setKonditeremVarosanakMegyeje("MegyeNeve");
        ujKonditeremElerhetoseg2.setKonditeremCime("KodniteremCíme1");
        ujKonditeremElerhetoseg2.setKonditremTelefonszam("+12-34-567-8910");
        ujKonditeremElerhetoseg2.setKonditremEmailCim("E-mail cím");
        ujKonditeremElerhetoseg2.setKonditeremWeboldalLink("WeboldalLink");
        ujKonditeremElerhetoseg2.setKonditeremFacebookOldalLink("FacebookOldalLink");
        ujKonditeremElerhetoseg2.setKonditerem(tesztKonditeremA);

        tesztElerhetosegB = ujKonditeremElerhetoseg2;

        KonditeremElerhetoseg ujKonditeremElerhetoseg3 = new KonditeremElerhetoseg();
        ujKonditeremElerhetoseg3.setId(5L);
        ujKonditeremElerhetoseg3.setKonditeremVarosanakIranyitoSzama(2010);
        ujKonditeremElerhetoseg3.setKonditeremVarosanakNeve("VarosNeve");
        ujKonditeremElerhetoseg3.setKonditeremVarosanakMegyeje("MegyeNeve");
        ujKonditeremElerhetoseg3.setKonditeremCime("KodniteremCíme1");
        ujKonditeremElerhetoseg3.setKonditremTelefonszam("+12-34-567-8910");
        ujKonditeremElerhetoseg3.setKonditremEmailCim("E-mail cím");
        ujKonditeremElerhetoseg3.setKonditeremWeboldalLink("WeboldalLink");
        ujKonditeremElerhetoseg3.setKonditeremFacebookOldalLink("FacebookOldalLink");
        ujKonditeremElerhetoseg3.setKonditerem(tesztKonditeremA);

        tesztElerhetosegC = ujKonditeremElerhetoseg3;

        tesztKonditeremA.getKonditeremElerhetosegek().addAll(Arrays.asList(tesztElerhetosegA, tesztElerhetosegB, tesztElerhetosegC));

        tesztKonditeremB.getKonditeremElerhetosegek().add(tesztElerhetosegC);

        tesztElerhetosegeiA.addAll(Arrays.asList(tesztElerhetosegA, tesztElerhetosegB, tesztElerhetosegC));

        tesztElerhetosegeiB.add(tesztElerhetosegC);

    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(konditeremElerhetosegTarolo.save(Mockito.any(KonditeremElerhetoseg.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((KonditeremElerhetoseg) args[0]).getId() == null) {
                        ((KonditeremElerhetoseg) args[0]).setId(91L);
                    }
                    return args[0];
                });

        Mockito.when(konditeremElerhetosegTarolo.findOne(Mockito.any(Long.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    switch (((Long) args[0]).intValue()) {
                        case 7:
                            return tesztElerhetosegeiA.get(0);
                        case 8:
                            return tesztElerhetosegeiB.get(1);
                        default:
                            return null;
                    }
                });

        Mockito.when(konditeremElerhetosegTarolo.findByKonditerem(Mockito.any(Konditerem.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((Konditerem) args[0]).getId().equals(tesztKonditeremA.getId())) {
                        return tesztElerhetosegeiA;
                    } else if (((Konditerem) args[0]).getId().equals(tesztKonditeremB.getId())) {
                        return tesztElerhetosegeiB;
                    } else {
                        return null;
                    }
                });

        Mockito.when(konditeremElerhetosegTarolo.findAll())
                .thenAnswer(invocation -> Arrays.asList(tesztElerhetosegA, tesztElerhetosegB, tesztElerhetosegC));
    }

    @Test
    public void letrehozKonditeremElerhetoseget() {

        KonditeremElerhetosegVo ujKonditeremElerhetoseg = new KonditeremElerhetosegVo();
        ujKonditeremElerhetoseg.setKonditeremVarosanakIranyitoSzama(2010);
        ujKonditeremElerhetoseg.setKonditeremVarosanakNeve("VarosNeve");
        ujKonditeremElerhetoseg.setKonditeremVarosanakMegyeje("MegyeNeve");
        ujKonditeremElerhetoseg.setKonditeremCime("KodniteremCíme1");
        ujKonditeremElerhetoseg.setKonditremTelefonszam("+12-34-567-8910");
        ujKonditeremElerhetoseg.setKonditremEmailCim("E-mail cím");
        ujKonditeremElerhetoseg.setKonditeremWeboldalLink("WeboldalLink");
        ujKonditeremElerhetoseg.setKonditeremFacebookOldalLink("FacebookOldalLink");
        ujKonditeremElerhetoseg.setKonditerem(KonditeremMapper.toVo(tesztKonditeremA));

        KonditeremElerhetosegVo mentett = konditeremElerhetosegSzolgaltatas.letrehozElerhetoseget(ujKonditeremElerhetoseg);

        Assert.assertNotNull(mentett);
        Assert.assertNotNull(mentett.getId());

    }

    @Test
    public void frissitKonditeremElerhetoseget() {

        KonditeremElerhetosegVo ujKonditeremElerhetoseg = new KonditeremElerhetosegVo();
        ujKonditeremElerhetoseg.setKonditeremVarosanakIranyitoSzama(2010);
        ujKonditeremElerhetoseg.setKonditeremVarosanakNeve("VarosNeve");
        ujKonditeremElerhetoseg.setKonditeremVarosanakMegyeje("MegyeNeve");
        ujKonditeremElerhetoseg.setKonditeremCime("KodniteremCíme2");
        ujKonditeremElerhetoseg.setKonditremTelefonszam("+12-34-567-8910");
        ujKonditeremElerhetoseg.setKonditremEmailCim("E-mail cím");
        ujKonditeremElerhetoseg.setKonditeremWeboldalLink("WeboldalLink");
        ujKonditeremElerhetoseg.setKonditeremFacebookOldalLink("FacebookOldalLink");
        ujKonditeremElerhetoseg.setKonditerem(KonditeremMapper.toVo(tesztKonditeremA));

        KonditeremElerhetosegVo mentett = konditeremElerhetosegSzolgaltatas.letrehozElerhetoseget(ujKonditeremElerhetoseg);

        mentett.setKonditeremVarosanakNeve("Módosított város név");

        KonditeremElerhetosegVo frissitett = konditeremElerhetosegSzolgaltatas.frissitElerhetoseget(mentett);

        Assert.assertEquals("Módosított város név", frissitett.getKonditeremVarosanakNeve());
    }

    @Test
    public void keresKonditeremOsszesElerhetosege() {

        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremA);

        List<KonditeremElerhetosegVo> konditeremElerhetosegei = konditeremElerhetosegSzolgaltatas.konditremElerhetosegei(konditerem);

        Assert.assertNotNull(konditeremElerhetosegei);
        Assert.assertEquals(3, konditeremElerhetosegei.size());
    }

}
