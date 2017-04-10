package de.htwg.mdd.intern.route;

import de.htwg.mdd.intern.dsl.Driven;
import de.htwg.mdd.intern.dsl.End;
import de.htwg.mdd.intern.dsl.Start;

import java.util.LinkedList;
import java.util.List;
import static de.htwg.mdd.intern.route.Directions.*;

/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public final class RouteBuilder {
    //Data to be Model
    List<Directions> directions = new LinkedList<Directions>();
    public static StartScope begin() {
        return new RouteBuilder().new StartScope();
    }
    public final class StartScope implements Start<Route>{
        public Driven<Route> startRoute() {
            return RouteBuilder.this.new DrivenScope();
        }
    }
    public final class DrivenScope implements Driven<Route>{

        public Driven<Route> straightAhead() {
            directions.add(STRAIGHT);
            return this;
        }

        public Driven<Route> makeTurnToTheLeft() {
            directions.add(LEFT);
            return this;
        }

        public Driven<Route> makeTurnToTheRight() {
            directions.add(RIGHT);
            return this;
        }

        public Route stopRoute() {
            return RouteBuilder.this.new EndScope().stopRoute();
        }
    }

    public final class EndScope implements End<Route>{

        public Route stopRoute() {
            return new Direction(directions);
        }
    }



}
