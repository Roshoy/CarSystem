package agh.cs.lab2;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class MapsTest {
    @Test
    public void unboundedMapForcedTest()throws IllegalAccessException{
        IWorldMap map = new UnboundedMap();
        Car car1 = new Car(map,new Position(0,0));
        Car car2 = new Car(map,new Position(3,4));

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
        map.place(car1);
        map.place(car2);
        for (int i=0;i<stacks.length;i++) {
            ((UnboundedMap) map).placeHayStack(stacks[i]);
        }
        map.run(directions);

        assertEquals("N (2,7)",((UnboundedMap) map).getCars().get(1).dataToString());
        assertEquals("S (1,-3)",((UnboundedMap) map).getCars().get(0).dataToString());
    }
    @Test
    public void unboundedMapTest()throws IllegalAccessException{
        IWorldMap map = new UnboundedMap();
        Car car1 = new Car(map,new Position(0,0));


        HayStack[] stacks = {new HayStack(new Position(0,1)),

        };
        String[] arg = {"f",
                "r",
                "f",
                "l",
                "f",
                "f",
                "b",
                "f", "b", "b", "b", "b"};

        LinkedList<MoveDirection> directions = new OptionsParser().parse(arg);
        map.place(car1);

        for (int i=0;i<stacks.length;i++) {
            ((UnboundedMap) map).placeHayStack(stacks[i]);
        }
        map.run(directions);

        assertEquals("N (1,-2)",((UnboundedMap) map).getCars().get(0).dataToString());
        assertEquals(new Position(1,-2),((UnboundedMap) map).getLeftDownCorner());

    }
    @Test
    public void rectangleMapTest()throws IllegalAccessException{
        IWorldMap map = new RectangularMap(10,10);
        Car car1 = new Car(map,new Position(0,0));
        HayStack[] stacks = {new HayStack(new Position(0,1)),

        };
        String[] arg = {"f",
                "r",
                "f",
                "l",
                "f",
                "f",
                "b", "f", "b", "b", "b", "b"};

        LinkedList<MoveDirection> directions = new OptionsParser().parse(arg);
        map.place(car1);

        for (int i=0;i<stacks.length;i++) {
            ((RectangularMap) map).placeHayStack(stacks[i]);
        }
        map.run(directions);

        assertEquals("N (1,0)",((RectangularMap) map).getCars().get(0).dataToString());
        String[] arg2 = {"r","f","f","f","f","f","f","f","f","f","f","f",};
        map.run(new OptionsParser().parse(arg2));
        assertEquals("E (9,0)",((RectangularMap) map).getCars().get(0).dataToString());
    }
}
