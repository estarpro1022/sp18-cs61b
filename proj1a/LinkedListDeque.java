public class LinkedListDeque<T> {
    private static class ListNode<T> {
        T item;
        ListNode<T> prev;
        ListNode<T> next;
        public ListNode(T i, ListNode<T> p, ListNode<T> n) {
            item = i;
            prev = p;
            next = n;
        }
        public ListNode(T i) {
            this(i, null, null);
        }
    }

    private final ListNode<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ListNode<>(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        ListNode<T> node = new ListNode<>(item, sentinel, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
    }

    public void addLast(T item) {
        ListNode<T> node = new ListNode<>(item, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode<T> node = sentinel.next;
        while (node != sentinel) {
            System.out.print(node.item + " ");
            node = node.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ListNode<T> deleted = sentinel.next;
        deleted.next.prev = sentinel;
        sentinel.next = deleted.next;
        size--;
        return deleted.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ListNode<T> deleted = sentinel.prev;
        deleted.prev.next = sentinel;
        sentinel.prev = deleted.prev;
        size--;
        return deleted.item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode<T> p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    private T getHelper(ListNode<T> node, int index) {
        if (node == sentinel) {
            return null;
        }
        if (index == 0) {
            return node.item;
        }
        return getHelper(node.next, index - 1);
    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getHelper(sentinel.next, index);
    }
}

