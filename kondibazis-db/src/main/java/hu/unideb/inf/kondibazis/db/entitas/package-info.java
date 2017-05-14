/**
 * Ebben a csomagban vannak az Entitások amelyek reprezentálják az adatbázis elemeket.
 * Tartalmaz egy {@link hu.unideb.inf.kondibazis.db.entitas.FoEntitas FoEntitas} osztályt amely közös ős a többi entitás számára.
 * Az egyes osztályok az adatbázisban tárolt táblákat reprezentáják, az adattagok pedig a mefelelő táblában lévő oszlopokat.
 * A táblák közötti kapcoslatot a Hibernate annotációival alakítom ki.
 */
package hu.unideb.inf.kondibazis.db.entitas;