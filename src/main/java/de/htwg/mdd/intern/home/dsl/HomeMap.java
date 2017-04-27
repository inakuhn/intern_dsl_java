package de.htwg.mdd.intern.home.dsl;

/**
 * Created by Ina Kuhn on 26.04.2017.
 */
public interface HomeMap<T> {

    End<T> numberOfStreets(int horizontalNumberOfStreets, int verticalNumberOfStreets);
}
