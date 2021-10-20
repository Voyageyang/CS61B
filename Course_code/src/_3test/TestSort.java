package _3test;

public class TestSort {
    public static void testSort() {
        String[] input = {"I", "hava", "an", "egg"};
        String[] expected = {"an", "egg", "hava", "i"};

        Sort.sort(input);

        org.junit.Assert.assertArrayEquals(expected, input);
    }

    public static void testFindSmallest() {
        String[] input = {"i", "hava", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input);

        org.junit.Assert.assertEquals(expected, actual);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 1;

        int actual2 = Sort.findSmallest(input2);
        org.junit.Assert.assertEquals(1, actual2);
    }

    public static void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        org.junit.Assert.assertArrayEquals(expected, input);
    }

    public static void main(String[] args) {
        testFindSmallest();
    }

}
