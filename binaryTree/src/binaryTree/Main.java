package binaryTree;

public class Main {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(8);
		tree.insertKey(10);
		tree.insertKey(14);
		tree.insertKey(13);
		tree.insertKey(3);
		tree.insertKey(1);
		tree.insertKey(6);
		tree.insertKey(4);
		tree.insertKey(7);
		System.out.println(tree.root.left);
		tree.remove(3);
		System.out.println(tree.root.left);
	}
}
