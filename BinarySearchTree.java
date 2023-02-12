package assignment_3;

// import some libraries if you want

public class BinarySearchTree {
    public Node root;

    // Constructor
    BinarySearchTree(){
        //Write your codes here
    }

    // Insert a key node to Binary-Search-Tree. Make sure that the BST is balanced after inserted operation.
    public void insert(int key) {
        //Write your codes here
    }

    // Delete a key node to Binary-Search-Tree. Make sure that the BST is balanced after deleted operation.
    public void delete(int key){
        //Write your codes here
    }

    /* A function that constructs Balanced Binary Search Tree from a sorted integer array */
    private Node buildBalancedBST(int arr[], int start, int end) {
        //Write your codes here
        return null; // don't forget to delete this line
    }

    // find the given key node
    public Node find(int key){
        //Write your codes here
        return null; // don't forget to delete this line
    }

    // find and return minimum node of BST
    public Node min(){
        //Write your codes here
        return null; // don't forget to delete this line
    }

    // find and return maximum node of BST
    public Node max(){
        //Write your codes here
        return null; // don't forget to delete this line
    }

    // check given key is leaf node of BST or not
    public boolean isLeaf(int key){
        //Write your codes here
        return true; // don't forget to delete this line
    }

    // Return preOrder traversal result. Returned string format must be 1,2,3,4,...
    public String getPreOrder(Node node) {
        //Write your codes here
        return ""; // don't forget to delete this line
    }

    // Return inOrder traversal result. Returned string format must be 1,2,3,4,...
    public String getInOrder(Node node) {
        //Write your codes here
        return ""; // don't forget to delete this line
    }

    // Return postOrder traversal result. Returned string format must be 1,2,3,4,...
    public String getPostOrder(Node node) {
        //Write your codes here
        return ""; // don't forget to delete this line
    }

    /* function to print level order traversal of tree*/
    public void printLevelOrder() {
        //Write your codes here
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the given node
    down to the farthest leaf node.*/
    public int height(Node n) {
        //Write your codes here
        return -1; // don't forget to delete this line
    }

    /* Print nodes at the given level */
    public void printGivenLevel(Node root, int level) {
        //Write your codes here
    }
}
