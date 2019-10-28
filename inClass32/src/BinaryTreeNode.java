
/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author CS2110 - Spring 2019
 * @param <T> The type of data this tree node stores
 */
/**
 * @author jrhott
 *
 * @param <T>
 */
public class BinaryTreeNode<T> {
	
	/**
	 * Reference pointer to the left subtree
	 */
	private BinaryTreeNode<T> left;
	
	/**
	 * Reference pointer to the right subtree
	 */
	private BinaryTreeNode<T> right;
	
	/**
	 * Data stored at this node
	 */
	private T data;
	
	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	
	/**
	 * Full Constructor
	 * 
	 * Creates a binary tree node with the given data and child reference pointers
	 * 
	 * @param theData The data to store at this node
	 * @param leftChild A reference pointer to the left subtree
	 * @param rightChild A reference pointer to the right subtree
	 */
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}


	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
	public BinaryTreeNode<T> getRight() {
		return right;
	}

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
	public void setRight(BinaryTreeNode<T> right) {
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
	 *
	 */
	@Override
	public String toString() {
	    String retVal = "";
	    if (left != null)
	        retVal += left.toString(); // recursive call on left
	    if (right != null) 
	        retVal += right.toString(); // recursive call on right
	    retVal += "("+data+")"; // add this node's data
	    return retVal;
	}
	
	
	public int size() {
	    int size =0;
	    if(left!=null) {
	        size += left.size();
	    }
	    if(right!=null) {
            size += right.size();
        }
	    size += 1;
	    return size;
	}
	/**
	 * Main method
	 * 
	 * Your code should go here
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
	    BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
	    BinaryTreeNode<Integer> b2 = new BinaryTreeNode<Integer>(2);
	    BinaryTreeNode<Integer> b3 = new BinaryTreeNode<Integer>(3);
	    BinaryTreeNode<Integer> b4 = new BinaryTreeNode<Integer>(4);
	    BinaryTreeNode<Integer> b5 = new BinaryTreeNode<Integer>(5);
	    BinaryTreeNode<Integer> b6 = new BinaryTreeNode<Integer>(6);
	    BinaryTreeNode<Integer> b7 = new BinaryTreeNode<Integer>(7);
	    BinaryTreeNode<Integer> b8 = new BinaryTreeNode<Integer>(8);
	    
	    root.setRight(b3);
	    root.setLeft(b2);
	    b2.setLeft(b4);
	    b2.setRight(b5);
	    b4.setLeft(b6);
	    b5.setLeft(b7);
	    b5.setRight(b8);
	    
        System.out.println(root.toString());
	}

}
