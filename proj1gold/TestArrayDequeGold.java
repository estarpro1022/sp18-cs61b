import edu.princeton.cs.introcs.StdRandom;
import org.junit.*;
import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void test1() {
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 500; i++) {
            int number = StdRandom.uniform(20);
            double possibility = StdRandom.uniform();
            assertEquals(correct.isEmpty(), student.isEmpty());
            if (possibility < 0.25) {
                correct.addFirst(number);
                student.addFirst(number);
                sb.append("addFirst(").append(number).append(")\n");
            } else if (possibility < 0.5) {
                correct.addLast(number);
                student.addLast(number);
                sb.append("addLast(").append(number).append(")\n");
            } else if (possibility < 0.75) {
                if (!correct.isEmpty()) {
                    sb.append("removeFirst()\n");
                    assertEquals(sb.toString(), correct.removeFirst(), student.removeFirst());
                }
            } else {
                if (!correct.isEmpty()) {
                    sb.append("removeLast()\n");
                    assertEquals(sb.toString(), correct.removeLast(), student.removeLast());
                }
            }
            sb.append("size()\n");
            assertEquals(sb.toString(), correct.size(), student.size());
            if (!correct.isEmpty()) {
                int a = StdRandom.uniform(correct.size());
                sb.append("get(").append(a).append(")\n");
                assertEquals(sb.toString(), correct.get(a), student.get(a));
            }
        }
    }
}
