package agh.cs.lab2;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class MapsTest {
    @Test
    public void rectangularMapTest(){
        IWorldMap map = new RectangularMap(10,10);
        Car car1 = new Car(map,new Position(0,0));
        Car car2 = new Car(map,new Position(4,4));
        Car carWasted = new Car(map,new Position(0,0));
        HayStack[] stacks = {new HayStack(new Position(-4,-4)),
                             new HayStack(new Position(7,7)),
                             new HayStack(new Position(3,6)),
                             new HayStack(new Position(2,0))
        };
        String[] arg = {"f","b",
                        "r","l",
                        "f","f",
                        "r","r",
                        "f","f",
                        "f","f",
                        "f","f",
                        "f","f"};

        LinkedList<MoveDirection> directions = new OptionsParser().parse(arg);
        map.run(directions);
        assertEquals("N (2,4)",((Car)map.objectAt(new Position(2,4))).dataToString());
        assertEquals("S (1,0)",((Car)map.objectAt(new Position(1,0))).dataToString());

    }
}
