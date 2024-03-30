package binaryTree;

/*public class BinaryTree {
	public int key;
	public BinaryTree left;
	public BinaryTree right;
	
	public BinaryTree(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	public void insertKey(int key) {
		if (this.key > key) {
			if (left == null) {
				left = new BinaryTree(key);
			}
			else 
				left.insertKey(key);
		}
		else if (this.key < key){
			if (right == null) {
				right = new BinaryTree(key);
			}
			else 
				right.insertKey(key);
		}
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
	public boolean contains(int key) {
		if (this.key == key) {
				return true;
		}
		else if (this.key < key && right != null) {
			return right.contains(key);
		}
		else if (this.key > key && left != null){
			return left.contains(key);
		} 	
		else {
			return false;
		}
	}
	public boolean singleNode() {
		return left == null || right == null;
	}
	public void remove(int key) {
	}
	public String toString() {
		return "	Key: " + key + (left == null? "" : "\nLeft" + left) + (right == null? "" : "		Right" + right);
	}
}*/

public class BinaryTree{
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	public BinaryTree(int key) {
		root = new Node(key);
	}
	public void insertKey(int key) {
		if (root == null) {
			root = new Node(key);
		}
		else {
			Node node = root;
			while (true) {
				if (key < node.key) {
					if (node.left == null) {
						node.left = new Node(key); 
						break;
					}
					else {
						node = node.left;
					}
				}
				else if (key > node.key) {
					if (node.right == null) {
						node.right = new Node(key); 
						break;
					}
					else {
						node = node.right;
					}
				}
				
			}
		}
	}
	public boolean isBinarySearchTree() {
		return root.isBinarySearchTree();
		
	}
	public boolean contains(int key) {
		if (root == null) {
			return false;
		}
		else {
			Node node = root;
			while (true) {
				if (node == null) {
					return false;
				}
				else if (node.key == key) {
					return true;
				}
				else if (key < node.key) {
					node = node.left;
				}
				else {
					node = node.right;
				}
			}
		}
	}
	public Node minimum(Node node) {
		if (node.left == null) {
			return node;
		}
		else {
			return minimum(node.left);
		}
	}
	public void remove(int key) {
		if (root.key == key) {
			root = null;
		}
		else if (this.contains(key)) {
			Node node = root;
			while(true) {
				System.out.println(node.key);
				if (node.left != null && node.left.key == key) {
					if (node.left.left == null && node.left.right == null ) {
						node.left = null;
						break;
					}
					else if (node.left.left == null) {
						node.left = node.left.right;
						break;
					}
					else if (node.left.right == null) {
						node.left = node.left.left;
						break;
					}
					else {
						node.left.key = minimum(node.left.right).key;
						remove(minimum(node.left.right).key);
					}
				}
				else if (node.right != null && node.right.key == key) {
					if (node.right.left == null && node.right.right == null ) {
						node.right = null;
						break;
					}
					else if (node.right.left == null) {
						node.right = node.right.right;
						break;
					}
					else if (node.right.right == null) {
						node.right = node.right.left;
						break;
					}
					else {
						node.right.key = minimum(node.right.right).key;
						remove(minimum(node.right.right).key);
					}
				}
				else if (key < node.key) {
					node = node.left;
				}
				else if (key > node.key) {
					node = node.right;
				}
			}
		}
	}
	public String toString() {
		return root.toString();
	}
	public void printInOrder() {
	    if (root == null) {
	        System.out.println("Tree is empty");
	    } else {
	        printInOrder(root);
	    }
	}

	private void printInOrder(Node node) {
	    if (node != null) {
	        printInOrder(node.left);
	        System.out.print(node.key + " ");
	        printInOrder(node.right);
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

