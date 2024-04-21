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
	public int minimum(Node node) {
		if (node.left.left == null) {
			int key = node.left.key;
			node.left = null;
			return key;
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
				Node target = null;
				if (key < node.key) {
					target = node.left;
				}
				else if (key > node.key) {
					target = node.right;
				}
				if (target.key == key) {
					if (target.left == null) {
						if (target == node.left) 
							node.left = target.right;
						else
							node.right = target.right;
						break;
					}
					else if (target.right == null) {
						if (target == node.left) 
							node.left = target.left;
						else
							node.right = target.left;
						break;
					}
					else if (target.left == null && target.right == null) {
						if (target == node.left) 
							node.left = null;
						else
							node.right = null;
						break;
					}
					else {
						if (target.right.left == null) {
							target.key = target.right.key;
							target.right = null;
						}
						else
							target.key = minimum(target.right);
						break;
					}
				}
				else {
					node = target;
				}
			}
		}
	}
	public String toString() {
		return root.toString();
	}
	public static void printBinaryTree(Node root) {
        printBinaryTree(root, 0);
    }

    private static void printBinaryTree(Node node, int depth) {
        if (node == null) {
            return;
        }

        // Print right subtree
        printBinaryTree(node.right, depth + 1);

        // Indent based on depth
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        // Print current node's value
        System.out.println(node.key);

        // Print left subtree
        printBinaryTree(node.left, depth + 1);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

