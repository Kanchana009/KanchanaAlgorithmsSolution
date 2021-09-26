package com.secondproject.java;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String userName;

		int CompanyCount;

		float StockPrice;

		Stack<String> TotalStocks = new Stack<String>();
		Stack<Float> TotalStockPrice = new Stack<Float>();

		Boolean AcceptedStocks;
		int DeclinedStocks;

		System.out.println("enter the no of companies :");
		CompanyCount = sc.nextInt();

		for (int i = 1; i <= CompanyCount; i++) {
			System.out.println("Enter current stock price of the company " + i + " :");
			StockPrice = sc.nextFloat();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			AcceptedStocks = sc.nextBoolean();
			TotalStockPrice.push(StockPrice);
			if (AcceptedStocks == true) {
				TotalStocks.push("true");
			} else {
				TotalStocks.push("false");
			}

		}

		Object[] TotalStocksArr = TotalStocks.toArray();
		Object[] TotalStockPriceArr = TotalStockPrice.toArray();

		CallBackOut(TotalStocksArr, TotalStockPriceArr);
	}

	/** Call Back Function For Ask Question Again and Again **/
	static void CallBackOut(Object[] TotalStocksArr, Object[] TotalStockPriceArr) {
		Scanner sc = new Scanner(System.in);
		int UserInput;
		// Enter userName and press Enter
		System.out.println("-----------------------------------------------");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. press 0 to exit");
		System.out.println("-----------------------------------------------");
		// Get User Input
		UserInput = sc.nextInt();

		switch (UserInput) {
		case 1:
			AssendingStacks(TotalStockPriceArr);// call AssendingStacks Function
			CallBackOut(TotalStocksArr, TotalStockPriceArr);// call CallBackOut Function

		case 2:
			DescendingStacks(TotalStockPriceArr);// call DescendingStacks Function
			CallBackOut(TotalStocksArr, TotalStockPriceArr);// call CallBackOut Function

		case 3:
			StackPriceRoseCount(TotalStocksArr);// call StackPriceRoseCount Function
			CallBackOut(TotalStocksArr, TotalStockPriceArr);// call CallBackOut Function

		case 4:
			StackPriceDeclinedCount(TotalStocksArr);// call StackPriceDeclinedCount Function
			CallBackOut(TotalStocksArr, TotalStockPriceArr);// call CallBackOut Function

		case 5:
			SearchStackPrice(TotalStockPriceArr);// call SearchStackPrice Function
			CallBackOut(TotalStocksArr, TotalStockPriceArr);// call CallBackOut Function

		case 6:
			System.exit(0);
			break;

		}
	}

	/** Call Back Function For Print Data For Ascending Order **/
	static void AssendingStacks(Object[] TotalStockPriceArr) {
		float temp = 0;
		float val1;
		float val2;

		System.out.println("Your AscendingStacks");
		// Sort the array in ascending order
		for (int i = 0; i < TotalStockPriceArr.length; i++) {

			val1 = (Float) TotalStockPriceArr[i];
			for (int j = i + 1; j < TotalStockPriceArr.length; j++) {

				val2 = (Float) TotalStockPriceArr[j];

				if (val1 > val2) {
					temp = val1;
					TotalStockPriceArr[i] = val2;
					TotalStockPriceArr[j] = temp;
				}
			}
		}
		// Displaying elements of array after sorting
		System.out.println("Stock prices in ascending order are : ");
		for (int i = 0; i < TotalStockPriceArr.length; i++) {
			System.out.print(TotalStockPriceArr[i] + " ");
		}
	}

	/** Call Back Function For Print Data For Descending Order **/
	static void DescendingStacks(Object[] TotalStockPriceArr) {
		float temp = 0;
		float val1;
		float val2;
		
		System.out.println("Your DescendingStacks");
		// Sort the array in Descending order
		for (int i = 0; i < TotalStockPriceArr.length; i++) {

			val1 = (Float) TotalStockPriceArr[i];
			for (int j = i + 1; j < TotalStockPriceArr.length; j++) {

				val2 = (Float) TotalStockPriceArr[j];

				if (val1 < val2) {
					temp = val1;
					TotalStockPriceArr[i] = val2;
					TotalStockPriceArr[j] = temp;
				}
			}
		}

		// Displaying elements of array after sorting
		System.out.println("Stock prices in descending order are : ");
		for (int i = 0; i < TotalStockPriceArr.length; i++) {
			System.out.print(TotalStockPriceArr[i] + " ");
		}
	}

	/** Call Back Function For Print Stack Price Rose Count **/
	static void StackPriceRoseCount(Object[] TotalStocksArr) {
		String val1;
		int count = 0;
		for (int i = 0; i < TotalStocksArr.length; i++) {
			val1 = (String) TotalStocksArr[i];
			if (val1 == "true") {
				count += 1;
			}
		}

		System.out.println("Total no of companies whose stock price rose today :  " + count);
	}

	/** Call Back Function For Print Stack Price Declined Count **/
	static void StackPriceDeclinedCount(Object[] TotalStocksArr) {
		String val1;
		int count = 0;
		for (int i = 0; i < TotalStocksArr.length; i++) {
			val1 = (String) TotalStocksArr[i];
			if (val1 == "false") {
				count += 1;
			}
		}
		System.out.println("Total no of companies whose stock price declined today :  " + count);
	}

	/** Call Back Function For Search Stack Price **/
	static void SearchStackPrice(Object[] TotalStockPriceArr) {
		Scanner sc = new Scanner(System.in);

		float SearchInput;
		float val1;
		boolean flag = false;

		System.out.println("enter the key value :  ");
		SearchInput = sc.nextFloat();

		
		for (int i = 0; i < TotalStockPriceArr.length; i++) {

			val1 = (Float) TotalStockPriceArr[i];

			if (SearchInput == val1) {
				flag = true;
			}
		}

		if (flag == true) {
			System.out.println("Stock of value " + SearchInput + " is present");

		} else {
			System.out.println("Value not found");
		}

	}
}
