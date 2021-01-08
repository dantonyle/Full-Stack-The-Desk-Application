package com.hcl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

	static ArrayList<Integer> expenses = new ArrayList<Integer>();

	public static void main(String[] args) {

		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);

		/* System.out.println("Hello World!"); */
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to The Desk \n");
		System.out.println("**************************************");
		optionsSelection();

	}

	private static void optionsSelection() {

		int options = 0;

		do {
			String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
					"3. I wish to delete all expenditure", "4. I wish to sort the expenditures",
					"5. I wish to search for a particular expenditure", "6. I wish to delete an expediture",
					"7. Close the application" };

			for (String option : arr) {
				System.out.println(option);
			}

			System.out.println("\nEnter your choice:\t");
			Scanner sc = new Scanner(System.in);
			options = sc.nextInt();
			switch (options) {
			case 1:
				System.out.println("Your saved expenses are listed below: \n");
				System.out.println(expenses + "\n");
				//optionsSelection();
				break;
			case 2:
				System.out.println("Enter the value to add your Expense: \n");
				int value = sc.nextInt();
				expenses.add(value);
				System.out.println("Your value is updated\n");
				System.out.println(expenses + "\n");
				//optionsSelection();

				break;
			case 3:
				System.out.println(
						"You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
				int con_choice = sc.nextInt();
				if (con_choice == options) {
					expenses.clear();
					System.out.println(expenses + "\n");
					System.out.println("All your expenses are erased!\n");
				} else {
					System.out.println("Oops... try again!");
				}
				//optionsSelection();
				break;
			case 4:
				sortExpenses(expenses);
				//optionsSelection();
				break;
			case 5:
				System.out.println("Enter the expense you need to search:\t");
				int searchValue = sc.nextInt();
				searchExpenses(expenses, searchValue);
				//optionsSelection();
				break;
			case 6:
				System.out.println("Enter the expense you need to delete:\t");
				int deleteValue = sc.nextInt();
				deleteOneExpenses(expenses, deleteValue);
				//optionsSelection();
				break;
			case 7:
				sc.close();
				closeApp();
				options = 0;
				break;
			default:
				System.out.println("You have made an invalid choice!");
				break;
			}
		} while (!(options == 0));

	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}

	private static void searchExpenses(ArrayList<Integer> arrayList, int searchExp) {

		// Complete the method
		if (arrayList.contains(searchExp)) {
			System.out.println("Expense " + searchExp + " was found in Expenditures \n");
		} else {
			System.out.println("Expense " + searchExp + " was NOT found in Expenditures \n");
		}
	}

	private static void deleteOneExpenses(ArrayList<Integer> arrayList, int deleteExp) {

		// Complete the method
		int deleteIndex = arrayList.indexOf(deleteExp);
		if (arrayList.contains(deleteExp)) {
			arrayList.remove(deleteIndex);
			System.out.println("Expense " + deleteExp + " was found in Expenditures and removed\n");
		} else {
			System.out.println("Expense " + deleteExp + " was NOT found in Expenditures \n");
		}
	}

	private static void sortExpenses(ArrayList<Integer> arrayList) {

		Collections.sort(arrayList);
		System.out.println(arrayList + "\n");

	}
}
