package binaryTree;

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
	private int minimum(Node node) {
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
	
	public static void printTree(Node root) {
        printTree(root, 0, "root");
    }

    private static void printTree(Node node, int depth, String type) {
        if (node == null) {
            return;
        }
        printTree(node.right, depth + 1, "right");
        for (int i = 0; i < depth; i++) {
        	System.out.print("    ");
        }
        switch(type) {
			case "right":
				System.out.print("/ ");
				break;
			case "left":
				System.out.print("\\ ");
				break;
        }
        System.out.println(node.key);
        printTree(node.left, depth + 1, "left");
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

