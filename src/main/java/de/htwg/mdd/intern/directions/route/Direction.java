package de.htwg.mdd.intern.directions.route;

import de.htwg.mdd.intern.route.Route;

import java.util.List;

/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public class Direction implements Route {
    private List<Directions> directions;

    public Direction(List<Directions> directions) {
        this.directions = directions;

    }

    public void getDirections() {
        for (Directions direction : directions)
            switch (direction) {
                case UP:
                    System.out.print("\t\tUP\n\t\t\t|\n\t\t\t|\n\t\t\tv\n\t\t\t|\n");
                case LEFT:
                    System.out.print("\t\t\t->->LEFT->->-\n");
                case RIGHT:
                    System.out.print("-<-<-RIGHT<-<-\n");
            }


    }
}
