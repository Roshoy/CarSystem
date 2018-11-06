package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

/**
 * Created by student33 on 2018-10-16.
 */
public class CarTest {


    @Test
    public void testCar(){
    /*
        Car car = new Car();
        String[] args = {"r","r","l","f","f","f","b"};
        LinkedList<MoveDirection> arg = OptionsParser.parse(args);
        assertEquals(MoveDirection.RIGHT, arg.get(0));
        assertEquals(MoveDirection.RIGHT, arg.get(1));
        assertEquals(MoveDirection.LEFT, arg.get(2));
        assertEquals(MoveDirection.FORWARD, arg.get(3));
        assertEquals(MoveDirection.FORWARD, arg.get(4));
        assertEquals(MoveDirection.FORWARD, arg.get(5));
        assertEquals(MoveDirection.BACKWARD, arg.get(6));
        for(MoveDirection dir: arg){
            car.move(dir);
        }
        assertEquals("(3,2) Wschód",car.toString());

    }
    */
        String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        LinkedList<MoveDirection> directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        map.place(new Car(map,new Position(3,4)));
        map.run(directions);
       // MapVisualizer mv = new MapVisualizer(map);

     //   assertEquals("N (2,4)", RectangularMap.getCar());
        assertEquals("S (1,0)",((Car)map.objectAt(new Position(1,0))).dataToString());
    }
}
