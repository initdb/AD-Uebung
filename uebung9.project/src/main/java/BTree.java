import java.util.Stack;

/**
 * BTree class
 * based on CLRL, adapted by Wolfgang Mühlbauer
 */
public class BTree {

    public class BNode {
        int n;              // number of keys currently stored in node
        int keys[];         // sorted array of key values
        BNode children[];   // array of references
        boolean leaf;       // indicates if node is a leaf or not.

        public BNode(int t) {                // constructs a BNode with maximum 2t-1 keys
            // TODO
            keys = new int[2 * t - 1];
            children = new BNode[2 * t];
            leaf = true;                     // in the beginning, every node is a leaf node.
            n = 0;                           //until we add keys later.
        }

        // return key value stored at index position
        public int getValue(int index) {
            return keys[index];
        }


        // get i.th child of node
        public BNode getChild(int index) {
            return children[index];
        }

    }


    static int t;       // order t of tree, see lecture slides
    BNode root;         //every tree has at least a root node


    public BTree(int order) {
        this.t = order;
        root = new BNode(order);
    }


    /**
     * search for a key and return node
     *
     * @param key key to be searched
     * @return reference to BNode containing the key
     */
    public BNode search(int key) {
        int i = 0;
        return search(root, key);
    }

    /**
     * search for a given node within subtree rooted at node x
     * @param x root of the subtree in which the key shall be searched
     * @param key key to be searched
     * @return reference to BNode containing the key
     */
    public BNode search(BNode x, int key) {
        int i = 0;
        // TODO
        while (i < x.n && key > x.keys[i]) {
            i++;
        }

        // found
        if (i < x.n && x.keys[i] == key) {
            return x;
        }
        // not found
        else if (x.leaf == true) {
            return null;
        }

        // else: go down to child
        else {
            return search(x.children[i], key);
        }
    }

    //  splits child node children[i] of node x, see lecture nodes
    public void splitChild(BNode x, int i) {
        BNode y = x.children[i];
        BNode z = new BNode(t);                        //    create new node z
        z.leaf = y.leaf;
        z.n = t - 1;


        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[t + j];                 //copy end of y into front of z
        }
        if (!y.leaf) {                                 //if not leaf we have to reassign children nodes.
            for (int j = 0; j < t; j++) {
                z.children[j] = y.children[j + t];     // change children
            }
        }
        y.n = t - 1;                                   //new size of y

        for (int j = x.n; j > i; j--) {                //if we push keys into x we have to rearrange children nodes
            x.children[j + 1] = x.children[j];         //shift children of x
        }
        x.children[i + 1] = z;                         //reassign i child of x

        for (int j = x.n - 1; j >= i; j--) {
            x.keys[j + 1] = x.keys[j];                 // shift keys to the right to make space for new key
        }
        x.keys[i] = y.keys[t - 1];                     //finally push value up into root.

        y.keys[t - 1] = 0;                             //erase value where we pushed from

        for (int j = 0; j < t - 1; j++) {              // delete key values from y
            y.keys[j + t] = 0;
        }
        for (int j = 0; j <= t - 1; j++) {            // delete children references from y
            y.children[j + t] = null;
        }
        x.n++;
    }


    // insert method when node is not full, see lecture notes
    public void nonfullInsert(BNode x, int key) {
        int i = x.n - 1;                            //i is number of keys in node x
        if (x.leaf) {
            while (i >= 0 && key < x.keys[i]) {      // shift values to make room
                x.keys[i + 1] = x.keys[i];
                i--;
            }
            x.keys[i + 1] = key;
            x.n++;
        } else {
            int j = 0;
            while (j < x.n && key > x.keys[j]) {     // find correct child j for recursion
                j++;
            }

            if (x.children[j].n == t * 2 - 1) {
                splitChild(x, j);                    //call splitChild on node x's ith children
                if (key > x.keys[j]) {
                    j++;
                }
            }
            nonfullInsert(x.children[j], key);       //recursion to j.th child
        }
    }

    /**
     * This method finds the node where keys has to be inserted.
     * It starts at the root node and walks to a  leaf
     *
     * @param key keys to be inserted
     */
    public void insert(int key) {
        BNode r = root;
        if (r.n == 2 * BTree.t - 1) {            // if current node r is full
            BNode s = new BNode(BTree.t);  // create new node
            root = s;
            s.leaf = false;
            s.n = 0;
            s.children[0] = r;
            splitChild(s, 0);                  //splitChild root
            nonfullInsert(s, key);                //call insert method on new root
        } else {
            nonfullInsert(r, key);                //if its not full just insert it
        }
    }


    // print out contents of a node
    public void print(BNode n) {
        for (int i = 0; i < n.n; i++) {
            System.out.print(n.getValue(i) + " ");
        }

        if (!n.leaf) {
            for (int j = 0; j <= n.n; j++) {
                if (n.getChild(j) != null) {//preorder fashion, going from left most child to rightmost
                    System.out.println();
                    print(n.getChild(j));
                }
            }
        }
    }

    // prints out content of a searched node
    public void searchPrintNode(BTree T, int x) {
        BNode temp = new BNode(t);
        temp = search(T.root, x);
        if (temp == null) {
            System.out.println("The Key does not exist in this tree");
        } else {
            print(temp);
        }
    }


    /**
     * find maximum key stored in subtree rooted at a given node
     *
     * @param x subtree rooted at node x
     * @return maximum key
     */
    public int maximum(BNode x) {
        // TODO 
    }


    /**
     * finds the predecessor of a key
     *
     * @param key key for which we search the predecessor
     * @return predecessor key
     */
    public int predecessor(int key) {

        // first search the node that should store the key
        // remember all visited nodes on the search path
        Stack<BNode> searchPath = new Stack<BNode>();
        BNode current = root;
        while (current != null && !current.leaf) {
            searchPath.push(current);

            // check if key is stored in this node. If yes don't go on until leaf node is reached
            int i = 0;               // i takes the index of the key for which we search the predecessor
            while (i < current.n && key > current.keys[i]) {
                if (current.keys[i] == key) {
                    break;
                }
                i++;
            }

             current = current.children[i];
        }

        // No we are at the node that must contain the key

        // // determine index of key in this node
        int i = 0;
        while (i < current.n && key > current.keys[i]) {
            i++;
        }
        if (i < current.n && current.keys[i] != key) {
            throw new RuntimeException("Key for which you search a predecessor is not contained in BTree");
        }

        // NOW WE SEARCH THE ACTUAL PREDECESSOR (knowing that they key for which we search is in node "current" at index i)
	// TODO


    }

}









































