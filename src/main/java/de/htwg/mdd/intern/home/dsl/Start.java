package de.htwg.mdd.intern.home.dsl;

import de.htwg.mdd.intern.directions.dsl.Driven;

/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public interface Start<T> {

    HomeMap<T> startMap(String name);
}
