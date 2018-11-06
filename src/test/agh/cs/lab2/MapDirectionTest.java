package agh.cs.lab2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by student34 on 2018-10-09.
 */
public class MapDirectionTest {
    @Test
    public void testNext(){
        MapDirection dir = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, dir.next(MapDirection.EAST));
        assertEquals(MapDirection.NORTH, dir.next(MapDirection.WEST));
        assertEquals(MapDirection.EAST, dir.next(MapDirection.NORTH));
        assertEquals(MapDirection.WEST, dir.next(MapDirection.SOUTH));
    }
    @Test
    public void testPrevious(){
        MapDirection dir = MapDirection.EAST;
        assertEquals(MapDirection.SOUTH, dir.previous(MapDirection.WEST));
        assertEquals(MapDirection.NORTH, dir.previous(MapDirection.EAST));
        assertEquals(MapDirection.EAST, dir.previous(MapDirection.SOUTH));
        assertEquals(MapDirection.WEST, dir.previous(MapDirection.NORTH));
    }
}
