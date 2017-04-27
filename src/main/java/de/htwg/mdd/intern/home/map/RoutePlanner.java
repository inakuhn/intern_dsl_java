package de.htwg.mdd.intern.home.map;

import de.htwg.mdd.intern.directions.route.Directions;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Ina Kuhn on 26.04.2017.
 */
@Data
@Builder
public class RoutePlanner {
    private int verticalStreet;
    private int horizontalStreet;
    private TownMap townMap;

    /**
     * Always go first horizontal than vertical.
     * @param direction
     * @return
     */
    public boolean canMove(Directions direction){
        switch (direction){
            case UP:
                break;

        }
        return true;
    }

    private boolean canGoStraightVertical() {
        return verticalStreet + 1 <= townMap.getVerticalStreetNumbers();
    }
    private boolean canGoStraightHorizontal() {
        return horizontalStreet + 1 <= townMap.getHorizontalStreetNumbers();
    }
    private boolean canGoLeftHorizontal() {
        return verticalStreet - 1 >= 0;
    }


}
