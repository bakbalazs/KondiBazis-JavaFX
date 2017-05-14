package hu.unideb.inf.kondibazis.szolg.test;

import hu.unideb.inf.kondibazis.db.entitas.Konditerem;
import hu.unideb.inf.kondibazis.db.entitas.KonditeremBerlet;
import hu.unideb.inf.kondibazis.db.tarolo.KonditeremTarolo;
import hu.unideb.inf.kondibazis.szolg.impl.KonditeremSzolgaltatasImpl;
import hu.unideb.inf.kondibazis.szolg.vo.KonditeremVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KonditeremTeszt {

    private static final Logger logger = LoggerFactory.getLogger(KonditeremTeszt.class);

    @Mock
    private KonditeremTarolo konditeremTarolo;

    @Spy
    @InjectMocks
    private KonditeremSzolgaltatasImpl konditeremSzolgaltatas;

    private static Konditerem tesztKonditerem;

    @BeforeClass
    public static void setUpClass(){
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

        tesztKonditerem.getKonditeremBerletek().addAll(Arrays.asList(ujKonditeremBerlet, ujKonditeremBerlet2));

    }

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);

        Mockito.when( konditeremTarolo.findByFelhasznalonev(Mockito.any(String.class)))
                .thenAnswer( new Answer<Konditerem>() {
                    @Override
                    public Konditerem answer(InvocationOnMock invocation) throws Throwable {
                        Object[] args = invocation.getArguments();
                        // jelenleg csak egy felhasználó van az "adatbázisban"
                        if( ((String)args[0]).equals("TesztKonditerem") ){
                            return tesztKonditerem;
                        } else {
                            return null;
                        }
                    }
                });

        Mockito.when( konditeremTarolo.save(Mockito.any(Konditerem.class)))
                .thenAnswer( new Answer<Konditerem>() {
                    @Override
                    public Konditerem answer(InvocationOnMock invocation) throws Throwable {
                        Object[] args = invocation.getArguments();
                        if( ((Konditerem)args[0]).getId() == null ){
                            ((Konditerem)args[0]).setId(87L);
                        }
                        return ((Konditerem)args[0]);
                    }
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
    public void _2keresKonditermetTeszt(){
        KonditeremVo vanIlyen = konditeremSzolgaltatas.keresFelhasznalonevet("TesztKonditerem");
        Assert.assertNotNull(vanIlyen);

        KonditeremVo nincsIlyen = konditeremSzolgaltatas.keresFelhasznalonevet("NincsIlyen");
        Assert.assertNull(nincsIlyen);
    }

    @Test
    public void _3frissítKonditeremTeszt(){
        KonditeremVo ujKonditerem = new KonditeremVo();
        ujKonditerem.setKonditeremNeve("Nev");
        ujKonditerem.setFelhasznalonev("konditrem");
        ujKonditerem.setJelszo("jelszo");

        KonditeremVo mentett = konditeremSzolgaltatas.konditeremetLetrehoz(ujKonditerem);

        mentett.setFelhasznalonev("UjKonditerem");

        KonditeremVo frissített = konditeremSzolgaltatas.frissitKonditermet(mentett);

        Assert.assertEquals("UjKonditerem", frissített.getFelhasznalonev());
    }

}