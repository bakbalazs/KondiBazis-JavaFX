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

import java.time.LocalDate;
import java.util.*;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KonditeremTest {

    @Mock
    private KonditeremTarolo konditeremTarolo;

    @Spy
    @InjectMocks
    private KonditeremSzolgaltatasImpl konditeremSzolgaltatas;

    private static Konditerem tesztKonditerem;

    private static List<Konditerem> konditermek = new ArrayList<>();

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
        ujTag1.setId(7L);
        ujTag1.setTagVezeteknev("Ujtag1Vezeteknev");
        ujTag1.setTagKeresztnev("Ujtag1Keresztnev");
        ujTag1.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag1.setTagNeme("Férfi");
        ujTag1.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag1.setTagKora(20);
        ujTag1.setVasaroltBerletNeve("BerletNeve1");
        ujTag1.setVasaroltBerletTipusa("Havi");
        ujTag1.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag1.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag1.setTagVarosa("Varos1");
        ujTag1.setTagMegyeje("Megye1");
        ujTag1.setKonditeremBerlet(ujKonditeremBerlet);
        ujTag1.setKonditerem(tesztKonditerem);


        KonditeremTag ujTag2 = new KonditeremTag();
        ujTag2.setId(8L);
        ujTag2.setTagVezeteknev("Ujtag2Vezeteknev");
        ujTag2.setTagKeresztnev("Ujtag2Keresztnev");
        ujTag2.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag2.setTagNeme("Férfi");
        ujTag2.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag2.setTagKora(20);
        ujTag2.setVasaroltBerletNeve("BerletNeve2");
        ujTag2.setVasaroltBerletTipusa("Havi");
        ujTag2.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag2.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag2.setTagVarosa("Varos1");
        ujTag2.setTagMegyeje("Megye1");
        ujTag2.setKonditeremBerlet(ujKonditeremBerlet);
        ujTag2.setKonditerem(tesztKonditerem);

        KonditeremTag ujTag3 = new KonditeremTag();
        ujTag3.setId(9L);
        ujTag3.setTagVezeteknev("Ujtag3Vezeteknev");
        ujTag3.setTagKeresztnev("Ujtag3Keresztnev");
        ujTag3.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag3.setTagNeme("Férfi");
        ujTag3.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag3.setTagKora(20);
        ujTag3.setVasaroltBerletNeve("BerletNeve3");
        ujTag3.setVasaroltBerletTipusa("Havi");
        ujTag3.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag3.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag3.setTagVarosa("Varos3");
        ujTag3.setTagMegyeje("Megye1");
        ujTag3.setKonditeremBerlet(ujKonditeremBerlet);
        ujTag3.setKonditerem(tesztKonditerem);

        KonditeremTag ujTag4 = new KonditeremTag();
        ujTag4.setId(10L);
        ujTag4.setTagVezeteknev("Ujtag4Vezeteknev");
        ujTag4.setTagKeresztnev("Ujtag4Keresztnev");
        ujTag4.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag4.setTagNeme("Nő");
        ujTag4.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag4.setTagKora(20);
        ujTag4.setVasaroltBerletNeve("BerletNeve4");
        ujTag4.setVasaroltBerletTipusa("Napos");
        ujTag4.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag4.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag4.setTagVarosa("Varos2");
        ujTag4.setTagMegyeje("Megye2");
        ujTag4.setKonditeremBerlet(ujKonditeremBerlet2);
        ujTag4.setKonditerem(tesztKonditerem);

        KonditeremTag ujTag5 = new KonditeremTag();
        ujTag5.setId(11L);
        ujTag5.setTagVezeteknev("Ujtag5Vezeteknev");
        ujTag5.setTagKeresztnev("Ujtag5Keresztnev");
        ujTag5.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag5.setTagNeme("Férfi");
        ujTag5.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag5.setTagKora(20);
        ujTag5.setVasaroltBerletNeve("BerletNeve5");
        ujTag5.setVasaroltBerletTipusa("Napos");
        ujTag5.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag5.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag5.setTagVarosa("Varos2");
        ujTag5.setTagMegyeje("Megye2");
        ujTag5.setKonditeremBerlet(ujKonditeremBerlet2);
        ujTag5.setKonditerem(tesztKonditerem);

        KonditeremTag ujTag6 = new KonditeremTag();
        ujTag6.setId(12L);
        ujTag6.setTagVezeteknev("Ujtag6Vezeteknev");
        ujTag6.setTagKeresztnev("Ujtag6Keresztnev");
        ujTag6.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag6.setTagNeme("Nő");
        ujTag6.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag6.setTagKora(20);
        ujTag6.setVasaroltBerletNeve("BerletNeve6");
        ujTag6.setVasaroltBerletTipusa("Napos");
        ujTag6.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag6.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag6.setTagVarosa("Varos3");
        ujTag6.setTagMegyeje("Megye2");
        ujTag6.setKonditeremBerlet(ujKonditeremBerlet2);
        ujTag6.setKonditerem(tesztKonditerem);


        tesztKonditerem.getKonditeremBerletek().addAll(Arrays.asList(ujKonditeremBerlet, ujKonditeremBerlet2));
        tesztKonditerem.getKonditeremTagok().addAll(Arrays.asList(ujTag1, ujTag2, ujTag3, ujTag4, ujTag5, ujTag6));
        konditermek.add(ujKonditerem);
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

        Mockito.when(konditeremTarolo.findOne(Mockito.any(Long.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    switch (((Long) args[0]).intValue()) {
                        case 7:
                            return konditermek.get(0);
                        default:
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

        Mockito.when(konditeremTarolo.findAll())
                .thenAnswer(invocation -> Collections.singletonList(tesztKonditerem));
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
    public void _2keresKonditermetNevAlapjanTeszt() {
        KonditeremVo vanIlyen = konditeremSzolgaltatas.keresKonditermet("TesztKonditerem");
        Assert.assertNotNull(vanIlyen);

        KonditeremVo nincsIlyen = konditeremSzolgaltatas.keresKonditermet("NincsIlyen");
        Assert.assertNull(nincsIlyen);
    }

    @Test
    public void _3keresKonditermetIDAlapjanTeszt() {
        KonditeremVo vanIlyen = konditeremSzolgaltatas.keresKonditeremetId(7L);
        Assert.assertNotNull(vanIlyen);

        KonditeremVo nincsIlyen = konditeremSzolgaltatas.keresKonditeremetId(90L);
        Assert.assertNull(nincsIlyen);
    }

    @Test
    public void _4frissítKonditermetTeszt() {
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
    public void _5varosDiagramAdatokSzamitasaKonditeremhezTeszt() {

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
    public void _6megyeDiagramAdatokSzamolasaKoditeremhezTeszt() {

        Map<String, Long> map = konditeremSzolgaltatas.megyeDiagramKonditeremTagokhoz(KonditeremMapper.toVo(tesztKonditerem));

        Assert.assertTrue(map.containsKey("Megye1"));
        Assert.assertEquals(new Long(3L), map.get("Megye1"));

        Assert.assertTrue(map.containsKey("Megye2"));
        Assert.assertEquals(new Long(3L), map.get("Megye2"));

        Assert.assertFalse(map.containsKey("Megye3"));

    }

    @Test
    public void _7nemDiagramAdatokSzamolasaKonditeremhezTeszt() {

        Map<String, Long> map = konditeremSzolgaltatas.nemekDiagramKonditeremTagokhoz(KonditeremMapper.toVo(tesztKonditerem));

        Assert.assertTrue(map.containsKey("Nő"));
        Assert.assertEquals(new Long(2L), map.get("Nő"));

        Assert.assertTrue(map.containsKey("Férfi"));
        Assert.assertEquals(new Long(4L), map.get("Férfi"));

        Assert.assertFalse(map.containsKey("F"));
        Assert.assertFalse(map.containsKey("N"));

    }

    @Test
    public void _8berletTipusDiagramAdatokSzamolasaKonditeremhezTeszt() {

        Map<String, Long> map = konditeremSzolgaltatas.berlettipusDiagramKonditeremTagokhoz(KonditeremMapper.toVo(tesztKonditerem));

        Assert.assertTrue(map.containsKey("Napos"));
        Assert.assertEquals(new Long(3L), map.get("Napos"));

        Assert.assertTrue(map.containsKey("Havi"));
        Assert.assertEquals(new Long(3L), map.get("Havi"));

        Assert.assertFalse(map.containsKey("2Napos"));
        Assert.assertFalse(map.containsKey("3Havi"));

    }

    @Test
    public void _9osszesKonditerem(){
        List<KonditeremVo> osszesKonditerem = konditeremSzolgaltatas.osszesKonditerem();
        Assert.assertNotNull(osszesKonditerem.size());
        Assert.assertEquals(1,osszesKonditerem.size());
    }

}