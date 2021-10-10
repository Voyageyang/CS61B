package disc02;

public class SquraingAList {
    public static void main(String[] args) {
        IntList L = new IntList(10,null);
        L = new IntList(5, L);
        L = new IntList(15, L);

        System.out.println(L.rest.first);
        System.out.println(square(L).rest.first);
        //System.out.println(squareMutative(L).rest.first);
        System.out.println(squareRecursive(L).rest.first);
        System.out.println(squareMutativeRecursive(L).rest.first);
    }

    public static IntList square(IntList L) {
        if(L == null) return null;
        IntList Q = new IntList(L.first * L.first, null);
        IntList q = Q;
        L = L.rest;
        while(L != null) {
            q.rest = new IntList(L.first * L.first, null);
            L = L.rest;
            q = q.rest;
        }
        return Q;
    }
    public static IntList squareMutative(IntList L) {
        IntList q = L;
        while(q != null) {
            q.first = q.first * q.first;
            q = q.rest;
        }
        return L;
    }

    public static IntList squareRecursive(IntList L) {
        if(L == null) return null;
        return new IntList(L.first * L.first, squareRecursive(L.rest));
    }

    public static IntList squareMutativeRecursive(IntList L) {
        if(L == null) return null;
        else {
            L.first = L.first * L.first;
            squareMutativeRecursive(L.rest);
        }
        return L;
    }
}
