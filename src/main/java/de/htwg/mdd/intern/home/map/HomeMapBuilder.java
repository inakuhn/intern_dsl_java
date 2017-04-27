package de.htwg.mdd.intern.home.map;


import de.htwg.mdd.intern.directions.route.Directions;
import de.htwg.mdd.intern.home.dsl.End;
import de.htwg.mdd.intern.home.dsl.HomeMap;
import de.htwg.mdd.intern.home.dsl.Start;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ina Kuhn on 26.04.2017.
 */
public class HomeMapBuilder {
    private TownMap townMap;


    List<Directions> directions = new LinkedList<Directions>();
    public static HomeMapBuilder.StartScope start() {
        return new HomeMapBuilder().new StartScope();
    }
    public final class StartScope implements Start<TownMap> {

        public HomeMap<TownMap> startMap(String name) {
            HomeMapBuilder.this.townMap = TownMap.builder().name(name).build();
            return HomeMapBuilder.this.new DrivenScope();
        }
    }
    public final class DrivenScope implements HomeMap<TownMap> {

        public End<TownMap> numberOfStreets(int horizontalNumberOfStreets , int verticalNumberOfStreets) {
            if(horizontalNumberOfStreets < 1|| verticalNumberOfStreets < 1 ){
                throw new RuntimeException("Street number muss be a positive number");
            }

            HomeMapBuilder.this.townMap =  TownMap.builder().name(townMap.getName())
                                            .startHorizontal(1)
                                            .startVertical(1)
                                            .horizontalStreetNumbers(horizontalNumberOfStreets)
                                            .verticalStreetNumbers(verticalNumberOfStreets).homes(generateHomes(verticalNumberOfStreets,horizontalNumberOfStreets)).build();
            return HomeMapBuilder.this.new EndScope();
        }

        private List<Home> generateHomes(int verticalNumberOfStreets, int horizontalNumberOfStreets) {
            List<Home> result =  new LinkedList<Home>();
            for(int horizontal = 1 ; horizontal <= horizontalNumberOfStreets; horizontal ++){
                for(int vertical = 1; vertical <= verticalNumberOfStreets; vertical ++){
                    result.add(Home.builder().hasBottom(false).hasRight(false).horizontal(horizontal).vertical(vertical).build());
                }
            }
            return result;
        }
    }

    public final class EndScope implements End<TownMap> {
        public TownMap finishMap() {
            return  townMap;
        }
    }

}
