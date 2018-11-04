import static org.junit.Assert.*;

public class CountingSortTest {

    @org.junit.Test
    public void testSimpleArray() {
        Integer[] input = { 2, 5, 3, 0, 2, 3, 0, 3 };
        Integer[] expected = {0, 0, 2, 2, 3, 3, 3, 5};
        Integer[] result = CountingSort.sort(input, 5);
        assertArrayEquals("Sorting Integers in ascending order", expected, result);
        System.out.println("Result" + result.toString());
    }

    @org.junit.Test
    public void testStableSort() {
        Integer[] input = { 2, 5, 3, 0, 2, 3, 0, 3 };
        Integer[] result = CountingSort.sort(input, 5);
        assertSame("Checking stable sort for 1st 3", input[2], result[4]);
        assertSame("Checking stable sort for 2nd 3", input[5], result[5]);
        assertSame("Checking stable sort for 3rd 3", input[7], result[6]);
    }
 }