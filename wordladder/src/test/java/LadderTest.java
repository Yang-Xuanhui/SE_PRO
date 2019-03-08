import junit.framework.TestCase;

import java.util.Stack;
import java.util.TreeSet;

public class LadderTest extends TestCase {
    Dict dict = new Dict("dictionary/smalldict2.txt");
    Ladder ladder = new Ladder("code","data",dict);
    public void testGetLadder() {
        Stack<String> result = new Stack();
        result = ladder.getLadder();
        assertEquals(6,result.size());
    }

    public void testGetNeighbors() {
        TreeSet<String> neighbors = new TreeSet();
        ladder.getNeighbors("apple",neighbors);
        assertEquals(1,neighbors.size());
        assertTrue(neighbors.contains("apply"));
        assertFalse(neighbors.contains("apple"));
    }

}