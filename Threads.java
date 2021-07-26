package com.weeklyTask;

class ReverseThread extends Thread{

	@Override
	public void run() {
		try {
			StringBuilder str = new StringBuilder("Java is Nice");
			System.out.println("Reverse : " + str.reverse());
			Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

public class Threads extends Thread{

	@Override
	public void run() {
		try {
			StringBuilder str = new StringBuilder("Java is Good");
			System.out.println("Reverse : " + str.reverse());
			Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		ReverseThread t1 = new ReverseThread();
		Threads t2 = new Threads();
		
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
