public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst, nextLast;
    private static final int MINIMUM_CAPACITY = 16;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    public void addFirst(T item) {
        if (items.length == size) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    public void addLast(T item) {
        if (items.length == size) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (nextFirst >= nextLast) {
            for (int i = nextFirst + 1; i < items.length; i++) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = items[addOne(nextFirst)];
        nextFirst = addOne(nextFirst);
        size--;
        if (items.length >= MINIMUM_CAPACITY && (1.0 * size / items.length) < 0.25) {
            resize(items.length / 2);
        }
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = items[minusOne(nextLast)];
        nextLast = minusOne(nextLast);
        size--;
        if (items.length >= MINIMUM_CAPACITY && (1.0 * size / items.length) < 0.25) {
            resize(items.length / 2);
        }
        return item;
    }

    public T get(int index) {
        int k = (nextFirst + 1) % items.length;
        return items[(k + index) % items.length];
    }

    private int addOne(int digit) {
        if (digit == items.length - 1) {
            return 0;
        }
        return digit + 1;
    }

    private int minusOne(int digit) {
        if (digit == 0) {
            return items.length - 1;
        }
        return digit - 1;
    }

    private void resize(int capacity) {
        T[] res = (T[]) new Object[capacity];
        if (size == items.length || nextFirst >= nextLast) {
            // 满了
            for (int i = addOne(nextFirst); i < items.length; i++) {
                res[i - addOne(nextFirst)] = items[i];
            }
            for (int i = 0; i < nextLast; i++) {
                res[i + items.length - addOne(nextFirst)] = items[i];
            }
        } else {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                res[i - (nextFirst + 1)] = items[i];
            }
        }
        items = res;
        nextFirst = capacity - 1;
        nextLast = size;
    }


}
