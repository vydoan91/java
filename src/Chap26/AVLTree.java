package Chap26;

import Chap25.BST.BST;

import java.util.ArrayList;

public class AVLTree<T extends Comparable<T>> extends BST<T> {
    public AVLTree() { }
    public AVLTree(T[] array) {
        super(array);
    }
    public class AVLTreeNode<T extends Comparable<T>> extends TreeNode<T> {
        int height = 0;
        private AVLTreeNode(T e) {
            super(e);
        }
    }
    public AVLTreeNode<T> createNewNode(T e) {
        return new AVLTreeNode<>(e);
    }
    public boolean insert(T e) {
        boolean successful = super.insert(e);
        if(!successful) {
            return false;
        } else {
            balancePath(e);
        }
        return true;
    }
    public void updateHeight(AVLTreeNode<T> node) {
        if(node.left == null && node.right == null) {
            node.height = 0;
        } else if(node.left == null) {
            node.height = ((AVLTreeNode<T>)(node.right)).height + 1;
        } else if(node.right == null) {
            node.height = ((AVLTreeNode<T>)node.left).height + 1;
        } else {
            node.height = Math.max(((AVLTreeNode<T>)node.left).height, ((AVLTreeNode<T>)node.right).height) + 1;
        }
    }
    public void balancePath(T e){
        ArrayList<TreeNode<T>> path = path(e);
        for(int i = path.size() - 1; i >= 0; i--) {
            AVLTreeNode<T> A = (AVLTreeNode<T>)path.get(i);
            updateHeight(A);
            AVLTreeNode<T> parentOfA = (A == root) ? null : (AVLTreeNode<T>)(path.get(i-1));
            switch(balanceFactor(A)) {
                case -2:
                    if(balanceFactor((AVLTreeNode<T>)A.left) <= 0) {
                        balanceLL(A, parentOfA);
                    } else {
                        balanceLR(A, parentOfA);
                    }
                case 2:
                    if(balanceFactor((AVLTreeNode<T>)A.right) >= 0) {
                        balanceRR(A, parentOfA);
                    } else {
                        balanceRL(A, parentOfA);
                    }
            }
        }
    }

    public int balanceFactor(AVLTreeNode<T> node) {
        if(node.right == null) {
            return -node.height;
        } else if(node.left == null) {
            return node.height;
        } else {
            // right-left
            return ((AVLTreeNode<T>)node.right).height - ((AVLTreeNode<T>)node.left).height;
        }
    }
    public void balanceLL(TreeNode<T> A, TreeNode<T> parentOfA) {
        TreeNode<T> B = A.left;
        if(A == root) {
            root = B;
        } else {
            if(parentOfA.left == A) {
                parentOfA.left = B;
            } else {
                parentOfA.right = B;
            }
        }
        A.left = B.right;
        B.right = A;
        updateHeight((AVLTreeNode<T>)A);
        updateHeight((AVLTreeNode<T>)B);
    }

    public void balanceLR(TreeNode<T> A, TreeNode<T> parentOfA) {
        TreeNode<T> B = A.left;
        TreeNode<T> C = B.right;
        if(A == root) {
            root = C;
        } else {
            if(parentOfA.left == A) {
                parentOfA.left = C;
            } else {
                parentOfA.right = C;
            }
        }
        B.right = C.left;
        C.left = B;
        A.left = C.right;
        C.right = A;
        updateHeight((AVLTreeNode<T>)A);
        updateHeight((AVLTreeNode<T>)B);
        updateHeight((AVLTreeNode<T>)C);

    }
    public void balanceRR(TreeNode<T> A, TreeNode<T> parentOfA) {
        TreeNode<T> B = A.right;
        if(A == root) {
            root = B;
        } else {
            if(parentOfA.right == A) {
                parentOfA.right = B;
            } else {
                parentOfA.left = B;
            }
        }
        A.right = B.left;
        B.left = A;
        updateHeight((AVLTreeNode<T>)A);
        updateHeight((AVLTreeNode<T>)B);
    }

    public void balanceRL(TreeNode<T> A, TreeNode<T> parentOfA) {
        TreeNode<T> B = A.right;
        TreeNode<T> C = B.left;
        if(A == root) {
            root = C;
        } else {
            if (parentOfA.right == A) {
                parentOfA.right = C;
            } else {
                parentOfA.left = C;
            }
        }
        B.left = C.right;
        C.right = B;
        A.right = C.left;
        C.left = A;
        updateHeight((AVLTreeNode<T>)A);
        updateHeight((AVLTreeNode<T>)B);
        updateHeight((AVLTreeNode<T>)C);
    }
    public boolean delete(T e) {
        TreeNode<T> current = root;
        TreeNode<T> parent = null;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        if (current == null) {
            return false;
        }
        // case 1: current has no left child
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else if ((e.compareTo(parent.element) < 0)) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else { // case 2: current has left child
            TreeNode<T> parentRightMost = current;
            TreeNode<T> rightMost = current.left;
            while (rightMost.right != null) {
                parentRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if (parentRightMost.right == rightMost) {
                parentRightMost.right = rightMost.left;
            } else {
                parentRightMost.left = rightMost.left;
            }
            balancePath(parentRightMost.element);
        }
        size--;
        return true;
    }
}


