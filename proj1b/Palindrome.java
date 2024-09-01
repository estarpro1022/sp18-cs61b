public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        char[] chars = word.toCharArray();
        for (char c: chars) {
            deque.addLast(c);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            if (deque.removeFirst().charValue() != deque.removeLast().charValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = new LinkedListDeque<>();
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char second = deque.removeLast();
            if (!cc.equalChars(first, second)) {
                return false;
            }
        }
        return true;
    }
}
