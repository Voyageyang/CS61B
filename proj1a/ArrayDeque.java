public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst = 2;
    private int nextLast = 3;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 8;
    }

    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (size + nextFirst - 1) % size;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (size + nextLast + 1) % size;
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
            int first = (size + nextFirst + 1) % size;
            int last = (size + nextFirst - 1) % size;
            while(first != last) {
                System.out.print(items[first] + ", ");
                if(first == last - 1) System.out.print(items[first]);
                first = (size + first + 1) % size;
            }
            System.out.println("]");
        }
    }

    public T removeFirst() {
        return null;
    }

    public T removeLast() {
        T x = items[size-1];
        items[size-1] = null;
        size -= 1;
        return x;
    }

    public T get(int index) {
        return items[index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addLast(4);
        a.printDeque();
    }
}
