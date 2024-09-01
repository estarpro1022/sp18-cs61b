import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
//    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome1() {
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("bbb"));
        assertTrue(palindrome.isPalindrome("raar"));
        assertTrue(palindrome.isPalindrome("abcddcba"));
    }

    @Test
    public void testIsPalindrome2() {
        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("abcd"));
        assertFalse(palindrome.isPalindrome("Aa"));
        assertFalse(palindrome.isPalindrome("car"));
    }

    @Test
    public void testIsPalindrome3() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("A"));
    }
}
