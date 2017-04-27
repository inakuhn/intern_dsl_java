package de.htwg.mdd.intern.home.map;

import de.htwg.mdd.intern.directions.route.Directions;
import lombok.Builder;
import lombok.Data;

import java.util.List;

import static de.htwg.mdd.intern.directions.route.Directions.*;

/**
 * Created by Ina Kuhn on 26.04.2017.
 */
@Builder
@Data
public class TownMap {
    private String name;
    private int verticalStreetNumbers;
    private int horizontalStreetNumbers;
    private int startHorizontal;
    private int startVertical;
    private List<Home> homes;

    public boolean canMove(String direction) {
        Directions value = Directions.valueOf(direction);
        if (isInMap(startHorizontal, horizontalStreetNumbers) &&
                isInMap(startVertical, verticalStreetNumbers)) {
            setLine(value);
            return true;
        }

        return false;
    }

    private boolean isInMap(int value , int end){
        return value >= 1 && value <= end;
    }

    public void setLine(Directions line) {
        homes.forEach(home -> {
            if(home.getHorizontal() == startHorizontal && home.getVertical() == startVertical){
                if(line == UP || line == DOWN){
                    home.setHasRight(true);
                }else if(line == LEFT || line == RIGHT){
                    home.setHasBottom(true);
                }
            }

        });
    }
}
