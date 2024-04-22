package binaryTree;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		BinaryTree tree;
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
				case (1): {
					Menu.Create();
					int userInput = read.nextInt();
					tree = new BinaryTree(userInput);
					Menu.ReturnMenu();
					break;
				}
			}
			read.close();
		}
	}
}
