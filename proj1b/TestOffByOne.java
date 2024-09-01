import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
//    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void test1() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'c'));
        assertTrue(offByOne.equalChars('A', 'B'));
    }

    @Test
    public void test2() {
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('b', 'd'));
        assertFalse(offByOne.equalChars('a', 'z'));
    }
}
