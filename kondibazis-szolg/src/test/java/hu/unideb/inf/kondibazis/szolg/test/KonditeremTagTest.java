package hu.unideb.inf.kondibazis.szolg.test;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremTag;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTagTarolo;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremTagSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.mapper.KonditeremMapper;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremBerletVo;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremTagVo;
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
public class KonditeremTagTest {

    @Mock
    private KonditeremTagTarolo konditeremTagTarolo;

    @Spy
    @InjectMocks
    private KonditeremTagSzolgaltatasImpl konditeremTagSzolgaltatas;

    private static Konditerem tesztKonditeremA;

    private static Konditerem tesztKonditeremB;

    private static List<KonditeremBerlet> tesztKonditeremABerletei = new ArrayList<>();

    private static List<KonditeremBerlet> tesztKonditeremBBerletei = new ArrayList<>();

    private static List<KonditeremTag> tesztKonditeremATagjai = new ArrayList<>();

    private static List<KonditeremTag> tesztKonditeremBTagjai = new ArrayList<>();

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
        ujKonditerem2.setKonditeremNeve("TezstKonditeremNev");
        ujKonditerem2.setFelhasznalonev("TesztKonditerem");
        ujKonditerem2.setJelszo("TesztJelszo");
        ujKonditerem2.setRegisztralasDatuma(LocalDate.now());
        ujKonditerem2.setKonditeremTagok(new ArrayList<>());
        ujKonditerem2.setKonditeremBerletek(new ArrayList<>());
        ujKonditerem2.setKonditeremElerhetosegek(new ArrayList<>());

        tesztKonditeremB = ujKonditerem2;

        KonditeremBerlet ujKonditeremBerlet1 = new KonditeremBerlet();
        ujKonditeremBerlet1.setId(3L);
        ujKonditeremBerlet1.setBerletNeve("TesztHavi");
        ujKonditeremBerlet1.setBerletAra(10000);
        ujKonditeremBerlet1.setBerletTipusa("Havi");
        ujKonditeremBerlet1.setMennyiAlkalom(0);
        ujKonditeremBerlet1.setMennyiHonap(1);
        ujKonditeremBerlet1.setMennyiNap(0);
        ujKonditeremBerlet1.setKonditerem(tesztKonditeremA);

        KonditeremBerlet ujKonditeremBerlet2 = new KonditeremBerlet();
        ujKonditeremBerlet2.setId(4L);
        ujKonditeremBerlet2.setBerletNeve("Teszt2Napos");
        ujKonditeremBerlet2.setBerletAra(10000);
        ujKonditeremBerlet2.setBerletTipusa("2 napos");
        ujKonditeremBerlet2.setMennyiAlkalom(2);
        ujKonditeremBerlet2.setMennyiHonap(0);
        ujKonditeremBerlet2.setMennyiNap(0);
        ujKonditeremBerlet2.setKonditerem(tesztKonditeremA);

        KonditeremBerlet ujKonditeremBerlet3 = new KonditeremBerlet();
        ujKonditeremBerlet3.setId(5L);
        ujKonditeremBerlet3.setBerletNeve("TesztHavi");
        ujKonditeremBerlet3.setBerletAra(10000);
        ujKonditeremBerlet3.setBerletTipusa("Havi");
        ujKonditeremBerlet3.setMennyiAlkalom(0);
        ujKonditeremBerlet3.setMennyiHonap(1);
        ujKonditeremBerlet3.setMennyiNap(0);
        ujKonditeremBerlet3.setKonditerem(tesztKonditeremB);

        KonditeremBerlet ujKonditeremBerlet4 = new KonditeremBerlet();
        ujKonditeremBerlet2.setId(6L);
        ujKonditeremBerlet2.setBerletNeve("Teszt2Napos");
        ujKonditeremBerlet2.setBerletAra(10000);
        ujKonditeremBerlet2.setBerletTipusa("2 napos");
        ujKonditeremBerlet2.setMennyiAlkalom(2);
        ujKonditeremBerlet2.setMennyiHonap(0);
        ujKonditeremBerlet2.setMennyiNap(0);
        ujKonditeremBerlet2.setKonditerem(tesztKonditeremB);

