public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst = 2;
    private int nextLast = 3;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    private void resizeIncr(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = items[(nextFirst + 1 + size) % size];
            nextFirst = (nextFirst + 1 + size) % size;
        }
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    private void resizedecr(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = items[(items.length + nextFirst + 1) % items.length];
            nextFirst = (items.length + nextFirst + 1) % items.length;
        }
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resizeIncr(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (items.length + nextFirst - 1) % items.length;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resizeIncr(size * 2);
        }
        items[nextLast] = item;
        nextLast = (items.length + nextLast + 1) % items.length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            System.out.println("[]");
            return;
        } else {
            System.out.print("[");
            int first = (items.length + nextFirst + 1) % items.length;
            int last = (items.length + nextLast - 1) % items.length;
            while (first != last) {
                System.out.print(items[first] + ", ");
                first = (items.length + first + 1) % items.length;
            }
            System.out.print(items[last] + "]\n");
        }
    }

    public T removeFirst() {
        T x = items[(nextFirst + 1 + items.length) % items.length];
        items[(nextFirst + 1 + items.length) % items.length] = null;
        size -= 1;
        nextFirst = (nextFirst + 1 + items.length) % items.length;
        if (1.0 * size / items.length < 0.25 && items.length >= 16) {
            resizedecr(items.length / 2);
        }
        return x;
    }

    public T removeLast() {
        T x = items[(nextLast - 1 + items.length) % items.length];
        items[(nextLast - 1 + items.length) % items.length] = null;
        size -= 1;
        nextLast = (items.length + nextLast - 1) % items.length;
        if (1.0 * size / items.length < 0.25 && items.length >= 16) {
            resizedecr(items.length / 2);
        }
        return x;
    }

    public T get(int index) {
        return items[(nextFirst + 1 + index + items.length) % items.length];
    }
}
