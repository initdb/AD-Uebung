import java.util.LinkedList;
import java.util.Queue;


// implementation of a binary search tree
class BinarySearchTree<T>  {
	
	// inner static class that represents a node 
	public static class Node<T> {
		private int key;
		private T val;
		private Node<T> left; 
		private Node<T> right;
		private Node<T> parent; 

		public Node(int key, T val) {
			this.key = key;
			this.val = val;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		public Node<T> left() {
			return this.left;
		}

		public Node<T> right() {
			return this.right;
		}

        public int getKey() {
            return key;
        }


	}
	
	// root of the binary tree
	private Node<T> root; 
	

	public BinarySearchTree() {
		root = null; 
	}
	
	
	// searches Node with key "k"
	public Node<T> search (int k) {
		Node<T> currentNode = root; 
		while (currentNode != null && currentNode.key != k) {
			if (k < currentNode.key) {
				currentNode = currentNode.left;
			} 
			else {
				currentNode = currentNode.right;
			}
		}
		return currentNode; 
	}
	
	
		
	// inserts a new node "n" into tree 
	public void insert(Node<T> n) {
		Node<T> currentNode = root; 
		Node<T> currentParent = null;  // keep parent of current node 
		
		// search position for insertion
		while (currentNode != null) {
			currentParent = currentNode;
			if (n.key < currentNode.key) {
				currentNode = currentNode.left;
			}
			else {
				currentNode = currentNode.right;
			}
		}
		
		n.parent = currentParent; 
		if (currentParent == null) {		// first node in tree
			root = n;
		}
		else if (n.key < currentParent.key) {
			currentParent.left = n;
		} 
		else if (n.key > currentParent.key) {
			currentParent.right = n;
		} 

	}



	/**
	 * print out key values using Morris In_order-Traversal
	 */
	public void morrisInorderTraverse() {

		System.out.println("In order sequence: ");

		Node current = root;
		
                // TODO 

		System.out.println();
	}


	public static void main(String[] args) {
		BinarySearchTree<String> bst = new BinarySearchTree<String>();

		// create nodes
		BinarySearchTree.Node<String> n3, n5, n6, n7, n10, n12, n13, n15, n16, n18, n20, n23;
		n7 = new BinarySearchTree.Node<String>(7, "A");
		n6 = new BinarySearchTree.Node<String>(6, "B");
		n10 = new BinarySearchTree.Node<String>(10, "C");
		n13 = new BinarySearchTree.Node<String>(13, "D");
		n12 = new BinarySearchTree.Node<String>(12, "E");
		n16 = new BinarySearchTree.Node<String>(16, "F");
		n23 = new BinarySearchTree.Node<String>(23, "G");
		n18 = new BinarySearchTree.Node<String>(18, "H");
		n20 = new BinarySearchTree.Node<String>(20, "I");
		n15 = new BinarySearchTree.Node<String>(15, "J");
		n5 = new BinarySearchTree.Node<String>(5, "K");
		n3 = new BinarySearchTree.Node<String>(3, "L");

		bst.insert(n7);
		bst.insert(n6);
		bst.insert(n10);
		bst.insert(n13);
		bst.insert(n12);
		bst.insert(n16);
		bst.insert(n23);
		bst.insert(n18);
		bst.insert(n20);
		bst.insert(n15);
		bst.insert(n5);
		bst.insert(n3);


		System.out.println("Print In-Order using Morris Traversal");
		bst.morrisInorderTraverse();
	}


}
