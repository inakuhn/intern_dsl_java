package de.htwg.mdd.intern.directions.dsl;

/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public interface Start<T> {
    Driven<T> startRoute(int verticalStreetNumber, int horizontalStreetNumber);
}
