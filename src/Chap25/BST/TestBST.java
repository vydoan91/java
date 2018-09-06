package Chap25.BST;

import java.util.ArrayList;
import java.util.Iterator;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(3);
        tree.insert(9);
        tree.insert(6);
        tree.insert(1);
//        tree.insert(0);
//        tree.insert(4);
//        tree.insert(7);
//        tree.insert(10);
//        tree.insert(2);
//        tree.insert(5);
        System.out.print("Height of tree: " + tree.height());
        System.out.print("\nBreadth-first order: ");
        tree.breadthFirstTraversal();
        System.out.print("\nInorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());

        System.out.print("\nIs 0 in the tree? " + tree.search(0));

        tree.delete(9);
        System.out.print("\nInorder: ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();


        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BST<Integer> intTree = new BST<>(numbers);
        System.out.print("\nInorder (sorted): ");
        intTree.inorder();
    }

}