        KonditeremTag ujTag1 = new KonditeremTag();
        ujTag1.setId(7L);
        ujTag1.setTagVezeteknev("Ujtag1Vezeteknev");
        ujTag1.setTagKeresztnev("Ujtag1Keresztnev");
        ujTag1.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag1.setTagNeme("Nő");
        ujTag1.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag1.setTagKora(20);
        ujTag1.setVasaroltBerletNeve("BerletNeve1");
        ujTag1.setVasaroltBerletTipusa("Időkorlátos bérlet");
        ujTag1.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag1.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag1.setTagVarosa("Varos1");
        ujTag1.setTagMegyeje("Megye1");
        ujTag1.setKonditeremBerlet(ujKonditeremBerlet1);
        ujTag1.setKonditerem(tesztKonditeremA);

        KonditeremTag ujTag2 = new KonditeremTag();
        ujTag2.setId(8L);
        ujTag2.setTagVezeteknev("Ujtag2Vezeteknev");
        ujTag2.setTagKeresztnev("Ujtag2Keresztnev");
        ujTag2.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag2.setTagNeme("Férfi");
        ujTag2.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag2.setTagKora(20);
        ujTag2.setVasaroltBerletNeve("BerletNeve2");
        ujTag2.setVasaroltBerletTipusa("Alkalmas bérlet");
        ujTag2.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag2.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag2.setTagVarosa("Varos2");
        ujTag2.setTagMegyeje("Megye2");
        ujTag2.setKonditeremBerlet(ujKonditeremBerlet2);
        ujTag2.setKonditerem(tesztKonditeremA);

        KonditeremTag ujTag3 = new KonditeremTag();
        ujTag3.setId(9L);
        ujTag3.setTagVezeteknev("Ujtag3Vezeteknev");
        ujTag3.setTagKeresztnev("Ujtag3Keresztnev");
        ujTag3.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag3.setTagNeme("Férfi");
        ujTag3.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag3.setTagKora(20);
        ujTag3.setVasaroltBerletNeve("BerletNeve3");
        ujTag3.setVasaroltBerletTipusa("Iődkorlátos bérlet");
        ujTag3.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag3.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag3.setTagVarosa("Varos3");
        ujTag3.setTagMegyeje("Megye3");
        ujTag3.setKonditeremBerlet(ujKonditeremBerlet3);
        ujTag3.setKonditerem(tesztKonditeremA);

        KonditeremTag ujTag4 = new KonditeremTag();
        ujTag4.setId(10L);
        ujTag4.setTagVezeteknev("Ujtag4Vezeteknev");
        ujTag4.setTagKeresztnev("Ujtag4Keresztnev");
        ujTag4.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag4.setTagNeme("Nő");
        ujTag4.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag4.setTagKora(20);
        ujTag4.setVasaroltBerletNeve("BerletNeve4");
        ujTag4.setVasaroltBerletTipusa("Időkorlátos bérlet");
        ujTag4.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag4.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag4.setTagVarosa("Varos4");
        ujTag4.setTagMegyeje("Megye4");
        ujTag4.setKonditeremBerlet(ujKonditeremBerlet4);
        ujTag4.setKonditerem(tesztKonditeremB);

        KonditeremTag ujTag5 = new KonditeremTag();
        ujTag5.setId(11L);
        ujTag5.setTagVezeteknev("Ujtag5Vezeteknev");
        ujTag5.setTagKeresztnev("Ujtag5Keresztnev");
        ujTag5.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag5.setTagNeme("Férfi");
        ujTag5.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag5.setTagKora(20);
        ujTag5.setVasaroltBerletNeve("BerletNeve5");
        ujTag5.setVasaroltBerletTipusa("Időkorlátos bérlet");
        ujTag5.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag5.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag5.setTagVarosa("Varos5");
        ujTag5.setTagMegyeje("Megye5");
        ujTag5.setKonditeremBerlet(ujKonditeremBerlet3);
        ujTag5.setKonditerem(tesztKonditeremB);

        KonditeremTag ujTag6 = new KonditeremTag();
        ujTag6.setId(12L);
        ujTag6.setTagVezeteknev("Ujtag6Vezeteknev");
        ujTag6.setTagKeresztnev("Ujtag6Keresztnev");
        ujTag6.setTagNeve(ujTag1.getTagVezeteknev() + " " + ujTag1.getTagKeresztnev());
        ujTag6.setTagNeme("Nő");
        ujTag6.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag6.setTagKora(20);
        ujTag6.setVasaroltBerletNeve("BerletNeve6");
        ujTag6.setVasaroltBerletTipusa("Alkalmas bérlet");
        ujTag6.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag6.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag6.setTagVarosa("Varos6");
        ujTag6.setTagMegyeje("Megye6");
        ujTag6.setKonditeremBerlet(ujKonditeremBerlet3);
        ujTag6.setKonditerem(tesztKonditeremB);

