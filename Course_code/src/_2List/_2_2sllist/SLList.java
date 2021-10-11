package _2List._2_2sllist;

import java.util.Set;

public class SLList {
    public static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /*public int size() {
        int count = 0;
        IntNode p = first;
        while(p != null) {
            count++;
            p = p.next;
        }
        return count;
    }*/

    /** Returns the size of the list that starts at IntNode p.  */
    public static int size(IntNode p) {
        if(p.next == null) return 1;
        return 1 + size(p.next);
    }

    public int size() {
        return size(sentinel.next);
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public static void main(String[] args) {
        SLList s = new SLList(5);
        s.addFirst(10);
        s.addFirst(15);
        System.out.println(s.getFirst());
        s.addLast(20);
        System.out.println(s.size);
    }
}
