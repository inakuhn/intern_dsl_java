package de.htwg.mdd.intern.directions.route;

import de.htwg.mdd.intern.directions.dsl.Driven;
import de.htwg.mdd.intern.directions.dsl.End;
import de.htwg.mdd.intern.directions.dsl.Start;
import de.htwg.mdd.intern.home.map.TownMap;
import de.htwg.mdd.intern.route.Route;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;
import static de.htwg.mdd.intern.directions.route.Directions.*;

/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public final class RouteBuilder {
    private List<Directions> directions = new LinkedList<Directions>();
    private int verticalStart;
    private int horizontalStart;
    public static StartScope begin(@NonNull TownMap townMap) {


        return new RouteBuilder().new StartScope(townMap);
    }

    public final class StartScope implements Start<Route>{
        public StartScope(TownMap townMap){
            this.townMap = townMap;
        }
        private TownMap townMap;

        /**
         *
         * @param verticalStreetNumber can be 0 or more
         * @param horizontalStreetNumber can be 1 or more
         * @return
         */
        public Driven<Route> startRoute(int verticalStreetNumber, int horizontalStreetNumber) {
            if(verticalStreetNumber < 0 ||
                    verticalStreetNumber > townMap.getVerticalStreetNumbers()
                    || horizontalStreetNumber > townMap.getHorizontalStreetNumbers()
                    || horizontalStreetNumber < 1){
                throw new RuntimeException("Street Start does not exist!");
            }
            RouteBuilder.this.horizontalStart = horizontalStreetNumber;
            RouteBuilder.this.verticalStart = verticalStreetNumber;
            return RouteBuilder.this.new DrivenScope();
        }
    }
    public final class DrivenScope implements Driven<Route>{

        public Driven<Route> straightAhead() {
            directions.add(UP);
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
