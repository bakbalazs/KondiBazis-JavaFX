[![Build Status](https://travis-ci.org/bakbalazs/KondiBazis-JavaFX.svg?branch=master)](https://travis-ci.org/bakbalazs/KondiBazis-JavaFX)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/97e57c526d4b4a58bee0f7c43e131953)](https://www.codacy.com/app/bakbalazs/KondiBazis-JavaFX?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bakbalazs/KondiBazis-JavaFX&amp;utm_campaign=Badge_Grade)

# KondiBazis

![Alt text](https://github.com/bakbalazs/KondiBazis-JavaFX/blob/master/kepek/foAblak.png "Az alkalmazás fő képernyője felülete.")

##### A KondiBázis a magyarországi edzőtermek gyűjtőhelye, melynek célja, hogy megkönnyítye a bérletek kiadását, valamint a tagok kezelését. Az alkalmazás már a bejelentkező felületen láttatja a regisztrált edzőtermeket, ezáltal elősegítve a vállalkozások terjeszkedését. 

Az alkalmazás indulásakor a következő képernyő fogad:

![Alt text](https://github.com/bakbalazs/KondiBazis-JavaFX/blob/master/kepek/inditasiKepernyoFelulet.png "Az alkalmazás indító képernyője.")

### Funkciók
* Regisztráció
    Az edzőterem létrehozása az adatbázisban felhasználói fiókként.
	
![Alt text](https://github.com/bakbalazs/KondiBazis-JavaFX/blob/master/kepek/teremRegisztralasaFelulet.png "Az alkalmazás terem regisztrálási felülete.")

* Bérletek kezelése
	* Bérlet létrehozása
	  - Alkalmas bérlet
	        Előzetesen meg kell adni, hány alkalommal érvényes a bérlet. Amennyiszer megjelenik a tag, gombbal kell jelölni a rendszerben, a program úgy számol vissza. A bérlet időbeli lejárati dátumát is kötelező megadni, így a bérlet egy idő után akkor is lejár, ha az összes alkalom nem lett felhasználva. 
	  - Időkorlátos bérlet
	        Az időkorlátos bérlet lejáratát a program a következőképpen kezeli. Megadhat a felhasználó hónapot – hány hónapig használható fel a bérlet –, avagy napot – mennyi napig használható fel a bérlet. A program  a bérlet taghoz rendelésének napjától számolja ki a lejárati dátumot. 
	* Bérlet módosítása
	
![Alt text](https://github.com/bakbalazs/KondiBazis-JavaFX/blob/master/kepek/berletKivalasztva.png "Az alkalmazás bérlet létrehozási felülete.")

* Tagok kezelése
    * Tag létrehozása
    * Tag módosítása
    * Tag bérletének kezelése
    * Jelöli a lejárt bérletes tagokat

![Alt text](https://github.com/bakbalazs/KondiBazis-JavaFX/blob/master/kepek/tagHozzaadaasa.png "Az alkalmazás tag létrehozási felülete.")

* Elérhetőségek kezelése
    * Regisztrációkor adhat meg az edzőterem elérhetőségi adatokat (cím, telefonszám), viszont ez nem kötelező. Később is elvégezheti ezt a módosítást. Amennyiben az edzőterem több kirendeltségen is működik, lehetősége van több elérhetőség megadására. A tagjait együtt kezeli, egy felhasználói fiókban gyűjti össze az összeset. 

![Alt text](https://github.com/bakbalazs/KondiBazis-JavaFX/blob/master/kepek/elerhetosegFelulet.png "Az alkalmazás elérhetőség létrehozási felülete.")

* Tagok szűrése
    Lehetőség van szűrést végrehajtani a tagokon.
    * Lehetőség van megjelníteni az Aktív bérlettel rendelkező tagokat
    * A lejárt bérlettel rendelkező tagokat
    * A férfi tagokat
    * A női tagokat
    * Bérlet típus alapján is szűrhet
    * A tagok nevére is lehetőség van keresni
	
![Alt text](https://github.com/bakbalazs/KondiBazis-JavaFX/blob/master/kepek/szures.png "Példa Női tagok szűrése.")

És ezen szűrések kombinációjára is lehetőség van.
* Statisztikák
    Lehetőség van statisztikák megjelnítésére.
	* A tagok városának nevére
	* A tagok megyéjének nevére
	* A tagok nemére
	* A tagok bérlet típusára
	
![Alt text](https://github.com/bakbalazs/KondiBazis-JavaFX/blob/master/kepek//varosStatisztika.png "Példa város statisztikára.")
	
### Telepítés
1. A tároló leklónozása
2. A leklónozott tároló _KondiBazis-JavaFX_ mappájában kiadni a következő parancsot: _mvn package_
3. Miután lefutott a parancs, a _KondiBazis-JavaFX\_kondibazis-ui\\target\\_ mappában kell kiadni a következő parancsot: _java -jar KondiBazis - 1.0.jar_
4. Az alkalmazás elindul

### Rendszerkövetelmények
* Java 8 JRE megléte szükséges
* Minél gyorsabb számítógép

License
----

MIT