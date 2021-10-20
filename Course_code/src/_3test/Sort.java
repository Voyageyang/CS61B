package _3test;

public class Sort {
    public static void sort(String[] x) {
        int smallestIndex = findSmallest(x);
        swap(x, 0, smallestIndex);
    }

    /** Swap item a with b */
    public static void swap(String[] x, int a, int b) {
        String temp;
        temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    /** Return the smallest String in x */
    public static int findSmallest(String[] x) {
        int smallestIndex = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i].compareTo(x[smallestIndex]) < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }


}
