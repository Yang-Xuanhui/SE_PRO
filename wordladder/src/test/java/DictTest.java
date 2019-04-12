import junit.framework.TestCase;

public class DictTest extends TestCase {

    public void testInDict() {
        String word = "code";
        String none = "abcd";
        Dict dict = new Dict("dictionary/smalldict1.txt");
        assertTrue(dict.inDict(word));
        assertFalse(dict.inDict(none));
    }
}