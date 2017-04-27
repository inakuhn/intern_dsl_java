package de.htwg.mdd.intern.home.map;


import de.htwg.mdd.intern.directions.route.Directions;
import de.htwg.mdd.intern.home.dsl.End;
import de.htwg.mdd.intern.home.dsl.FavoriteHome;
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

        public FavoriteHome<TownMap> numberOfStreets(int horizontalNumberOfStreets , int verticalNumberOfStreets) {
            if(horizontalNumberOfStreets < 1|| verticalNumberOfStreets < 1 ){
                throw new RuntimeException("Street number muss be a positive number");
            }

            HomeMapBuilder.this.townMap =  TownMap.builder().name(townMap.getName())
                                            .horizontalStreetNumbers(horizontalNumberOfStreets)
                                            .verticalStreetNumbers(verticalNumberOfStreets).build();
            return HomeMapBuilder.this.new FavoriteHomeScope();
        }
    }
    public final class FavoriteHomeScope implements FavoriteHome<TownMap> {

        @Override
        public End<TownMap> numberOfSFavoriteHome(int horizontalStreet, int verticalStreet) {
            if(!isInRange(horizontalStreet, verticalStreet)){
                throw new RuntimeException("Favorite street muss be in map!!");
            }
            townMap.setFavoriteHomeHorizontal(horizontalStreet);
            townMap.setFavoriteHomeVertical(verticalStreet);
            return HomeMapBuilder.this.new EndScope() ;
        }

        private boolean isInRange(int horizontalStreet, int verticalStreet) {
            return horizontalStreet >= 1 && verticalStreet >= 1
                    && horizontalStreet <= townMap.getHorizontalStreetNumbers()
                    && verticalStreet <= townMap.getVerticalStreetNumbers();
        }
    }

    public final class EndScope implements End<TownMap> {
        public TownMap finishMap() {
            return  townMap;
        }
    }

}
