package de.htwg.mdd.intern.home.map;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Ina Kuhn on 27.04.2017.
 */
@Builder
@Data
public class Home {
    private int vertical;
    private int horizontal;
    private boolean hasBottom;
    private boolean hasRight;
}
