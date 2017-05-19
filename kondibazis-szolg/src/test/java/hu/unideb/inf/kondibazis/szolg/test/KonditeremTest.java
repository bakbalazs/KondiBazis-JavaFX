package hu.unideb.inf.kondibazis.szolg.test;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KonditeremTest {

    private static final Logger logger = LoggerFactory.getLogger(KonditeremTest.class);

    @Mock
    private KonditeremTarolo konditeremTarolo;

    @Spy
    @InjectMocks
    private KonditeremSzolgaltatasImpl konditeremSzolgaltatas;

    private static Konditerem tesztKonditerem;

    @BeforeClass
    public static void setUpClass() {
        Konditerem ujKonditerem = new Konditerem();
        ujKonditerem.setId(1L);
        ujKonditerem.setKonditeremNeve("TezstKonditeremNev");
        ujKonditerem.setFelhasznalonev("TesztKonditerem");
        ujKonditerem.setJelszo("TesztJelszo");
        ujKonditerem.setRegisztralasDatuma(LocalDate.now());
        ujKonditerem.setKonditeremTagok(new ArrayList<>());
        ujKonditerem.setKonditeremBerletek(new ArrayList<>());

        tesztKonditerem = ujKonditerem;

        KonditeremBerlet ujKonditeremBerlet = new KonditeremBerlet();
        ujKonditeremBerlet.setId(2L);
        ujKonditeremBerlet.setBerletNeve("TesztHavi");
        ujKonditeremBerlet.setBerletAra(10000);
        ujKonditeremBerlet.setBerletTipusa("Havi");
        ujKonditeremBerlet.setMennyiAlkalom(0);
        ujKonditeremBerlet.setMennyiHonap(1);
        ujKonditeremBerlet.setMennyiNap(0);
        ujKonditeremBerlet.setKonditerem(tesztKonditerem);

        KonditeremBerlet ujKonditeremBerlet2 = new KonditeremBerlet();
        ujKonditeremBerlet2.setId(3L);
        ujKonditeremBerlet2.setBerletNeve("Teszt2Napos");
        ujKonditeremBerlet2.setBerletAra(10000);
        ujKonditeremBerlet2.setBerletTipusa("2 napos");
        ujKonditeremBerlet2.setMennyiAlkalom(2);
        ujKonditeremBerlet2.setMennyiHonap(0);
        ujKonditeremBerlet2.setMennyiNap(0);
        ujKonditeremBerlet2.setKonditerem(tesztKonditerem);

        KonditeremTag ujTag1 = new KonditeremTag();
        ujTag1.setId(4L);
        ujTag1.setTagVezeteknev("Ujtag1Vezeteknev");
        ujTag1.setTagKeresztnev("Ujtag1Keresztnev");
        ujTag1.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag1.setTagNeme("Férfi");
//        ujTag1.setTagSzuletesidatuma();
//        ujTag1.setTagKora();
//        ujTag1.setVasaroltBerletNeve();
        ujTag1.setVasaroltBerletTipusa("Havi");
//        ujTag1.setBerletVasarlasideje();
//        ujTag1.setBerletVasarlasideje();
        ujTag1.setTagVarosa("Varos1");
        ujTag1.setTagMegyeje("Megye1");

        KonditeremTag ujTag2 = new KonditeremTag();
        ujTag2.setId(5L);
//        ujTag2.setTagVezeteknev();
//        ujTag2.setTagKeresztnev();
//        ujTag2.setTagNeve();
        ujTag2.setTagNeme("Férfi");
//        ujTag2.setTagSzuletesidatuma();
//        ujTag2.setTagKora();
//        ujTag2.setVasaroltBerletNeve();
        ujTag2.setVasaroltBerletTipusa("Havi");
//        ujTag2.setBerletVasarlasideje();
//        ujTag2.setBerletVasarlasideje();
        ujTag2.setTagVarosa("Varos1");
        ujTag2.setTagMegyeje("Megye2");

        KonditeremTag ujTag3 = new KonditeremTag();
        ujTag3.setId(6L);
//        ujTag3.setTagVezeteknev();
//        ujTag3.setTagKeresztnev();
//        ujTag3.setTagNeve();
        ujTag3.setTagNeme("Férfi");
//        ujTag3.setTagSzuletesidatuma();
//        ujTag3.setTagKora();
//        ujTag3.setVasaroltBerletNeve();
        ujTag3.setVasaroltBerletTipusa("Napos");
//        ujTag3.setBerletVasarlasideje();
//        ujTag3.setBerletVasarlasideje();
        ujTag3.setTagVarosa("Varos2");
        ujTag3.setTagMegyeje("Megye2");

        KonditeremTag ujTag4 = new KonditeremTag();
        ujTag4.setId(7L);
//        ujTag4.setTagVezeteknev();
//        ujTag4.setTagKeresztnev();
//        ujTag4.setTagNeve();
        ujTag4.setTagNeme("Nő");
//        ujTag4.setTagSzuletesidatuma();
//        ujTag4.setTagKora();
//        ujTag4.setVasaroltBerletNeve();
        ujTag4.setVasaroltBerletTipusa("Napos");
//        ujTag4.setBerletVasarlasideje();
//        ujTag4.setBerletVasarlasideje();
        ujTag4.setTagVarosa("Varos2");
        ujTag4.setTagMegyeje("Megye1");

        KonditeremTag ujTag5 = new KonditeremTag();
        ujTag5.setId(8L);
//        ujTag5.setTagVezeteknev();
//        ujTag5.setTagKeresztnev();
//        ujTag5.setTagNeve();
        ujTag5.setTagNeme("Férfi");
//        ujTag5.setTagSzuletesidatuma();
//        ujTag5.setTagKora();
//        ujTag5.setVasaroltBerletNeve();
        ujTag5.setVasaroltBerletTipusa("Napos");
//        ujTag5.setBerletVasarlasideje();
//        ujTag5.setBerletVasarlasideje();
        ujTag5.setTagVarosa("Varos3");
        ujTag5.setTagMegyeje("Megye1");

        KonditeremTag ujTag6 = new KonditeremTag();
        ujTag6.setId(9L);
//        ujTag6.setTagVezeteknev();
//        ujTag6.setTagKeresztnev();
//        ujTag6.setTagNeve();
        ujTag6.setTagNeme("Nő");
//        ujTag6.setTagSzuletesidatuma();
//        ujTag6.setTagKora();
//        ujTag6.setVasaroltBerletNeve();
        ujTag6.setVasaroltBerletTipusa("Havi");
//        ujTag6.setBerletVasarlasideje();
//        ujTag6.setBerletVasarlasideje();
        ujTag6.setTagVarosa("Varos3");
        ujTag6.setTagMegyeje("Megye2");

        tesztKonditerem.getKonditeremBerletek().addAll(Arrays.asList(ujKonditeremBerlet, ujKonditeremBerlet2));
        tesztKonditerem.getKonditeremTagok().addAll(Arrays.asList(ujTag1, ujTag2, ujTag3, ujTag4, ujTag5, ujTag6));

    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(konditeremTarolo.findByFelhasznalonev(Mockito.any(String.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (args[0].equals("TesztKonditerem")) {
                        return tesztKonditerem;
                    } else {
                        return null;
                    }
                });

        Mockito.when(konditeremTarolo.save(Mockito.any(Konditerem.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((Konditerem) args[0]).getId() == null) {
                        ((Konditerem) args[0]).setId(87L);
                    }
                    return args[0];
                });

    }

    @Test
    public void _1letrehozKonditeremetTeszt() {

        KonditeremVo ujKonditerem = new KonditeremVo();
        ujKonditerem.setKonditeremNeve("Nev");
        ujKonditerem.setFelhasznalonev("konditrem");
        ujKonditerem.setJelszo("jelszo");

        KonditeremVo mentett = konditeremSzolgaltatas.konditeremetLetrehoz(ujKonditerem);

        Assert.assertEquals("Nev", mentett.getKonditeremNeve());
        Assert.assertNotNull(mentett.getId());
        Assert.assertNotNull(mentett.getFelhasznalonev());
        Assert.assertNotNull(mentett.getJelszo());
        Assert.assertNull(mentett.getKonditeremBerletek());
        Assert.assertNull(mentett.getKonditeremTagok());
        Assert.assertNull(mentett.getRegisztralasDatuma());

    }

    @Test
    public void _2keresKonditermetTeszt() {
        KonditeremVo vanIlyen = konditeremSzolgaltatas.keresKonditermet("TesztKonditerem");
        Assert.assertNotNull(vanIlyen);

        KonditeremVo nincsIlyen = konditeremSzolgaltatas.keresKonditermet("NincsIlyen");
        Assert.assertNull(nincsIlyen);
    }

    @Test
    public void _3frissítKonditermetTeszt() {
        KonditeremVo ujKonditerem = new KonditeremVo();
        ujKonditerem.setKonditeremNeve("Nev");
        ujKonditerem.setFelhasznalonev("konditrem");
        ujKonditerem.setJelszo("jelszo");

        KonditeremVo mentett = konditeremSzolgaltatas.konditeremetLetrehoz(ujKonditerem);

        mentett.setFelhasznalonev("UjKonditerem");

        KonditeremVo frissített = konditeremSzolgaltatas.frissitKonditermet(mentett);

        Assert.assertEquals("UjKonditerem", frissített.getFelhasznalonev());
    }

    @Test
    public void _4varosDiagramAdatokSzamitasaKonditeremhezTeszt() {

        Map<String, Long> map = konditeremSzolgaltatas.varosDiagramKonditeremTagokhoz(KonditeremMapper.toVo(tesztKonditerem));

        Assert.assertTrue(map.containsKey("Varos1"));
        Assert.assertEquals(new Long(2L), map.get("Varos1"));

        Assert.assertTrue(map.containsKey("Varos2"));
        Assert.assertEquals(new Long(2L), map.get("Varos2"));

        Assert.assertTrue(map.containsKey("Varos3"));
        Assert.assertEquals(new Long(2L), map.get("Varos3"));

        Assert.assertFalse(map.containsKey("TesztVaros1"));

    }

    @Test
    public void _5megyeDiagramAdatokSzamolasaKoditeremhezTeszt() {

        Map<String, Long> map = konditeremSzolgaltatas.megyeDiagramKonditeremTagokhoz(KonditeremMapper.toVo(tesztKonditerem));

        Assert.assertTrue(map.containsKey("Megye1"));
        Assert.assertEquals(new Long(3L), map.get("Megye1"));

        Assert.assertTrue(map.containsKey("Megye2"));
        Assert.assertEquals(new Long(3L), map.get("Megye2"));

        Assert.assertFalse(map.containsKey("Megye3"));

    }

    @Test
    public void _6nemDiagramAdatokSzamolasaKonditeremhezTeszt() {

        Map<String, Long> map = konditeremSzolgaltatas.nemekDiagramKonditeremTagokhoz(KonditeremMapper.toVo(tesztKonditerem));

        Assert.assertTrue(map.containsKey("Nő"));
        Assert.assertEquals(new Long(2L), map.get("Nő"));

        Assert.assertTrue(map.containsKey("Férfi"));
        Assert.assertEquals(new Long(4L), map.get("Férfi"));

        Assert.assertFalse(map.containsKey("F"));
        Assert.assertFalse(map.containsKey("N"));

    }

    @Test
    public void _7berletTipusDiagramAdatokSzamolasaKonditeremhezTeszt(){

        Map<String, Long> map = konditeremSzolgaltatas.berlettipusDiagramKonditeremTagokhoz(KonditeremMapper.toVo(tesztKonditerem));

        Assert.assertTrue(map.containsKey("Napos"));
        Assert.assertEquals(new Long(3L),map.get("Napos"));

        Assert.assertTrue(map.containsKey("Havi"));
        Assert.assertEquals(new Long(3L), map.get("Havi"));

        Assert.assertFalse(map.containsKey("2Napos"));
        Assert.assertFalse(map.containsKey("3Havi"));

    }

}