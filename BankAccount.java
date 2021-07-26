package com.weeklyTask;

import com.day3.withDrawException;

class Account{
	private int balance;
	
	Account(int bal){
		this.balance = bal;
	}
	
	public void showBalance() {
		System.out.println("Available Balance : " + balance);
		System.out.println("------------------------------------");
	}
	
	public void withdraw(int val) {
		try {
				if(val > balance) {
					throw new withDrawException("Insufficient Balance");
				}else {
					balance = balance-val;
					System.out.println("WithDraw successful");
					System.out.println("Available Balance : " +balance);
					System.out.println("-----------------------------------");
				}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

public class BankAccount {

	public static void main(String[] args) {
		
		Account ac = new Account(10000);
		ac.showBalance();
		ac.withdraw(11000);
		ac.withdraw(8000);

	}

}
