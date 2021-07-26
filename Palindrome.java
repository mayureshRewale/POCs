package com.weeklyTask;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {

		int r;
		int rev = 0;
		int temp;
		int n;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		

		temp = n;
		while (n > 0) {
			r = n % 10; 
			rev = (rev * 10) + r;
			n = n / 10;
		}
		if (temp == rev)
			System.out.println("palindrome number ");
		else
			System.out.println("not palindrome");

	}

}
