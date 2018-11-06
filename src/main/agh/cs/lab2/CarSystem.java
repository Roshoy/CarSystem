package agh.cs.lab2;

import java.util.LinkedList;

/**
 * Created by student34 on 2018-10-09.
 */
public class CarSystem {
    public static void main(String[] args){

        String[] arg = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};

        LinkedList<MoveDirection> directions = new OptionsParser().parse(arg);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        map.place(new Car(map,new Position(3,4)));
        map.run(directions);
        System.out.println(map.toString());

    }
}
