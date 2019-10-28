import java.util.ArrayList;

/**
 * Binary Search Tree Class The head class for a binary search tree implementation.
 * 
 * @author YOURID yl4df
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /**
     * A reference pointer to the root of the tree
     */
    private TreeNode<T> root;

    /**
     * Default constructor Creates a binary tree object with null root note (empty tree)
     */
    public BinarySearchTree() {
        this(null);
    }

    /**
     * Constructor Creates a binary tree object with the given node as root
     * 
     * @param newRoot The root of the tree
     */
    public BinarySearchTree(TreeNode<T> newRoot) {
        this.root = newRoot;
    }

    /**
     * Get the root of the tree
     * 
     * @return The root of the tree
     */
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * Set the root of the tree
     * 
     * @param root The new root of this tree
     */
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    /**
     * /** Count size on tree level by calling node-level size on root.
     * 
     * @return the size of the tree
     */

    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size();
    }

    /**
     * Count height on tree level by calling node-level height on root.
     * 
     * @return the height of the tree
     */
    public int height() {
        if (root == null) {
            return 0;
        }
        return root.height();
    }

    /**
     * Find if an element exists Checks to see if the value val appears in the tree (recursively). Returns true if it
     * appears and false otherwise.
     * 
     * @param val The value to find
     * @return True if the tree contains the value, false otherwise
     */
    public boolean find(T val) {
        if (root == null) {
            return false;
        }
        return root.find(val);
    }

    /**
     * Insert an element Inserts val into the tree where it should appear, returning true on success and false otherwise
     * 
     * @param val The value to insert
     * @return True on success, false otherwise
     */
    public boolean insert(T val) {
        TreeNode<T> newNode = new TreeNode<T>();
        newNode.setData(val);
        newNode.setLeft(null);
        newNode.setRight(null);
        if (root == null) {
            root = newNode;
            return true;
        }
        return root.insert(val);
    }

    /**
     * Delete an element from the tree Deletes val from the tree if it appears, returning true on success and false
     * otherwise
     * 
     * @param val The value to delete
     * @return True on success, false otherwise
     */

    public boolean delete(T val) {
        TreeNode<T> current = root;
        TreeNode<T> parent = null;
        boolean found = false;

        while (!found && current != null) {
            int com = val.compareTo(current.getData());
            if (com == 0) {
                found = true;
            } else {
                parent = current;
                if (com < 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
        }
        if (!found) {
            return false;
        }

        if (current.getLeft() == null || current.getRight() == null) {
            TreeNode<T> newChild;
            if (current.getLeft() == null) {
                newChild = current.getRight();
            } else {
                newChild = current.getLeft();

            }
            if (parent == null) {
                root = newChild;
            } else if (parent.getLeft() == current) {
                parent.setLeft(newChild);
            } else {
                parent.setRight(newChild);
            }
            return true;

        }

        TreeNode<T> smallestParent = current;
        TreeNode<T> smallestNode = current.getRight();
        while (smallestNode.getLeft() != null) {
            smallestParent = smallestNode;
            smallestNode = smallestNode.getLeft();
        }
        current.setData(smallestNode.getData());
        if (smallestParent == current) {
            smallestParent.setRight(smallestNode.getRight());
        } else {
            smallestParent.setLeft(smallestNode.getRight());
        }
        return true;

    }

    /**
     * inOrder traversal of BST
     * 
     * @return the string in inOrder traversal
     */
    public String inOrder() {
        return root.inOrder();
    }

    /**
     * postOrder traversal of BST
     * 
     * @return the string in postOrder traversal
     */
    public String postOrder() {
        return root.postOrder();
    }

    /**
     * Build from a list Build the tree from the given list, overwriting any tree data previously stored in this tree.
     * Should read from beginning to end of the list and repeatedly call insert() to build the tree.
     * 
     * @param list The list from which to build the tree
     * @return True if successfully built, false otherwise
     */
    public boolean buildFromList(ArrayList<T> list) {
        this.setRoot(null);
        for (T element : list) {
            if (insert(element)) {
                insert(element);
            } else {
                return false;
            }
            ;
        }
        return true;
    }

    /**
     * toString method
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return inOrder();
    }

    /**
     * Main method For testing, etc
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(7);
        tree.insert(3);
        tree.insert(9);
        tree.insert(2);
        tree.insert(5);
        tree.insert(8);
        tree.insert(10);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.delete(2);
        System.out.println(tree);
    }
}
