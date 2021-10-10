package _2List._2_1intlist;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if(rest == null) return 1;
        return 1 + this.rest.size();
    }

    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while(p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /*public void addFirst(int x) {
       this = new IntList(x, this);
    }*/

    public int get(int i) {
        if(i == 0) return first;
        return rest.get(i - 1);
    }

    public static IntList incrList(IntList L, int x) {
        IntList Q = new IntList(L.first + x, null);
        IntList p = Q;
        IntList q = Q;
        L = L.rest;
        while(L != null) {
            q = new IntList(L.first + x, null);
            p.rest = q;
            p = q;
            L = L.rest;
        }
        return Q;
    }

    public static IntList dincrList(IntList L, int x) {
        IntList Q = L;
        while(Q != null) {
            Q.first += x;
            Q = Q.rest;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15,null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.iterativeSize());
        System.out.println(L.get(2));

        System.out.println(L.get(0) + " " + L.get(1) + " " + L.get(2));
        System.out.println(incrList(L, 2).get(0) + " " + incrList(L, 2).get(1) + " " + incrList(L, 2).get(2));
        IntList Q = dincrList(L, 2);
        System.out.println(Q.get(0) + " " + Q.get(1) + " " + Q.get(2));
        System.out.println(L.get(0) + " " + L.get(1) + " " + L.get(2));
        System.out.println(incrList(L, 2).get(0) + " " + incrList(L, 2).get(1) + " " + incrList(L, 2).get(2));
        System.out.println(L.get(0) + " " + L.get(1) + " " + L.get(2));

    }
}
