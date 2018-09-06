package Chap25.BST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class BST<T extends Comparable<T>> extends AbstractTree<T>{
    protected TreeNode<T> root;
    protected int size =0;

    /**
     * Default constructor
     */
    public BST() { }

    /** Create a BST from array of object
     * @param array input
     */
    public BST(T[] array) {
        for(int i = 0; i < array.length; i++) {
            insert(array[i]);
        }
    }

    /**
     * Implement class TreeNode
     * @param <T>
     */
    public class TreeNode<T> {
        public T element;
        public TreeNode<T> left, right;
        public TreeNode(T e) {
            element = e;
            left = right = null;
        }
    }
    public boolean search(T e) {
        TreeNode<T> current = root;
        while(current != null) {
            if(e.compareTo(current.element) < 0) {
                current = current.left;
            } else if(e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }
    public boolean insert(T e) {
        if(root == null) {
            root = new TreeNode<>(e);
        } else {
            TreeNode<T> parent = null;
            TreeNode<T> current = root;
            while(current != null) {
                if(e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if(e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // duplicate node not inserted
                }
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
            } else {
                parent.right = new TreeNode<>(e);
            }
        }
        size++;
        return true;
    }
    public void inorder() {
        inorder(root);
    }
    public void inorder(TreeNode<T> root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);

    }
    public void preorder() {
        preorder(root);
    }
    public void preorder(TreeNode<T> root) {
        if(root == null) return;
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.element + " ");
    }
    public void postorder() {
        postorder(root);
    }
    public void postorder(TreeNode<T> root) {
        if(root == null) return;
        System.out.print(root.element + " ");
        postorder(root.left);
        postorder(root.right);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        root = null;
        size = 0;
    }
    public ArrayList<TreeNode<T>>  path(T e) {
        ArrayList<TreeNode<T>> list = new ArrayList<>();
        TreeNode<T> current = root;
        while(current != null) {
            list.add(current);
            if(e.compareTo(current.element) < 0) {
                current = current.left;
            } else if(e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        return list;
    }

    public boolean delete(T e) {
        TreeNode<T> current = root;
        TreeNode<T> parent = null;
        while(current != null) {
            if(e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if(e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        if(current == null) {
            return false;
        }
        // case 1: current has no left child
        if(current.left == null) {
            if (parent == null) {
                root = current.right;
            } else if((e.compareTo(parent.element) < 0)){
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else { // case 2: current has left child
            TreeNode<T> parentRightMost = current;
            TreeNode<T> rightMost = current.left;
            while(rightMost.right != null) {
                parentRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if(parentRightMost.right == rightMost) {
                parentRightMost.right = rightMost.left;
            } else {
                parentRightMost.left = rightMost.left;
            }
        }
        size--;
        return true;
    }
    public Iterator<T> iterator() {
        return new TreeIterator();
    }
    public class TreeIterator implements Iterator<T> {
        public ArrayList<T> list = new ArrayList<>();
        public int current = 0;
        public TreeIterator() {
            inorder();
        }
        public void inorder() {
            inorder(root);
        }
        public void inorder(TreeNode<T> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }
        public boolean hasNext() {
            if(current < list.size())
                return true;
            return false;
        }
        public T next() {
            return list.get(current++);
        }
        public void remove() {
            delete(list.get(current));
            list.clear();
            inorder();
        }

        public ArrayList<T> getList() {
            return list;
        }
    }
    public void breadthFirstTraversal() {
        breadthFirstTraversal(root);
    }
    /** Displays the nodes in a breadth-first traversal */
    public void breadthFirstTraversal(TreeNode<T> root) {
        ArrayList<TreeNode<T>> list = new ArrayList<>();
        if(root == null) {
            return;
        }
        list.add(root);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).left != null) {
                list.add(list.get(i).left);
            }
            if(list.get(i).right != null) {
                list.add(list.get(i).right);
            }
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).element + " ");
        }
    }
    public int height() {
        return height(root);
    }
    /** Returns the height of this binary tree */
    public int height(TreeNode<T> root) {
        TreeNode<T> current = root;
        if(current == null) {
            return -1;
        } else {
            if(height(current.left) >= height(current.right)) {
                return height(current.left) + 1;
            } else {
                return height(current.right) + 1;
            }
        }
    }
    public boolean isFullBST() {
        int depth = height(root);
        if(size == Math.pow(2,depth) - 1) {
            return true;
        } else {
            return false;
        }
    }
}
