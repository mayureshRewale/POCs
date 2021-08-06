import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Customer {

	String name, address, username, pass;
	Long mobile, inDeposit;
	ArrayList<String> transList;

	public Customer(String name, String address, String username, Long mobile, Long inDeposit, String pass,
			ArrayList list) {
		super();
		this.name = name;
		this.address = address;
		this.username = username;
		this.mobile = mobile;
		this.inDeposit = inDeposit;
		this.pass = pass;
		this.transList = list;
	}

}

public class Poc20 {
	static Scanner sc;

	static ArrayList<Object> users = new ArrayList<>();

	static Map<String, Customer> cust = new HashMap<String, Customer>();

	public static void main(String[] args) {
		int choice;
		sc = new Scanner(System.in);

		while (true) {
			System.out.println("--------------");
			System.out.println("BANK OF MYBANK");
			System.out.println("--------------");

			System.out.println("\n1. Register Account \n2. Login \n3. Update Account \n4. Exit \n");

			System.out.println("Enter Choice : ");
			choice = sc.nextInt();

			if (choice == 1)
				registerUser();
			else if (choice == 2) {
				loginUser();
			} else if (choice == 3) {
				updateUser();
			} else if (choice == 4) {
				break;
			}

		}

	}

	private static void exit() {

	}

	private static void updateUser() {

	}

	private static void loginUser() {
		String un, upass;
		boolean uf = false;
		Customer loggedIn = null;

		System.out.println("Enter username : ");
		un = sc.next();
		
		System.out.println("Enter Password : ");
		upass = sc.next();

		for (Map.Entry<String, Customer> pair : cust.entrySet()) {
			
			if (pair.getKey().equals(un) && pair.getValue().pass.equals(upass)) {
				uf = true;
				loggedIn = pair.getValue();
				System.out.println("Name : " + loggedIn.name);
				System.out.println("Address : " + loggedIn.address);
				System.out.println("Mobile : " + loggedIn.mobile);
				System.out.println("Balance : " + loggedIn.inDeposit);
			}
		}
		if(uf) {
			while(loggedIn != null) {
				int choice;
				System.out.println("-----------------------------------------");
				System.out.println("WELCOME " + loggedIn.name.toUpperCase());
				System.out.println("-----------------------------------------");
				
				System.out.println("\n1. Deposit \n2. Tansfer \n3. Last 5 transcations \n4. UserInformation \n5. Logout \nEnter Your Choice");
				choice = sc.nextInt();
				
				if(choice == 1) {
					//Deposit
					System.out.println("Enter Amount : ");
					Long amount = sc.nextLong();
					loggedIn.inDeposit = loggedIn.inDeposit + amount;
					System.out.println("Balance : " + loggedIn.inDeposit);
					/*
					 * for(int i = loggedIn.transList.size(); i >= 0; i++) {
					 * 
					 * }
					 */
				}
				else if(choice == 2) {
					//Transfer
					boolean bl = false;
					System.out.println("Enter Amount : ");
					Long tamount = sc.nextLong();
					if(loggedIn.inDeposit > tamount) {
						System.out.println("Enter Payee Username : ");
						String tUname = sc.next();
						
						for (Map.Entry<String, Customer> pair : cust.entrySet()) {
							
							if (pair.getKey().equals(tUname)) {
								bl = true;
								pair.getValue().inDeposit = pair.getValue().inDeposit + tamount;
								loggedIn.inDeposit = loggedIn.inDeposit - tamount;
								System.out.println("Balance : " + loggedIn.inDeposit);
							}
						}
						if(!bl) {
							System.out.println("Payee Username Not Found");
						}
						bl = false;
					}else {
						System.out.println("IIInsufficient Balance in Acount");
					}
				}
				else if(choice == 3) {
					
				}
				else if(choice == 4) {
					
				}
				else if(choice == 5) {
					loggedIn = null;
					uf = false;
					break;
				}
				
			}
		}
		else {
			System.out.println("Incorrect Username Or Password");
		}

	}

	private static void registerUser() {
		String name, address, username, password;
		Long mobile, deposit;
		String mobExp1 = ".*\\d{10}";
		String passExp = "^(.*[A-Z].*[a-z].*[0-9].*[!@#$%^&*_]).{8,16}";

		ArrayList<String> transList = new ArrayList<>(5);

		System.out.println("Enter Name : ");
		name = sc.next();

		System.out.println("Enter username : ");
		username = sc.next();

		System.out.println("enter Password : ");
		password = sc.next();
		while(!password.matches(passExp)) {
			password = sc.next();
		}

		System.out.println("Enter Address : ");
		address = sc.next();

		System.out.println("Enter Contact number : ");
		mobile = sc.nextLong();
		while (!mobile.toString().matches(mobExp1)) {
			System.out.println("Enter Valid Contact No. : ");
			mobile = sc.nextLong();
		}

		System.out.println("Enter initial Deposit Amount : ");
		deposit = sc.nextLong();
		transList.add("Initial Deposit of Rs." + deposit + " on " + java.time.LocalDate.now() + " at "
				+ java.time.LocalTime.now());

		cust.put(username, new Customer(name, address, username, mobile, deposit, password, transList));
	}

}
