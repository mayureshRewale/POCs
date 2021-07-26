package com.weeklyTask;

import java.util.ArrayList;

public class HousieTicket {
	static ArrayList useArr = new ArrayList<Integer>();
	static int val;

	public static void main(String[] args) {
		
		int[] arr1 = new int[3];
		int[] arr2 = new int[3];
		int[] arr3 = new int[3];
		int[] arr4 = new int[3];
		int[] arr5 = new int[3];
		int[] arr6 = new int[3];
		int[] arr7 = new int[3];
		int[] arr8 = new int[3];
		int[] arr9 = new int[3];
		
		fillCol(arr1, 10);
		fillCol(arr2, 20);
		fillCol(arr3, 30);
		fillCol(arr4, 40);
		fillCol(arr5, 50);
		fillCol(arr6, 60);
		fillCol(arr7, 70);
		fillCol(arr8, 80);
		fillCol(arr9, 90);
		
		
		for(int i = 0; i < 3; i++) {
			System.out.println("|" + arr1[i] + "|" + arr2[i] + "|" + arr3[i] + "|" + arr4[i] + "|" + arr5[i] + "|" + arr6[i] + "|" + arr7[i] + "|" + arr8[i] + "|" + arr9[i] + "|");
		}
		
	}

	private static void fillCol(int[] arr, int range) {
		
		int ePos = (int) (Math.random()*3);
		for(int i = 0; i < 3; i++) {
			if(i==ePos) {
				arr[i] = 0;
			}else {
				getRandInt(range);
				arr[i] = val;
				useArr.add(arr[i]);
			}
		}
		
	}

	private static void getRandInt(int range) {
		
		int num = (int) (Math.random()*range);
		if(useArr.contains(num) || num == 0) {
			getRandInt(range);
		}else if(num < (range-10)) {
			getRandInt(range);
		}else {
			val = num;
		}
		
		
	}

}
