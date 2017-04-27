package de.htwg.mdd.intern.directions.dsl;

/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public interface Driven<T> extends End<T> {

    Driven<T> straightAhead();
    Driven<T> makeTurnToTheLeft();
    Driven<T> makeTurnToTheRight();

}
