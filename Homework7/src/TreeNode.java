
/**
 * Binary Tree Node Tree node that has two children: left and right
 * 
 * @author YOURID yl4df
 * @param <Comparable> The type of data this tree node stores
 */
public class TreeNode<T extends Comparable<T>> {

    /**
     * Reference pointer to the left subtree
     */
    private TreeNode<T> left;

    /**
     * Reference pointer to the right subtree
     */
    private TreeNode<T> right;

    /**
     * Data stored at this node
     */
    private T data;

    /**
     * Default Constructor Creates a binary tree node with null data and null children
     */
    public TreeNode() {
        this(null, null, null);
    }

    /**
     * Data-only Constructor Creates a binary tree node with the given data and null children
     * 
     * @param theData The data to store at this node
     */
    public TreeNode(T theData) {
        this(theData, null, null);
    }

    /**
     * Full Constructor Creates a binary tree node with the given data and child reference pointers
     * 
     * @param theData    The data to store at this node
     * @param leftChild  A reference pointer to the left subtree
     * @param rightChild A reference pointer to the right subtree
     */
    public TreeNode(T theData, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        data = theData;
        left = leftChild;
        right = rightChild;
    }

    /**
     * Left Child/Subtree getter
     * 
     * @return A reference pointer to the root of the left subtree
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Left Child/Subtree Setter
     * 
     * @param left A reference pointer to the new left subtree's root node
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * Get the data at this node
     * 
     * @return The data stored at this node
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data at this node
     * 
     * @param data The data to be stored at this node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * toString method
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     * Count size on node level, which is size of left + size of right + 1
     * 
     * @return the size of the tree rooted at this node
     */
    public int size() {
        int sum = 0;
        if (left != null) {
            sum = sum + left.size();
        }
        if (right != null) {
            sum = sum + right.size();
        }
        return sum + 1;

    }

    /**
     * Count height on node level, which is maximum height of all nodes in the tree.
     * 
     * @return the height of the tree rooted at this node
     */
    public int height() {
        int height_left = 1;
        int height_right = 1;

        if (left != null) {
            height_left = height_left + left.height();
        }
        if (right != null) {
            height_right = height_right + right.height();
        }

        if (height_left > height_right) {
            return height_left;
        } else {
            return height_right;
        }

    }

    /**
     * Find whether value is in the tree rooted at this node
     * 
     * @param val the value to be searched
     * @return true if the value is found and false if not
     */
    public boolean find(T val) {

        int com = val.compareTo(data);
        if (com == 0) {
            return true;
        } else if (com < 0) {
            if (left == null) {
                return false;
            }
            return left.find(val);
        } else {
            if (right == null) {
                return false;
            }
            return right.find(val);
        }
    }

    /**
     * Insert a new node as a child of this node
     * 
     * @param val the value to be inserted
     * @return true if the node is inserted and false if not
     */
    public boolean insert(T val) {
        int com = val.compareTo(data);
        TreeNode<T> newNode = new TreeNode<T>();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        if (com == 0) {
            return false;
        } else if (com < 0) {
            if (left == null) {
                left = newNode;
                return true;
            } else {
                return left.insert(val);
            }

        } else {
            if (right == null) {
                right = newNode;
                return true;
            } else {
                return right.insert(val);
            }
        }

    }

    /**
     * inOrder traversal of BST rooted at this node
     * 
     * @return the string in inOrder traversal rooted at this node
     */
    public String inOrder() {

        if (left == null && right == null) {
            return "(" + this.data + ")";
        } else if (left != null && right == null) {
            return left.inOrder() + "(" + this.data + ")";
        } else if (right != null && left == null) {
            return "(" + this.data + ")" + right.inOrder();
        }
        return left.inOrder() + "(" + this.data + ")" + right.inOrder();
    }

    /**
     * postOrder traversal of BST rooted at this node
     * 
     * @return the string in postOrder traversal rooted at this node
     */
    public String postOrder() {
        if (left == null && right == null) {
            return "(" + this.data + ")";
        } else if (left != null && right == null) {
            return left.postOrder() + "(" + this.data + ")";
        } else if (right != null && left == null) {
            return right.postOrder() + "(" + this.data + ")";
        }
        return left.postOrder() + right.postOrder() + "(" + this.data + ")";
    }

    /**
     * Main method For main method testing, etc
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

    }

}
