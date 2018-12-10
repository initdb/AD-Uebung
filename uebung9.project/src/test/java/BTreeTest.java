import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Wolfgang Mühlbauer on 30.11.2017.
 */
public class BTreeTest {

    BTree btree;


    @Before
    public void setUp() {
        btree = new BTree(2);
        btree.insert(1);
        btree.insert(6);
        btree.insert(10);
        btree.insert(14);
        btree.insert(18);
        btree.insert(2);
        btree.insert(17);
        btree.insert(5);
        btree.insert(4);
        btree.insert(9);
        btree.insert(20);
        btree.insert(25);
        btree.insert(22);
        btree.insert(21);
        btree.insert(26);
        btree.insert(27);
        btree.insert(28);
        btree.insert(29);
        btree.insert(30);
        btree.insert(31);
    }

    @Test
    public void maximum()  {
        assertEquals(31, btree.maximum(btree.search(18)), 31);
    }

    @Test
    // predecessor of 18
    public void PredecessorNonLeaf() {
        assertEquals(17, btree.predecessor(18));
    }

    @Test
    // predecessor of 30
    public void PredecessorLeafNotLeftMostIndex() {
        assertEquals(29, btree.predecessor(30));
    }

    @Test
    //predecessor of 29
    public void PredecessorLeafLeftMostIndex() {
        assertEquals(18, btree.predecessor(20));
    }


}