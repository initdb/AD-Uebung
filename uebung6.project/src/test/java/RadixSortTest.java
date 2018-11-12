import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;

public class RadixSortTest {

    @org.junit.Test
    public void testSimpleArrayIntegerSort() {
        Integer[] input = { 2, 5, 3, 0, 2, 3, 0, 3 };
        Integer[] expected = {0, 0, 2, 2, 3, 3, 3, 5};
        Integer[] result = RadixSort.sortInteger(input, 5);
        assertArrayEquals("Sorting Integers in ascending order", expected, result);
        System.out.println("Result" + result.toString());
    }

    @org.junit.Test
    public void testStableIntegerSort() {
        Integer[] input = { 2, 5, 3, 0, 2, 3, 0, 3 };
        Integer[] result = RadixSort.sortInteger(input, 5);
        assertSame("Checking stable sort for 1st 3", input[2], result[4]);
        assertSame("Checking stable sort for 2nd 3", input[5], result[5]);
        assertSame("Checking stable sort for 3rd 3", input[7], result[6]);
    }


    @org.junit.Test
    public void testStringSort() {
        String[] input = { "4PGC938", "2IYE230", "3CIO720", "1ICK750", "1OHV845", "4JZY524", "1ICK750", "3CIO720", "1OHV845", "1OHV845", "2RLA629", "2RLA629", "3ATW723"};
        String[] output = RadixSort.sortStrings(input, 7);
        System.out.print("Result: ");
        for (String s : output) {
            System.out.print(s + " ");
        }
        System.out.println();
        String[] expected = {"1ICK750", "1ICK750", "1OHV845", "1OHV845", "1OHV845", "2IYE230", "2RLA629", "2RLA629", "3ATW723", "3CIO720", "3CIO720", "4JZY524", "4PGC938"};
        assertArrayEquals(expected, output);
    }

}