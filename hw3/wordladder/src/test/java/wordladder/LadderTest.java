package wordladder;

import org.junit.Test;

import java.util.Stack;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class LadderTest {
    Dict dict = new Dict();
    Ladder ladder = new Ladder("code", "data", dict);
    Ladder nladder = new Ladder("happy", "apple", dict);

    @Test
    public void getLadder() {
        Stack<String> result = new Stack();
        result = ladder.getLadder(dict);
        assertEquals(5, result.size());
    }

    @Test
    public void getNeighbors() {
        TreeSet<String> neighbors = new TreeSet();
        ladder.getNeighbors("apple", neighbors, dict);
        assertEquals(0, neighbors.size());
        //assertTrue(neighbors.contains("apply"));
        assertFalse(neighbors.contains("apple"));
        ladder.getNeighbors("code", neighbors, dict);
        assertEquals(1, neighbors.size());
        assertTrue(neighbors.contains("cade"));
        assertFalse(neighbors.contains("data"));
    }

    @Test
    public void parseLadder() {
        String result = ladder.parseLadder(dict);
        String nresult = nladder.parseLadder(dict);
        assertNotEquals("no ladder", result);
        assertEquals("no ladder", nresult);

    }
}