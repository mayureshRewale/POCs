package com.weeklyTask;

import java.util.Scanner;

public class ArraySort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		for(int i = 0; i < 5; i++) {
			System.out.println("Enter " + (i+1) + " value : ");
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Array elements after sorting:");
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tmp = 0;
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
			
			System.out.println(arr[i]);
		}

	}

}
