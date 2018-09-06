package Chap25.BST;

public interface Tree<T> extends Iterable<T> {
    /**
     * Return true if the element is in the tree
     */
    public boolean search(T e);

    /**
     * Insert element e into the binary search tree.
     * Return true if the element is inserted successfully.
     */
    public boolean insert(T e);

    /** Delete the specified element from the tree.
     Return true if the element is deleted successfully. */
    public boolean delete(T e);

    /** Inorder traversal from the root*/
    public void inorder();

    /** Postorder traversal from the root */
    public void postorder();

    /** Preorder traversal from the root */
    public void preorder();

    /** Get the number of nodes in the tree */
    public int getSize();

    /** Return true if the tree is empty */
    public boolean isEmpty();
}
