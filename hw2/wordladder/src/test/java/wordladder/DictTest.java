package wordladder;

import org.junit.Test;
import static org.junit.Assert.*;

public class DictTest{
    private Dict dict = new Dict();
    String word = "code";
    String none = "abcd";
    @Test
    public void getDictionary() {
    }

    @Test
    public void inDict() {
        assertTrue(dict.inDict(word));
        assertFalse(dict.inDict(none));
    }

    @Test
    public void isEmpty() {
        assertFalse(dict.isEmpty());
    }
}