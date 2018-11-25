import java.util.LinkedList;
import java.util.Queue;

/**
 * adapted from Sedgewick et al.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;                   // sorted by key
        private Value val;                 // associated data
        private Node left, right, parent;  // left and right subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BST() {
    }


    /**
     * Does this symbol table contain the given key?
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return search(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     * and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value search(Key key) {
        return search(root, key);
    }

    /**
     * start search at node x, searching for key
     *
     * @param x
     * @param key
     * @return
     */
    private Value search(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls search() with a null key");
        if (x == null) {
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp < 0) {
            return search(x.right, key);
        } else if (cmp > 0) {
            return search(x.left, key);
        } else {
            return x.val;
        }
    }


    /**
     * insert node z into tree and returns node
     */
    public void insert(Key k, Value v) {
        Node newNode = new Node(k, v);
        Node y = null;  // keep track of node from where we are coming
        Node x = root;
        while (x != null) {
            y = x;
            int cmp = k.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        newNode.parent = y;

        if (y == null) {
            root = newNode;   // tree was empty
        } else if (newNode.key.compareTo(y.key) < 0) {  // is new node left or right child
            y.left = newNode;
        } else {
            y.right = newNode;
        }
    }


    // replaces subtree rooted at u by subtree root at v, see lecture
    private void transplant(Node u, Node v) {
        if (u.parent == null) {            // u was the root
            root = v;
        } else if (u == u.parent.left) {    // u was left child
            u.parent.left = v;
        } else {                            // u was right child
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }


    // deletes node with key key from tree
    public void delete(Key key) {
		
	// TODO 

    }


    /**
     * Returns the smallest key in the subtree rooted at x
     */
    private Node minimum(Node x) {
        if (root == null)
            return null;
        while (x.left != null) {
            x = x.left;
        }
        return x;

    }


    /**
     * computes height of the subtree rooted at x, i.e. the longest path from x to any of the leaves.
     * Assumption: We count the number of edges along this path.
     * @param x node for which height of subtree is computed
     * @return
     */
    public int height(Node x) {
	
	//TODO
    }

    public int height() {
        return height(root);
    }



    /**
     * find successor of node x
     */
    private Node successor(Node x) {
        if (x.right != null) {
            return minimum(x.right);
        }
        Node y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // traverse and print keys of tree in Inorder (wrapper)
    public void printInOrder() {
        System.out.println("Preorder of keys: ");
        printInOrder(root);
        System.out.println("\n");
    }

    private void printInOrder(Node n) {
        if (n != null) {
            printInOrder(n.left);
            System.out.println(n.key.toString());
            printInOrder(n.right);
        }
    }


    // traverse and print keys of tree in level-order
    public String levelOrder() {
        StringBuffer levelOrder = new StringBuffer();
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node n = queue.remove();            // FIFO: remove "oldest" element
            levelOrder.append(n.key + " ");
            if (n.left != null) {                // add left child to queue
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);                // add right child to queue
            }
        }
        return levelOrder.toString().trim();
    }

}


