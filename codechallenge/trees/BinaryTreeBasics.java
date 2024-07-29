package codechallenge.trees;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;
    
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

/**
 * pre,in and post traversal
 * get height
 */
public class BinaryTreeBasics {
    //Root node
    Node root;


    public BinaryTreeBasics() {
        root = null;
    }

    void printLevelOrder() {
        int h = height(root);
        int i;
        for(i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    //recursilve  call  until you get to empty. 
    //Then get the highests value of the two height + 1 (for root)
    int height(Node root) {
        if(root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if(lheight > rheight) {
                return lheight + 1;
            } else {
                return rheight + 1;
            }
        }
    }

    void printCurrentLevel(Node root, int level) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(root.data + " => ");
        }else if( level > 1 ) {
            printCurrentLevel(root.left, level -1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    //Print then traverse
    void preOrderTraversal(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(" => " + root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //Go left, print , then traverse
    void inOrderTraversal(Node root, List<Node> visited) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left, visited);
        System.out.print(" => " + root.data);
        inOrderTraversal(root.right, visited);
    }

    //got left and right then print.
    void postOrderTraversal(Node root, List<Node> visited) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left, visited);
        postOrderTraversal(root.right, visited);
        System.out.print(" => " + root.data);
    }

    public static void main(String[] args) {
        BinaryTreeBasics tree  = new  BinaryTreeBasics();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        List<Node>  visited = new ArrayList<>();

        System.out.println("Level order traversal of binary tree is: " );
        tree.printLevelOrder();
        System.out.println("\nPreOrder Traversal:");
        tree.preOrderTraversal(tree.root);
        System.out.println("\nIn-Order Traversal:");
        tree.inOrderTraversal(tree.root, visited);
        System.out.println("\nPostOrder Traversal:");
        tree.postOrderTraversal(tree.root, visited);
    }
}

