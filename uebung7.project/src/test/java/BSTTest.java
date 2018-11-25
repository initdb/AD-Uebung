import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertSame;


/**
 * Created by Wolfgang Mühlbauer on 03.12.2016.
 */
public class BSTTest {

    private BST<Integer, String> bst;


    @Before
    public void setUp() {
        // create binary search tree
        bst = new BST<Integer, String>();

        // create nodes
        bst.insert(7, "A");
        bst.insert(6, "B");
        bst.insert(10, "C");
        bst.insert(13, "D");
        bst.insert(12, "E");
        bst.insert(16, "F");
        bst.insert(23, "G");
        bst.insert(18, "H");
        bst.insert(20, "I");
        bst.insert(15, "J");
        bst.insert(5, "K");
        bst.insert(3, "L");


        String result = bst.levelOrder();
        System.out.println("\nLevel-Order after building up tree: " + result);
    }

    @Test
    public void testDelete3() {
        bst.delete(3);
        String result = bst.levelOrder();
        System.out.println("\nLevel-Order after deleting key 3: " + result);
        assertEquals("7 6 10 5 13 12 16 15 23 18 20", result);
    }

    @Test
    public void testDelete10() {
        bst.delete(10);
        String result = bst.levelOrder();
        System.out.println("\nLevel-Order after deleting key 10: ");
        assertEquals("7 6 13 5 12 16 3 15 23 18 20", result);
    }

    @Test
    public void testDelete16() {
        bst.delete(16);
        String result = bst.levelOrder();
        System.out.println("\nLevel-Order after deleting key 16: ");
        assertEquals("7 6 10 5 13 3 12 18 15 23 20", result);
    }

    @Test
    public void testHeight() {
        assertEquals(6, bst.height());
    }

}