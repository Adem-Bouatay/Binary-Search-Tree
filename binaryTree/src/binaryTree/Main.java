package binaryTree;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		BinaryTree tree = null;
		while(true) {
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
					Menu.Create();
					int userInput = read.nextInt();
					tree = new BinaryTree(userInput);
					Menu.ReturnMenu();
					break;
				}
				case 2:{
					Menu.Add();
					int userInput = read.nextInt();
					tree.insertKey(userInput);
					Menu.ReturnMenu();
					break;
				}
				case 3:{
					Menu.Search();
					int userInput = read.nextInt();
					System.out.println(tree.contains(userInput));
					Menu.ReturnMenu();
					break;
				}
				case 4:{
					Menu.Remove();
					int userInput = read.nextInt();
					tree.remove(userChoice);
					System.out.println("Removed Successfully.");
					Menu.ReturnMenu();
					break;
				}
				case 5:{
					BinaryTree.printBinaryTree(tree.root);
					Menu.ReturnMenu();
					break;
				}
				case 6:{
					Menu.Exit();
					return;
				}
			}
		}
	}
}
