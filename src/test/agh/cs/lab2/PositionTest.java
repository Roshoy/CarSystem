package agh.cs.lab2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by student34 on 2018-10-09.
 */
public class PositionTest {
    @Test
    public void testToString(){
        assertEquals( "(2,0)", new Position(2,0).toString());
    }
    @Test
    public void testSmaller(){
        assertTrue(new Position(2,0).largerThan(new Position(3, 1)));
    }
    @Test
    public void testLarger(){
        assertTrue(new Position(3,1).smallerThan(new Position(2, 0)));
    }
    @Test
    public void testUpperRight() {assertEquals(new Position(2,2),new Position(2,0).upperRight(new Position(0, 2)));}
}