        tesztKonditeremA.getKonditeremBerletek().addAll(Arrays.asList(ujKonditeremBerlet1, ujKonditeremBerlet2));
        tesztKonditeremA.getKonditeremTagok().addAll(Arrays.asList(ujTag1, ujTag2, ujTag3));

        tesztKonditeremB.getKonditeremBerletek().addAll(Arrays.asList(ujKonditeremBerlet3, ujKonditeremBerlet4));
        tesztKonditeremB.getKonditeremTagok().addAll(Arrays.asList(ujTag4, ujTag5, ujTag6));

        tesztKonditeremABerletei.addAll(Arrays.asList(ujKonditeremBerlet1, ujKonditeremBerlet2));
        tesztKonditeremBBerletei.add(ujKonditeremBerlet4);

        tesztKonditeremATagjai.addAll(Arrays.asList(ujTag1, ujTag2, ujTag3));
        tesztKonditeremBTagjai.addAll(Arrays.asList(ujTag4, ujTag5, ujTag6));
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(konditeremTagTarolo.save(Mockito.any(KonditeremTag.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((KonditeremTag) args[0]).getId() == null) {
                        ((KonditeremTag) args[0]).setId(87L);
                    }
                    return args[0];
                });

        Mockito.when(konditeremTagTarolo.findOne(Mockito.any(Long.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    switch (((Long) args[0]).intValue()) {
                        case 7:
                            return tesztKonditeremATagjai.get(0);
                        case 8:
                            return tesztKonditeremATagjai.get(1);
                        case 9:
                            return tesztKonditeremATagjai.get(2);
                        default:
                            return null;
                    }
                });

        Mockito.when(konditeremTagTarolo.findByKonditerem(Mockito.any(Konditerem.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((Konditerem) args[0]).getId().equals(tesztKonditeremA.getId())) {
                        return tesztKonditeremATagjai;
                    } else if (((Konditerem) args[0]).getId().equals(tesztKonditeremB.getId())) {
                        return tesztKonditeremBTagjai;
                    } else {
                        return null;
                    }
                });
    }

    @Test
    public void letrehozKonditeremTagotTeszt() {
        KonditeremTagVo ujTag = new KonditeremTagVo();
        ujTag.setTagVezeteknev("Ujtag1Vezeteknev");
        ujTag.setTagKeresztnev("Ujtag1Keresztnev");
        ujTag.setTagNeve(ujTag.getTagVezeteknev() + " " + ujTag.getTagKeresztnev());
        ujTag.setTagNeme("Férfi");
        ujTag.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag.setTagKora(20);
        ujTag.setVasaroltBerletNeve("BerletNeve1");
        ujTag.setVasaroltBerletTipusa("Havi1");
        ujTag.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag.setTagVarosa("Varos1");
        ujTag.setTagMegyeje("Megye1");
        ujTag.setKonditeremBerlet(new KonditeremBerletVo());
        ujTag.setKonditerem(KonditeremMapper.toVo(tesztKonditeremA));

        KonditeremTagVo mentett = konditeremTagSzolgaltatas.leterehozTagot(ujTag);

        Assert.assertNotNull(mentett);
        Assert.assertNotNull(mentett.getId());

    }

    @Test
    public void keresKonditeremTagokTeszt() {
        KonditeremTagVo leszIlyenTag = konditeremTagSzolgaltatas.keresTagot(7L);

        Assert.assertNotNull(leszIlyenTag);

        KonditeremTagVo nemLeszIlyenTag = konditeremTagSzolgaltatas.keresTagot(20L);

        Assert.assertNull(nemLeszIlyenTag);
    }

