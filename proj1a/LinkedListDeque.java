import sun.awt.image.ImageWatched;

public class LinkedListDeque<DataType> {
    public class Node {
        private Node prev;
        private DataType item;
        private Node next;

        public Node(Node p, DataType i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private static int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        size = 0;
    }

    public void addFirst(DataType item) {
        Node s = new Node(null, item, null);
        if(size == 0) {
            s.next = sentinel;
            s.prev = sentinel;
            sentinel.next = s;
            sentinel.prev = s;
        } else {
            s.next = sentinel.next;
            s.prev = sentinel;
            sentinel.next.prev = s;
            sentinel.next = s;
        }
        size++;
    }

    public void addLast(DataType item) {
        Node s = new Node(null, item, null);
        if(size == 0) {
            s.next = sentinel;
            s.prev = sentinel;
            sentinel.next = s;
            sentinel.prev = s;
        } else {
            s.next = sentinel;
            s.prev = sentinel.prev;
            sentinel.prev.next = s;
            sentinel.prev = s;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if(size == 0) return ;
        Node s = sentinel.next;
        for(int i = 0; i < size; i++) {
            System.out.println(s.item.toString());
            s = s.next;
        }
    }

    public DataType removeFirst() {
        if(size == 0) return null;
        Node s = sentinel.next;
        DataType e = s.item;
        s.next.prev = sentinel;
        sentinel.next = s.next;
        s.next = null;
        s.prev = null;
        size--;
        return e;
    }

    public DataType removeLast() {
        if(size == 0) return null;
        Node s = sentinel.prev;
        DataType e = s.item;
        s.prev.next = sentinel;
        sentinel.prev = s.prev;
        s.next = null;
        s.prev = null;
        size--;
        return e;
    }

    public DataType get(int index) {
        if(index < 0 || index > size) return null;
        Node s = sentinel.next;
        for(int i = 0; i < size; i++) {
            if(i == index) break;
            s = s.next;
        }
        return s.item;
    }

    public DataType getRecursive(int index) {
        return getRecursive(index, sentinel.next);

    }

    public DataType getRecursive(int index, Node node) {
        if(index == 0) return node.item;
        return getRecursive(index - 1, node.next);
    }
}
