package assignment_3_2022_2023;

public class TestBST {

    public static void main(String[] args) {

        int grade = 0;
        BSTPrinter printer = new BSTPrinter();
        BinarySearchTree t = new BinarySearchTree();

        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(9);
        t.insert(10);
        t.insert(11);
        t.insert(12);
        t.insert(13);
        t.insert(14);
        t.insert(15);
        t.insert(16);

        printer.printNode(t.root);

        System.out.println("************************Test 1********************************");
        //*************************Test 1*******************************
        if(t.root != null && t.root.key == 8) grade += 2;

        if(t.root != null && t.root.leftNode.key == 4) grade += 2;
        if(t.root != null && t.root.rightNode.key == 12) grade += 2;

        if(t.root != null && t.root.leftNode.leftNode.key == 2) grade += 2;
        if(t.root != null && t.root.leftNode.rightNode.key == 6) grade += 2;
        if(t.root != null && t.root.rightNode.leftNode.key == 10) grade += 2;
        if(t.root != null && t.root.rightNode.rightNode.key == 14) grade += 2;

        if(t.root != null && t.root.leftNode.leftNode.leftNode.key == 1) grade += 2;
        if(t.root != null && t.root.leftNode.leftNode.rightNode.key == 3) grade += 2;
        if(t.root != null && t.root.leftNode.rightNode.leftNode.key == 5) grade += 2;
        if(t.root != null && t.root.leftNode.rightNode.rightNode.key == 7) grade += 2;
        if(t.root != null && t.root.rightNode.leftNode.leftNode.key == 9) grade += 2;
        if(t.root != null && t.root.rightNode.leftNode.rightNode.key == 11) grade += 2;
        if(t.root != null && t.root.rightNode.rightNode.leftNode.key == 13) grade += 2;
        if(t.root != null && t.root.rightNode.rightNode.rightNode.key == 15) grade += 2;

        if(t.root != null && t.root.rightNode.rightNode.rightNode.rightNode.key == 16) grade += 2;

        System.out.println("Preorder: " + t.getPreOrder(t.root));
        System.out.println("********************************************************");

        System.out.println("Inorder: " + t.getInOrder(t.root));
        System.out.println("********************************************************");

        System.out.println("Postorder: " + t.getPostOrder(t.root));
        System.out.println("********************************************************");

        System.out.println("Level order BST");
        t.printLevelOrder();
        System.out.println("********************************************************");

        if(t.getPreOrder(t.root).contains("8,4,2,1,3,6,5,7,12,10,9,11,14,13,15,16"))
            grade += 2;
        if(t.getInOrder(t.root).contains("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16"))
            grade += 2;
        if(t.getPostOrder(t.root).contains("1,3,2,5,7,6,4,9,11,10,13,16,15,14,12,8"))
            grade += 2;

        if(t.min() != null) System.out.println("Minimum: " + t.min().key);
        if(t.max() != null) System.out.println("Maximum: " + t.max().key);

        if(t.min() != null && t.min().key == 1) grade += 3;
        if(t.max() != null && t.max().key == 16) grade += 3;

        if(t.find(5) != null){
            System.out.println("Key node 5 is found at the BST");
            grade += 3;
        }
        if(t.find(25) != null){
            System.out.println("Key node 25 is found at the BST");
            grade -= 3;
        }

        if(t.isLeaf(13)){
            System.out.println("Key node 13 is leaf node");
            grade += 3;
        }
        if(t.isLeaf(15)){
            System.out.println("Key node 15 is leaf node");
            grade -= 3;
        }
        //*************************End Test 1*******************************
        System.out.println("********************************************************");
        System.out.println("After Test 1 Grade is " + grade);
        System.out.println("********************************************************");

        System.out.println("After delete key 1, 9, 12, 16");
        t.delete(1);
        t.delete(9);
        t.delete(12);
        t.delete(16);
        printer.printNode(t.root);

        System.out.println("**************************Test 2******************************");
        //*************************Test 2*******************************
        if(t.root != null && t.root.key == 7) grade += 2;

        if(t.root != null && t.root.leftNode.key == 4) grade += 2;
        if(t.root != null && t.root.rightNode.key == 11) grade += 2;

        if(t.root != null && t.root.leftNode.leftNode.key == 2) grade += 2;
        if(t.root != null && t.root.leftNode.rightNode.key == 5) grade += 2;
        if(t.root != null && t.root.rightNode.leftNode.key == 8) grade += 2;
        if(t.root != null && t.root.rightNode.rightNode.key == 14) grade += 2;

        if(t.root != null && t.root.leftNode.leftNode.rightNode.key == 3) grade += 2;
        if(t.root != null && t.root.leftNode.rightNode.rightNode.key == 6) grade += 2;
        if(t.root != null && t.root.rightNode.leftNode.rightNode.key == 10) grade += 2;
        if(t.root != null && t.root.rightNode.rightNode.leftNode.key == 13) grade += 2;
        if(t.root != null && t.root.rightNode.rightNode.rightNode.key == 15) grade += 2;

        System.out.println("Preorder: " + t.getPreOrder(t.root));
        System.out.println("********************************************************");

        System.out.println("Inorder: " + t.getInOrder(t.root));
        System.out.println("********************************************************");

        System.out.println("Postorder: " + t.getPostOrder(t.root));
        System.out.println("********************************************************");

        System.out.println("Level order BST");
        t.printLevelOrder();
        System.out.println("********************************************************");

        if(t.getPreOrder(t.root).contains("7,4,2,3,5,6,11,8,10,14,13,15"))
            grade += 3;
        if(t.getInOrder(t.root).contains("2,3,4,5,6,7,8,10,11,13,14,15"))
            grade += 4;
        if(t.getPostOrder(t.root).contains("3,2,6,5,4,10,8,13,15,14,11,7"))
            grade += 3;

        if(t.min() != null) System.out.println("Minimum: " + t.min().key);
        if(t.max() != null) System.out.println("Maximum: " + t.max().key);

        if(t.min() != null && t.min().key == 2) grade += 4;
        if(t.max() != null && t.max().key == 15) grade += 4;

        if(t.find(14) != null){
            System.out.println("Key node 14 is found at the BST");
            grade += 4;
        }
        if(t.find(1) != null){
            System.out.println("Key node 1 is found at the BST");
            grade -= 4;
        }

        if(t.isLeaf(10)){
            System.out.println("Key node 10 is leaf node");
            grade += 4;
        }
        if(t.isLeaf(8)){
            System.out.println("Key node 8 is leaf node");
            grade -= 4;
        }
        //*************************End Test 2*******************************
        System.out.println("********************************************************");
        System.out.println("Total Grade is " + grade);
        System.out.println("********************************************************");

    }

}