    @Test
    public void frissitKonditeremTagotTeszt() {
        KonditeremTagVo ujTag = new KonditeremTagVo();
        ujTag.setTagVezeteknev("Ujtag1Vezeteknev");
        ujTag.setTagKeresztnev("Ujtag1Keresztnev");
        ujTag.setTagNeve(ujTag.getTagVezeteknev() + " " + ujTag.getTagKeresztnev());
        ujTag.setTagNeme("Férfi");
        ujTag.setTagSzuletesidatuma(LocalDate.now().minusMonths(12));
        ujTag.setTagKora(20);
        ujTag.setVasaroltBerletNeve("BerletNeve1");
        ujTag.setVasaroltBerletTipusa("Havi1");
        ujTag.setBerletVasarlasideje(LocalDate.now().minusWeeks(4));
        ujTag.setBerletLejaratiIdeje(LocalDate.now().minusWeeks(2));
        ujTag.setTagVarosa("Varos1");
        ujTag.setTagMegyeje("Megye1");
        ujTag.setKonditeremBerlet(new KonditeremBerletVo());
        ujTag.setKonditerem(KonditeremMapper.toVo(tesztKonditeremA));

        KonditeremTagVo mentett = konditeremTagSzolgaltatas.leterehozTagot(ujTag);

        mentett.setTagVezeteknev("UjtagModositottVezeteknev");
        mentett.setTagKeresztnev("Ujtag1Keresztnev");
        mentett.setTagNeve(ujTag.getTagVezeteknev() + " " + ujTag.getTagKeresztnev());

        KonditeremTagVo frissített = konditeremTagSzolgaltatas.frissitKonditeremTagot(mentett);

        Assert.assertEquals("UjtagModositottVezeteknev", frissített.getTagVezeteknev());

    }

    @Test
    public void konditeremOsszesTagjaTeszt() {
        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremA);

        List<KonditeremTagVo> konditeremTagjai = konditeremTagSzolgaltatas.konditeremOsszesTagja(konditerem);

        Assert.assertNotNull(konditeremTagjai);
        Assert.assertEquals(3, konditeremTagjai.size());
    }

    @Test
    public void konditeremNoiTagjaiTeszt() {
        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremA);

        List<KonditeremTagVo> konditeremNoiTagjai = konditeremTagSzolgaltatas.noiTagok(konditerem);

        Assert.assertNotNull(konditeremNoiTagjai);
        Assert.assertEquals(1, konditeremNoiTagjai.size());
    }

    @Test
    public void konditeremFerfiTagjaiTeszt() {
        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremB);

        List<KonditeremTagVo> konditeremFerfiTagjai = konditeremTagSzolgaltatas.ferfiTagok(konditerem);

        Assert.assertNotNull(konditeremFerfiTagjai);
        Assert.assertEquals(1, konditeremFerfiTagjai.size());
    }

    @Test
    public void konditeremAlkalmasBerletuTagjaiTeszt() {
        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremA);

        List<KonditeremTagVo> konditeremAlkalmasBerletuTagjai = konditeremTagSzolgaltatas.alkalmasBerletuTagok(konditerem);

        Assert.assertNotNull(konditeremAlkalmasBerletuTagjai);
        Assert.assertEquals(1, konditeremAlkalmasBerletuTagjai.size());
    }

    @Test
    public void konditeremIdokorlatosBerletuTagjaiTeszt() {
        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremB);

        List<KonditeremTagVo> konditeremIdokorlatosBerletuTagjai = konditeremTagSzolgaltatas.idokorlatosBerletuTagok(konditerem);

        Assert.assertNotNull(konditeremIdokorlatosBerletuTagjai);
        Assert.assertEquals(2, konditeremIdokorlatosBerletuTagjai.size());
    }

    @Test
    public void konditeremLejartAlkalmasBerletuTagjaiTeszt() {
        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremA);

        List<KonditeremTagVo> konditeremLejartAlkalmasBerletuTagjai = konditeremTagSzolgaltatas.lejartAlkalmasBerletuTagok(konditerem);

        Assert.assertNotNull(konditeremLejartAlkalmasBerletuTagjai);
        Assert.assertEquals(1, konditeremLejartAlkalmasBerletuTagjai.size());
    }

    @Test
    public void konditeremLejartIdokorlatosBerletuTagjaiTeszt() {
        KonditeremVo konditerem = KonditeremMapper.toVo(tesztKonditeremB);

        List<KonditeremTagVo> konditeremLejartIdokorlatosBerletuTagjai = konditeremTagSzolgaltatas.lejartIdokorlatosBerletuTagok(konditerem);

        Assert.assertNotNull(konditeremLejartIdokorlatosBerletuTagjai);
        Assert.assertEquals(2, konditeremLejartIdokorlatosBerletuTagjai.size());
    }

}
