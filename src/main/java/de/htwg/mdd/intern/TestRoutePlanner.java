package de.htwg.mdd.intern;
import de.htwg.mdd.intern.route.Route;

import static de.htwg.mdd.intern.route.RouteBuilder.*;
/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public class TestRoutePlanner {
    private TestRoutePlanner(){}
    public static void main(String[] args) {

        Route route = begin().startRoute().straightAhead().makeTurnToTheLeft().straightAhead().makeTurnToTheRight().straightAhead().stopRoute();
        Route route2 = begin().startRoute().stopRoute();
        route2.getDirections();
    }
}
