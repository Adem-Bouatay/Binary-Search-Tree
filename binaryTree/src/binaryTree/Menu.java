package binaryTree;

import java.util.Scanner;

public class Menu {
	static void Home() {
		System.out.println("-------------------------------------Welcome--------------------------------------\n");
		System.out.println("1- Create a binary search tree");
		System.out.println("2- Add an element to the tree");
		System.out.println("3- Search for an element in the tree");
		System.out.println("4- Remove an element from the tree");
		System.out.println("5- Print the tree");
		System.out.println("6- Exit");
	}
	static void Add() {
		System.out.println("------------------------------------------Add-Page---------------------------------------------\n");
		System.out.print("Give the value of the element to add: ");
	}
	static void Create() {
		System.out.println("------------------------------------------Create-Page------------------------------------------\n");
		System.out.print("Enter the root value: ");
	}
	static void Search() {
		System.out.println("------------------------------------------Search-Page------------------------------------------\n");
		System.out.print("Enter the element you are looking for: ");
	}
	static void Remove() {
		System.out.println("------------------------------------------Remove-Page------------------------------------------\n");
		System.out.print("Enter the element you want to remove: ");
	}
	static boolean Exit() {
		System.out.println("------------------------------------------Exit-Page--------------------------------------------\n");
		System.out.print("Are you sure ? [y/n]: ");
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		char userChoice = read.nextLine().charAt(0);
		while ( userChoice != 'y' && userChoice != 'n') {
			System.out.print("Enter y or n: ");
			userChoice = read.next().charAt(0);
		}
		if (userChoice == 'y')
			return true;
		else 
			return false;
	}
	static boolean ReturnMenu() {
		System.out.println("-----------------------------------------------------------------------------------------------\n");
		System.out.print("Do you want to return to the home menu? [y/n]: ");
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		char userChoice = read.nextLine().charAt(0);
		while ( userChoice != 'y' && userChoice != 'n') {
			System.out.print("Enter y or n: ");
			userChoice = read.next().charAt(0);
		}
		if (userChoice == 'y')
			return true;
		else 
			return false;
	}
}
