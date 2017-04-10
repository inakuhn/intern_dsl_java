package de.htwg.mdd.intern.route;

import java.util.List;

/**
 * Created by Ina Kuhn on 07.04.2017.
 */
public class Direction implements Route {
    private int tabs = 2;
    private List<Directions> directions;

    public Direction(List<Directions> directions) {
        this.directions = directions;

    }

    public void getDirections() {
        int tab = tabs;
        for (Directions direction : directions)
            switch (direction) {
                case STRAIGHT:
                    System.out.print("\t\tSTRAIGHT\n\t\t\t|\n\t\t\t|\n\t\t\tv\n\t\t\t|\n");
                case LEFT:
                    System.out.print("\t\t\t->->LEFT->->-\n");
                case RIGHT:
                    System.out.print("-<-<-RIGHT<-<-\n");
            }


    }
}
