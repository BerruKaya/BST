package assignment_3;

// import some libraries if you want


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public Node root;


    // Constructor
    BinarySearchTree(){
        //Write your codes here
        this.root = null;
    }

    // Insert a key node to Binary-Search-Tree. Make sure that the BST is balanced after inserted operation.
    public void insert(int key) {
		Node newNode = new Node(key);
		//if the tree is empty
		if(this.root == null) {
			root = newNode;
			return;
		}
		if(find(key) != null){
			return;
			//node already exists
		}
		Node current = root;
		Node parent = null;
		// Keep going until we reach a leaf node
		while (current != null) {
			// Update the parent node
			parent = current;

			// If the key is less than the current node's key, go left
			if (key < current.key) {
				current = current.leftNode;
			}
			// Otherwise, go right
			else {
				current = current.rightNode;
			}
		}
		// Update the parent's left or right child to point to the new node
		if (key < parent.key) {
			parent.leftNode = newNode;
		} else {
			parent.rightNode = newNode;
		}
        //balancing
		String InOrderedTree = getInOrder(root);
		//to remove the commas
		String [] InOrderedString = InOrderedTree.split(",");
		//creating array to build balance tree with
		int newArray[] = new int[InOrderedString.length];
		//read each number from the String Array to the int array
		for (int i = 0; i < InOrderedString.length; i++) {
			newArray[i] = Integer.parseInt(InOrderedString[i]);
		}
		root = buildBalancedBST(newArray, 0, newArray.length -1);
    }

    // Delete a key node to Binary-Search-Tree. Make sure that the BST is balanced after deleted operation.
    public void delete(int key){
        //Write your codes here
		if (find(key) == null){			//maybe the key doesn't exist
			return;
		}
		Node current = root;
		Node parent = null;

		// Keep going until we find the key
		while(current.key != key) {
			parent = current;
			if(key < current.key)
				current = current.leftNode;
			else
				current = current.rightNode;
		}
		//if it's a root node
		if (isLeaf(current.key)){
			if (key < parent.key) {
				parent.leftNode = null;
			} else {
				parent.rightNode = null;
			}

		}else if(parent ==null){				//for root node
			Node child= current.rightNode;
			Node pp = null;
			//get the smallest on the right sub-tree
			while (child.leftNode != null) {
				pp = child;
				child = child.leftNode;
			}
			child.leftNode = current.leftNode;
			child.rightNode = current.rightNode;
			root = child;
			if (child.key < pp.key ){
				pp.leftNode = null;
			}else{
				pp.rightNode = null;
			}
		}else{
			if (current.leftNode == null) {
				parent.rightNode = current.rightNode;
			} else if (current.rightNode == null){
				parent.rightNode = current.leftNode;
			}else{
				current = current.rightNode;
			}
		}
		//balancing
		String InOrderedTree = getInOrder(root);
		//to remove the commas
		String [] InOrderedString = InOrderedTree.split(",");
		//creating array to build balance tree with
		int newArray[] = new int[InOrderedString.length];
		//read each number from the String Array to the int array
		for (int i = 0; i < InOrderedString.length; i++) {
			newArray[i] = Integer.parseInt(InOrderedString[i]);
		}
		root = buildBalancedBST(newArray, 0, newArray.length -1);
    }

    /* A function that constructs Balanced Binary Search Tree from a sorted integer array */
    private Node buildBalancedBST(int arr[], int start, int end) {
        //Write your codes here
		if (start > end) return null;
		else {

			int mid = (start + end) / 2;
			Node node = new Node(arr[mid]);

			node.leftNode = buildBalancedBST( arr,start, mid - 1);
			node.rightNode = buildBalancedBST(arr,  mid + 1, end);
			return node;
		}


	}

    // find the given key node
    public Node find(int key){
        //Write your codes here// (assumes non-empty tree)
		Node current = this.root;
		while(current.key != key) {
			if(key < current.key)
				current = current.leftNode;
			else
				current = current.rightNode;
			if(current == null)
				return null;
		}
		return current;


    }

    // find and return minimum node of BST
    public Node min(){
        //Write your codes here
		Node current = this.root;
		while (current.leftNode != null)
			current = current.leftNode;
		return current;
    }

    // find and return maximum node of BST
    public Node max(){
        //Write your codes here
		Node current = this.root;
		while (current.rightNode != null)
			current = current.rightNode;
		return current;
    }

    // check given key is leaf node of BST or not
    public boolean isLeaf(int key){
        //Write your codes here
		Node current = find(key);
		if (current.rightNode== null && current.leftNode == null){
			return true;
		}
        return false; // don't forget to delete this line
    }

    // Return preOrder traversal result. Returned string format must be 1,2,3,4,...
	public String getPreOrder(Node node) {
		//Write your codes here
		String result = "";
		if (node == null) return "";
		if (node.key == max().key){
			result += node.key + "";
		}else{
			result += node.key + ",";
		}

		result += getPreOrder(node.leftNode);
		result += getPreOrder(node.rightNode);

		return result;
	}

    // Return inOrder traversal result. Returned string format must be 1,2,3,4,...
    public String getInOrder(Node node) {
        //Write your codes here
		if (node == null) return "";

		String result = getInOrder(node.leftNode) ;
		if (node.key == max().key){
			result += node.key + "";
		}else{
			result += node.key + ",";
		}
		result += getInOrder(node.rightNode);

		return result;



	}

    // Return postOrder traversal result. Returned string format must be 1,2,3,4,...
    public String getPostOrder(Node node) {
        //Write your codes here

		if (node == null) return "";
		String result = getPostOrder(node.leftNode);
		result +=getPostOrder(node.rightNode);
		if (node.key == root.key){
			result += node.key ;
		}else{
			result += node.key + ",";
		}


		return result;

    }

    /* function to print level order traversal of tree*/
    public void printLevelOrder() {
        //Write your codes here
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++){
			printGivenLevel(root, i);
			System.out.println();
		}

    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the given node
    down to the farthest leaf node.*/
    public int height(Node n) {
        //Write your codes here
        if (n == null) {
            return 0;
        }

        // Otherwise, the height is the maximum of the left and right subtrees, plus one
        return Math.max(height(n.leftNode), height(n.rightNode)) + 1;

    }

    /* Print nodes at the given level */
    public void printGivenLevel(Node root, int level) {
        //Write your codes here
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.key + " ");
		} else {
			printGivenLevel(root.leftNode, level - 1);
			printGivenLevel(root.rightNode, level - 1);
		}
    }
}

