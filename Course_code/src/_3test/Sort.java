package _3test;

public class Sort {
    public static void sort(String[] x) {
        sort(x, 0);
    }

    /** Sorts x starting at position start. */
    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallestIndex = findSmallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    /** Swap item a with b */
    public static void swap(String[] x, int a, int b) {
        String temp;
        temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    /** Return the smallest String in x */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            if (x[i].compareTo(x[smallestIndex]) < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }


}
