package binaryTree;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		BinaryTree tree = null;
		while(true) {
			@SuppressWarnings("resource")
			Scanner read = new Scanner(System.in);
			Menu.Home();
			System.out.print("\nEnter your choice: ");
			int userChoice = read.nextInt();
			while(userChoice<1 || userChoice>7) {
				System.out.print("Enter an integer 1--7: ");
				userChoice = read.nextInt();
			}
			switch(userChoice) {
				case 1: {
					while(true) {
						if (tree == null) {
							Menu.Create();
							int userInput = read.nextInt();
							tree = new BinaryTree(userInput);
							System.out.println("Tree created successfully!!");
							BinaryTree.printTree(tree.root);
						}
						else 
						System.out.println("Tree is already created.");
						if (Menu.ReturnMenu()) {
							break;
						}
					}
					break;
				}
				case 2:{
					while(true) {
						if (tree != null) {
							Menu.Add();
							int userInput = read.nextInt();
							tree.insertKey(userInput);
							System.out.println("Element added successfully!!");
						}
						else {
							System.out.println("Create a tree first.");
						}
						if (Menu.ReturnMenu()) {
							break;
						}
					}
					break;
				}
				case 3:{
					while(true) {
						if (tree != null) {
							Menu.Search();
							int userInput = read.nextInt();
							if (tree.contains(userInput))
								System.out.println("Element found!!");
							else
								System.out.println("Element not found!!");
						}
						else {
							System.out.println("Create a tree first.");
						}
						if (Menu.ReturnMenu()) {
							break;
						}
					}
					break;
				}
				case 4:{
					while(true) {
						if (tree != null) {
							Menu.Remove();
							int userInput = read.nextInt();
							tree.remove(userInput);
							System.out.println("Removed Successfully.");
						}
						else {
							System.out.println("Create a tree first.");
						}
						if (Menu.ReturnMenu()) {
							break;
						}
					}
					break;
				}
				case 5:{
					while(true) {
						if (tree != null) {
							BinaryTree.printTree(tree.root);
						}
						else {
							System.out.println("Create a tree first.");
						}
						if (Menu.ReturnMenu()) {
							break;
						}
					}
					break;
				}
				case 6:{
					if(Menu.Exit()) {
						read.close();
						return;	
					}
					else
						break;
				}
			}

		}
	}

}
