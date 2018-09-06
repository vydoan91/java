package Chap25.BST;

public abstract class AbstractTree<T> implements Tree<T> {
    @Override
    /** Inorder traversal from the root*/
    public void inorder() {
    }

    @Override
    /** Postorder traversal from the root */
    public void postorder() {
    }

    @Override
    /** Preorder traversal from the root */
    public void preorder() {
    }

    @Override /** Return true if the tree is empty */
    public boolean isEmpty() {
        return getSize() == 0;
    }
}