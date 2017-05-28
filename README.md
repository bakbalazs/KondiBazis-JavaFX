[![Build Status](https://travis-ci.org/bakbalazs/KondiBazis-JavaFX.svg?branch=master)](https://travis-ci.org/bakbalazs/KondiBazis-JavaFX)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/97e57c526d4b4a58bee0f7c43e131953)](https://www.codacy.com/app/bakbalazs/KondiBazis-JavaFX?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=bakbalazs/KondiBazis-JavaFX&amp;utm_campaign=Badge_Grade)

# KondiBazis

##### Az alkalmazás célja hogy megkönnyítse a konditermeknek a bérletek és a tagok kezeléséz.

### Funkciók
* Bérletek kezelése
	* Bérlet létrehozása
	  - Alkalmas bérlet
	  - Időkorlátos bérlet
	* Bérlet módosítása
* Tagok kezelése
    * Tag létrehozása
    * Tag módosítása
    * Tag bérletének kezelése
    * Jelöli a lejárt bérletes tagokat
* Elérhetpségek kezelése
    * A konditerem megtud adni több elérhetőséget is, ha több helyen is van ugyanaz a konditerem akkor a tagok be tudnak menni bármelyik terembe.
* Tagok szűrése
    Lehetőség van szűrást végrehajtani a tagokon.
    * Lehetőség van megjelníti az Aktív bérlettel rendelkező tagokat
    * A lejárt bérlettel rendelkező tagokat
    * A férfi tagokat
    * A női tagokat
    * Bérlet típus alapján is van lehetőség szűrésre
    * A tagok nevére is lehetőség van keresni
És ezen szűrések kombinációjára is lehetőség van.
* Statisztikák
    Lehetőség van statisztikák megjelnítésére.
	* A tagok városának nevére
	* A tagok megyéjének nevére
	* A tagok nemére
	* A tagok bérlet típusára

### Útmutató a használathoz

### Telepítés
1. A tároló leklónozása
2. A leklónozott tároló _KondiBazis-JavaFX_ mappájában kiadni a következő parancsot: _mvn package_
3. Miután lefutott a parancs, a _KondiBazis-JavaFX\_kondibazis-ui\\target\\_ mappában kell kiadni a következő parancsot: _java -jar KondiBazis - 1.0.jar_
4. Az alkalmazás elindul

### Rendszerkövetelmények
* Java 8 JRE megléte szükséges
* Minél gyorsabb számítógép