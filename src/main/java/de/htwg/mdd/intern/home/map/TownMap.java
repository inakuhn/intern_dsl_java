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
    private int favoriteHomeHorizontal;
    private int favoriteHomeVertical;
}
