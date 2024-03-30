package binaryTree;

public class Node {
    public int key;
    public Node left;
    public Node right;

    public Node(int val) {
        this.key = val;
        this.left = null;
        this.right = null;
    }
    public boolean isBinarySearchTree() {
		if (left == null && right == null) {
			return true;
		}
		else {
			if ((left != null && left.key > key) || (right != null && right.key < key)) {
				return false;
			}
			else {
				if (left == null) {
					return right.isBinarySearchTree();
				}
				else if (right == null) {
					return left.isBinarySearchTree();
				}
				else {
					return left.isBinarySearchTree() && right.isBinarySearchTree();
				}
			}
		}
	}
    public String toString() {
		return "	Key: " + key + (left == null? "" : "\nLeft" + left) + (right == null? "" : "		Right" + right);
	}
}
